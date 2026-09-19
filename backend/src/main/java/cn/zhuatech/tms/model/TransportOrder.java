/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="tms_transport_order") public class TransportOrder extends BaseEntity {
    @Column(nullable=false,unique=true,length=32) private String orderNo;
    @Column(nullable=false,length=80) private String customerName;
    @Column(nullable=false,length=120) private String origin;
    @Column(nullable=false,length=120) private String destination;
    @Column(nullable=false,length=120) private String cargoName;
    @Column(nullable=false,precision=10,scale=2) private BigDecimal weightTons;
    @Column(nullable=false,precision=10,scale=2) private BigDecimal volumeCbm;
    @Column(nullable=false) private LocalDateTime plannedPickupAt;
    @Column(nullable=false) private LocalDateTime plannedDeliveryAt;
    @Column(nullable=false,length=24) private String status;
    @Column(nullable=false,length=20) private String priority;
    @ManyToOne(fetch=FetchType.LAZY) private Driver driver;
    @ManyToOne(fetch=FetchType.LAZY) private Vehicle vehicle;
    @Column(precision=12,scale=2) private BigDecimal freightAmount;
    @Column(length=200) private String proofRemark;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected TransportOrder(){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public TransportOrder(String orderNo,String customerName,String origin,String destination,String cargoName,BigDecimal weightTons,BigDecimal volumeCbm,LocalDateTime plannedPickupAt,LocalDateTime plannedDeliveryAt,String status,String priority,BigDecimal freightAmount){this.orderNo=orderNo;this.customerName=customerName;this.origin=origin;this.destination=destination;this.cargoName=cargoName;this.weightTons=weightTons;this.volumeCbm=volumeCbm;this.plannedPickupAt=plannedPickupAt;this.plannedDeliveryAt=plannedDeliveryAt;this.status=status;this.priority=priority;this.freightAmount=freightAmount;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOrderNo(){return orderNo;} /**
                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                 */
public String getCustomerName(){return customerName;} /**
                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                       */
public String getOrigin(){return origin;} /**
                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                 */
public String getDestination(){return destination;} /**
                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                     */
public String getCargoName(){return cargoName;} /**
                                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                     */
public BigDecimal getWeightTons(){return weightTons;} /**
                                                                                                                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                           */
public BigDecimal getVolumeCbm(){return volumeCbm;} /**
                                                                                                                                                                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                               */
public LocalDateTime getPlannedPickupAt(){return plannedPickupAt;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                  */
public LocalDateTime getPlannedDeliveryAt(){return plannedDeliveryAt;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         */
public String getStatus(){return status;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   */
public String getPriority(){return priority;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 */
public Driver getDriver(){return driver;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           */
public Vehicle getVehicle(){return vehicle;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        */
public BigDecimal getFreightAmount(){return freightAmount;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    */
public String getProofRemark(){return proofRemark;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void dispatch(Driver driver,Vehicle vehicle){this.driver=driver;this.vehicle=vehicle;this.status="待提货";driver.setStatus("任务中");vehicle.setStatus("执行中");}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void updateStatus(String status){this.status=status;} /**
                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                  */
public void sign(String remark){this.status="已签收";this.proofRemark=remark;if(driver!=null)driver.setStatus("可调度");if(vehicle!=null)vehicle.setStatus("可调度");}
}
