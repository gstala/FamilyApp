import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Sex} from '../../models/child.model';
import {FamilyService} from '../../services/family.service';
import {Observable} from 'rxjs';
import {FamilyList} from '../../models/family-list.model';

@Component({
  selector: 'app-search-family',
  templateUrl: './search-family.component.html',
  styleUrls: ['./search-family.component.css']
})
export class SearchFamilyComponent implements OnInit {

  searchFormGroup = new FormGroup({
      childFirstNameCtrl: new FormControl(),
      childSecondNameCtrl: new FormControl(),
      childPeselCtrl: new FormControl(),
      childSexCtrl: new FormControl(),
    }
  );
  sexes = [];
  displayedColumns: string[] = ['fatherFirstName', 'fatherSecondName', 'fatherPesel', 'fatherBirthDate'];
  families: FamilyList[] = [];

  constructor(private familyService: FamilyService) {
  }

  ngOnInit() {
    this.sexes = Object.keys(Sex);
  }

  searchFamily() {
    this.familyService.searchFamily(
      this.searchFormGroup.get('childFirstNameCtrl').value,
      this.searchFormGroup.get('childSecondNameCtrl').value,
      this.searchFormGroup.get('childPeselCtrl').value,
      this.searchFormGroup.get('childSexCtrl').value,
    ).subscribe(families => this.families = families);
  }

  searchAvailability() {
    return Object.values(this.searchFormGroup.controls).some(({value}) => !!value || value === 0);
  }

}
