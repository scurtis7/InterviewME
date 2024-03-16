import { Component, OnInit, ViewChild } from '@angular/core';
import { RestService } from "../../../service/rest.service";
import { MatSort } from "@angular/material/sort";
import { Question } from "../../../model/question";
import { MatTableDataSource } from "@angular/material/table";
import { HttpErrorResponse } from "@angular/common/http";
import { ErrorResponse } from "../../../model/error-response";
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { QuestionComponent } from "../question/question.component";

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrl: './question-list.component.scss'
})
export class QuestionListComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;

  questions: Question[];
  displayedColumns: string[] = ['action', 'id', 'category', 'skill', 'question', 'answer'];
  dataSource: MatTableDataSource<Question> = new MatTableDataSource<Question>();

  constructor(private restService: RestService, private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.refreshQuestionList();
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

  displayQuestionDialog(id: number) {
    let question: Question = new Question();
    if (id > 0) {
      question = this.questions.find(q => q.id === id);
    }
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    // dialogConfig.height = "4000";
    // dialogConfig.width = "4000";
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
