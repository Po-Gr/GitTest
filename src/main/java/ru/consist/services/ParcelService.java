package ru.consist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.consist.dao.AllParcelsSpecification;
import ru.consist.dao.ParcelByIdSpecification;
import ru.consist.dao.ParcelRepository;
import ru.consist.dao.UnclosedParcelsSpecification;
import ru.consist.models.Parcel;

import java.util.List;
import java.util.UUID;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    @Autowired
    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public void save(Parcel parcel) {
        parcelRepository.save(parcel);
    }

    public void update(Parcel parcel) {
        parcelRepository.update(parcel);
    }

    public void delete(Parcel parcel) {
        parcelRepository.delete(parcel);
    }

    public List<Parcel> show(Object showUnclosed) {
        if(showUnclosed != null && (boolean) showUnclosed) {
            return findUnclosedParcels();
        }
        return findAllParcels();
    }

    public List<Parcel> findParcelById(UUID id) {
        return parcelRepository.find(new ParcelByIdSpecification(id));
    }

    public List<Parcel> findAllParcels() {
        return parcelRepository.find(new AllParcelsSpecification());
    }

    public List<Parcel> findUnclosedParcels() {
        return parcelRepository.find(new UnclosedParcelsSpecification());
    }

}
