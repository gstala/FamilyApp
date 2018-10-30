export abstract class Person {
  id: number;
  pesel: string;
  firstName: string;
  secondName: string;

  protected constructor(id: number, pesel: string, firstName: string, secondName: string) {
    this.id = id;
    this.pesel = pesel;
    this.firstName = firstName;
    this.secondName = secondName;
  }
}
