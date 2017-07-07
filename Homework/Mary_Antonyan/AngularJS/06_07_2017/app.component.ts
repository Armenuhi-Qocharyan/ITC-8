import { Component } from '@angular/core';

@Component({
    selector: 'fullName',
    template: `
    <form class='name forms' id='ElementfullName' style='display: none;'>
        <label for='fname'>First Name</label>
        <br/>
        <input class='inputs' type='text' id='fname' name='firstname' placeholder='Name...' disabled/>
        <br/>
        <label for='lname'>Last Name</label>
        <br/>
        <input class='inputs' type='text' id='lname' name='lastname' placeholder='Last name..' disabled/>
        <button type='button' class='btn btn-danger btn-circle btn-xl RemoveButton' onclick='Remove(this)'>
            <i class='glyphicon glyphicon-remove'></i>
        </button>
    </form>`
})
