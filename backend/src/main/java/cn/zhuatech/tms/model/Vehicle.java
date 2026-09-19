/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.math.BigDecimal;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="tms_vehicle") public class Vehicle extends BaseEntity {
    @Column(nullable=false,unique=true,length=16) private String plateNo;
    @Column(nullable=false,length=40) private String vehicleType;
    @Column(nullable=false,precision=10,scale=2) private BigDecimal capacityTons;
    @Column(nullable=false,precision=10,scale=2) private BigDecimal capacityCbm;
    @Column(nullable=false,length=20) private String status;
    @Column(length=80) private String currentPosition;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Vehicle(){} /**
                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                           */
public Vehicle(String plateNo,String vehicleType,BigDecimal capacityTons,BigDecimal capacityCbm,String status,String currentPosition){this.plateNo=plateNo;this.vehicleType=vehicleType;this.capacityTons=capacityTons;this.capacityCbm=capacityCbm;this.status=status;this.currentPosition=currentPosition;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getPlateNo(){return plateNo;} /**
                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                 */
public String getVehicleType(){return vehicleType;} /**
                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                     */
public BigDecimal getCapacityTons(){return capacityTons;} /**
                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                               */
public BigDecimal getCapacityCbm(){return capacityCbm;} /**
                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                       */
public String getStatus(){return status;} /**
                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                 */
public String getCurrentPosition(){return currentPosition;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void setStatus(String status){this.status=status;} /**
                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                               */
public void setCurrentPosition(String currentPosition){this.currentPosition=currentPosition;}
}
