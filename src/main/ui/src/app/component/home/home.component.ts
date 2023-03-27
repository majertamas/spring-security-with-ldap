import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent{
  form: FormGroup;

  constructor(private http: HttpClient,
              private fb: FormBuilder) {
    this.form = this.fb.group({
      username: [null, Validators.required]
    });
  }

  submit() {
    this.http.get('rest/current-user').subscribe({
      next: value => console.log(value)
    });
  }

  submit2() {
    this.http.post('rest/authorities', {username: this.form.get('username').value}).subscribe({
      next: value => console.log(value),
      error: err => console.log(err)
    });
  }


}
