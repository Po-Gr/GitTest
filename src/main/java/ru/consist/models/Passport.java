package ru.consist.models;

import org.joda.time.LocalDateTime;

import java.util.UUID;

/**
 * Доменная модель паспорта - является составной частью модели Person;
 * Экземпляр класса содержит данные о паспорте получателя почтовой посылки
 */
public class Passport {

    /**
     * Уникальный идентификатор паспорта - присваивается в конструкторе при создании нового паспорта в системе
     */
    protected UUID passportId;

    /**
     * Для хранения номера паспорта
     */
    protected int passportNumber;

    /**
     * Для хранения наименования отделения выдачи паспорта
     */
    protected String authority;

    /**
     * Для хранения даты окончания дейстаия паспорта
     */
    protected LocalDateTime dateOfIssue;

    public Passport(int passportNumber, String authority, LocalDateTime dateOfIssue) {
        passportId = UUID.randomUUID();
        this.passportNumber = passportNumber;
        this.authority = authority;
        this.dateOfIssue = dateOfIssue;
    }

    public Passport(UUID passportId, int passportNumber, String authority, LocalDateTime dateOfIssue) {
        this.passportId = passportId;
        this.passportNumber = passportNumber;
        this.authority = authority;
        this.dateOfIssue = dateOfIssue;
    }
}
