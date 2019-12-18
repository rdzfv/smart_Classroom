/*
Navicat MySQL Data Transfer

Source Server         : BUS
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : smart_classroom

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-12-14 13:03:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `ans_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_true` int(11) DEFAULT NULL,
  `problem_id` int(11) DEFAULT NULL,
  `problem_set_id` int(11) DEFAULT NULL,
  `student_ans` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ans_id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '0', '1', '1', '1', '1');
INSERT INTO `answer` VALUES ('2', '0', '2', '1', '1', '1');
INSERT INTO `answer` VALUES ('3', '1', '3', '1', '2', '1');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `course_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `class_classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `class_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `class_openyear` int(11) DEFAULT NULL,
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`class_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '1', '仁和108', '软件工程（移动应用开发方向）', '2019', '1');
INSERT INTO `class` VALUES ('2', '1', '计C307', '移动应用开发方向', '2019', '2');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_credit` int(11) DEFAULT NULL,
  `course_method` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_detail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_pic_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '64', '考查', 'JavaEE', 'detail', 'picUrlpicUrlpicUrlpicUrlpicUrlpicUrl');
INSERT INTO `course` VALUES ('2', '48', '考试', '软件工程', 'detail', 'urlurlurlurl');

-- ----------------------------
-- Table structure for courseppt
-- ----------------------------
DROP TABLE IF EXISTS `courseppt`;
CREATE TABLE `courseppt` (
  `courseppt_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `ppt_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseppt_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of courseppt
-- ----------------------------
INSERT INTO `courseppt` VALUES ('1', '1', 'urlurlrurl', '1');

-- ----------------------------
-- Table structure for my_answers_model
-- ----------------------------
DROP TABLE IF EXISTS `my_answers_model`;
CREATE TABLE `my_answers_model` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `my_answers` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_set_id` int(11) DEFAULT NULL,
  `student_account` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of my_answers_model
-- ----------------------------

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_set_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('1', 'JavaEE第一次练习（修改后）', '1');
INSERT INTO `paper` VALUES ('2', 'javaEE AOP', '1');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem` (
  `problem_id` int(11) NOT NULL AUTO_INCREMENT,
  `problem_ans` int(11) DEFAULT NULL,
  `problem_choose1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_choose2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_choose3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_choose4` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_explain` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_info` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`problem_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES ('1', '2', '选项1选项1选项1选项1选项1选项1选项1选项1选项1', '选项2选项2选项2选项2选项2选项2选项2选项2', '选项3选项3选项3选项3选项3选项3选项3选项3', '选项4选项4选项4选项4选项4选项4选项4选项4', '题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解', '题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干');
INSERT INTO `problem` VALUES ('2', '2', '2选项1选项1选项1选项1选项1选项1选项1选项1选项', '2选项2选项2选项2选项2选项2选项2选项2选项2', '2选项3选项3选项3选项3选项3选项3选项3选项3', '2选项4选项4选项4选项4选项4选项4选项4选项4', '2题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解', '2题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干');
INSERT INTO `problem` VALUES ('3', '2', '3选项1选项1选项1选项1选项1选项1选项1选项1选项1', '3选项2选项2选项2选项2选项2选项2选项2选项', '3选项3选项3选项3选项3选项3选项3选项3选项3', '3选项4选项4选项4选项4选项4选项4选项4选项4', '3题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解', '3题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干');
INSERT INTO `problem` VALUES ('5', '2', '5选项1选项1选项1选项1选项1选项1选项1选项1选项1', '5选项2选项2选项2选项2选项2选项2选项2选项2', '5选项3选项3选项3选项3选项3选项3选项3选项3', '5选项4选项4选项4选项4选项4选项4选项4选项4', '5题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解', '5题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干题干');

-- ----------------------------
-- Table structure for problems_detailiin_problem_set_model
-- ----------------------------
DROP TABLE IF EXISTS `problems_detailiin_problem_set_model`;
CREATE TABLE `problems_detailiin_problem_set_model` (
  `problem_id` int(11) NOT NULL,
  `father_course_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `father_course_teacher` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `father_problem_set_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_ans` int(11) NOT NULL,
  `problem_choose1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_choose2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_choose3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_choose4` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_explain` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_info` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`problem_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of problems_detailiin_problem_set_model
-- ----------------------------

-- ----------------------------
-- Table structure for problem_paper
-- ----------------------------
DROP TABLE IF EXISTS `problem_paper`;
CREATE TABLE `problem_paper` (
  `problem_id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL,
  PRIMARY KEY (`problem_id`,`paper_id`),
  KEY `paperid` (`paper_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of problem_paper
-- ----------------------------
INSERT INTO `problem_paper` VALUES ('1', '1');
INSERT INTO `problem_paper` VALUES ('1', '2');
INSERT INTO `problem_paper` VALUES ('2', '1');
INSERT INTO `problem_paper` VALUES ('2', '2');
INSERT INTO `problem_paper` VALUES ('3', '1');

-- ----------------------------
-- Table structure for problem_set
-- ----------------------------
DROP TABLE IF EXISTS `problem_set`;
CREATE TABLE `problem_set` (
  `problem_set_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `paper_id` int(11) DEFAULT NULL,
  `problem_release_time` date DEFAULT NULL,
  `problem_set_detail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_set_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `problem_set_pic_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`problem_set_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of problem_set
-- ----------------------------
INSERT INTO `problem_set` VALUES ('1', '1', '1', '2019-12-07', 'detail', 'problrmSet name', 'urlurlurl', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `session_key` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_account` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'xyy', 'xyy', '201706120122', 'xyy', 'xyy', '1');

-- ----------------------------
-- Table structure for student_class
-- ----------------------------
DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class` (
  `stu_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_class_id`),
  KEY `class_id_idx` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student_class
-- ----------------------------
INSERT INTO `student_class` VALUES ('1', '1', '1', '2017');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `session_key` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_account` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher_sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'openidopenid', 'sessionkeysessionkey', '00xx00xx00xx001', '美丽善良温柔韩姗姗', 'hss', '1xxxxxxxxxx', '1');

-- ----------------------------
-- Table structure for update_paper_problem_model
-- ----------------------------
DROP TABLE IF EXISTS `update_paper_problem_model`;
CREATE TABLE `update_paper_problem_model` (
  `paper_id` int(11) NOT NULL,
  `new_problem_id` int(11) DEFAULT NULL,
  `problem_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of update_paper_problem_model
-- ----------------------------

-- ----------------------------
-- View structure for answer_situation
-- ----------------------------
DROP VIEW IF EXISTS `answer_situation`;
CREATE ALGORITHM=UNDEFINED DEFINER=`javaee`@`localhost` SQL SECURITY INVOKER VIEW `answer_situation` AS select `problem`.`problem_id` AS `problem_id`,`answer`.`problem_set_id` AS `problem_set_id`,`answer`.`problem_id` AS `problem_id1`,`problem`.`problem_info` AS `problem_info`,`problem`.`problem_choose1` AS `problem_choose1`,`problem`.`problem_choose2` AS `problem_choose2`,`problem`.`problem_choose3` AS `problem_choose3`,`problem`.`problem_choose4` AS `problem_choose4`,`problem`.`problem_ans` AS `problem_ans`,`problem`.`problem_explain` AS `problem_explain`,`problem_set`.`problem_set_id` AS `father_problem_set_id`,`problem_set`.`teacher_id` AS `teacher_id`,`problem_set`.`course_id` AS `course_id`,`teacher`.`teacher_id` AS `teacher_id1`,`teacher`.`teacher_name` AS `father_teacher_name`,`course`.`course_name` AS `father_course_name`,`course`.`course_id` AS `course_id1`,count(if((`answer`.`student_ans` = 1),TRUE,NULL)) AS `student_ans1`,count(if((`answer`.`student_ans` = 2),TRUE,NULL)) AS `student_ans2`,count(if((`answer`.`student_ans` = 3),TRUE,NULL)) AS `student_ans3`,count(if((`answer`.`student_ans` = 4),TRUE,NULL)) AS `student_ans4`,`answer`.`student_id` AS `student_id` from ((((`answer` join `problem`) join `problem_set`) join `teacher`) join `course`) where ((`answer`.`problem_set_id` = `problem_set`.`problem_set_id`) and (`answer`.`problem_id` = `problem`.`problem_id`) and (`problem_set`.`teacher_id` = `teacher`.`teacher_id`) and (`course`.`course_id` = `problem_set`.`course_id`)) group by `problem`.`problem_id`,`answer`.`problem_set_id`,`answer`.`problem_id`,`problem`.`problem_info`,`problem`.`problem_ans`,`problem`.`problem_explain`,`problem_set`.`problem_set_id`,`problem_set`.`teacher_id`,`problem_set`.`course_id`,`teacher`.`teacher_id`,`teacher`.`teacher_name`,`course`.`course_name`,`course`.`course_id` ;

-- ----------------------------
-- View structure for paper_problem_view
-- ----------------------------
DROP VIEW IF EXISTS `paper_problem_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`javaee`@`localhost` SQL SECURITY DEFINER VIEW `paper_problem_view` AS select `problem_paper`.`paper_id` AS `paper_id`,`paper`.`paper_name` AS `paper_name`,`problem`.`problem_info` AS `problem_info`,`problem`.`problem_ans` AS `problem_ans`,`problem`.`problem_explain` AS `problem_explain`,`problem_paper`.`problem_id` AS `problem_id` from ((`problem_paper` join `paper` on((`problem_paper`.`paper_id` = `paper`.`paper_id`))) join `problem` on((`problem_paper`.`problem_id` = `problem`.`problem_id`))) ;

-- ----------------------------
-- View structure for problem_set_course
-- ----------------------------
DROP VIEW IF EXISTS `problem_set_course`;
CREATE ALGORITHM=UNDEFINED DEFINER=`javaee`@`localhost` SQL SECURITY DEFINER VIEW `problem_set_course` AS select `problem_set`.`problem_set_id` AS `problem_set_id`,`problem_set`.`problem_set_name` AS `problem_set_name`,`problem_set`.`problem_set_detail` AS `problem_set_detail`,`problem_set`.`problem_set_pic_url` AS `problem_set_pic_url`,`course`.`course_name` AS `course_name`,`teacher`.`teacher_name` AS `teacher_name`,`course`.`course_id` AS `course_id` from ((`problem_set` join `course` on((`problem_set`.`course_id` = `course`.`course_id`))) join `teacher` on((`problem_set`.`teacher_id` = `teacher`.`teacher_id`))) ;

-- ----------------------------
-- View structure for problem_set_part
-- ----------------------------
DROP VIEW IF EXISTS `problem_set_part`;
CREATE ALGORITHM=UNDEFINED DEFINER=`javaee`@`localhost` SQL SECURITY DEFINER VIEW `problem_set_part` AS select `problem_set`.`problem_set_id` AS `problem_set_id`,`problem_set`.`problem_set_name` AS `problem_set_name`,`problem_set`.`problem_set_detail` AS `problem_set_detail`,`problem_set`.`problem_release_time` AS `problem_release_time`,`problem_set`.`problem_set_pic_url` AS `problem_set_pic_url`,`problem_set`.`paper_id` AS `paper_id` from `problem_set` ;

-- ----------------------------
-- View structure for student_course_detail_view
-- ----------------------------
DROP VIEW IF EXISTS `student_course_detail_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`javaee`@`localhost` SQL SECURITY DEFINER VIEW `student_course_detail_view` AS select `student`.`student_id` AS `student_id`,`student`.`student_name` AS `student_name`,`class`.`class_name` AS `class_name`,`class`.`class_id` AS `class_id`,`course`.`course_id` AS `course_id`,`course`.`course_name` AS `course_name`,`teacher`.`teacher_id` AS `teacher_id`,`teacher`.`teacher_name` AS `teacher_name`,`course`.`course_pic_url` AS `course_pic_url`,`course`.`course_detail` AS `course_detail`,`course`.`course_credit` AS `course_credit`,`course`.`course_method` AS `course_method` from ((((`student_class` join `student`) join `class`) join `course`) join `teacher`) where ((`student_class`.`student_id` = `student`.`student_id`) and (`student_class`.`class_id` = `class`.`class_id`) and (`class`.`course_id` = `course`.`course_id`) and (`class`.`teacher_id` = `teacher`.`teacher_id`)) ;
