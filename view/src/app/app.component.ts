// Lib
import { Component } from '@angular/core';

// Service
import { MenuService } from '../app/services/menu/menu.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'companyEmployee';
  showMenu: boolean;

  constructor(private menuService: MenuService) {}

  ngOnInit() {
    this.menuService.getShowMenu().subscribe(val => this.showMenu = val);
  }
}
