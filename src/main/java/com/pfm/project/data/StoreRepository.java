package com.pfm.project.data;

import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.store.response.StoreDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("select s from Store as s join fetch s.place join fetch  s.place")
    StoreDetailResponse findById();
}
