# 数据库设计

- `sys_user`：运营管理员、调度员和司机账号。
- `tms_driver`：司机证照、联系方式及可调度状态。
- `tms_vehicle`：车牌、车型、载重、容积与实时位置。
- `tms_transport_order`：客户、货物、起讫地、计划时窗、运力、状态和运费。
- `tms_tracking_event`：到场、提货、运输、异常及签收时间轴。

初始化脚本位于 `backend/src/main/resources/db/migration/V1__init.sql`，表名、索引及外键均通过 Flyway 管理。
