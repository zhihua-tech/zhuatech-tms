/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.LocalDateTime;
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
    protected TransportOrder(){}
    public TransportOrder(String orderNo,String customerName,String origin,String destination,String cargoName,BigDecimal weightTons,BigDecimal volumeCbm,LocalDateTime plannedPickupAt,LocalDateTime plannedDeliveryAt,String status,String priority,BigDecimal freightAmount){this.orderNo=orderNo;this.customerName=customerName;this.origin=origin;this.destination=destination;this.cargoName=cargoName;this.weightTons=weightTons;this.volumeCbm=volumeCbm;this.plannedPickupAt=plannedPickupAt;this.plannedDeliveryAt=plannedDeliveryAt;this.status=status;this.priority=priority;this.freightAmount=freightAmount;}
    public String getOrderNo(){return orderNo;} public String getCustomerName(){return customerName;} public String getOrigin(){return origin;} public String getDestination(){return destination;} public String getCargoName(){return cargoName;} public BigDecimal getWeightTons(){return weightTons;} public BigDecimal getVolumeCbm(){return volumeCbm;} public LocalDateTime getPlannedPickupAt(){return plannedPickupAt;} public LocalDateTime getPlannedDeliveryAt(){return plannedDeliveryAt;} public String getStatus(){return status;} public String getPriority(){return priority;} public Driver getDriver(){return driver;} public Vehicle getVehicle(){return vehicle;} public BigDecimal getFreightAmount(){return freightAmount;} public String getProofRemark(){return proofRemark;}
    public void dispatch(Driver driver,Vehicle vehicle){this.driver=driver;this.vehicle=vehicle;this.status="待提货";driver.setStatus("任务中");vehicle.setStatus("执行中");}
    public void updateStatus(String status){this.status=status;} public void sign(String remark){this.status="已签收";this.proofRemark=remark;if(driver!=null)driver.setStatus("可调度");if(vehicle!=null)vehicle.setStatus("可调度");}
}
