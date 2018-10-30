import {Person} from './person.model';

export class Father extends Person {
  birthDate: Date;

  constructor(id: number, pesel: string, firstName: string, secondName: string, birthDate: Date) {
    super(id, pesel, firstName, secondName);
    this.birthDate = birthDate;
  }
}
