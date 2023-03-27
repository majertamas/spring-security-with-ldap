import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  form: FormGroup;

  constructor(private http: HttpClient,
              private router: Router,
              private fb: FormBuilder) {
    this.form = this.fb.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  submit() {
    let formData: any = new FormData();
    formData.append('username', this.form.get('username').value);
    formData.append('password', this.form.get('password').value);
    this.http
      .post('http://localhost:8080/login', formData)
      .subscribe({
        next: (response) => console.log(response),
        error: (error) => {
          if (error.status === 200) {
            this.router.navigate(['/home'])
          }
        },
      });
  }
}
