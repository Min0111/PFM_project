package com.pfm.project.data;

import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.store.response.StoreDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store,Long> {

    Optional<List<Store>> findAllByStoreNameContaining(String searchname);

    Optional<List<Store>> findAllByProduct_ProductName(String searchname);

    @Query("select s from Store as s join fetch s.place join fetch  s.place")
    StoreDetailResponse findById();


}
