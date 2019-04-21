import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  private showMenu: BehaviorSubject<boolean>;

  constructor() {
    this.showMenu = new BehaviorSubject(false);
  }

  getShowMenu(): Observable<boolean> {
    return this.showMenu.asObservable();
  }

  setShowMenu(bool: boolean) {
    this.showMenu.next(bool);
  }
}
