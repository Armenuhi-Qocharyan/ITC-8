package com.itc.decorators;

public class Main {
    public static void main(String[] args) {
        Person familyPerson = new PersonWithFamily(new SomePerson());
        familyPerson.about();
        Person personWithJob = new PersonWithFamily(new PersonWithJob(new SomePerson()));
        personWithJob.about();
    }
}
