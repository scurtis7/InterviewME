import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { Category } from "../../../model/category";
import { Skill } from "../../../model/skill";
import { RestService } from "../../../service/rest.service";
import { Question } from "../../../model/question";

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrl: './question.component.scss'
})
export class QuestionComponent implements OnInit {

  title: string;
  question: string;
  answer: string;
  selectedCategory: string;
  selectedSkill: string;
  categories: string[];
  skills: string[];

  constructor(@Inject(MAT_DIALOG_DATA) public data: Question, private restService: RestService,
              public dialogRef: MatDialogRef<QuestionComponent>) {
    if (data.id) {
      this.title = "Edit Question";
      this.selectedCategory = data.category;
      this.selectedSkill = data.skill;
      this.question = data.question;
      this.answer = data.answer;
    } else {
      this.title = "New Question";
    }
  }

  ngOnInit(): void {
    this.loadCategories();
    this.loadSkills();
  }

  close(save: boolean): void {
    if (save) {
      this.data.question = this.question;
      this.data.answer = this.answer;
      this.data.category = this.selectedCategory;
      this.data.skill = this.selectedSkill;
      this.dialogRef.close(this.data);
    } else {
      this.dialogRef.close(null);
    }
  }

  private loadCategories() {
    this.restService.getCategories()
      .subscribe(
        (data: Category[]) => {
          this.categories = data.map(category => category.name);
          if (!this.selectedCategory) {
            this.selectedCategory = this.categories[0];
          }
        }
      );
  }

  private loadSkills() {
    this.restService.getSkills()
      .subscribe(
        (data: Skill[]) => {
          this.skills = data.map(skill => skill.name);
          if (!this.selectedSkill) {
            this.selectedSkill = this.skills[0];
          }
        }
      );
  }

}
