import { Component, Input, OnInit, Output } from '@angular/core';
import { Category } from "../../../model/category";
import { RestService } from "../../../service/rest.service";
import { map, Observable } from "rxjs";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.scss'
})
export class CategoryListComponent implements OnInit {

  @Input() @Output() newCategory: string = "";
  categories$: Observable<string[]>;

  constructor(private restService: RestService) {
  }

  ngOnInit(): void {
    this.refreshCategories();
  }

  private refreshCategories() {
    this.categories$ = this.restService.getCategories()
      .pipe(
        map(categories => categories.map(category => category.name))
      );
  }

  saveCategory() {
    this.restService.saveCategory(this.newCategory)
      .subscribe({
        next: (category: Category) => {
          console.log("Category saved: " + category.name + " ...Refreshing list")
          this.refreshCategories();
        },
        error: (err: Error) => {
          console.error("Error while saving category: " + err.message);
        }
      });
  }

}
