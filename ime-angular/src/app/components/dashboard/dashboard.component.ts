import { Component, OnInit } from '@angular/core';
import { RestService } from "../../service/rest.service";
import { Category } from "../../model/category";
import { Skill } from "../../model/skill";
import { Criteria } from "../../model/criteria";
import { Question } from "../../model/question";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  categoryList: string[];
  skillList: string[];

  selectedCategories: string;
  selectedSkills: string;

  questions: Question[];
  currentCount = -1;
  showAnswer = false;
  currentCategory: string = "";
  currentSkill: string = "";
  currentQuestion: string = "";
  currentAnswer: string = "";

  isLoading = true;
  prevDisabled = true;
  nextDisabled = true;

  constructor(private restService: RestService) {
  }

  ngOnInit(): void {
    this.resetFields();
    this.loadDropdowns();
  }

  private loadDropdowns() {
    this.isLoading = true;
    this.loadCategories();
  }

  private loadCategories() {
    this.restService.getCategories()
      .subscribe(
        (result: Category[]) => {
          this.categoryList = result.map(category => category.name);
          this.loadSkills();
        }
      );
  }

  private loadSkills() {
    this.restService.getSkills()
      .subscribe(
        (result: Skill[]) => {
          this.skillList = result.map(skill => skill.name);
          this.isLoading = false;
        }
      );
  }

  start() {
    let criteria: Criteria = new Criteria();
    criteria.categories = this.stringToArray(this.selectedCategories);
    criteria.skills = this.stringToArray(this.selectedSkills);
    this.restService.searchQuestions(criteria)
      .subscribe((result: Question[]) => {
        this.questions = this.shuffle(result);
        this.currentCount = -1;
        this.nextQuestion();
      });
  }

  private stringToArray(str: string) {
    let strArray: string[] = [];
    if (str && str.length > 0) {
      for (const element of str) {
        strArray.push(element);
      }
    }
    return strArray;
  }

  private shuffle(questions: Question[]) {
    for (let i = questions.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [questions[i], questions[j]] = [questions[j], questions[i]];
    }
    return questions;
  }

  stop() {
    this.resetFields();
  }

  private resetFields() {
    this.questions = [];
    this.currentCount = -1;
    this.showAnswer = false;
    this.currentCategory = "";
    this.currentSkill = "";
    this.currentQuestion = "";
    this.currentAnswer = "";
  }

  previousQuestion() {
    if (this.currentCount > 0) {
      this.currentCount--;
    }
    this.enableDisableButtons();
    this.setQuestion();
  }

  nextQuestion() {
    if (this.currentCount <= this.questions.length) {
      this.currentCount++;
    }
    this.enableDisableButtons();
    this.setQuestion();
  }

  private setQuestion() {
    this.showAnswer = false;
    const question = this.questions[this.currentCount];
    this.currentCategory = question.category;
    this.currentSkill = question.skill;
    this.currentQuestion = question.question;
    this.currentAnswer = question.answer;
  }

  private enableDisableButtons() {
    this.prevDisabled = true;
    this.nextDisabled = true;
    if (this.currentCount > 0) {
      this.prevDisabled = false;
    }
    if ((this.currentCount + 1) < this.questions.length) {
      this.nextDisabled = false;
    }
  }

  toggleShowAnswer() {
    this.showAnswer = !this.showAnswer;
  }

}
