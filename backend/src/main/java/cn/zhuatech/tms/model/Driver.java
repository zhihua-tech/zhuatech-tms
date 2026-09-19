/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.time.LocalDate;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="tms_driver") public class Driver extends BaseEntity {
    @Column(nullable=false,unique=true,length=24) private String code;
    @Column(nullable=false,length=40) private String name;
    @Column(nullable=false,length=20) private String phone;
    @Column(nullable=false,length=30) private String licenseNo;
    @Column(nullable=false) private LocalDate licenseExpiry;
    @Column(nullable=false,length=20) private String status;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Driver(){} /**
                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                          */
public Driver(String code,String name,String phone,String licenseNo,LocalDate licenseExpiry,String status){this.code=code;this.name=name;this.phone=phone;this.licenseNo=licenseNo;this.licenseExpiry=licenseExpiry;this.status=status;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getCode(){return code;} /**
                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                           */
public String getName(){return name;} /**
                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                 */
public String getPhone(){return phone;} /**
                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                         */
public String getLicenseNo(){return licenseNo;} /**
                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                         */
public LocalDate getLicenseExpiry(){return licenseExpiry;} /**
                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                    */
public String getStatus(){return status;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void setStatus(String status){this.status=status;}
}
