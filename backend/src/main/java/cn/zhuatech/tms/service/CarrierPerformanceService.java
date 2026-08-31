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

/** 企业承运商绩效卡，用于月度复盘、招标准入和运输份额调整。 */
@Service
public class CarrierPerformanceService {
    public Scorecard evaluate(Request request) {
        int delivered = Math.max(1, request.completedShipments());
        BigDecimal onTimeRate = percent(request.onTimeShipments(), delivered);
        BigDecimal claimRate = percent(request.claimShipments(), delivered);
        BigDecimal podRate = percent(request.electronicPodShipments(), delivered);
        BigDecimal costVarianceRate = request.actualFreight().subtract(request.quotedFreight())
                .multiply(BigDecimal.valueOf(100)).divide(request.quotedFreight(), 2, RoundingMode.HALF_UP);
        int score = onTimeRate.multiply(new BigDecimal("0.45")).intValue()
                + BigDecimal.valueOf(100).subtract(claimRate).multiply(new BigDecimal("0.20")).intValue()
                + Math.max(0, 15 - costVarianceRate.abs().intValue())
                + podRate.multiply(new BigDecimal("0.10")).intValue()
                + Math.max(0, 10 - request.complianceIncidents() * 5);
        score = Math.max(0, Math.min(100, score));
        String tier = score >= 85 ? "A" : score >= 70 ? "B" : score >= 55 ? "C" : "D";
        boolean tenderEligible = score >= 70 && request.complianceIncidents() == 0
                && claimRate.compareTo(new BigDecimal("5")) <= 0;
        List<String> actions = new ArrayList<>();
        if (onTimeRate.compareTo(new BigDecimal("92")) < 0) actions.add("提交线路准时率改善计划");
        if (claimRate.compareTo(new BigDecimal("3")) > 0) actions.add("启动货损索赔专项复盘");
        if (costVarianceRate.abs().compareTo(new BigDecimal("8")) > 0) actions.add("复核报价、里程与附加费规则");
        if (request.complianceIncidents() > 0) actions.add("暂停新增运力分配并完成合规整改");
        if (actions.isEmpty()) actions.add("保持核心承运商份额并进入季度续约池");
        return new Scorecard(request.carrierCode(), onTimeRate, claimRate, podRate,
                costVarianceRate, score, tier, tenderEligible, List.copyOf(actions));
    }

    private BigDecimal percent(int value, int total) {
        return BigDecimal.valueOf(value * 100L).divide(BigDecimal.valueOf(total), 2, RoundingMode.HALF_UP);
    }

    public record Request(@NotBlank String carrierCode, @Min(1) int completedShipments,
                          @Min(0) int onTimeShipments, @Min(0) int claimShipments,
                          @Min(0) int electronicPodShipments, @Min(0) int complianceIncidents,
                          @DecimalMin("0.01") BigDecimal quotedFreight,
                          @DecimalMin("0") BigDecimal actualFreight) {}

    public record Scorecard(String carrierCode, BigDecimal onTimeRate, BigDecimal claimRate,
                            BigDecimal electronicPodRate, BigDecimal costVarianceRate,
                            int score, String tier, boolean tenderEligible, List<String> actions) {}
}
