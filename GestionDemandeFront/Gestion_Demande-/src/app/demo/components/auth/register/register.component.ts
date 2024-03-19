import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/demo/service/auth.service';
import { LayoutService } from 'src/app/layout/service/app.layout.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styles: [`
  :host ::ng-deep .pi-eye,
  :host ::ng-deep .pi-eye-slash {
      transform:scale(1.6);
      margin-right: 1rem;
      color: var(--primary-color) !important;
  }
`]
})
export class RegisterComponent implements OnInit {

  valCheck: string[] = ['remember'];

  password!: string; 
  constructor(public layoutService: LayoutService,public _auth:AuthService,private router:Router) { }
  user ={
    username: "",
    email: "",
    role: [
      "ROLE_User"
    ],
    password: "",
    firstname: "",
    lastename: "",
    cin: "",
    retypePassword:"",
    phone: ""
  }
  ngOnInit(): void {
    
  }
  register(){
    if (this.user.password !== this.user.retypePassword) {
      alert("Les mots de passe ne correspondent pas.");
      // Gérer l'erreur ici, par exemple, afficher un message à l'utilisateur
      return;
    }
    this._auth.signup(this.user).subscribe(
      (res)=>{
        console.log(this.user);
        this.router.navigate(['/']);

      console.log(res);
      
    // localStorage.setItem('token',this.token.myToken);
     
      },
      err=>{
        alert('verifier vos champs et votre email');
        console.log(err.error.message);
        console.log(err);

      }
    );
}
}
