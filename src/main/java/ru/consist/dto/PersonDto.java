package ru.consist.dto;

import java.util.UUID;

public class PersonDto {

    private String name;

    private String surname;

    private String patronymic;

    private String phone;

    private PassportDto passport;

    public PersonDto() {
    }

    public PersonDto(String name, String surname, String patronymic, String phone, PassportDto passport) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.passport = passport;
    }

    public PersonDto(String name, String surname, String patronymic, String phone) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PassportDto getPassport() {
        return passport;
    }

    public void setPassportId(UUID passportId) {
        this.passport = passport;
    }
}
