/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.tms.controller;

import cn.zhuatech.tms.common.ApiResponse;
import cn.zhuatech.tms.service.DeliveryRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class DeliveryRiskController {
    private final DeliveryRiskService service;
    public DeliveryRiskController(DeliveryRiskService service) { this.service = service; }

    @PostMapping("/delivery-risk")
    public ApiResponse<DeliveryRiskService.Result> evaluate(@Valid @RequestBody DeliveryRiskService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
