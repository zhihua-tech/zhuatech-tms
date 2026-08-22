/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.controller;

import cn.zhuatech.tms.common.ApiResponse;
import cn.zhuatech.tms.service.TransportCarbonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tms/insights")
public class TransportCarbonController {
    private final TransportCarbonService service;
    public TransportCarbonController(TransportCarbonService service) { this.service = service; }

    @PostMapping("/carbon-estimate")
    public ApiResponse<TransportCarbonService.Result> estimate(@Valid @RequestBody TransportCarbonService.Request request) {
        return ApiResponse.ok(service.estimate(request));
    }
}
