package com.pfm.project.domain.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Entity
@Getter
@NoArgsConstructor
@Table(name="STORE")
public class Store {
    // 업소 아이디
    @Id
    @Column(name="store_id")
    private int storeId;

    // 업소명
    @Column(name = "store_name", nullable = false)
    private String storeName;

    // 분류 코드
    @Column(name = "store_type", nullable = false)
    private int storeType;

    // 업소 전화 번호
    @Column(name = "store_number", nullable = false)
    private String storeNumber;

    // 찾아 오시는 길
    @Column(name = "store_waytocome")
    private String storeWayToCome;

    // 자랑거리
    @Column(name = "store_pride")
    private String storePride;

    // 업소 사진
    @Column(name = "store_url")
    private String storeUrl;

    // 업소 정보
    @Column(name = "store_info")
    private String storeInfo;

    // 업소 주소
    @Column(name = "store_address", nullable = false)
    private String storeAddress;

    //https://cheese10yun.github.io/spring-builder-pattern/
    @Builder
    public Store(
            String storeName,
            int storeType,
            String storeNumber,
            String storeWayToCome,
            String storePride,
            String storeUrl,
            String storeInfo,
            String storeAddress
    ) {
        this.storeName = storeName;
        this.storeType = storeType;
        this.storeNumber = storeNumber;
        this.storeWayToCome = storeWayToCome;
        this.storePride = storePride;
        this.storeUrl = storeUrl;
        this.storeInfo = storeInfo;
        this.storeAddress = storeAddress;
    }
}
