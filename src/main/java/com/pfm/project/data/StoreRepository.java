package com.pfm.project.data;

import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.store.response.StoreDetail;
import com.pfm.project.dto.store.response.StoreDetailResponse;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("select s from Store as s join fetch s.place join fetch  s.product where s.storeId = :id")
    Optional<Store> findById(Long id);
}
