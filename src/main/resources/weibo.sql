/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50548
Source Host           : 127.0.0.1:3306
Source Database       : weibo

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2017-10-13 18:57:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_school
-- ----------------------------
DROP TABLE IF EXISTS `t_school`;
CREATE TABLE `t_school` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL COMMENT '用户ID，与学校绑定的管理员',
  `schoolNumber` varchar(50) NOT NULL COMMENT '学校编号',
  `schoolName` varchar(30) DEFAULT NULL COMMENT '学校名字',
  `schoolProvince` varchar(20) DEFAULT NULL COMMENT '学校所在省份',
  `schoolCity` varchar(20) DEFAULT NULL COMMENT '学校所在市',
  `totalSignUp` int(11) DEFAULT NULL COMMENT '学校总注册量',
  `totalStudent` int(11) DEFAULT NULL COMMENT '学校学生总人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校信息';

-- ----------------------------
-- Records of t_school
-- ----------------------------
INSERT INTO `t_school` VALUES ('1', '1', 'SX123456', '西安邮电大学', '陕西省', '西安市', '0', '13200');

-- ----------------------------
-- Table structure for t_sensitive
-- ----------------------------
DROP TABLE IF EXISTS `t_sensitive`;
CREATE TABLE `t_sensitive` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(50) NOT NULL COMMENT '敏感词内容',
  `type` tinyint(4) NOT NULL COMMENT '敏感词类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='敏感词表';

-- ----------------------------
-- Records of t_sensitive
-- ----------------------------
INSERT INTO `t_sensitive` VALUES ('1', '枪', '1');
INSERT INTO `t_sensitive` VALUES ('2', '色情', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL COMMENT '邮箱，当做用户名',
  `nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `type` tinyint(2) DEFAULT NULL COMMENT '用户类型：1：普通学生，2：管理员',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `active` tinyint(2) DEFAULT NULL COMMENT '账户是否被激活；0：未激活; 1:激活',
  `school` int(11) DEFAULT NULL COMMENT '学校',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户账户信息';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '123@qq.com', '西安邮电大学', '123456', '18829292713', null, '2017-06-03 12:19:31', null, '1');
INSERT INTO `t_user` VALUES ('2', '456@qq.com', 'user', '123456', '18829292713', null, '2017-06-03 12:19:14', null, '1');
INSERT INTO `t_user` VALUES ('4', '798@qq.com', 'user', '123456', '18829292713', null, '2017-06-03 12:19:12', null, '1');

-- ----------------------------
-- Table structure for t_weibo_emotion
-- ----------------------------
DROP TABLE IF EXISTS `t_weibo_emotion`;
CREATE TABLE `t_weibo_emotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `weibo_id` int(11) NOT NULL COMMENT '微博ID',
  `positive` double NOT NULL COMMENT '积极指数,小于1的数值；消极指数为1-积极指数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COMMENT='微博情感分析';

-- ----------------------------
-- Records of t_weibo_emotion
-- ----------------------------
INSERT INTO `t_weibo_emotion` VALUES ('1', '26', '0.1724452534211558');
INSERT INTO `t_weibo_emotion` VALUES ('2', '27', '0.4787865331070966');
INSERT INTO `t_weibo_emotion` VALUES ('3', '28', '0.9955046099661772');
INSERT INTO `t_weibo_emotion` VALUES ('4', '29', '0.8093759124900808');
INSERT INTO `t_weibo_emotion` VALUES ('5', '30', '0.39585670810082285');
INSERT INTO `t_weibo_emotion` VALUES ('6', '31', '0.9406006040751731');
INSERT INTO `t_weibo_emotion` VALUES ('7', '32', '0.7013028516629087');
INSERT INTO `t_weibo_emotion` VALUES ('8', '33', '0.9753103019297888');
INSERT INTO `t_weibo_emotion` VALUES ('9', '34', '0.9818620506977727');
INSERT INTO `t_weibo_emotion` VALUES ('10', '35', '0.9529445442131635');
INSERT INTO `t_weibo_emotion` VALUES ('11', '36', '0.9619962276774441');
INSERT INTO `t_weibo_emotion` VALUES ('12', '37', '0.9854919409041162');
INSERT INTO `t_weibo_emotion` VALUES ('13', '38', '0.9507685941470011');
INSERT INTO `t_weibo_emotion` VALUES ('14', '39', '0.9728578525281699');
INSERT INTO `t_weibo_emotion` VALUES ('15', '40', '0.9682041954698335');
INSERT INTO `t_weibo_emotion` VALUES ('16', '41', '0.939696759401141');
INSERT INTO `t_weibo_emotion` VALUES ('17', '42', '0.15521194129391358');
INSERT INTO `t_weibo_emotion` VALUES ('18', '43', '0.9985715286273423');
INSERT INTO `t_weibo_emotion` VALUES ('19', '44', '0.9793929478279302');
INSERT INTO `t_weibo_emotion` VALUES ('20', '45', '0.977511407563047');
INSERT INTO `t_weibo_emotion` VALUES ('21', '46', '0.9803301798866481');
INSERT INTO `t_weibo_emotion` VALUES ('22', '47', '0.8675864146964476');
INSERT INTO `t_weibo_emotion` VALUES ('23', '48', '0.9078712243098874');
INSERT INTO `t_weibo_emotion` VALUES ('24', '49', '0.8543631486414913');
INSERT INTO `t_weibo_emotion` VALUES ('25', '50', '0.8804503692877954');
INSERT INTO `t_weibo_emotion` VALUES ('26', '51', '0.7909800498132408');
INSERT INTO `t_weibo_emotion` VALUES ('27', '52', '0.9421808614373355');
INSERT INTO `t_weibo_emotion` VALUES ('28', '53', '0.7312784428905814');
INSERT INTO `t_weibo_emotion` VALUES ('29', '54', '0.8528663297181669');
INSERT INTO `t_weibo_emotion` VALUES ('30', '55', '0.32749548342250456');
INSERT INTO `t_weibo_emotion` VALUES ('31', '56', '0.9035501478984584');
INSERT INTO `t_weibo_emotion` VALUES ('32', '57', '0.9582135394839485');
INSERT INTO `t_weibo_emotion` VALUES ('33', '58', '0.9787079819448594');
INSERT INTO `t_weibo_emotion` VALUES ('34', '59', '0.7324081648990719');
INSERT INTO `t_weibo_emotion` VALUES ('35', '60', '0.9673271666388118');
INSERT INTO `t_weibo_emotion` VALUES ('36', '61', '0.9292807637324265');
INSERT INTO `t_weibo_emotion` VALUES ('37', '62', '0.999668031930057');
INSERT INTO `t_weibo_emotion` VALUES ('38', '63', '0.9989886721000845');
INSERT INTO `t_weibo_emotion` VALUES ('39', '64', '0.9540477265656089');
INSERT INTO `t_weibo_emotion` VALUES ('40', '65', '0.9879338216922436');
INSERT INTO `t_weibo_emotion` VALUES ('41', '66', '0.9993271082643714');
INSERT INTO `t_weibo_emotion` VALUES ('42', '67', '0.5316476455784125');
INSERT INTO `t_weibo_emotion` VALUES ('43', '68', '0.37400945282549547');

-- ----------------------------
-- Table structure for t_weibo_info
-- ----------------------------
DROP TABLE IF EXISTS `t_weibo_info`;
CREATE TABLE `t_weibo_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `weiboId` varchar(40) NOT NULL COMMENT 'id',
  `weiboContent` varchar(500) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `weiboAuthor` varchar(30) DEFAULT NULL,
  `releaseWay` varchar(30) DEFAULT NULL,
  `isForward` tinyint(4) DEFAULT NULL COMMENT '1   0 ',
  `reasonOfForward` varchar(200) DEFAULT NULL,
  `praiseNum` int(11) DEFAULT NULL,
  `commentNum` int(11) DEFAULT NULL,
  `forwardNum` int(11) DEFAULT NULL,
  `hasPicture` tinyint(4) DEFAULT NULL COMMENT '1 2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_weibo_info
-- ----------------------------
INSERT INTO `t_weibo_info` VALUES ('26', '2', 'M_EBavkoOP7', '#为中国足球加油#【今晚这条微博一定要转！中国队1:0战胜韩国队！祝贺中国男足！】[威武][威武][威武] ​​​', '2017-04-19 17:21:03', 'u/1984666617', '来自iPhone 6s', '1', '@我是个胖子cct 某人说他要吃屎??', '0', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('27', '2', 'M_EAmKS77nE', '我在微博买了《美女与野兽(2017)》的电影票，省了10.4元。 美女与野兽(2017) ​​​', '2017-04-20 17:21:03', 'u/1984666617', '来自微博电影', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('28', '2', 'M_EAh5KEmNU', '若干年后，大家又回到了同样的地方或用同样的姿势拍照，岁月可真让人感慨啊，希望未来还能有你[心] ​​​​', '2017-04-21 17:21:03', 'u/1984666617', '来自iPhone 6s', '1', '[心][心] //@几米漫画集:好有爱~[心]', '1', '1', '1', '1');
INSERT INTO `t_weibo_info` VALUES ('29', '2', 'M_EwrkOjcco', '迷茫了一周 还好知道自己想要的是什么了 迎接下一个挑战就好了 加油[可爱][可爱] 北京·海淀区 ​​​', '2017-04-22 17:21:03', 'u/1984666617', '来自iPhone 6s', '0', null, '5', '5', '5', '0');
INSERT INTO `t_weibo_info` VALUES ('30', '2', 'M_EukajETB3', '真是老了 听到当年超喜欢的歌词都觉着矫情。 北京·搜狐网络大厦 ​​​', '2017-04-23 17:21:03', 'u/1984666617', '来自iPhone 6s', '0', null, '3', '3', '3', '0');
INSERT INTO `t_weibo_info` VALUES ('31', '2', 'M_F1yn9AGTT', '即便所有的故事都千篇一律，也希望它们都能有一个好的结局！ 西安·雁塔区 ​​​', '2017-05-04 15:28:00', 'u/3907247887', '来自魅蓝 Note', '0', null, '0', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('32', '2', 'M_EuV1Jct5o', '努力着回忆过去，却怎么也拾不起过往的天真！ ​​​枪', '2017-02-10 19:42:00', 'u/3907247887', '来自魅蓝 Note', '0', null, '2', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('33', '2', 'M_EuMRpCGpa', '#朴寶劍_ParkBoGum的红包# Boomshakalaka！我在朴寶劍_ParkBoGum 的红包中抽到了 @让红包飞 提供的“限量版财神卡-要”，2017年的小惊喜！也许你的惊喜更大哦~ 朴寶劍_ParkBoGum 的红包 ​​​', '2017-02-09 22:55:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('34', '2', 'M_Eu7ZXuxaP', '#M鹿M的红包# Boomshakalaka！我在M鹿M 的红包中抽到了 @让红包飞 提供的“金牛座财神卡”，2017年的小惊喜！也许你的惊喜更大哦~ M鹿M 的红包 ​​​', '2017-02-05 14:53:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('35', '2', 'M_EtyJVxcl6', '#吴尊的红包# Boomshakalaka！我在吴尊 的红包中抽到了 @聚美陈欧 提供的“聚美百元礼包”，2017年的小惊喜！也许你的惊喜更大哦~ 吴尊 的红包 ​​​', '2017-02-01 21:08:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('36', '2', 'M_EtyJUpY96', '#M鹿M的红包# Boomshakalaka！我在M鹿M 的红包中抽到了 @粉丝夺宝 提供的“粉丝夺宝大礼包”，2017年的小惊喜！也许你的惊喜更大哦~ M鹿M 的红包 ​​​', '2017-02-01 21:08:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('37', '2', 'M_EtyJRrtyr', '#李晨的红包# Boomshakalaka！我在李晨 的红包中抽到了 @让红包飞 提供的“处女座财神卡”，2017年的小惊喜！也许你的惊喜更大哦~ 李晨 的红包 ​​​', '2017-02-01 21:08:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('38', '2', 'M_EsUnD4HZk', '#魅族手机让红包飞# boom boom boom！我在 @魅族科技 的红包中抽到了“微博会员5元代金券”！2017年的小惊喜！也许你的惊喜更大哦~ 魅族科技 的红包 ​​​', '2017-01-28 14:23:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('39', '2', 'M_EsjFUzkKk', '#張恒遠-垃圾車庫的红包# Boomshakalaka！我在張恒遠-垃圾車庫 的红包中抽到了 @众筹吧 提供的“众筹现金券”，2017年的小惊喜！也许你的惊喜更大哦~ 張恒遠-垃圾車庫 的红包 ​​​', '2017-01-24 16:56:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('40', '2', 'M_EsjFIsQ6Q', '#李大霄的红包# Boomshakalaka！我在李大霄 的红包中抽到了 @微博会员 提供的“50元会员红包”，2017年的小惊喜！也许你的惊喜更大哦~ 李大霄 的红包 ​​​', '2017-01-24 16:56:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('41', '2', 'M_EsjFDpO5M', '#蜜枣baby吴彦凝的红包# 哟！2017伊始运气不错哦！我刚刚抢到蜜枣baby吴彦凝 和 @春之声2017 发出的联手现金红包！你也快来领比比谁的红包更大吧~ 蜜枣baby吴彦凝 的红包 ​​​', '2017-01-24 16:56:00', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('42', '2', 'M_EpgZtA5pd', '为什么现在好多医院还是以赚病人钱，而不是让病人花最少的钱治好病为目的？ @中国医师协会 @中国医生联盟 ​​​', '2017-01-04 16:36:00', 'u/3907247887', '来自魅蓝 Note', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('43', '2', 'M_EoIKXq4rU', '爱你宝贝 @玫瑰碧琳的Alice ​​​', '2017-01-01 01:26:00', 'u/3907247887', '来自魅蓝 Note', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('44', '2', 'M_EfqtNivkY', '#欢乐吃金币，魅族送大礼# 我已经错过了拯救世界的机会，但绝不能再错过它，这些超值大奖！我参加了活动“下微博赢魅蓝E”，你也来试试手气 下微博赢魅蓝E ​​​', '2016-10-31 22:22:22', 'u/3907247887', '来自微博活动', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('45', '2', 'M_DEd4OdWqZ', '小伙伴们看过来，我在58同城发现了一个绝世好贴~ （出租）两室一厅一厨一卫转租,无中介,无押金-个人 ​​​', '2016-07-10 23:28:23', 'u/3907247887', '来自58同城客户端', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('46', '2', 'M_DyNfwx8Jl', '如果拥有了爱情，就别去碰暧昧。面对弥足珍贵的爱情，我们需要从一而终。经得起诱惑，耐得住寂寞，唯有这样，才能给予彼此最大的安全感,爱情之路才会走得平平坦坦。 ​​​', '2016-06-05 08:31:52', 'u/3907247887', '来自乐1', '0', null, '0', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('47', '2', 'M_DyNegumpY', '心甘情愿才能理所当然，理所当然才会义无反顾。 ​​​', '2016-06-05 08:28:45', 'u/3907247887', '来自乐1', '0', null, '0', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('48', '2', 'M_DrSxiBvrR', '#阿里2016实习生招聘笔试# [泪流满面][衰][泪] ​​​', '2016-04-20 21:07:16', 'u/3907247887', '来自微话题', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('49', '2', 'M_Dgk4CB5F5', '#易用汇的红包# 一不小心又中奖了！(≖ ‿ ≖)✧我在 @易用汇 的红包中抽到了“微博会员5元代金券”！好实在的礼物，让宝宝心情美丽一整天～ 易用汇 的红包 ​​​', '2016-02-04 21:09:52', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('50', '2', 'M_Dgk0FkS6o', '#英语听说读写背的红包# 一不小心又中奖了！(≖ ‿ ≖)✧我在英语听说读写背 的红包中抽到了 @聚美陈欧 提供的“聚美百元大礼包”，好实在的礼物，让宝宝心情美丽一整天～ 英语听说读写背 的红包 ​​​', '2016-02-04 21:00:08', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('51', '2', 'M_DgjZS22vB', '#联合利华卫宝的红包# 天上掉红包，不捡白不捡！ヽ(^。^)ノ我被 @卫宝 的红包砸中啦~ 不要太幸运！不信你试试~ 卫宝 的红包 ​​​', '2016-02-04 20:58:10', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('52', '2', 'M_DfwGy1YaI', '#杨洋的红包# 一不小心又中奖了！(≖ ‿ ≖)✧我在杨洋icon 的红包中抽到了 @有信打打打 提供的“有信120分钟话费”，好实在的礼物，让宝宝心情美丽一整天～ 杨洋icon 的红包 ​​​', '2016-01-30 15:25:57', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('53', '2', 'M_Df5hFdPnj', '#包贝尔的红包# 天上掉红包，不捡白不捡！ヽ(^。^)ノ 我被 @包贝尔 和 @我的头好重啊啊啊 一起发出的现金红包砸中啦！不要太幸运！不信你试试~ 包贝尔 的红包 ​​​', '2016-01-27 17:40:29', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('54', '2', 'M_Df5hugwfC', '#娜扎的红包# 一不小心又中奖了！(≖ ‿ ≖)✧我在我是娜扎 的红包中抽到了 @滴滴出行 提供的“滴滴百元礼包”，好实在的礼物，让宝宝心情美丽一整天～ 我是娜扎 的红包 ​​​', '2016-01-27 17:40:04', 'u/3907247887', '来自粉丝红包', '0', null, '0', '0', '0', '0');
INSERT INTO `t_weibo_info` VALUES ('55', '2', 'M_CwGAe8WaG', '我想告诉自己，事情做好了就是做好了，没做好就是没做好，不要说差不多。总是马马虎虎的做着，最后的结果总是差不多，这样每次心里都会有失落，何必呢？还有，一定要注意细节，多少事情都败在了细节上，几乎是数也数不清，但总是不知悔改！注意细节，就可以关注到很多东西，学到很多的。 ​​​', '2015-08-20 13:08:43', 'u/3907247887', '来自联想乐檬 K3', '0', null, '1', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('56', '4', 'M_F4M72vFv6', '签证下来了，没有激动，没有想象中的喜悦 ​​​', '2017-05-25 19:57:00', 'u/3271331805', '来自iPhone 6s', '0', null, '0', '6', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('57', '4', 'M_F4l4ocobf', '69% 42% 14% 6% 可以睡个安稳觉啦开心[耶] #花式比心# ​​​', '2017-05-22 23:07:00', 'u/3271331805', '来自iPhone 6s', '0', null, '3', '16', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('58', '4', 'M_F3RD94js2', '@歌歌的gg的ge [小嘴]礼物好惊喜[爱你]luck，好运带给我们[心] ​​​ 西安·长安大学城 ​​​', '2017-05-19 20:10:00', 'u/3271331805', '来自iPhone 6s', '0', null, '0', '1', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('59', '4', 'M_F3JZPpnBQ', '回来一次，少一次 西安·西安邮电大学(长安校区) ​​​', '2017-05-19 00:44:00', 'u/3271331805', '来自iPhone 6s', '0', null, '5', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('60', '4', 'M_F3poxd1gN', '青涩不言语，红脸颊给你[小嘴] ​​​', '2017-05-16 20:17:00', 'u/3271331805', '来自iPhone 6s', '0', null, '4', '6', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('61', '4', 'M_F2UiO8C4r', '『爱人的脸』 ​​​', '2017-05-13 13:08:00', 'u/3271331805', '来自iPhone 6s', '0', null, '1', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('62', '4', 'M_F2NKvFl7q', '[黄心] ​​​枪', '2017-05-12 20:27:00', 'u/3271331805', '来自iPhone 6s', '0', null, '1', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('63', '4', 'M_F1Q6k290t', 'Blendoku [鼓掌] ​​​色情', '2017-05-06 12:36:00', 'u/3271331805', '来自iPhone 6s', '0', null, '2', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('64', '4', 'M_F1DZt1es2', '#晓东日语# 新日语能力考试N1级语法句型频率讲解（1），这绝对是经典的干货啦。备考N1级的时候，我们需要掌握历年真题中考过哪些句型，那么大家知道迄今为止考过次数最多的N1级句型是哪个吗？欢迎收看视频，如果喜欢请点赞支持啦。爱你们。 秒拍视频 . ​​​', '2017-05-05 05:46:00', 'u/3271331805', '来自iPhone 6s', '0', null, '0', '0', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('65', '4', 'M_F14m68bQ8', '倒计时：66天[蓝心] ​​​', '2017-05-01 11:03:00', 'u/3271331805', '来自iPhone 6s', '0', null, '2', '9', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('66', '4', 'M_F0QIpD95f', '晚安[月亮] ​​​', '2017-04-30 00:19:00', 'u/3271331805', '来自iPhone 6s', '0', null, '5', '4', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('67', '4', 'M_F0wOLmcsD', '心慌慌～不想在踏进红会[医院][抓狂] ​​​', '2017-04-27 21:40:00', 'u/3271331805', '来自iPhone 6s', '0', null, '1', '3', '0', '1');
INSERT INTO `t_weibo_info` VALUES ('68', '4', 'M_F0dwbjpFh', '如此之事，天理难容。政府出面，为百姓解决问题。我们的血汗钱该怎么办？我们的人身安全又谁来维护。西安正茂集团到底什么背景？居然这样的无法无天？ @西安公安 @西安电视台官方微博 @陕西新闻吧 @中国日报 @中国政府网 @央视新闻 http://t.cn/RXT24Jk . ​​​', '2017-04-25 20:32:00', 'u/3271331805', '来自iPhone 6s', '0', null, '1', '1', '4', '1');

-- ----------------------------
-- Table structure for t_weibo_sensitive
-- ----------------------------
DROP TABLE IF EXISTS `t_weibo_sensitive`;
CREATE TABLE `t_weibo_sensitive` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `weiboId` int(11) NOT NULL COMMENT '微博ID',
  `type` tinyint(4) NOT NULL COMMENT '敏感词类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_weibo_sensitive
-- ----------------------------
INSERT INTO `t_weibo_sensitive` VALUES ('3', '32', '1');
INSERT INTO `t_weibo_sensitive` VALUES ('4', '62', '1');
INSERT INTO `t_weibo_sensitive` VALUES ('5', '63', '2');

-- ----------------------------
-- Table structure for t_weibo_user
-- ----------------------------
DROP TABLE IF EXISTS `t_weibo_user`;
CREATE TABLE `t_weibo_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(30) NOT NULL,
  `weiboId` varchar(50) DEFAULT NULL COMMENT '微博ID',
  `nickname` varchar(35) DEFAULT NULL,
  `authentication` varchar(30) DEFAULT NULL,
  `intelligent` varchar(200) DEFAULT NULL COMMENT '达人 标签',
  `gender` varchar(10) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `birthday` varchar(30) DEFAULT NULL,
  `seaxualOrientation` varchar(20) DEFAULT NULL COMMENT '用户性取向',
  `emotional` varchar(20) DEFAULT NULL COMMENT '感情状况',
  `authenticationInfo` varchar(50) DEFAULT NULL COMMENT '用户认证信息',
  `brief` varchar(200) DEFAULT NULL COMMENT '简介',
  `tags` varchar(100) DEFAULT NULL COMMENT '标签',
  `schoolTime` varchar(30) DEFAULT NULL COMMENT '入学时间',
  `works` varchar(200) DEFAULT NULL COMMENT '工作经历',
  `homepage` varchar(100) DEFAULT NULL COMMENT '用户主页,暂时保存手机界面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_weibo_user
-- ----------------------------
INSERT INTO `t_weibo_user` VALUES ('4', '2', '3907247887', '柏拉图的忧桑', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_weibo_user` VALUES ('6', '4', '3271331805', '爱抓知了的菇凉', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('mike', '123456');
