import { Component, OnInit, ViewChild } from '@angular/core';
import { RestService } from "../../../service/rest.service";
import { MatSort } from "@angular/material/sort";
import { Question } from "../../../model/question";
import { MatTableDataSource } from "@angular/material/table";
import { HttpErrorResponse } from "@angular/common/http";
import { ErrorResponse } from "../../../model/error-response";
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { QuestionComponent } from "../question/question.component";
import { Category } from "../../../model/category";

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrl: './question-list.component.scss'
})
export class QuestionListComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;

  questionsAll: Question[];
  questions: Question[];
  displayedColumns: string[] = ['action', 'id', 'category', 'skill', 'question', 'answer'];
  dataSource: MatTableDataSource<Question> = new MatTableDataSource<Question>();

  searchValue = '';
  recordCount = 0;

  selectedCategory = 'All';
  categoryList: Category[];

  constructor(private restService: RestService, private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.refreshQuestionList();
    this.loadCategories();
  }

  private refreshQuestionList() {
    this.restService.getQuestions()
      .subscribe(
        (data: Question[]) => {
          this.questionsAll = data;
          this.questions = data;
          this.selectCategory();
          this.resetDatasource();
        }
      );
  }

  private loadCategories() {
    this.restService.getCategories()
      .subscribe( (result: Category[]) => {
        this.categoryList = result;
      });
  }

  private resetDatasource() {
    this.recordCount = this.questions.length;
    this.dataSource.data = this.questions;
    this.dataSource.sort = this.sort;
  }

  searchEvent(event: Event) {
    this.searchValue = ((event.target as HTMLInputElement).value).trim().toLowerCase();
    this.dataSource.filter = this.searchValue;
    this.dataSource.sort = this.sort;
  }

  selectCategory() {
    this.questions = this.questionsAll;
    if (this.selectedCategory !== 'All') {
      this.questions = this.questionsAll.filter((question: Question) => question.category === this.selectedCategory);
    }
    this.resetDatasource();
  }

  displayQuestionDialog(id: number) {
    let question: Question = new Question();
    if (id > 0) {
      question = this.questions.find(q => q.id === id);
    }
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.data = question;
    const dialogRef = this.dialog.open(QuestionComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
        console.log(`Result returned from dialog is: ${result}`);
        if (result) {
          question.question = result.question;
          question.answer = result.answer;
          question.category = result.category;
          question.skill = result.skill;
          this.restService.saveQuestion(question)
            .subscribe({
              next: (question: Question) => {
                this.refreshQuestionList();
              },
              error: (err: HttpErrorResponse) => {
                this.handleError(err);
              }
            });
        }
      }
    );
  }

  deleteQuestion(id: number) {
    console.log("Delete question with Id: ", id);
    this.restService.deleteQuestion(id)
      .subscribe({
        next: () => {
          this.refreshQuestionList();
        },
        error: (err: HttpErrorResponse) => {
          this.handleError(err);
        }
      });
  }

  private handleError(err: HttpErrorResponse) {
    const errorResponse: ErrorResponse = err.error;
    console.error(errorResponse.message, errorResponse);
  }

}
