/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.tms;

import cn.zhuatech.tms.service.TransportCarbonService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TransportCarbonServiceTests {
    private final TransportCarbonService service = new TransportCarbonService();

    @Test void gradesEfficientFullLoadTransport() {
        var result = service.estimate(new TransportCarbonService.Request("TMS-1001", new BigDecimal("500"),
            BigDecimal.ZERO, new BigDecimal("12"), new BigDecimal("15"), new BigDecimal("0.80")));
        assertThat(result.efficiencyGrade()).isEqualTo("A");
        assertThat(result.emissionsKgCo2e()).isEqualByComparingTo("400.00");
    }

    @Test void recommendsReturnLoadForEmptyMileage() {
        var result = service.estimate(new TransportCarbonService.Request("TMS-1002", new BigDecimal("300"),
            new BigDecimal("180"), new BigDecimal("4"), new BigDecimal("12"), new BigDecimal("1.10")));
        assertThat(result.emptyMileageRate()).isGreaterThan(new BigDecimal("0.20"));
        assertThat(result.actions()).anyMatch(action -> action.contains("返程货源"));
    }
}
