/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.tms.controller;

import cn.zhuatech.tms.common.ApiResponse;
import cn.zhuatech.tms.service.FreightCostAuditService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tms/insights/freight-cost-audit")
public class FreightCostAuditController {
    private final FreightCostAuditService service;

    public FreightCostAuditController(FreightCostAuditService service) { this.service = service; }

    @PostMapping
    public ApiResponse<FreightCostAuditService.Result> audit(
            @Valid @RequestBody FreightCostAuditService.Request request) {
        return ApiResponse.ok(service.audit(request));
    }
}
