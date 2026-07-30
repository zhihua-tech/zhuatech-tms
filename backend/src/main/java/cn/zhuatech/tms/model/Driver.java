/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.time.LocalDate;
@Entity @Table(name="tms_driver") public class Driver extends BaseEntity {
    @Column(nullable=false,unique=true,length=24) private String code;
    @Column(nullable=false,length=40) private String name;
    @Column(nullable=false,length=20) private String phone;
    @Column(nullable=false,length=30) private String licenseNo;
    @Column(nullable=false) private LocalDate licenseExpiry;
    @Column(nullable=false,length=20) private String status;
    protected Driver(){} public Driver(String code,String name,String phone,String licenseNo,LocalDate licenseExpiry,String status){this.code=code;this.name=name;this.phone=phone;this.licenseNo=licenseNo;this.licenseExpiry=licenseExpiry;this.status=status;}
    public String getCode(){return code;} public String getName(){return name;} public String getPhone(){return phone;} public String getLicenseNo(){return licenseNo;} public LocalDate getLicenseExpiry(){return licenseExpiry;} public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}
