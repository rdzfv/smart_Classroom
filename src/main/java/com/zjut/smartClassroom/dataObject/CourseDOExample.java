package com.zjut.smartClassroom.dataObject;

import java.util.ArrayList;
import java.util.List;

public class CourseDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseDOExample() {
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

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseCreditIsNull() {
            addCriterion("course_credit is null");
            return (Criteria) this;
        }

        public Criteria andCourseCreditIsNotNull() {
            addCriterion("course_credit is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCreditEqualTo(Integer value) {
            addCriterion("course_credit =", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditNotEqualTo(Integer value) {
            addCriterion("course_credit <>", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditGreaterThan(Integer value) {
            addCriterion("course_credit >", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_credit >=", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditLessThan(Integer value) {
            addCriterion("course_credit <", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditLessThanOrEqualTo(Integer value) {
            addCriterion("course_credit <=", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditIn(List<Integer> values) {
            addCriterion("course_credit in", values, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditNotIn(List<Integer> values) {
            addCriterion("course_credit not in", values, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditBetween(Integer value1, Integer value2) {
            addCriterion("course_credit between", value1, value2, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("course_credit not between", value1, value2, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseMethodIsNull() {
            addCriterion("course_method is null");
            return (Criteria) this;
        }

        public Criteria andCourseMethodIsNotNull() {
            addCriterion("course_method is not null");
            return (Criteria) this;
        }

        public Criteria andCourseMethodEqualTo(String value) {
            addCriterion("course_method =", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodNotEqualTo(String value) {
            addCriterion("course_method <>", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodGreaterThan(String value) {
            addCriterion("course_method >", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodGreaterThanOrEqualTo(String value) {
            addCriterion("course_method >=", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodLessThan(String value) {
            addCriterion("course_method <", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodLessThanOrEqualTo(String value) {
            addCriterion("course_method <=", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodLike(String value) {
            addCriterion("course_method like", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodNotLike(String value) {
            addCriterion("course_method not like", value, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodIn(List<String> values) {
            addCriterion("course_method in", values, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodNotIn(List<String> values) {
            addCriterion("course_method not in", values, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodBetween(String value1, String value2) {
            addCriterion("course_method between", value1, value2, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCourseMethodNotBetween(String value1, String value2) {
            addCriterion("course_method not between", value1, value2, "courseMethod");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlIsNull() {
            addCriterion("course_picUrl is null");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlIsNotNull() {
            addCriterion("course_picUrl is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlEqualTo(String value) {
            addCriterion("course_picUrl =", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlNotEqualTo(String value) {
            addCriterion("course_picUrl <>", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlGreaterThan(String value) {
            addCriterion("course_picUrl >", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlGreaterThanOrEqualTo(String value) {
            addCriterion("course_picUrl >=", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlLessThan(String value) {
            addCriterion("course_picUrl <", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlLessThanOrEqualTo(String value) {
            addCriterion("course_picUrl <=", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlLike(String value) {
            addCriterion("course_picUrl like", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlNotLike(String value) {
            addCriterion("course_picUrl not like", value, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlIn(List<String> values) {
            addCriterion("course_picUrl in", values, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlNotIn(List<String> values) {
            addCriterion("course_picUrl not in", values, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlBetween(String value1, String value2) {
            addCriterion("course_picUrl between", value1, value2, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePicurlNotBetween(String value1, String value2) {
            addCriterion("course_picUrl not between", value1, value2, "coursePicurl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlIsNull() {
            addCriterion("course_ppt_url is null");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlIsNotNull() {
            addCriterion("course_ppt_url is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlEqualTo(String value) {
            addCriterion("course_ppt_url =", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlNotEqualTo(String value) {
            addCriterion("course_ppt_url <>", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlGreaterThan(String value) {
            addCriterion("course_ppt_url >", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlGreaterThanOrEqualTo(String value) {
            addCriterion("course_ppt_url >=", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlLessThan(String value) {
            addCriterion("course_ppt_url <", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlLessThanOrEqualTo(String value) {
            addCriterion("course_ppt_url <=", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlLike(String value) {
            addCriterion("course_ppt_url like", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlNotLike(String value) {
            addCriterion("course_ppt_url not like", value, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlIn(List<String> values) {
            addCriterion("course_ppt_url in", values, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlNotIn(List<String> values) {
            addCriterion("course_ppt_url not in", values, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlBetween(String value1, String value2) {
            addCriterion("course_ppt_url between", value1, value2, "coursePptUrl");
            return (Criteria) this;
        }

        public Criteria andCoursePptUrlNotBetween(String value1, String value2) {
            addCriterion("course_ppt_url not between", value1, value2, "coursePptUrl");
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