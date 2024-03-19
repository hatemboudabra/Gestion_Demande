import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/demo/service/auth.service';
import { LayoutService } from 'src/app/layout/service/app.layout.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styles: [`
        :host ::ng-deep .pi-eye,
        :host ::ng-deep .pi-eye-slash {
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
    `]
})
export class LoginComponent implements OnInit{

    valCheck: string[] = ['remember'];

    password!: string;

    constructor(public layoutService: LayoutService,public _auth:AuthService,private router:Router) { }
    ngOnInit(): void {
        
    }
    user ={
        username:'',
        password:'',
        
      
      }
      accessToken:any;
      
    login(){

          this._auth.signin(this.user).subscribe(
            (res: { accessToken: string } | any) => { 
              
                console.log(res);
               
                    localStorage.setItem('token', res.accessToken);
                    this.router.navigate(['/']);
            },
            err=>{
              console.log(err);
              this.router.navigate(['/access']);
    
            }
          );
}
}
