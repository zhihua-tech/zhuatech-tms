/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.tms;

import cn.zhuatech.tms.service.FreightCostAuditService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class FreightCostAuditServiceTests {
    private final FreightCostAuditService service = new FreightCostAuditService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void disputesLargeFreightAndRouteDeviation() {
        var result = service.audit(new FreightCostAuditService.Request(3000, 3700, 500, 590, 300, 480, 7, 2));
        assertEquals("DISPUTE", result.status());
        assertTrue(result.riskScore() >= 50);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void approvesContractAlignedFreight() {
        var result = service.audit(new FreightCostAuditService.Request(3000, 3060, 500, 510, 300, 320, 2, 2));
        assertEquals("APPROVE", result.status());
    }
}
