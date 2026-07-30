/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.tms.repository;
import cn.zhuatech.tms.model.TransportOrder;import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
public interface TransportOrderRepository extends JpaRepository<TransportOrder,Long>{List<TransportOrder> findAllByOrderByPlannedPickupAtAsc();long countByStatus(String status);}
