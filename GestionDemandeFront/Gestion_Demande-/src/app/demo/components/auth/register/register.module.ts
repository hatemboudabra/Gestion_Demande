import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { ButtonModule } from 'primeng/button';
import { CheckboxModule } from 'primeng/checkbox';
import { FormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import { RegisterComponent } from './register.component';


@NgModule({
  imports: [
    CommonModule,
    ButtonModule,
    CheckboxModule,
    RegisterRoutingModule,
    InputTextModule,
    FormsModule,
    PasswordModule
  ],
  declarations: [RegisterComponent]
})
export class RegisterModule { }
