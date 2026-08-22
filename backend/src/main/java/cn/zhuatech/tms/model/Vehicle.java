/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.math.BigDecimal;
@Entity @Table(name="tms_vehicle") public class Vehicle extends BaseEntity {
    @Column(nullable=false,unique=true,length=16) private String plateNo;
    @Column(nullable=false,length=40) private String vehicleType;
    @Column(nullable=false,precision=10,scale=2) private BigDecimal capacityTons;
    @Column(nullable=false,precision=10,scale=2) private BigDecimal capacityCbm;
    @Column(nullable=false,length=20) private String status;
    @Column(length=80) private String currentPosition;
    protected Vehicle(){} public Vehicle(String plateNo,String vehicleType,BigDecimal capacityTons,BigDecimal capacityCbm,String status,String currentPosition){this.plateNo=plateNo;this.vehicleType=vehicleType;this.capacityTons=capacityTons;this.capacityCbm=capacityCbm;this.status=status;this.currentPosition=currentPosition;}
    public String getPlateNo(){return plateNo;} public String getVehicleType(){return vehicleType;} public BigDecimal getCapacityTons(){return capacityTons;} public BigDecimal getCapacityCbm(){return capacityCbm;} public String getStatus(){return status;} public String getCurrentPosition(){return currentPosition;}
    public void setStatus(String status){this.status=status;} public void setCurrentPosition(String currentPosition){this.currentPosition=currentPosition;}
}
