/*
 Navicat Premium Data Transfer

 Source Server         : virtual_server
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 192.168.56.101:3306
 Source Schema         : dance

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 24/02/2021 07:13:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '随笔', '2020-11-30 13:38:01', '2020-11-30 13:38:01');
INSERT INTO `tb_category` VALUES ('2', 'Java', '2020-12-01 14:47:29', '2020-12-01 14:47:29');

-- ----------------------------
-- Table structure for tb_client
-- ----------------------------
DROP TABLE IF EXISTS `tb_client`;
CREATE TABLE `tb_client`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户端名称',
  `client_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户端密钥',
  `scope` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限',
  `state` tinyint(1) DEFAULT NULL COMMENT '状态：0：不可用，1：可用'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '客户端信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_client
-- ----------------------------
INSERT INTO `tb_client` VALUES ('1', '2021-01-03 18:17:08', '2021-01-03 18:17:10', '+vkOhnVVHNZ6siDvKioKSVVDalvNRxy66SbMrVXYHj0=', 'cnxYU3h2njEWKpJoLOnj30n3h/4GQ8c60OroXh28SMg=', 'all', 1);

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `author` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论者',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `ip_addr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'ip地址',
  `post_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论文章id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `comment_status` tinyint(1) DEFAULT NULL COMMENT '是否展示评论',
  `parent_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父评论id',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('1', 'KKK', '1060647301@qq.com', '192.168.2.21', '1552ce3ed970c76d4954a7b349f9c5fa', '这是我的第一个评论[嘻嘻]', 1, '0', '2021-02-15 19:04:04', '2021-02-15 19:04:08');
INSERT INTO `tb_comment` VALUES ('153e698b5833f3c3921b8def261870f0', '荷花', '1006181408@qq.com', '127.0.0.1', '2', '[馋嘴]一朵小荷花', 1, '0', '2021-02-16 00:00:00', '2021-02-16 00:00:00');
INSERT INTO `tb_comment` VALUES ('19a711c71f785a9173c46c4982b0e121', '小花', '1320121@qq.com', '127.0.0.1', '2', '小花的评论', 1, '0', '2020-12-16 00:00:00', '2020-12-16 00:00:00');
INSERT INTO `tb_comment` VALUES ('1aa1e40a01316fe7ef0c61a9ec56b7d4', '阿拉蕾', '1212@qq.com', '127.0.0.1', '2', '啦啦啦[互粉]', 1, '19a711c71f785a9173c46c4982b0e121', '2021-02-16 00:00:00', '2021-02-16 00:00:00');
INSERT INTO `tb_comment` VALUES ('1d762f066256f3f816a1c68581efa42b', '测试用户', '1006181408@qq.com', '127.0.0.1', '1552ce3ed970c76d4954a7b349f9c5fa', '[微笑]好厉害啊', 1, '0', '2020-12-16 00:00:00', '2020-12-16 00:00:00');
INSERT INTO `tb_comment` VALUES ('2', 'Jane', '1006181408@qq.com', '172.167.12.31', '1552ce3ed970c76d4954a7b349f9c5fa', '评论2', 1, '0', '2021-02-15 19:05:43', '2021-02-15 19:05:46');
INSERT INTO `tb_comment` VALUES ('3', 'Yang', '10512124@qq.com', '128.0.0.1', '1552ce3ed970c76d4954a7b349f9c5fa', '评论3', 1, '0', '2021-02-16 14:21:11', '2021-02-16 14:21:19');
INSERT INTO `tb_comment` VALUES ('4', 'Huang', '1212214@qq.com', '122.12.31.21', '1552ce3ed970c76d4954a7b349f9c5fa', '评论4', 1, '3', '2021-02-16 14:28:16', '2021-02-16 14:28:18');
INSERT INTO `tb_comment` VALUES ('7a32464256803bb5f5b20a1163370d2f', 'sunny', '1006181408@qq.com', '127.0.0.1', '2', '[微笑][嘻嘻][哈哈][可爱]我是一只小可爱', 1, '0', '2021-02-21 00:00:00', '2021-02-21 00:00:00');
INSERT INTO `tb_comment` VALUES ('a88477d7917e76f52dc7b8c9b5287b83', '荷花', '1006181408@qq.com', '127.0.0.1', '2', '好厉害啊[可怜][吃惊][挤眼]', 1, '0', '2021-02-16 00:00:00', '2021-02-16 00:00:00');
INSERT INTO `tb_comment` VALUES ('a88b1056bda9df729c1095df1fc61df0', '康同学', '120121@qq.com', '127.0.0.1', '2', '[哈哈] 还是挺有感触的', 1, '0', '2021-02-16 00:00:00', '2021-02-16 00:00:00');
INSERT INTO `tb_comment` VALUES ('abac77299e22a2a930f258b20d15ab1d', '我的最爱', '1007181407@qq.com', '127.0.0.1', '2', '好可爱啊', 1, 'c433f1d17e2a82f71c699363a09b6518', '2021-02-17 00:00:00', '2021-02-17 00:00:00');
INSERT INTO `tb_comment` VALUES ('c433f1d17e2a82f71c699363a09b6518', '我的最爱', '1007181407@qq.com', '127.0.0.1', '2', '[可怜][挤眼][闭嘴][左哼哼][白眼][太开心][亲亲]', 1, '0', '2021-02-17 00:00:00', '2021-02-17 00:00:00');
INSERT INTO `tb_comment` VALUES ('ca2a51ae3ba01de8565f2334c3a3de94', '作者', '1006181408@qq.com', '127.0.0.1', '2', '你也好棒棒', 1, '153e698b5833f3c3921b8def261870f0', '2021-02-16 00:00:00', '2021-02-16 00:00:00');
INSERT INTO `tb_comment` VALUES ('d951c47d3acd7ca4a1aa65b737076de6', '美景', '1006181208@qq.com', '127.0.0.1', '2', '还好啦', 1, '153e698b5833f3c3921b8def261870f0', '2021-02-16 00:00:00', '2021-02-16 00:00:00');

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志内容',
  `ip_addr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '访问ip地址记录',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '日志表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_post
-- ----------------------------
DROP TABLE IF EXISTS `tb_post`;
CREATE TABLE `tb_post`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `description` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章简介',
  `original_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '原始内容',
  `format_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '格式化内容',
  `post_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发布状态',
  `cover_image` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '封面图片',
  `browse_times` bigint(0) DEFAULT NULL COMMENT '浏览次数',
  `category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文章的所属的分类',
  `allow_comment` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否允许被评论',
  `recommend` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文章是否被推荐',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `主键`(`id`) USING BTREE COMMENT '唯一索引',
  INDEX `标题`(`title`) USING BTREE COMMENT '标题索引',
  INDEX `文章简介`(`description`) USING BTREE COMMENT '文章简介搜索索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章发布表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_post
-- ----------------------------
INSERT INTO `tb_post` VALUES ('1552ce3ed970c76d4954a7b349f9c5fa', 'SpringBoot学习总结', '简介1', '新增文章', '这是新增的文章', '1', 'http://127.0.0.1:8085/image/37d9cae7-16a7-4a94-99d3-bb3966ef8ec0.png', 12313, '1', '1', '', '2021-02-21 00:58:59', '2021-02-21 00:58:59');
INSERT INTO `tb_post` VALUES ('17a01cd6339dd2364f3bd26a701db715', '学会理财', '简介2', '新增文章', '这是新增的文章', '1', 'http://127.0.0.1:8085/image/6b7e1bda-4a60-497b-9184-cfa1398cb073.jpg', 0, '1', '0', '', '2021-02-21 00:59:19', '2021-02-21 00:59:19');
INSERT INTO `tb_post` VALUES ('2', '流年岁月', '这是第二篇博客这是我写的第一篇文章这是我写的第一篇文章这是我写的第一篇文章这是我写的第一篇文章这是我写的第一篇文章这是我写的第一篇文章', '文章内容', '这是新增的文章', NULL, 'http://127.0.0.1:8085/image/1306d534-b759-4b8e-b90f-568874c31b35.jpg', 1, '2', '1', '1', '2021-02-21 00:59:47', '2021-02-21 00:59:47');
INSERT INTO `tb_post` VALUES ('3', '美好的回忆', '这是第三篇文章，这是第三篇文章这是第三篇文章这是第三篇文章，这是第三篇文章这是第三篇文章', '## 定时任务的应用\n定时消息的通知、业务数据的定时结算、缓存数据的定时更新等。\n## 实现方法\n- 使用Java自带的java.util.Timer类\n- 使用Quartz(一个功能比较强大的调度器，当然使用起来也相对麻烦)\n- 使用Spring框架自带的Schedule模块\n## 执行方式\n> 定时任务执行方式可分为：单线程（串行）和多线程（并行）。\n## 如何使用\n- 启动类上增加`@EnableScheduling`注解来开启定时任务功能。\n- `@Scheduled`设置任务定时执行\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20201127231505306.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4NDU0Nzc2,size_16,color_FFFFFF,t_70)\n## Cron表达式简介\n` @Scheduled(cron = \"0 0 10 ? * FRI\")`：每个星期五早上10点触发\n- cron的表达式是字符串，由7个子表达式构成\n- cron有6～7个空格分隔的时间元素，按顺序依次是“`秒 分 时 天 月 星期 年`”，其中年是一个可以不配置的元素。\n- 如`?`和`*`，这里因为天和星期会产生定义上的冲突，所以往往会以通配符?表示，它表示不指定值，而*则表示任意的月\n', '## 定时任务的应用\n定时消息的通知、业务数据的定时结算、缓存数据的定时更新等。\n## 实现方法\n- 使用Java自带的java.util.Timer类\n- 使用Quartz(一个功能比较强大的调度器，当然使用起来也相对麻烦)\n- 使用Spring框架自带的Schedule模块\n## 执行方式\n> 定时任务执行方式可分为：单线程（串行）和多线程（并行）。\n## 如何使用\n- 启动类上增加`@EnableScheduling`注解来开启定时任务功能。\n- `@Scheduled`设置任务定时执行\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20201127231505306.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4NDU0Nzc2,size_16,color_FFFFFF,t_70)\n## Cron表达式简介\n` @Scheduled(cron = \"0 0 10 ? * FRI\")`：每个星期五早上10点触发\n- cron的表达式是字符串，由7个子表达式构成\n- cron有6～7个空格分隔的时间元素，按顺序依次是“`秒 分 时 天 月 星期 年`”，其中年是一个可以不配置的元素。\n- 如`?`和`*`，这里因为天和星期会产生定义上的冲突，所以往往会以通配符?表示，它表示不指定值，而*则表示任意的月\n', NULL, 'http://127.0.0.1:8085/image/1306d534-b759-4b8e-b90f-568874c31b35.jpg', 5, '1', '0', NULL, '2021-02-21 13:14:41', '2021-02-21 13:14:41');
INSERT INTO `tb_post` VALUES ('4', '是否还记得那些年少的时光', '这是第三篇文章，这是第三篇文章这是第三篇文章这是第三篇文章，这是第三篇文章这是第三篇文章', '这是新增的文章', '这是新增的文章', NULL, 'http://127.0.0.1:8085/image/1306d534-b759-4b8e-b90f-568874c31b35.jpg', 6, '1', '0', NULL, '2020-07-01 01:00:14', '2021-02-21 01:01:35');

-- ----------------------------
-- Table structure for tb_post_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_post_tag`;
CREATE TABLE `tb_post_tag`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `post_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文章id',
  `tag_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标签id',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = ' 文章标签关联表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_post_tag
-- ----------------------------
INSERT INTO `tb_post_tag` VALUES ('2', '1', '2', '2020-12-01 22:39:49', '2020-12-01 22:39:55');
INSERT INTO `tb_post_tag` VALUES ('3', '2', '1', '2020-12-01 22:48:02', '2020-12-01 22:48:05');
INSERT INTO `tb_post_tag` VALUES ('8cd69bd4fc9d00e22dfa45471401bcb5', '', '2', NULL, NULL);
INSERT INTO `tb_post_tag` VALUES ('e511aa61930e34629ad55495f36fd4b9', '', '1', NULL, NULL);

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签名称',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag` VALUES ('1', '标签1', '2020-11-30 21:46:14', '2020-11-30 21:46:18');
INSERT INTO `tb_tag` VALUES ('2', '标签2', '2020-12-16 21:47:28', '2020-12-16 21:47:32');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `enabled` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账户是否可用',
  `expired` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账户是否过期',
  `locked` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账户是否被锁定',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = ' 用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '1006181408@qq.com', '$2a$10$oTozFwlYqt5EEQTEhGRJruPURlSvle3clJ8fcoHh8nTK6BJdWvcSS', '1', '0', '0', '2020-12-19 14:38:54', '2020-12-19 14:38:58');

SET FOREIGN_KEY_CHECKS = 1;
