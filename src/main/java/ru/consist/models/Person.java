package ru.consist.models;

import java.util.UUID;

/**
 * Доменная модель человека - является составной частью модели Parcel;
 * Экземпляр класса содержит данные о получателе или отправителе почтовой посылки
 */
public class Person {

    /**
     * Уникальный идентификатор человека - присваивается в конструкторе при создании нового человека в системе
     */
    protected UUID personId;

    /**
     * Для хранения имени
     */
    protected String name;

    /**
     * Для хранения фамилии
     */
    protected String surname;

    /**
     * Для хранения отчества, не обязательное поле
     */
    protected String patronymic;

    /**
     * Для хранения номера телефона, не обязательное поле
     */
    protected String phone;

    /**
     * Для хранения информации о паспорте, не обязательное поле
     */
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
