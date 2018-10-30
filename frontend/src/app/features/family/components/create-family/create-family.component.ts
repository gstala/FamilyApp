import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {Child, Sex} from '../../models/child.model';
import {FamilyService} from '../../services/family.service';
import {MatSnackBar} from '@angular/material';
import {Father} from '../../models/father.model';
import {Router} from '@angular/router';
import {forkJoin} from 'rxjs';
import {exhaustMap, switchMap, tap} from 'rxjs/operators';

@Component({
  selector: 'app-create-family',
  templateUrl: './create-family.component.html',
  styleUrls: ['./create-family.component.css']
})
export class CreateFamilyComponent implements OnInit {

  children: Child[] = [];
  familyId: number;

  fatherFormGroup = new FormGroup({
      firstNameCtrl: new FormControl(),
      secondNameCtrl: new FormControl(),
      peselCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(11),
        Validators.maxLength(11),
        this.checkPeselCorrectness()
      ]),
      birthDateCtrl: new FormControl(),
    }
  );
  childFormGroup = new FormGroup({
    firstNameCtrl: new FormControl(),
    secondNameCtrl: new FormControl(),
    peselCtrl: new FormControl('', [
      Validators.required,
      Validators.minLength(11),
      Validators.maxLength(11),
      this.checkPeselCorrectness()
    ]),
    sexCtrl: new FormControl()
  });
  sexes = [];

  constructor(private familyService: FamilyService, public snackBar: MatSnackBar, private router: Router) {
  }

  addChild() {
    this.children.push(new Child(
      null,
      this.childFormGroup.get('peselCtrl').value,
      this.childFormGroup.get('firstNameCtrl').value,
      this.childFormGroup.get('secondNameCtrl').value,
      this.childFormGroup.get('sexCtrl').value
    ));
    this.childFormGroup.reset();
    this.snackBar.open('Child added', null, {
      duration: 2000,
    });
  }

  checkPeselCorrectness(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      const containsOnlyNumbers = /^[0-9]+$/.test(control.value);
      return !containsOnlyNumbers ? {'Wrong PESEL': {value: control.value}} : null;
    };
  };

  //
  // checkPeselCorrectness(pesel: string) {
  //   return pesel.length === 11 && /^[0-9]+$/.test(pesel);
  // }

  ngOnInit() {
    this.sexes = Object.keys(Sex);
  }

  saveFamily() {
    this.familyService.createFamily()
      .pipe(
        tap(family => this.familyId = family.id),
        switchMap(() => {
          return this.familyService.addFatherToFamily(this.familyId, new Father(
            null,
            this.fatherFormGroup.get('peselCtrl').value,
            this.fatherFormGroup.get('firstNameCtrl').value,
            this.fatherFormGroup.get('secondNameCtrl').value,
            this.fatherFormGroup.get('birthDateCtrl').value
          ));
        }),
        exhaustMap(() => {
          return forkJoin(this.children.map(x => this.familyService.addChildToFamily(this.familyId, x)));
        })
      ).subscribe((data) => {
      this.router.navigate(['/family/' + this.familyId + '/details']);
      this.children = [];
    });
  }

}
