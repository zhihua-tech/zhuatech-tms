/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.tms.dto;
import cn.zhuatech.tms.model.*;import jakarta.validation.constraints.*;import java.math.BigDecimal;import java.time.LocalDateTime;import java.util.List;
public final class TmsDto {private TmsDto(){}
    public record Dashboard(long totalOrders,long inTransit,long pendingDispatch,long exceptions,long availableVehicles,BigDecimal todayFreight,List<OrderView> urgentOrders){}
    public record OrderView(Long id,String orderNo,String customerName,String origin,String destination,String cargoName,BigDecimal weightTons,BigDecimal volumeCbm,LocalDateTime plannedPickupAt,LocalDateTime plannedDeliveryAt,String status,String priority,String driverName,String plateNo,BigDecimal freightAmount,String proofRemark){public static OrderView from(TransportOrder o){return new OrderView(o.getId(),o.getOrderNo(),o.getCustomerName(),o.getOrigin(),o.getDestination(),o.getCargoName(),o.getWeightTons(),o.getVolumeCbm(),o.getPlannedPickupAt(),o.getPlannedDeliveryAt(),o.getStatus(),o.getPriority(),o.getDriver()==null?null:o.getDriver().getName(),o.getVehicle()==null?null:o.getVehicle().getPlateNo(),o.getFreightAmount(),o.getProofRemark());}}
    public record DriverView(Long id,String code,String name,String phone,String licenseNo,String status){public static DriverView from(Driver d){return new DriverView(d.getId(),d.getCode(),d.getName(),d.getPhone(),d.getLicenseNo(),d.getStatus());}}
    public record VehicleView(Long id,String plateNo,String vehicleType,BigDecimal capacityTons,BigDecimal capacityCbm,String status,String currentPosition){public static VehicleView from(Vehicle v){return new VehicleView(v.getId(),v.getPlateNo(),v.getVehicleType(),v.getCapacityTons(),v.getCapacityCbm(),v.getStatus(),v.getCurrentPosition());}}
    public record TrackingView(LocalDateTime eventTime,String location,String eventType,String description){public static TrackingView from(TrackingEvent e){return new TrackingView(e.getEventTime(),e.getLocation(),e.getEventType(),e.getDescription());}}
    public record CreateOrderRequest(@NotBlank String customerName,@NotBlank String origin,@NotBlank String destination,@NotBlank String cargoName,@Positive BigDecimal weightTons,@Positive BigDecimal volumeCbm,@NotNull LocalDateTime plannedPickupAt,@NotNull LocalDateTime plannedDeliveryAt,@NotBlank String priority,@PositiveOrZero BigDecimal freightAmount){}
    public record DispatchRequest(@NotNull Long driverId,@NotNull Long vehicleId){}
    public record StatusRequest(@NotBlank String status,@NotBlank String location,String remark){}
    public record SignRequest(@NotBlank String location,@NotBlank String receiver,@NotBlank String remark){}
}
