import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ResourceRequirementsComponent } from './resource-requirements/resource-requirements.component';
import { CandidateDetailsComponent } from './candidate-details/candidate-details.component'; 
import { HRDiscussionComponent } from './hr-discussion/hr-discussion.component';
import { Level1FeedbackComponent } from './level1-feedback/level1-feedback.component';
import { Level2FeedbackComponent } from './level2-feedback/level2-feedback.component';
import { HomeComponent } from './home/home.component';
import { DiscussionDetailsComponent } from './discussion-details/discussion-details.component';
import { AuthGuard } from './guards/auth.guard';
import { UserRole } from './enums/user-role.enum';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'hr-discussion', component: HRDiscussionComponent, canActivate: [AuthGuard], data: { expectedRole: UserRole.HR_MANAGER } },
  { path: 'resource-requirements', component: ResourceRequirementsComponent },
  { path: 'candidate-details', component: CandidateDetailsComponent, canActivate: [AuthGuard], data: { expectedRole: UserRole.RECRUITER } },
  { path: 'discussion-details', component: DiscussionDetailsComponent },
  { path: 'level1-feedback', component: Level1FeedbackComponent, canActivate: [AuthGuard], data: { expectedRole: UserRole.LEVEL1_PANEL } },
  { path: 'level2-feedback', component: Level2FeedbackComponent, canActivate: [AuthGuard], data: { expectedRole: UserRole.LEVEL2_PANEL } },
  { path: '', redirectTo: '/login', pathMatch: 'full' }, 
  { path: '**', redirectTo: '/login' } ,
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
