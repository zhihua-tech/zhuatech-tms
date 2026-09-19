/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.tms.controller;

import cn.zhuatech.tms.common.ApiResponse;
import cn.zhuatech.tms.service.DeliveryRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin")
public class DeliveryRiskController {
    private final DeliveryRiskService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DeliveryRiskController(DeliveryRiskService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/delivery-risk")
    public ApiResponse<DeliveryRiskService.Result> evaluate(@Valid @RequestBody DeliveryRiskService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
