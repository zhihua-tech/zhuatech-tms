/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransportCarbonService {
    public Result estimate(Request request) {
        BigDecimal totalDistance = request.distanceKm().add(request.emptyReturnKm());
        BigDecimal emissions = totalDistance.multiply(request.emissionFactorKgPerKm()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal tonKilometers = request.cargoWeightTon().multiply(request.distanceKm());
        BigDecimal intensity = emissions.divide(tonKilometers, 4, RoundingMode.HALF_UP);
        BigDecimal loadFactor = request.cargoWeightTon().divide(request.vehicleCapacityTon(), 4, RoundingMode.HALF_UP);
        BigDecimal emptyRate = request.emptyReturnKm().divide(totalDistance, 4, RoundingMode.HALF_UP);
        String efficiency = intensity.compareTo(new BigDecimal("0.08")) <= 0 ? "A"
            : intensity.compareTo(new BigDecimal("0.15")) <= 0 ? "B" : "C";
        List<String> actions = new ArrayList<>();
        if (loadFactor.compareTo(new BigDecimal("0.70")) < 0) actions.add("合并相邻线路订单以提升车辆装载率");
        if (emptyRate.compareTo(new BigDecimal("0.20")) > 0) actions.add("匹配返程货源以降低空驶里程");
        if ("C".equals(efficiency)) actions.add("评估新能源车辆或低排放承运商替换方案");
        if (actions.isEmpty()) actions.add("保持当前运输方案并留存碳排核算凭证");
        return new Result(request.shipmentNo(), emissions, intensity, loadFactor, emptyRate, efficiency, actions);
    }

    public record Request(@NotBlank String shipmentNo,
                          @DecimalMin("0.01") BigDecimal distanceKm,
                          @DecimalMin("0") BigDecimal emptyReturnKm,
                          @DecimalMin("0.01") BigDecimal cargoWeightTon,
                          @DecimalMin("0.01") BigDecimal vehicleCapacityTon,
                          @DecimalMin("0.0001") BigDecimal emissionFactorKgPerKm) {}
    public record Result(String shipmentNo, BigDecimal emissionsKgCo2e,
                         BigDecimal intensityKgPerTonKm, BigDecimal loadFactor,
                         BigDecimal emptyMileageRate, String efficiencyGrade, List<String> actions) {}
}
