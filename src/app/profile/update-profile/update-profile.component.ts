import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersHttpService } from 'src/app/users-http.service';
import { User } from 'src/app/users/user.model';

@Component({
  selector: 'update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  user: User ={
    userId:0,
    userFirstName: '',
    userLastName: '',
    userEmail: '',
    userPassword: '',
    userRole: '',
  }
  storeUserInfo(user: User): void{
    sessionStorage.setItem("userInformation", JSON.stringify(user));
  }
//  user = sessionStorage.getItem("userinformation");
 
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
  

  constructor(private activatedRoute: ActivatedRoute, 
    private usersHttpService: UsersHttpService,
    private router: Router) { }

  ngOnInit(): void {
     let updateUser = this.activatedRoute.snapshot.paramMap.get('user');
     console.log(updateUser);

     
    
     }
     updateUserInfo(user: User){
      this.usersHttpService.updateUser(user).subscribe((response)=>{
        this.router.navigate(['view-http-books']);
      })
    }
  
    logTheChanges(title: any){
      console.log(title);
    }
 
}


