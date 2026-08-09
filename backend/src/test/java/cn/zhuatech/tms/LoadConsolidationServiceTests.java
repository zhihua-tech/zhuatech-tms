/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.tms;

import cn.zhuatech.tms.service.LoadConsolidationService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadConsolidationServiceTests {
    private final LoadConsolidationService service = new LoadConsolidationService();

    @Test
    void consolidatesCompatibleLoadWithMeaningfulUtilizationGain() {
        var result = service.evaluate(new LoadConsolidationService.Request(
            "SH-PD-01", new BigDecimal("10000"), new BigDecimal("5000"), 8,
            new BigDecimal("2500"), new BigDecimal("8"), new BigDecimal("0.8"),
            new BigDecimal("15")));

        assertEquals(new BigDecimal("0.7500"), result.combinedUtilization());
        assertEquals(new BigDecimal("6.40"), result.extraEmissionKg());
        assertEquals("CONSOLIDATE", result.decision());
    }

    @Test
    void keepsLoadsSeparateWhenVehicleWouldBeOverloaded() {
        var result = service.evaluate(new LoadConsolidationService.Request(
            "SH-SZ-02", new BigDecimal("10000"), new BigDecimal("8500"), 10,
            new BigDecimal("2200"), new BigDecimal("5"), new BigDecimal("0.8"),
            new BigDecimal("15")));

        assertEquals("KEEP_SEPARATE", result.decision());
    }
}
