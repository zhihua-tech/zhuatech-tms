/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.model;
import jakarta.persistence.*;import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="tms_tracking_event") public class TrackingEvent extends BaseEntity {
    @ManyToOne(fetch=FetchType.LAZY,optional=false) private TransportOrder transportOrder;
    @Column(nullable=false) private LocalDateTime eventTime;
    @Column(nullable=false,length=80) private String location;
    @Column(nullable=false,length=30) private String eventType;
    @Column(nullable=false,length=240) private String description;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected TrackingEvent(){} /**
                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                 */
public TrackingEvent(TransportOrder order,LocalDateTime eventTime,String location,String eventType,String description){this.transportOrder=order;this.eventTime=eventTime;this.location=location;this.eventType=eventType;this.description=description;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public TransportOrder getTransportOrder(){return transportOrder;} /**
                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                       */
public LocalDateTime getEventTime(){return eventTime;} /**
                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                              */
public String getLocation(){return location;} /**
                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                            */
public String getEventType(){return eventType;} /**
                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                            */
public String getDescription(){return description;}
}
