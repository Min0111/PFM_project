package com.pfm.project.data;

import com.pfm.project.domain.place.Place;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place,Long> {

    @Override
    @EntityGraph(attributePaths = {"store"})
    List<Place> findAll();





}
