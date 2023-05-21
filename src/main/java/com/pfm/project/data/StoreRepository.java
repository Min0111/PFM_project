package com.pfm.project.data;

import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.store.response.StoreBriefInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("select s from Store as s join fetch s.place join fetch  s.product where s.storeId = :id")
    Optional<Store> findById(Long id);

    @Query(value = "select " +
                "s.store_id as storeId, s.store_name as storeName, s.store_type as storeType, s.store_pride as storePride, s.store_address as storeAddress, p.latitude as latitude, p.longitude as longitude, " +
            "ST_DISTANCE_SPHERE(POINT(:userLatitude, :userLongitude), Point(p.latitude, p.longitude)) as dist " +
            "from " +
                "pfm_local.store as s " +
            "inner join pfm_local.place as p on s.store_id = p.store_id " +
            "where " +
                "p.latitude <= :upLeftLatitude " +
                "and p.latitude >= :downRightLatitude " +
                "and p.longitude >= :upLeftLongitude " +
                "and p.longitude <= :downRightLongitude " +
            "group by s.store_id order by dist limit 20 offset :offset", nativeQuery = true
    )
    List<StoreBriefInfo> findAllByMapOrderByDistance(
            double upLeftLatitude,
            double upLeftLongitude,
            double downRightLatitude,
            double downRightLongitude,
            double userLatitude,
            double userLongitude,
            int offset
        );

//    @Query(value = "select s.store_id as storeId, s.store_name as storeName, s.store_type as storeType, s.store_pride as storePride, s.store_address as storeAddress, pl.latitude as latitude, pl.longitude as longitude, " +
//            "ST_DISTANCE_SPHERE(POINT(:userLatitude, :userLongitude), Point(pl.latitude, pl.longitude)) AS dist " +
//            "from pfm_local.store as s inner join pfm_local.place as pl on s.store_id = pl.store_id " +
//            "left join pfm_local.product as pr on s.store_id = pr.store_id " +
//            "where pl.latitude between :downRightLatitude and :upLeftLatitude and pl.longitude between :upLeftLongitude and :downRightLongitude " +
//            "and (s.store_name like concat('%', :userInput, '%') or pr.product_name like concat('%', :userInput, '%')) " +
//            "group by s.store_id order by " +
//            "case when s.store_name like concat('%', :userInput, '%') then 1 " +
//            "when pr.product_name like concat('%', :userInput, '%') then 2 else 3 end, dist asc", nativeQuery = true)
//    List<StoreBriefInfo> findAllByMapOrderByDistanceWithWord(
//            double upLeftLatitude,
//            double upLeftLongitude,
//            double downRightLatitude,
//            double downRightLongitude,
//            double userLatitude,
//            double userLongitude,
//            String userInput,
//            int offset
//    );

//    @Query(value = "select distinct " +
//            "s.store_id as storeId, s.store_name as storeName, s.store_type as storeType, s.store_pride as storePride, s.store_address as storeAddress, pl.latitude as latitude, pl.longitude as longitude, " +
//            "ST_DISTANCE_SPHERE(POINT(:userLatitude, :userLongitude), Point(pl.latitude, pl.longitude)) as dist " +
//            "from " +
//            "pfm_local.store as s " +
//            "inner join pfm_local.place as pl on s.store_id = pl.store_id " +
//            "inner join pfm_local.product as pr on s.store_id = pr.store_id " +
//            "where " +
//            "pl.latitude <= :upLeftLatitude " +
//            "and pl.latitude >= :downRightLatitude " +
//            "and pl.longitude >= :upLeftLongitude " +
//            "and pl.longitude <= :downRightLongitude " +
//            "and (s.store_name like concat('%', :userInput, '%') or pr.product_name like concat('%', :userInput, '%')) " +
//            "group by s.store_id " +
//            "order by " +
//            "case when s.store_name like concat('%', :userInput, '%') then 1 " +
//            "when pr.product_name like concat('%', :userInput, '%') then 2 " +
//            "else 3 " +
//            "end, dist asc", nativeQuery = true
//    )
//    "order by case " +
//            "when s.store_name like CONTACT('%', :userInput, '%') then 1 " +
//            "when pr.product_name like CONTACT('%', :userInput, '%') then 2 " +
//            "else 3 " +
//            "end, distance asc", nativeQuery = true
}
