import { Component } from '@angular/core';

import { MdDialog } from '@angular/material';
import { PopupContentComponent } from '../popup-content/popup-content.component';


@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class AppPopupComponent {
  constructor(public popup: MdDialog) {}
  openDialog() {
    this.popup.open(PopupContentComponent);
  }
}

