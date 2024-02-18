import { Component, Input, OnInit, Output } from '@angular/core';
import { Category } from "../../../model/category";
import { RestService } from "../../../service/rest.service";
import { map, Observable } from "rxjs";
import { HttpErrorResponse } from "@angular/common/http";
import { ErrorResponse } from "../../../model/error-response";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.scss'
})
export class CategoryListComponent implements OnInit {

  modalCategory: string = "";
  modalTitle: string = "";

  categories$: Observable<string[]>;

  constructor(private restService: RestService) {
  }

  ngOnInit(): void {
    this.refreshCategories();
  }

  setModalDialog(title: string, category: string) {
    this.modalTitle = title;
    this.modalCategory = category;
  }

  private refreshCategories() {
    this.categories$ = this.restService.getCategories()
      .pipe(
        map(categories => categories.map(category => category.name))
      );
  }

  saveCategory() {
    this.restService.saveCategory(this.modalCategory)
      .subscribe({
        next: (category: Category) => {
          this.refreshCategories();
        },
        error: (err: HttpErrorResponse) => {
          this.handleError(err);
        }
      });
  }

  deleteCategory(categoryName: string) {
    this.restService.deleteCategory(categoryName)
      .subscribe({
        next: (category: Category) => {
          this.refreshCategories();
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
