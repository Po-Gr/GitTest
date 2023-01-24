package ru.consist.models;

import java.util.UUID;

public class Person {

    protected UUID personId;

    protected String name;

    protected String surname;

    protected String patronymic;

    protected String phone;

    protected Passport passport;

    public Person(String name, String surname, String patronymic, String phone, Passport passport) {
        personId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.passport = passport;
    }

    public Person(UUID personId, String name, String surname, String patronymic, String phone, Passport passport) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.passport = passport;
    }
}
