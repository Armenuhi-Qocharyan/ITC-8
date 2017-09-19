package com.itc.decorators;

public class PersonDecorator implements Person {

    protected Person person;

    public PersonDecorator(Person person){
        this.person=person;
    }

    public void about() {
        this.person.about();
    }
}
