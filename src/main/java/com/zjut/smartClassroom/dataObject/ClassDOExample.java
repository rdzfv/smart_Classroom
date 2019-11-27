package com.zjut.smartClassroom.dataObject;

import java.util.ArrayList;
import java.util.List;

public class ClassDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassDOExample() {
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

        public Criteria andClassClassroomIsNull() {
            addCriterion("class_classroom is null");
            return (Criteria) this;
        }

        public Criteria andClassClassroomIsNotNull() {
            addCriterion("class_classroom is not null");
            return (Criteria) this;
        }

        public Criteria andClassClassroomEqualTo(String value) {
            addCriterion("class_classroom =", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomNotEqualTo(String value) {
            addCriterion("class_classroom <>", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomGreaterThan(String value) {
            addCriterion("class_classroom >", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomGreaterThanOrEqualTo(String value) {
            addCriterion("class_classroom >=", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomLessThan(String value) {
            addCriterion("class_classroom <", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomLessThanOrEqualTo(String value) {
            addCriterion("class_classroom <=", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomLike(String value) {
            addCriterion("class_classroom like", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomNotLike(String value) {
            addCriterion("class_classroom not like", value, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomIn(List<String> values) {
            addCriterion("class_classroom in", values, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomNotIn(List<String> values) {
            addCriterion("class_classroom not in", values, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomBetween(String value1, String value2) {
            addCriterion("class_classroom between", value1, value2, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassClassroomNotBetween(String value1, String value2) {
            addCriterion("class_classroom not between", value1, value2, "classClassroom");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearIsNull() {
            addCriterion("class_openyear is null");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearIsNotNull() {
            addCriterion("class_openyear is not null");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearEqualTo(Integer value) {
            addCriterion("class_openyear =", value, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearNotEqualTo(Integer value) {
            addCriterion("class_openyear <>", value, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearGreaterThan(Integer value) {
            addCriterion("class_openyear >", value, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_openyear >=", value, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearLessThan(Integer value) {
            addCriterion("class_openyear <", value, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearLessThanOrEqualTo(Integer value) {
            addCriterion("class_openyear <=", value, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearIn(List<Integer> values) {
            addCriterion("class_openyear in", values, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearNotIn(List<Integer> values) {
            addCriterion("class_openyear not in", values, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearBetween(Integer value1, Integer value2) {
            addCriterion("class_openyear between", value1, value2, "classOpenyear");
            return (Criteria) this;
        }

        public Criteria andClassOpenyearNotBetween(Integer value1, Integer value2) {
            addCriterion("class_openyear not between", value1, value2, "classOpenyear");
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