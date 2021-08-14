import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent implements OnInit {

  submitted: boolean;
  loading: boolean;
  lastName: string;
  firstName: string;
  username: string
  password: string;
  doNotMatch: string;
  
  errors: string;
  errorEmailExists: string;
  errorUserExists: string;
  success: boolean;
  userEmail: string;
  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder) { }




  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      // login: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(50), Validators.pattern('^[_.@A-Za-z0-9-]*$')]],
      email: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(254), Validators.email]],
      password: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
      confirmPassword: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
      // telephone: [
      //   null,
      //   [
      //     Validators.required,
      //     Validators.pattern(
      //       ''
      //     )
      //   ]
      // ],
      // profession: [],
      // adressePostale: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(50)]],
      firstName: [undefined, [Validators.required, Validators.minLength(2), Validators.maxLength(50)]],
      lastName: [undefined, []],
      username: [null, Validators.required]
    });

  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    let registerAccount = {};
    let profile = {}
    const email = this.registerForm.get(['email']).value;
    const login = email;
    const password = this.registerForm.get(['password']).value;
    // const telephone= this.registerForm.get(['telephone']).value;
    // const profession=this.registerForm.get(['profession']).value;
    // const adressePostale= this.registerForm.get(['adressePostale']).value;
    // const firstName=this.registerForm.get(['firstName']).value;
    // const lastName=this.registerForm.get(['lastName']).value;


    if (password !== this.registerForm.get(['confirmPassword']).value) {
      this.doNotMatch = 'ERROR';
    } else {
      registerAccount = { ...registerAccount, login, email, password };
      this.doNotMatch = null;
      this.errors = null;
      this.errorUserExists = null;
      this.errorEmailExists = null;
      console.log(registerAccount)
    }
  }

  private processError(response: HttpErrorResponse) {
    this.success = null;
    if (response.status === 400 && response.error.type === "LOGIN_ALREADY_USED_TYPE") {
      this.errorUserExists = 'ERROR';
    } else if (response.status === 400 && response.error.type === "EMAIL_ALREADY_USED_TYPE") {
      this.errorEmailExists = 'ERROR';
    } else {
      this.errors = 'ERROR';
    }
  }

}
