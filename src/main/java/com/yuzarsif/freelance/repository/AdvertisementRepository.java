package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findByHeaderContaining(String header);

    List<Advertisement> findByHeaderContainingOrderByCreatedDateDesc(String header);

    List<Advertisement> findByHeaderContainingOrderByCreatedDateAsc(String header);

    List<Advertisement> findByHeaderContainingOrderByViewsDesc(String header);

    List<Advertisement> findByHeaderContainingOrderByViewsAsc(String header);

    List<Advertisement> findByHeaderContainingOrderByPriceDesc(String header);

    List<Advertisement> findByHeaderContainingOrderByPriceAsc(String header);

    List<Advertisement> findByOrderByCreatedDateDesc();

    List<Advertisement> findByOrderByCreatedDateAsc();

    List<Advertisement> findByPriceBetween(int startPrice, int endPrice);

    List<Advertisement> findByOrderByViewsDesc();

    List<Advertisement> findByOrderByViewsAsc();
}
