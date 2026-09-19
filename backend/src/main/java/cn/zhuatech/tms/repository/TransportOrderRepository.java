/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.repository;
import cn.zhuatech.tms.model.TransportOrder;import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface TransportOrderRepository extends JpaRepository<TransportOrder,Long>{/**
                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                      */
List<TransportOrder> findAllByOrderByPlannedPickupAtAsc();/**
                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                */
long countByStatus(String status);}
