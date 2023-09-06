package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.AdvertisementDto;
import com.yuzarsif.freelance.exceptioin.AdvertisementNotFoundException;
import com.yuzarsif.freelance.model.Advertisement;
import com.yuzarsif.freelance.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementSearchService {

    private final AdvertisementRepository repository;

    public AdvertisementSearchService(AdvertisementRepository repository) {
        this.repository = repository;
    }

    public AdvertisementDto findAdvertisementByGivenId(Long id) {
        Advertisement advertisement = getAdvertisementById(id);

        return AdvertisementDto.convert(advertisement);
    }

    protected Advertisement getAdvertisementById(Long id) {
        Advertisement advertisement = repository.findById(id)
                .orElseThrow(
                        () -> new AdvertisementNotFoundException("Advertisement didnt find by id : " + id));

        return advertisement;
    }

    public List<AdvertisementDto> findAdvertisementsByHeader(String header) {
        List<Advertisement> advertisements = repository.findByHeaderContaining(header);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> orderAdvertisementByCreatedDateDesc() {
        List<Advertisement> advertisements = repository.findByOrderByCreatedDateDesc();

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> orderAdvertisementByCreatedDateAsc() {
        List<Advertisement> advertisements = repository.findByOrderByCreatedDateAsc();

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementByHeaderOrderByCreatedDateDesc(String header) {
        List<Advertisement> advertisements = repository.findByHeaderContainingOrderByCreatedDateDesc(header);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementByHeaderOrderByCreatedDateAsc(String header) {
        List<Advertisement> advertisements = repository.findByHeaderContainingOrderByCreatedDateAsc(header);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementByHeaderOrderByViewsDesc(String header) {
        List<Advertisement> advertisements = repository.findByHeaderContainingOrderByViewsDesc(header);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementByHeaderOrderByViewsAsc(String header) {
        List<Advertisement> advertisements = repository.findByHeaderContainingOrderByViewsAsc(header);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementByHeaderOrderByPriceDesc(String header) {
        List<Advertisement> advertisements = repository.findByHeaderContainingOrderByPriceDesc(header);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementByHeaderOrderByPriceAsc(String header) {
        List<Advertisement> advertisements = repository.findByHeaderContainingOrderByPriceAsc(header);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementBetweenPrice(int startPrice, int endPrice) {
        List<Advertisement> advertisements = repository.findByPriceBetween(startPrice, endPrice);

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }


    public List<AdvertisementDto> findAdvertisementOrderByViewsDesc() {
        List<Advertisement> advertisements = repository.findByOrderByViewsDesc();

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

    public List<AdvertisementDto> findAdvertisementOrderByViewsAsc() {
        List<Advertisement> advertisements = repository.findByOrderByViewsAsc();

        return advertisements.stream()
                .map(AdvertisementDto::convert)
                .collect(Collectors.toList());
    }

}
