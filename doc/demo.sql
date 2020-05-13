CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(32) DEFAULT '' COMMENT '账号',
  `password` varchar(128) DEFAULT '' COMMENT '密码',
  `nick_name` varchar(20) DEFAULT '' COMMENT '昵称',
  `create_time` int(10) DEFAULT '0' COMMENT '新增时间',
  `update_time` int(10) DEFAULT '0' COMMENT '修改时间',
  `delete_status` tinyint(1) DEFAULT '1' COMMENT '是否删除(1 正常  2删除)',
  `delete_time` int(10) DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COMMENT='用户';