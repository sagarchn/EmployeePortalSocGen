import { Component, OnInit } from '@angular/core';
declare var $:any;
@Component({
  selector: 'app-app-header',
  templateUrl: './app-header.component.html',
  styleUrls: ['./app-header.component.css']
})
export class AppHeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }


  tabcClick(val) {
    $('.active').removeClass('active');
    $('#' + val).addClass('active');

  }
}
