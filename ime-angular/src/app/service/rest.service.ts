import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) {
  }

  public getCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(`http://localhost:8080/ime/category`);
  }

  public saveCategory(newCategory: string): Observable<Category> {
    console.log("Saving new category -> " + newCategory);
    let category = new Category();
    category.name = newCategory;
    return this.http.post<Category>(`http://localhost:8080/ime/category`, category);
  }

}
