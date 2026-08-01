/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.tms.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryRiskService {
    public Result evaluate(Request request) {
        double travelHours = request.remainingKm() / request.averageSpeedKmh();
        double etaHours = travelHours + (travelHours > request.drivingHoursLeft() ? 8 : 0);
        double delayHours = Math.max(0, etaHours - request.promisedHours());
        int score = Math.min(100, (int) Math.round(delayHours / request.promisedHours() * 50
            + request.weatherRisk() * .3 + (request.urgent() ? 10 : 0)));
        String status = score >= 70 ? "DELAY_LIKELY" : score >= 40 ? "AT_RISK" : "ON_TIME";
        List<String> actions = new ArrayList<>();
        if (travelHours > request.drivingHoursLeft()) actions.add("安排合规休息或评估中途换驾");
        if (request.weatherRisk() >= 60) actions.add("核对天气绕行方案和道路管制");
        if (delayHours > 0) actions.add("更新预计到达时间并主动通知收货方");
        if (actions.isEmpty()) actions.add("维持当前运输计划");
        return new Result(request.transportOrderNo(), round(etaHours), round(delayHours), score, status, actions);
    }

    private double round(double value) { return Math.round(value * 100.0) / 100.0; }

    public record Request(@NotBlank String transportOrderNo, @Min(0) double remainingKm,
                          @Positive double averageSpeedKmh, @Min(0) double drivingHoursLeft,
                          @Positive double promisedHours, @Min(0) @Max(100) int weatherRisk,
                          boolean urgent) {}
    public record Result(String transportOrderNo, double etaHours, double delayHours,
                         int riskScore, String status, List<String> actions) {}
}
