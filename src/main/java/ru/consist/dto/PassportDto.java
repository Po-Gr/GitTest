package ru.consist.dto;

import org.joda.time.LocalDateTime;

public class PassportDto {

    private int passportNumber;

    private String authority;

    private LocalDateTime dateOfIssue;

    public PassportDto() {
    }

    public PassportDto(int passportNumber, String authority, LocalDateTime dateOfIssue) {
        this.passportNumber = passportNumber;
        this.authority = authority;
        this.dateOfIssue = dateOfIssue;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public LocalDateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDateTime dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}
