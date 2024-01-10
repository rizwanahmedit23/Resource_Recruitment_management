import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ResourceRequirementsComponent } from './resource-requirements/resource-requirements.component';
import { CandidateDetailsComponent } from './candidate-details/candidate-details.component'; 
import { HRDiscussionComponent } from './hr-discussion/hr-discussion.component';
import { Level1FeedbackComponent } from './level1-feedback/level1-feedback.component';
import { Level2FeedbackComponent } from './level2-feedback/level2-feedback.component';
import { HomeComponent } from './home/home.component';
import { DiscussionDetailsComponent } from './discussion-details/discussion-details.component';
import { NavbarComponent } from './navbar/navbar.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ResourceRequirementsComponent,
    CandidateDetailsComponent, 
    HRDiscussionComponent,
    Level1FeedbackComponent,
    Level2FeedbackComponent,
    HomeComponent,
    DiscussionDetailsComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }