/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.tms.repository;
import cn.zhuatech.tms.model.TrackingEvent;import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
public interface TrackingEventRepository extends JpaRepository<TrackingEvent,Long>{List<TrackingEvent> findByTransportOrderIdOrderByEventTimeDesc(Long orderId);}
