# smart_Classroom
## ZJUT JavaEE Final Project


### 已完成功能：
    1.学生绑定学号 (POST)
    /user/login
    （传入studentName[非空],studentPassword[非空],studentAccount[非空],openId[非空],sessionKey[非空]）
    
    2.通过练习id获取学生答题情况 (GET)
    /problem/getProblemSetStudentAnsweringDetailByProblemSetId
    （传入problemSetId[非空]）
    
    3.通过problemId修改problem详情 (POST)
    /problem/updateProblemById
    （传入problemId[非空],problemInfo,problemAns,problemExplain,problemChoose1,problemChoose2,problemChoose3,problemChoose4;）
    
    4.通过problemId获取problem详情 (GET)
    /problem/getProblemById
    （传入problemId[非空]）
    
    5.添加problem (POST)
    /problem/addProblem （problemInfo[非空],problemAns[非空],problemExplain[非空],problemChoose1[非空],problemChoose2[非空],problemChoose3[非空],problemChoose4[非空]）
    
    6.通过problemset_id获取问题详情列表 (GET)
    /problem/getProblemsByProblemSetId
    （传入id[非空]）
    
    7.学生提交做题记录并判题 (POST)
    /problem/postMyAnswer
    （传入studentId[非空],studentAccount[非空],courseId[非空],problemSetId[非空],myAnswers[非空]）
    
    8.通过课程id获取problemSet (GET)
    /problemSet/getProblemSetByCourseId
    （传参course_id[非空]）
    
    9.通过problemSetId获取problemSet (GET)
    /problemSet/getProblemSetByProblemSetId
    （传参problem_set_id[非空]）
    
    10.通过problemSetId更新problemSet (POST)
    /problemSet/updateProblemSetByProblemSetId
    （传入problemSetId[非空]，其他可缺省problemSetName、 problemSetDetail、problemSetPicUrl，缺省部分默认使用记录原值）
    
    11.通过problemSetId删除problemSet (GET)
    /problemSet/deleteProblemSetByProblemSetId
    （传参problem_set_id[非空]）
    
    12.根据老师选择的题目来插入试题 (POST)
    /paperProblem/createNewPaper
    （传入字符串problemList[非空]，形如"1,2,3,4"[题号为1、2、3、4],paperName[非空]）
    
    13.根据paperId查询paper内的题目等详细信息 (GET)
    /paperProblem/getPaperDetailByPaperId
    （传参paper_id[非空]）
    
    14.通过paperId删除paper (GET)
    /paperProblem/deletePaperProblemByPaperId
    （传参paper_id[非空]）
    
    15.通过paperId更新paper (POST)
    /paperProblem/updatePaperByPaperId
    （paperId[非空]，扩展功能：同时传参旧问题id(problemId)和新问题id(newProblemId)时做替换；仅传参旧问题id(problemId)时做删除；仅传参新问题id(newProblemId)时做新增）
    
    16.获取全部paper信息 (GET)
    /paper/getAllPaperInfo
    
    17.插入paper (POST)
    /paper/insertPaper
    （传参paperName[非空]）
    
    18.通过paperId删除paper (GET)
    /paper/deletePaperBypaperId
    （传参paperId[非空]）
    
    19.通过paperId更新paper (POST)
    /paper/updatePaperByPaperId
    （传参paperId[非空],paperName）
    
    20.通过paperId获取paper (GET)
    /paper/getPaperByPaperId
    （传参paperId[非空]）
    
    21.通过课程id更新course (POST)
    /course/updateCourse
    （传入courseId[非空]，courseName，courseCredit，courseMethod，courseDetail， coursePicUrl）
    
    22.为课程添加problemSet (POST)
     /course/addProblemSetToCourse
    （传入teacherId[非空],courseId[非空],pperId[非空]）
    
    23.为课程添加ppt (POST)
    /course/addPPT_ToCourse
    （传入courseId[非空],ppt_url[非空],teacherId[非空]）
    
    24.获取全部班级信息 (GET)
    /class/getAllClass
    
    25.添加班级 (POST)
    /class/addClass
    （传入classOpenyear[非空],courseId[非空],teacherId[非空],classClassroom[非空],classOpenyear[非空],className[非空]）
    
    26.通过teacherId和courseId更新班级信息 (POST)
    /class/updateClass
    （传入teacherId[非空],courseId[非空],classOpenyear,classClassroom,classOpenyear,className）
    
### 待解决的问题：
    1.集成swagger配置（用于自动生成在线接口文档）
    2.继承七牛配置（用于上传功能）
    3.解决微信小程序后台sessionkey验证工具类
