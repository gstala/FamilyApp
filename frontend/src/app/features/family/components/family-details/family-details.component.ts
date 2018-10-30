import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {FamilyService} from '../../services/family.service';
import {switchMap} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {Family} from '../../models/family.model';

@Component({
  selector: 'app-family-details',
  templateUrl: './family-details.component.html',
  styleUrls: ['./family-details.component.css']
})
export class FamilyDetailsComponent implements OnInit {

  family$: Observable<Family>;

  constructor(private route: ActivatedRoute, private familyService: FamilyService) {
  }

  ngOnInit() {
    this.family$ = this.route.params.pipe(
      switchMap(params => this.familyService.readFamily(params.id))
    );
  }

}
