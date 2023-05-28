package com.pfm.project.domain.place;

import com.pfm.project.domain.store.Store;
import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Getter
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place")
public class Place {
    @Id
    @Column(name = "store_id")
    private Long id;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;


    @OneToOne(targetEntity = Store.class)
    @MapsId
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;



    @Builder
    public Place(Long id, double latitude, double longitude, Store store) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.store = store;
    }







}