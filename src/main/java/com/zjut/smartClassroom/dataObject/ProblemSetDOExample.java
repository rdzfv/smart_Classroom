package com.zjut.smartClassroom.dataObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProblemSetDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProblemSetDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProblemSetIdIsNull() {
            addCriterion("problem_set_id is null");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdIsNotNull() {
            addCriterion("problem_set_id is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdEqualTo(Integer value) {
            addCriterion("problem_set_id =", value, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdNotEqualTo(Integer value) {
            addCriterion("problem_set_id <>", value, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdGreaterThan(Integer value) {
            addCriterion("problem_set_id >", value, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem_set_id >=", value, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdLessThan(Integer value) {
            addCriterion("problem_set_id <", value, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdLessThanOrEqualTo(Integer value) {
            addCriterion("problem_set_id <=", value, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdIn(List<Integer> values) {
            addCriterion("problem_set_id in", values, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdNotIn(List<Integer> values) {
            addCriterion("problem_set_id not in", values, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdBetween(Integer value1, Integer value2) {
            addCriterion("problem_set_id between", value1, value2, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andProblemSetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("problem_set_id not between", value1, value2, "problemSetId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeIsNull() {
            addCriterion("problem_release_time is null");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeIsNotNull() {
            addCriterion("problem_release_time is not null");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeEqualTo(Date value) {
            addCriterion("problem_release_time =", value, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeNotEqualTo(Date value) {
            addCriterion("problem_release_time <>", value, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeGreaterThan(Date value) {
            addCriterion("problem_release_time >", value, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("problem_release_time >=", value, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeLessThan(Date value) {
            addCriterion("problem_release_time <", value, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("problem_release_time <=", value, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeIn(List<Date> values) {
            addCriterion("problem_release_time in", values, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeNotIn(List<Date> values) {
            addCriterion("problem_release_time not in", values, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("problem_release_time between", value1, value2, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andProblemReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("problem_release_time not between", value1, value2, "problemReleaseTime");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Integer value) {
            addCriterion("paper_id =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Integer value) {
            addCriterion("paper_id <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Integer value) {
            addCriterion("paper_id >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_id >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Integer value) {
            addCriterion("paper_id <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("paper_id <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Integer> values) {
            addCriterion("paper_id in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Integer> values) {
            addCriterion("paper_id not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("paper_id between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_id not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameIsNull() {
            addCriterion("problem_set_name is null");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameIsNotNull() {
            addCriterion("problem_set_name is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameEqualTo(String value) {
            addCriterion("problem_set_name =", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameNotEqualTo(String value) {
            addCriterion("problem_set_name <>", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameGreaterThan(String value) {
            addCriterion("problem_set_name >", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameGreaterThanOrEqualTo(String value) {
            addCriterion("problem_set_name >=", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameLessThan(String value) {
            addCriterion("problem_set_name <", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameLessThanOrEqualTo(String value) {
            addCriterion("problem_set_name <=", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameLike(String value) {
            addCriterion("problem_set_name like", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameNotLike(String value) {
            addCriterion("problem_set_name not like", value, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameIn(List<String> values) {
            addCriterion("problem_set_name in", values, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameNotIn(List<String> values) {
            addCriterion("problem_set_name not in", values, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameBetween(String value1, String value2) {
            addCriterion("problem_set_name between", value1, value2, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetNameNotBetween(String value1, String value2) {
            addCriterion("problem_set_name not between", value1, value2, "problemSetName");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailIsNull() {
            addCriterion("problem_set_detail is null");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailIsNotNull() {
            addCriterion("problem_set_detail is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailEqualTo(String value) {
            addCriterion("problem_set_detail =", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailNotEqualTo(String value) {
            addCriterion("problem_set_detail <>", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailGreaterThan(String value) {
            addCriterion("problem_set_detail >", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailGreaterThanOrEqualTo(String value) {
            addCriterion("problem_set_detail >=", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailLessThan(String value) {
            addCriterion("problem_set_detail <", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailLessThanOrEqualTo(String value) {
            addCriterion("problem_set_detail <=", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailLike(String value) {
            addCriterion("problem_set_detail like", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailNotLike(String value) {
            addCriterion("problem_set_detail not like", value, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailIn(List<String> values) {
            addCriterion("problem_set_detail in", values, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailNotIn(List<String> values) {
            addCriterion("problem_set_detail not in", values, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailBetween(String value1, String value2) {
            addCriterion("problem_set_detail between", value1, value2, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetDetailNotBetween(String value1, String value2) {
            addCriterion("problem_set_detail not between", value1, value2, "problemSetDetail");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlIsNull() {
            addCriterion("problem_set_picUrl is null");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlIsNotNull() {
            addCriterion("problem_set_picUrl is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlEqualTo(String value) {
            addCriterion("problem_set_picUrl =", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlNotEqualTo(String value) {
            addCriterion("problem_set_picUrl <>", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlGreaterThan(String value) {
            addCriterion("problem_set_picUrl >", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlGreaterThanOrEqualTo(String value) {
            addCriterion("problem_set_picUrl >=", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlLessThan(String value) {
            addCriterion("problem_set_picUrl <", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlLessThanOrEqualTo(String value) {
            addCriterion("problem_set_picUrl <=", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlLike(String value) {
            addCriterion("problem_set_picUrl like", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlNotLike(String value) {
            addCriterion("problem_set_picUrl not like", value, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlIn(List<String> values) {
            addCriterion("problem_set_picUrl in", values, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlNotIn(List<String> values) {
            addCriterion("problem_set_picUrl not in", values, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlBetween(String value1, String value2) {
            addCriterion("problem_set_picUrl between", value1, value2, "problemSetPicurl");
            return (Criteria) this;
        }

        public Criteria andProblemSetPicurlNotBetween(String value1, String value2) {
            addCriterion("problem_set_picUrl not between", value1, value2, "problemSetPicurl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}