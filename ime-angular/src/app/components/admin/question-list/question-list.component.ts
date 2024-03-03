import { Component, OnInit, ViewChild } from '@angular/core';
import { RestService } from "../../../service/rest.service";
import { MatSort } from "@angular/material/sort";
import { Question } from "../../../model/question";
import { MatTableDataSource } from "@angular/material/table";
import { HttpErrorResponse } from "@angular/common/http";
import { map, Observable } from "rxjs";
import { Category } from "../../../model/category";
import { Skill } from "../../../model/skill";

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrl: './question-list.component.scss'
})
export class QuestionListComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;

  questions: Question[];
  displayedColumns: string[] = ['id', 'category', 'skill', 'question', 'answer'];
  dataSource: MatTableDataSource<Question> = new MatTableDataSource<Question>();

  modalTitle: string = "";
  modalSkill: string = "";
  modalCategory: string = "";
  modalQuestion: string = "";
  modalAnswer: string = "";

  categories: string[];
  skills: string[];

  constructor(private restService: RestService) {
  }

  ngOnInit(): void {
    this.refreshQuestionList();
    this.loadCategories();
    this.loadSkills();
  }

  private refreshQuestionList() {
    this.restService.getQuestions()
      .subscribe(
        (data: Question[]) => {
          this.questions = data;
          this.resetDatasource();
        }
      );
  }

  private resetDatasource() {
    this.dataSource.data = this.questions;
    this.dataSource.sort = this.sort;
  }

  setModalDialog(title: string, question: string) {
    this.modalTitle = title;
    this.modalQuestion = question;
  }

  saveQuestion() {
    // this.restService.saveQuestion(this.modalQuestion)
    //   .subscribe({
    //     next: (question: Question) => {
    //       this.refreshQuestionList();
    //     },
    //     error: (err: HttpErrorResponse) => {
    //       this.handleError(err);
    //     }
    //   });
    this.modalSkill = '';
    this.modalCategory = '';
    this.modalQuestion = '';
    this.modalAnswer = '';
  }

  deleteQuestion(id: number) {
    // this.restService.deleteQuestion(id)
    //   .subscribe({
    //     next: (question: Question) => {
    //       this.refreshQuestionList();
    //     },
    //     error: (err: HttpErrorResponse) => {
    //       this.handleError(err);
    //     }
    //   });
  }

  private handleError(err: HttpErrorResponse) {
    // const errorResponse: ErrorResponse = err.error;
    // console.error(errorResponse.message, errorResponse);
  }

  private loadCategories() {
    this.restService.getCategories()
      .subscribe(
        (data: Category[]) => {
          this.categories = data.map(category => category.name);
        }
      );
  }

  private loadSkills() {
    this.restService.getSkills()
      .subscribe(
        (data: Skill[]) => {
          this.skills = data.map(skill => skill.name);
        }
      );
  }


}
