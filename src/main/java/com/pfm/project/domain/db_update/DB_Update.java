//package com.pfm.project.domain.db_update;
//
//import org.springframework.data.domain.Persistable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "store_aa")
//public class DB_Update implements Persistable<Long> {
//
//    @Id
//    private Long store_id;
//
//    @Column(length = 50)
//    private String store_name;
//    private int store_type;
//    @Column(length = 10)
//    private String store_type_name;
//    @Column(length = 50)
//    private String store_address;
//    @Column(length = 50)
//    private String store_number;
//    @Column(length = 100)
//    private String store_waytocome;
//    @Column(length = 100)
//    private String store_pride;
//    @Column(length = 100)
//    private String store_url;
//    @Column(length = 100)
//    private String store_info;
//
//    public DB_Update() {
//    }
//
//    public DB_Update(Long store_id, String store_name, int store_type, String store_tpye_name, String store_address, String store_number, String store_waytogo, String store_price, String store_url, String store_info) {
//        this.store_id = store_id;
//        this.store_name = store_name;
//        this.store_type = store_type;
//        this.store_type_name = store_tpye_name;
//        this.store_address = store_address;
//        this.store_number = store_number;
//        this.store_waytocome = store_waytogo;
//        this.store_pride = store_price;
//        this.store_url = store_url;
//        this.store_info = store_info;
//    }
//
//    public Long getStore_id() {
//        return store_id;
//    }
//
//    public String getStore_name() {
//        return store_name;
//    }
//
//    public int getStore_type() {
//        return store_type;
//    }
//
//    public String getStore_type_name() {
//        return store_type_name;
//    }
//
//    public String getStore_address() {
//        return store_address;
//    }
//
//    public String getStore_number() {
//        return store_number;
//    }
//
//    public String getStore_waytocome() {
//        return store_waytocome;
//    }
//
//    public String getStore_pride() {
//        return store_pride;
//    }
//
//    public String getStore_url() {
//        return store_url;
//    }
//
//    public String getStore_info() {
//        return store_info;
//    }
//
//    @Override
//    public Long getId() {
//        return store_id;
//    }
//
//    @Override
//    public boolean isNew() {
//        return true;
//    }
//}
