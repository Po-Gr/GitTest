package ru.consist.dao;

import org.springframework.stereotype.Component;
import ru.consist.models.Parcel;
import ru.consist.models.ParcelStatus;
import ru.consist.models.ParcelStatusUtil;
import ru.consist.models.ParcelUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ParcelRepositoryMemory implements ParcelRepository {

    private final Logger logger = LoggerFactory.getLogger(ParcelRepositoryMemory.class);

    private final Map<UUID, Parcel> parcelTable = new ConcurrentHashMap<>();

    @Override
    public void save(Parcel parcel) {
        parcelTable.put((UUID) ParcelUtil.getParcelFields(parcel).get("parcelNumber"), parcel);

        logger.info(String.valueOf(parcelTable));
        logger.info(String.valueOf(ParcelUtil.getParcelFields(parcel)));
    }

    @Override
    public void update(Parcel parcel) {
        save(parcel);
    }

    @Override
    public void delete(Parcel parcel) {
        parcelTable.remove((UUID) ParcelUtil.getParcelFields(parcel).get("parcelNumber"));
    }

    @Override
    public List<Parcel> find(ParcelSpecification specification) {
        List<Parcel> parcels = new ArrayList<>();
        if (specification instanceof ParcelByIdSpecification) {
            ParcelByIdSpecification parcelByIdSpecification = (ParcelByIdSpecification) specification;

            parcels.add(parcelTable.get(parcelByIdSpecification.getId()));
        }
        if (specification instanceof AllParcelsSpecification) {
            parcels = new ArrayList<>(parcelTable.values());
        }
        if (specification instanceof UnclosedParcelsSpecification) {
            UnclosedParcelsSpecification unclosedParcelsSpecification = (UnclosedParcelsSpecification) specification;
            int closedStatusCode = unclosedParcelsSpecification.getClosedStatusCode();

            for (Parcel parcel: parcelTable.values()) {
                if ((int) ParcelStatusUtil.getStatusFields((ParcelStatus) ParcelUtil.getParcelFields(parcel).get("status")).get("statusCode") != closedStatusCode) {
                    parcels.add(parcel);
                }
            }
        }
        return parcels;
    }
}
