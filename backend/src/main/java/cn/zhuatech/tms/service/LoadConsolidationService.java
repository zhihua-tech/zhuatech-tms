/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoadConsolidationService {
    public Result evaluate(Request request) {
        BigDecimal combinedWeight = request.plannedWeightKg().add(request.additionalWeightKg());
        BigDecimal currentUtilization = request.plannedWeightKg()
            .divide(request.vehicleCapacityKg(), 4, RoundingMode.HALF_UP);
        BigDecimal combinedUtilization = combinedWeight
            .divide(request.vehicleCapacityKg(), 4, RoundingMode.HALF_UP);
        BigDecimal extraEmission = request.extraDistanceKm().multiply(request.emissionFactorKgPerKm())
            .setScale(2, RoundingMode.HALF_UP);
        boolean overloaded = combinedUtilization.compareTo(BigDecimal.ONE) > 0;
        boolean excessiveDetour = request.extraDistanceKm().compareTo(request.maxDetourKm()) > 0;
        BigDecimal utilizationGain = combinedUtilization.subtract(currentUtilization);
        String decision = overloaded || excessiveDetour ? "KEEP_SEPARATE"
            : utilizationGain.compareTo(new BigDecimal("0.15")) >= 0 ? "CONSOLIDATE" : "REVIEW";

        List<String> actions = new ArrayList<>();
        if (overloaded) actions.add("保留独立运输，合单后将超过车辆核定载重");
        if (excessiveDetour) actions.add("重新选择顺路订单或调整停靠顺序");
        if ("CONSOLIDATE".equals(decision)) actions.add("合并运输任务并重新生成装载与签收顺序");
        if (actions.isEmpty()) actions.add("人工复核时间窗、体积与车型适配后决定是否合单");
        return new Result(request.routeCode(), currentUtilization, combinedUtilization,
            extraEmission, decision, actions);
    }

    public record Request(@NotBlank String routeCode,
                          @DecimalMin("0.01") BigDecimal vehicleCapacityKg,
                          @DecimalMin("0") BigDecimal plannedWeightKg,
                          @Min(1) int plannedOrderCount,
                          @DecimalMin("0") BigDecimal additionalWeightKg,
                          @DecimalMin("0") BigDecimal extraDistanceKm,
                          @DecimalMin("0") BigDecimal emissionFactorKgPerKm,
                          @DecimalMin("0") BigDecimal maxDetourKm) {}

    public record Result(String routeCode, BigDecimal currentUtilization,
                         BigDecimal combinedUtilization, BigDecimal extraEmissionKg,
                         String decision, List<String> actions) {}
}
