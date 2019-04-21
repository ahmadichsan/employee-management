// Lib
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from  '@angular/forms';
import { Router } from  '@angular/router';

// Model
import { User } from  '../../models/user';

// Service
import { AuthService } from  '../../services/auth/auth.service';
import { MenuService } from '../../services/menu/menu.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  isSubmitted = false;

  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder,
    private menuService: MenuService
  ) {
    this.menuService.setShowMenu(false);
  }

  ngOnInit() {
    this.loginForm  =  this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', Validators.required]
    });
  }

  get formControls() { return this.loginForm.controls; }

  onSubmit = () => {
    this.isSubmitted = true;
    if(this.loginForm.invalid){
      return;
    }
    this.authService.login(this.loginForm.value)
      .then((resSuccess) => {
        this.router.navigateByUrl('/dashboard');
      })
      .catch((onRejected) => {
        console.log('reason why login rejected is: ', onRejected);
      });
  }

}
