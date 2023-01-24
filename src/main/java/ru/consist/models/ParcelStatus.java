package ru.consist.models;

public class ParcelStatus {

    protected int statusCode;

    protected String statusName;

    public ParcelStatus(int statusCode, String statusName) {
        this.statusCode = statusCode;
        this.statusName = statusName;
    }
}
