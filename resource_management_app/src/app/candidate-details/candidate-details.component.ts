// candidate.component.ts
import { Component, OnInit } from '@angular/core';
import { CandidateService } from './candidate.service';
import { AuthService } from '../login/auth.service';
import { UserRole } from '../enums/user-role.enum';
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidate-details',
  templateUrl: './candidate-details.component.html',
  styleUrls: ['./candidate-details.component.css']
})
export class CandidateDetailsComponent implements OnInit {
  userRoles = UserRole;
  id: number | null = null;
  name: string = '';
  email: string = '';
  contactNo: string = '';

  candidates: any[] = [];
  selectedCandidateIndex: number | null = null;


  constructor(private candidateService: CandidateService, public authService: AuthService,private router: Router) {}

  ngOnInit() {
    this.loadCandidates();
  }

  loadCandidates() {
    this.candidateService.getAllCandidates().subscribe({
      next: (data) => {
        this.candidates = data;
      },
      error: (error) => {
        console.error('Error loading candidates', error);
      }
    });
  }

  addCandidate() {
    const candidate = {
      id: this.id,
      name: this.name,
      email: this.email,
      contactNo: this.contactNo
      // Add other properties as needed
    };

    if (this.selectedCandidateIndex !== null) {
      const selectedid = this.candidates[this.selectedCandidateIndex].id;
      this.candidateService.editCandidate(selectedid, candidate).subscribe({
        next: () => {
          this.selectedCandidateIndex = null;
          this.clearForm();
          this.loadCandidates();
        },
        error: (error) => {
          console.error('Error editing candidate', error);
        }
      });
    } else {
      this.candidateService.addCandidate(candidate).subscribe({
        next: () => {
          this.clearForm();
          this.loadCandidates();
        },
        error: (error) => {
          console.error('Error adding candidate', error);
        }
      });
    }
  }

  editCandidate(index: number) {
    console.log("edit working!!");
    this.selectedCandidateIndex = index;
    const selectedCandidate = this.candidates[index];
    this.id = selectedCandidate.id;
    this.name = selectedCandidate.name;
    this.email = selectedCandidate.email;
    this.contactNo = selectedCandidate.contactNo;
  }

  deleteCandidate(index: number) {
    const selectedid = this.candidates[index].id;
    this.candidateService.deleteCandidate(selectedid).subscribe({
      next: () => {
        this.loadCandidates();
      },
      error: (error) => {
        console.error('Error deleting candidate', error);
      }
    });
  }

  clearForm() {
    this.id = null;
    this.name = '';
    this.email = '';
    this.contactNo = '';
  }
  isHomePage(): boolean {
    return this.router.url === '/home';
  }
  
}
