import {Component, OnInit} from '@angular/core';
import {RestService} from "../../service/rest.service";
import {Category} from "../../model/category";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss'
})
export class AdminComponent {

  // dataSource: Category[];
  //
  // constructor(private restService: RestService) {
  // }
  //
  // ngOnInit(): void {
  //   this.getCategories();
  // }
  //
  // private getCategories() {
  //   this.restService.getCategories()
  //     .subscribe((categories: Category[]) => {
  //       this.dataSource = categories;
  //     });
  // }

}
