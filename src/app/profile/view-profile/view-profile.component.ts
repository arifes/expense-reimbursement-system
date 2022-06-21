import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersHttpService } from 'src/app/users-http.service';
import { User } from 'src/app/users/user.model';

@Component({
  selector: 'view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {
  
  constructor(private userHttpService: UsersHttpService,
              private router: Router) { }

              storeUserInfo(user: User): void{
                sessionStorage.setItem("userInformation", JSON.stringify(user));
              }
           
              
            retreiveUserInfo(): User{
                let  user: User ={
                  userId:0,
                  userFirstName: '',
                  userLastName: '',
                  userEmail: '',
                  userPassword: '',
                  userRole: '',
                };
                
                let userData: any = sessionStorage.getItem("userInformation");
                if(userData!=null){
                  user = JSON.parse(userData);
                }
                return user;
                
              }
  ngOnInit(): void {
  }

  goToUpdateProfile(){
    this.router.navigate(['update-profile'])
  }
 
}
