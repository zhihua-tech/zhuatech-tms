/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.tms;

import cn.zhuatech.tms.service.CarrierPerformanceService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CarrierPerformanceServiceTests {
    private final CarrierPerformanceService service = new CarrierPerformanceService();

    @Test void blocksCarrierWithComplianceIncident() {
        var result = service.evaluate(new CarrierPerformanceService.Request("CAR-01", 100, 96, 1, 98, 1,
                new BigDecimal("100000"), new BigDecimal("103000")));
        assertThat(result.tenderEligible()).isFalse();
        assertThat(result.actions()).anyMatch(value -> value.contains("合规整改"));
    }

    @Test void gradesHighPerformingCarrier() {
        var result = service.evaluate(new CarrierPerformanceService.Request("CAR-02", 100, 98, 1, 99, 0,
                new BigDecimal("100000"), new BigDecimal("101000")));
        assertThat(result.tier()).isEqualTo("A");
        assertThat(result.tenderEligible()).isTrue();
    }
}
