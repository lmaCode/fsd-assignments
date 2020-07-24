import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared.module';
import { CommonModule } from "@angular/common";

import { FormsComponent } from './forms/forms.component';
import { VideoService } from '../videoservice';

@NgModule({
    imports: [
        RouterModule,
        SharedModule,
        CommonModule
    ],
    declarations: [
        FormsComponent
    ],
    providers: [VideoService],
    entryComponents: [
        FormsComponent
    ],
    exports: []
})
export class AddNewVideoModule {
}
