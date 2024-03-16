import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from "./common/material.module";
import { FormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MenuComponent } from './components/shared/menu/menu.component';
import { AdminComponent } from './components/admin/admin.component';
import { HttpClientModule } from "@angular/common/http";
import { QuestionListComponent } from './components/admin/question-list/question-list.component';
import { CategoryListComponent } from './components/admin/category-list/category-list.component';
import { QuestionComponent } from './components/admin/question/question.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'admin', component: AdminComponent },
  { path: '**', redirectTo: 'dashboard' }
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    MenuComponent,
    AdminComponent,
    CategoryListComponent,
    QuestionListComponent,
    QuestionComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
