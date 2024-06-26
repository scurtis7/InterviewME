import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import { Question } from "../model/question";
import { Skill } from "../model/skill";
import { Criteria } from "../model/criteria";

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
    let category = new Category();
    category.name = newCategory;
    return this.http.post<Category>(`http://localhost:8080/ime/category`, category);
  }

  public deleteCategory(categoryName: string): Observable<Category> {
    return this.http.delete<Category>(`http://localhost:8080/ime/category?name=` + categoryName);
  }

  public getQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(`http://localhost:8080/ime/question`);
  }

  public saveQuestion(newQuestion: Question): Observable<Question> {
    return this.http.post<Question>(`http://localhost:8080/ime/question`, newQuestion);
  }

  public searchQuestions(criteria: Criteria): Observable<Question[]> {
    return this.http.post<Question[]>(`http://localhost:8080/ime/question/search`, criteria);
  }

  public deleteQuestion(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/ime/question?id=${id}`);
  }

  public getSkills(): Observable<Skill[]> {
    return this.http.get<Skill[]>(`http://localhost:8080/ime/skill`);
  }

}
