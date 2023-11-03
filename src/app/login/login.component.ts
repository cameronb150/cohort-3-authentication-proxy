import { Component } from '@angular/core';
import { LoginModel } from './login-model';
import { FormBuilder } from '@angular/forms';
import { AccountsService } from '../accounts.service';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    error: boolean = false;
    loginForm = this.formBuilder.group({
        username: '',
        password: ''
    })

    constructor(private formBuilder: FormBuilder, private accountsService: AccountsService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.queryParams.subscribe((params) => {
            this.error = params["error"];
            console.log(this.error);
        });
    }

    onSubmit(): void {
        this.accountsService.login(this.loginForm.value.username!, this.loginForm.value.password!);
    }
}
