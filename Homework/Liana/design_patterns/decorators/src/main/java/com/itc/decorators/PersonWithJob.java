package com.itc.decorators;

public class PersonWithJob extends PersonDecorator {
    public PersonWithJob(Person person) {
        super(person);
    }

    public void about() {
        super.about();
        System.out.println("Person get a job");
    }
}
