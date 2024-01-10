// candidate.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {
  private baseUrl = 'http://localhost:8080/api/candidates'; 

  constructor(private http: HttpClient) {}

  addCandidate(candidate: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/addCandidate`, candidate);
  }

  editCandidate(id: number, candidate: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/updateCandidate`, candidate);
  }

  deleteCandidate(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteCandidate/${id}`);
  }

  getAllCandidates(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getCandidates`);
  }
}
