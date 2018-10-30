import {Person} from './person.model';

export enum Sex {
  MALE = 'MALE',
  FEMALE = 'FEMALE'
}

export class Child extends Person {
  sex: Sex;

  constructor(id: number, pesel: string, firstName: string, secondName: string, sex: Sex) {
    super(id, pesel, firstName, secondName);
    this.sex = sex;
  }
}
