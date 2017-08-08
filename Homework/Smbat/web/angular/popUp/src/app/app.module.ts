import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MaterialModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { AppPopupComponent } from './popup/popup.component';
import { PopupContentComponent } from './popup-content/popup-content.component';

@NgModule({
  declarations: [
    AppComponent,
    AppPopupComponent,
    PopupContentComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  entryComponents: [PopupContentComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
