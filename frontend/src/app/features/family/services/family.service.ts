import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Family} from '../models/family.model';
import {Father} from '../models/father.model';
import {Child, Sex} from '../models/child.model';
import {FamilyList} from '../models/family-list.model';

@Injectable()
export class FamilyService {

  private familyBaseUrl = '/path/api/family';

  constructor(private http: HttpClient) {
  }

  createFamily(): Observable<Family> {
    return this.http.post<Family>(this.familyBaseUrl, {});
  }

  readFamily(familyId: number): Observable<Family> {
    return this.http.get<Family>(this.familyBaseUrl + '/' + familyId);
  }

  addFatherToFamily(familyId: number, father: Father) {
    return this.http.post(this.familyBaseUrl + '/' + familyId + '/father', father);
  }

  addChildToFamily(familyId: number, child: Child) {
    return this.http.post(this.familyBaseUrl + '/' + familyId + '/children', child);
  }

  searchFamily(childFirstName: string, childSecondName: string, childPesel: string, childSex: Sex): Observable<FamilyList[]> {
    let params = new HttpParams();

    params = childFirstName ? params.set('childFirstName', childFirstName) : params;
    params = childSecondName ? params.set('childSecondName', childSecondName) : params;
    params = childPesel ? params.set('childPesel', childPesel) : params;
    params = childSex ? params.set('childSex', childSex) : params;

    return this.http.get<FamilyList[]>(this.familyBaseUrl + '/search', {params: params});
  }

}
