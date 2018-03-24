import {Component, ElementRef, HostListener, OnInit, ViewChild} from '@angular/core';
import {Tech} from './tech';
//надо реализовать get/post. туториал на этом сайте: https://metanit.com/web/angular2/6.5.php
//в файле tech.ts добавить поля в соответсвии с БД
//в html компоненте реализовать отображение в соответсвии с туториалом, для этого нужен БЭК

@Component({
  selector: 'app-tech',
  templateUrl: './tech.component.html',
  styleUrls: ['./tech.component.css']
})
export class TechComponent implements OnInit {

  agriculture: string;
  pottery: string; //573,100,573,133,932,133,932,100
  husbandry: string; //573,214,573,246,932,246,932,214
  archery: string; //573,289,573,323,932,323,932,289
  mining: string; //573,365,573,398,932,398,932,365
  sailing: string; //1061,151,1061,229,1420,229,1420,151
  calendar: string; //1061,241,1061,319,1420,319,1420,241
  writing: string; //1061,331,1061,410,1420,410,1420,331
  trapping: string; //1061,422,1061,500,1420,500,1420,422
  wheel: string; //1061,603,1061,683,1420,8683,1420,603
  masonry: string; //1061,874,1061,964,1420,954,1420,874
  bronze: string; //1061,966,1061,1045,1420,1045,1420,
  optics: string; //1548 and 1908
  philosophy: string;
  horseriding: string;
  mathematics: string;
  construction: string;
  iron: string;

  constructor() {
    this.coords();
  }

  @HostListener('window:resize') onResize() {
    this.coords();
  }

  ngOnInit() {
  }

  coords() {
      this.agriculture = '';
      this.agriculture += Math.round(document.body.clientWidth * 0.044792) + ',';
      this.agriculture += '252,';
      this.agriculture += Math.round(document.body.clientWidth * 0.044792) + ',';
      this.agriculture += '283,';
      this.agriculture += Math.round(document.body.clientWidth * 0.23021) + ',';
      this.agriculture += '283,';
      this.agriculture += Math.round(document.body.clientWidth * 0.23021) + ',';
      this.agriculture += '252';
      this.pottery = '';
      this.pottery += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.pottery += '100,';
      this.pottery += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.pottery += '133,';
      this.pottery += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.pottery += '133,';
      this.pottery += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.pottery += '100';
      this.husbandry = '';
      this.husbandry += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.husbandry += '214,';
      this.husbandry += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.husbandry += '246,';
      this.husbandry += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.husbandry += '246,';
      this.husbandry += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.husbandry += '214';
      this.archery = '';
      this.archery += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.archery += '289,';
      this.archery += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.archery += '323,';
      this.archery += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.archery += '323,';
      this.archery += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.archery += '289';
      this.mining = '';
      this.mining += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.mining += '365,';
      this.mining += Math.round(document.body.clientWidth * 0.2984375) + ',';
      this.mining += '398,';
      this.mining += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.mining += '398,';
      this.mining += Math.round(document.body.clientWidth * 0.48541666666667) + ',';
      this.mining += '365';
      this.sailing = '';
      this.sailing += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.sailing += '63,';
      this.sailing += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.sailing += '95,';
      this.sailing += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.sailing += '95,';
      this.sailing += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.sailing += '63';
      this.calendar = '';
      this.calendar += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.calendar += '100,';
      this.calendar += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.calendar += '133,';
      this.calendar += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.calendar += '133,';
      this.calendar += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.calendar += '100';
      this.writing = '';
      this.writing += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.writing += '138,';
      this.writing += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.writing += '171,';
      this.writing += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.writing += '171,';
      this.writing += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.writing += '138';
      this.trapping = '';
      this.trapping += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.trapping += '176,';
      this.trapping += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.trapping += '208,';
      this.trapping += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.trapping += '208,';
      this.trapping += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.trapping += '176';
      this.wheel = '';
      this.wheel += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.wheel += '251,';
      this.wheel += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.wheel += '285,';
      this.wheel += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.wheel += '285,';
      this.wheel += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.wheel += '251';
      this.masonry = '';
      this.masonry += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.masonry += '364,';
      this.masonry += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.masonry += '398,';
      this.masonry += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.masonry += '398,';
      this.masonry += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.masonry += '364';
      this.bronze += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.bronze += '402,';
      this.bronze += Math.round(document.body.clientWidth * 0.5526) + ',';
      this.bronze += '435,';
      this.bronze += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.bronze += '435,';
      this.bronze += Math.round(document.body.clientWidth * 0.73958333) + ',';
      this.bronze += '402';
      this.optics = '';
      this.optics += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.optics += '63,';
      this.optics += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.optics += '95,';
      this.optics += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.optics += '95,';
      this.optics += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.optics += '63';
      this.philosophy = '';
      this.philosophy += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.philosophy += '138,';
      this.philosophy += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.philosophy += '171,';
      this.philosophy += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.philosophy += '171,';
      this.philosophy += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.philosophy += '138';
      this.horseriding = '';
      this.horseriding += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.horseriding += '214,';
      this.horseriding += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.horseriding += '247,';
      this.horseriding += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.horseriding += '247,';
      this.horseriding += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.horseriding += '214';
      this.mathematics = '';
      this.mathematics += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.mathematics += '289,';
      this.mathematics += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.mathematics += '323,';
      this.mathematics += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.mathematics += '323,';
      this.mathematics += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.mathematics += '289';
      this.construction = '';
      this.construction += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.construction += '364,';
      this.construction += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.construction += '398,';
      this.construction += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.construction += '398,';
      this.construction += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.construction += '364';
      this.iron = '';
      this.iron += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.iron += '402,';
      this.iron += Math.round(document.body.clientWidth * 0.80625) + ',';
      this.iron += '435,';
      this.iron += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.iron += '435,';
      this.iron += Math.round(document.body.clientWidth * 0.99375) + ',';
      this.iron += '402';
  }
}
