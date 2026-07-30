/* Copyright 2026 上海如静知华信息科技有限公司 */
export const orders=[
 {id:1,no:'TO-20260730-018',customer:'杭州云川智能装备有限公司',origin:'上海·松江',destination:'杭州·滨江',cargo:'工业控制柜 18 台',weight:'8.6 t',volume:'42 m³',pickup:'07-30 08:30',delivery:'07-30 16:30',status:'运输中',priority:'加急',driver:'陈海峰',plate:'沪A·7T528',freight:'¥3,680',progress:68,eta:'14:20'},
 {id:2,no:'TO-20260730-023',customer:'苏州恒微电子科技有限公司',origin:'上海·嘉定',destination:'苏州·园区',cargo:'电子元器件 36 箱',weight:'1.2 t',volume:'9.5 m³',pickup:'07-30 12:30',delivery:'07-30 16:00',status:'待调度',priority:'普通',driver:'—',plate:'—',freight:'¥980',progress:10,eta:'待调度'},
 {id:3,no:'TO-20260730-011',customer:'宁波东港精密制造有限公司',origin:'上海·临港',destination:'宁波·北仑',cargo:'精密减速器 12 托',weight:'14.8 t',volume:'38 m³',pickup:'07-30 06:10',delivery:'07-30 15:00',status:'运输异常',priority:'重点',driver:'徐文斌',plate:'沪C·6P801',freight:'¥4,280',progress:72,eta:'延误 55 分'},
 {id:4,no:'TO-20260730-027',customer:'无锡拓新自动化有限公司',origin:'上海·闵行',destination:'无锡·新吴',cargo:'伺服驱动器 24 托',weight:'6.4 t',volume:'31 m³',pickup:'07-30 14:00',delivery:'07-30 20:00',status:'待调度',priority:'普通',driver:'—',plate:'—',freight:'¥2,360',progress:8,eta:'待调度'},
 {id:5,no:'TO-20260729-096',customer:'嘉兴锐控科技有限公司',origin:'上海·青浦',destination:'嘉兴·南湖',cargo:'运动控制器 8 托',weight:'3.1 t',volume:'18 m³',pickup:'07-29 13:20',delivery:'07-29 18:00',status:'已签收',priority:'普通',driver:'周启明',plate:'沪B·3K917',freight:'¥1,460',progress:100,eta:'已签收'}]
export const vehicles=[
 {plate:'沪A·7T528',type:'9.6米厢式货车',driver:'陈海峰',load:'8.6 / 12 t',status:'执行中',position:'G60 沪昆高速嘉兴段',updated:'2 分钟前'},
 {plate:'沪B·3K917',type:'13米高栏车',driver:'待分配',load:'0 / 32 t',status:'可调度',position:'上海青浦运输基地',updated:'8 分钟前'},
 {plate:'苏E·8M206',type:'4.2米新能源厢货',driver:'待分配',load:'0 / 2.5 t',status:'可调度',position:'苏州工业园区',updated:'6 分钟前'},
 {plate:'沪C·6P801',type:'17.5米平板车',driver:'徐文斌',load:'14.8 / 30 t',status:'异常',position:'G15 沈海高速奉化段',updated:'刚刚'}]
export const timeline=[
 {time:'13:18',title:'车辆通过嘉兴南收费站',detail:'当前位置：G60 沪昆高速嘉兴段 · 车速 76km/h',done:true},
 {time:'10:42',title:'运输途中',detail:'司机已完成途中安全检查，货物状态正常',done:true},
 {time:'09:16',title:'提货完成',detail:'清点 18 台，封签号 SH26073018，装车照片 4 张',done:true},
 {time:'08:47',title:'到达提货点',detail:'上海市松江区新桥镇申港路 688 号',done:true},
 {time:'07:55',title:'司机接单',detail:'陈海峰 · 沪A·7T528',done:true}]
export const alerts=[{level:'紧急',title:'宁波线路预计延误 55 分钟',detail:'G15 奉化段前方事故拥堵，已通知客户及调度主管',time:'13:26'},{level:'提醒',title:'2 张订单尚未完成车辆匹配',detail:'最早计划提货时间 12:30，请尽快调度',time:'12:05'},{level:'证照',title:'司机王德军驾驶证 23 天后到期',detail:'已发送续期提醒',time:'09:10'}]
export const stats=[['今日运输单','28','较昨日 +4 单','navy'],['在途车辆','16','准点率 94.6%','teal'],['待调度','2','最早 12:30 提货','amber'],['异常任务','1','已启动应急处理','red']]
