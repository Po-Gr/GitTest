package ru.consist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.consist.dto.ParcelDto;
import ru.consist.dtoMappers.ParcelDtoMapper;
import ru.consist.models.Parcel;
import ru.consist.services.ParcelService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/postal_service")
public class ParcelController {

    private final ParcelService parcelService;
    private final ParcelDtoMapper mapper;

    @Autowired
    public ParcelController(ParcelService parcelService, ParcelDtoMapper mapper) {
        this.parcelService = parcelService;
        this.mapper = mapper;
    }

    @RequestMapping(method = GET)
    public List<ParcelDto> getUnclosedParcels(@RequestParam(value = "show_unclosed", required = false) Boolean showUnclosed) {
        List<Parcel> parcels = parcelService.show(showUnclosed);

        List<ParcelDto> parcelsDto = new ArrayList<>();
        for (Parcel parcel: parcels) {
            parcelsDto.add(mapper.mapForGet(parcel));
        }
        return parcelsDto;
    }

    @RequestMapping(method = GET, value = "/{id}")
    public ParcelDto getParcel(@PathVariable String id) {
        Parcel parcel = parcelService.findParcelById(UUID.fromString(id)).get(0);
        return mapper.mapForGet(parcel);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveParcel(@RequestBody ParcelDto dto) {
        parcelService.save(mapper.mapForCreate(dto));
    }

    @RequestMapping(method = PATCH, value = "/{id}")
    public void updateParcel(@PathVariable String id, @RequestBody ParcelDto dto) {
        parcelService.update(mapper.mapForUpdate(dto, UUID.fromString(id)));
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public void deleteParcel(@PathVariable String id) {
        parcelService.delete(parcelService.findParcelById(UUID.fromString(id)).get(0));
    }
}
