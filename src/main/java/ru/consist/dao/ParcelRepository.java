package ru.consist.dao;

import org.springframework.stereotype.Component;
import ru.consist.models.Parcel;

import java.util.List;

@Component
public interface ParcelRepository {

    public void save(Parcel parcel);

    public void update(Parcel parcel);

    public void delete(Parcel parcel);

    public List<Parcel> find(ParcelSpecification specification);
}
