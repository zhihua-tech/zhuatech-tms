/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.service;

import jakarta.validation.constraints.DecimalMin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FreightCostAuditService {

    public Result audit(Request request) {
        double variance = request.actualFreight() - request.quotedFreight();
        double varianceRate = variance * 100.0 / request.quotedFreight();
        double distanceDeviation = (request.actualDistanceKm() - request.plannedDistanceKm())
                * 100.0 / request.plannedDistanceKm();
        double tollVariance = request.actualTolls() - request.plannedTolls();
        double chargeableWaiting = Math.max(0, request.waitingHours() - request.freeWaitingHours());

        int riskScore = 0;
        List<String> findings = new ArrayList<>();
        if (varianceRate > 12) { riskScore += 40; findings.add("实际运费较报价偏差超过 12%"); }
        else if (varianceRate > 5) { riskScore += 20; findings.add("运费偏差需要承运商说明"); }
        if (distanceDeviation > 10) { riskScore += 25; findings.add("核验绕行、调度变更或轨迹异常"); }
        if (tollVariance > Math.max(100, request.plannedTolls() * 0.2)) { riskScore += 20; findings.add("复核路桥费票据与路线一致性"); }
        if (chargeableWaiting > 2) { riskScore += 20; findings.add("核验超时等待责任和签收记录"); }

        String status = riskScore >= 50 ? "DISPUTE" : riskScore >= 20 ? "REVIEW" : "APPROVE";
        if (findings.isEmpty()) findings.add("费用与合同及运输轨迹一致，可进入结算");
        return new Result(round(variance), round(varianceRate), round(distanceDeviation),
                round(tollVariance), round(chargeableWaiting), riskScore, status, findings);
    }

    private double round(double value) { return Math.round(value * 100.0) / 100.0; }

    public record Request(
            @DecimalMin("0.01") double quotedFreight,
            @DecimalMin("0") double actualFreight,
            @DecimalMin("0.1") double plannedDistanceKm,
            @DecimalMin("0") double actualDistanceKm,
            @DecimalMin("0") double plannedTolls,
            @DecimalMin("0") double actualTolls,
            @DecimalMin("0") double waitingHours,
            @DecimalMin("0") double freeWaitingHours
    ) {}

    public record Result(double freightVariance, double freightVarianceRate, double distanceDeviationRate,
                         double tollVariance, double chargeableWaitingHours, int riskScore,
                         String status, List<String> findings) {}
}
