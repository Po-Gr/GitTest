package ru.consist.models;

/**
 * Доменная модель статуса посылки - является составной частью модели Parcel;
 * Экземпляр класса содержит данные о статусе почтовой посылки
 */
public class ParcelStatus {

    /**
     * Уникальный идентификатор статуса почтовой посылки
     */
    protected int statusCode;

    /**
     * Название статуса почтовой посыки
     */
    protected String statusName;

    public ParcelStatus(int statusCode, String statusName) {
        this.statusCode = statusCode;
        this.statusName = statusName;
    }
}
