import { Component, OnInit } from '@angular/core';
import { RestService } from "../../service/rest.service";
import { Category } from "../../model/category";
import { Skill } from "../../model/skill";
import { FormControl } from "@angular/forms";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  categoryList: string[];
  skillList: string[];

  categories: FormControl<string>;
  skills: FormControl<string>;

  selectedCategories: string;
  selectedSkills: string;

  constructor(private restService: RestService) {
  }

  ngOnInit(): void {
    this.loadCategories();
    this.loadSkills();
  }

  private loadCategories() {
    this.restService.getCategories()
      .subscribe(
        (result: Category[]) => {
          this.categoryList = result.map(category => category.name);
        }
      );
  }

  private loadSkills() {
    this.restService.getSkills()
      .subscribe(
        (result: Skill[]) => {
          this.skillList = result.map(skill => skill.name);
        }
      );
  }

  selectionChange() {
    console.log(this.selectedCategories);
    console.log(this.selectedSkills);
    this.selectedCategories = this.categories.value;
    this.selectedSkills = this.skills.value;
  }

}
