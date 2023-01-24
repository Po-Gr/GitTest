package ru.consist.dto;

public class ParcelStatusDto {

    private int statusCode;

    private String statusName;

    public ParcelStatusDto() {
    }

    public ParcelStatusDto(String statusName) {
        this.statusName = statusName;
    }

    public ParcelStatusDto(int statusCode, String statusName) {
        this.statusCode = statusCode;
        this.statusName = statusName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
