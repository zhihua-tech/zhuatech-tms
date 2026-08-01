# API 摘要

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 用户登录并签发 JWT |
| GET | `/api/admin/dashboard` | 运营指标与重点订单 |
| GET/POST | `/api/admin/orders` | 查询或创建运输订单 |
| POST | `/api/admin/orders/{id}/dispatch` | 分配司机及车辆 |
| GET | `/api/admin/drivers` | 司机资源列表 |
| GET | `/api/admin/vehicles` | 车辆资源列表 |
| GET | `/api/admin/orders/{id}/tracking` | 查询运输轨迹 |
| GET | `/api/driver/tasks` | 司机任务列表 |
| POST | `/api/driver/tasks/{id}/status` | 上报到场、提货、运输或异常状态 |
| POST | `/api/driver/tasks/{id}/sign` | 提交电子签收回单 |

除登录接口外均需 `Authorization: Bearer <token>`。演示接口仅用于个人非商业学习。

## 交付风险

`POST /api/admin/delivery-risk`：计算在途 ETA、预计延误、风险分和调度动作。
