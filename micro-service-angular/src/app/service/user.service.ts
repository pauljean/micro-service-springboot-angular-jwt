import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { User } from '../modele/user';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/backend/users`);
    }
}