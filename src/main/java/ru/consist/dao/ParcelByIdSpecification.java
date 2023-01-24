package ru.consist.dao;

import java.util.UUID;

public class ParcelByIdSpecification implements ParcelSpecification {

    UUID id;

    public ParcelByIdSpecification(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
