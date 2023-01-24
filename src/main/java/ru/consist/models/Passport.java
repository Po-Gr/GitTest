package ru.consist.models;

import org.joda.time.LocalDateTime;

import java.util.UUID;

public class Passport {

    protected UUID passportId;

    protected int passportNumber;

    protected String authority;

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
