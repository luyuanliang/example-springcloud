# example-springcloud
验证参数
http://localhost:8081/testParam/twoParams?aa&dogAge=33&dogName=旺旺&studentName=xuza&homeddress=China&age=3&teacherList=222，灭霸&scores=33,44,55,66&studentDO2=

验证freemarker
http://localhost:8081/freemarker/sayFreeMarker

验证Graalvm
native-image在Windows中 运行GraalVM的步骤
https://blog.csdn.net/cunxiedian8614/article/details/105698258/

http://localhost:8081/account/selectAccountByAccountId?accountId=1



CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'account表主键',
  `account_name` varchar(255) NOT NULL COMMENT '账户名称',
  `account_no` int(255) NOT NULL COMMENT '账户号',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='资金帐户表，用于测试';

