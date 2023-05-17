package com.pfm.project.data;

import com.pfm.project.domain.place.Place;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place,Long> {

// @Query문 필요예정

//    @Query(value = "SELECT store_id" +
//            " FROM place" +
//            " WHERE latitude BETWEEN ?1 AND ?2" +
//            " AND longtitude BETWEEN ?3 AND ?4", nativeQuery = true)
//    Optional<List<Place>> findByLatitudeBetweenANDLongtitudeBetween(
//            double latittude,
//            double latittude2,
//            double longtitude,
//            double longtitude2
//    );


    Optional<List<Place>> findAllByLatitudeOrderByLatitudeDesc(double latittude);

    Optional<List<Place>> findTop7ByLatitudeOrderByLatitudeDesc(double latittude);


}
