import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {
  allRequests: Request [] = [];

  constructor() { }

  getAllRequests(): Request []{
    return this.allRequests;
  }
}
