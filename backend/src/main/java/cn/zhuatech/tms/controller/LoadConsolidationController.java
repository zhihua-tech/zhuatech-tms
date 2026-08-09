/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.tms.controller;

import cn.zhuatech.tms.common.ApiResponse;
import cn.zhuatech.tms.service.LoadConsolidationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tms/insights")
public class LoadConsolidationController {
    private final LoadConsolidationService service;

    public LoadConsolidationController(LoadConsolidationService service) {
        this.service = service;
    }

    @PostMapping("/load-consolidation")
    public ApiResponse<LoadConsolidationService.Result> evaluate(
        @Valid @RequestBody LoadConsolidationService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
