package com.pfm.project.data;

import com.pfm.project.domain.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepasitory extends JpaRepository<Store,Long> {

    Optional<List<Store>> findAllByStoreNameContaining(String searchname);

    Optional<List<Store>> findAllByProduct_ProductName(String searchname);


}
