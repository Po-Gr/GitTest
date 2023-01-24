package ru.consist.dao;

public class UnclosedParcelsSpecification implements ParcelSpecification {

    private final int closedStatusCode = 8;

    public UnclosedParcelsSpecification() {
    }

    public int getClosedStatusCode() {
        return closedStatusCode;
    }
}
