/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.time.LocalDateTime;
@Entity @Table(name="tms_tracking_event") public class TrackingEvent extends BaseEntity {
    @ManyToOne(fetch=FetchType.LAZY,optional=false) private TransportOrder transportOrder;
    @Column(nullable=false) private LocalDateTime eventTime;
    @Column(nullable=false,length=80) private String location;
    @Column(nullable=false,length=30) private String eventType;
    @Column(nullable=false,length=240) private String description;
    protected TrackingEvent(){} public TrackingEvent(TransportOrder order,LocalDateTime eventTime,String location,String eventType,String description){this.transportOrder=order;this.eventTime=eventTime;this.location=location;this.eventType=eventType;this.description=description;}
    public TransportOrder getTransportOrder(){return transportOrder;} public LocalDateTime getEventTime(){return eventTime;} public String getLocation(){return location;} public String getEventType(){return eventType;} public String getDescription(){return description;}
}
