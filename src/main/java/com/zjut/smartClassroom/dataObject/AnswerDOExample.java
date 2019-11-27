package com.zjut.smartClassroom.dataObject;

import java.util.ArrayList;
import java.util.List;

public class AnswerDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswerDOExample() {
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

        public Criteria andAnsIdIsNull() {
            addCriterion("ans_id is null");
            return (Criteria) this;
        }

        public Criteria andAnsIdIsNotNull() {
            addCriterion("ans_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnsIdEqualTo(Integer value) {
            addCriterion("ans_id =", value, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdNotEqualTo(Integer value) {
            addCriterion("ans_id <>", value, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdGreaterThan(Integer value) {
            addCriterion("ans_id >", value, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ans_id >=", value, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdLessThan(Integer value) {
            addCriterion("ans_id <", value, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ans_id <=", value, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdIn(List<Integer> values) {
            addCriterion("ans_id in", values, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdNotIn(List<Integer> values) {
            addCriterion("ans_id not in", values, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdBetween(Integer value1, Integer value2) {
            addCriterion("ans_id between", value1, value2, "ansId");
            return (Criteria) this;
        }

        public Criteria andAnsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ans_id not between", value1, value2, "ansId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
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

        public Criteria andProblemIdIsNull() {
            addCriterion("problem_id is null");
            return (Criteria) this;
        }

        public Criteria andProblemIdIsNotNull() {
            addCriterion("problem_id is not null");
            return (Criteria) this;
        }

        public Criteria andProblemIdEqualTo(Integer value) {
            addCriterion("problem_id =", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotEqualTo(Integer value) {
            addCriterion("problem_id <>", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdGreaterThan(Integer value) {
            addCriterion("problem_id >", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem_id >=", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdLessThan(Integer value) {
            addCriterion("problem_id <", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdLessThanOrEqualTo(Integer value) {
            addCriterion("problem_id <=", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdIn(List<Integer> values) {
            addCriterion("problem_id in", values, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotIn(List<Integer> values) {
            addCriterion("problem_id not in", values, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdBetween(Integer value1, Integer value2) {
            addCriterion("problem_id between", value1, value2, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("problem_id not between", value1, value2, "problemId");
            return (Criteria) this;
        }

        public Criteria andStudentAnsIsNull() {
            addCriterion("student_ans is null");
            return (Criteria) this;
        }

        public Criteria andStudentAnsIsNotNull() {
            addCriterion("student_ans is not null");
            return (Criteria) this;
        }

        public Criteria andStudentAnsEqualTo(Byte value) {
            addCriterion("student_ans =", value, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsNotEqualTo(Byte value) {
            addCriterion("student_ans <>", value, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsGreaterThan(Byte value) {
            addCriterion("student_ans >", value, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsGreaterThanOrEqualTo(Byte value) {
            addCriterion("student_ans >=", value, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsLessThan(Byte value) {
            addCriterion("student_ans <", value, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsLessThanOrEqualTo(Byte value) {
            addCriterion("student_ans <=", value, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsIn(List<Byte> values) {
            addCriterion("student_ans in", values, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsNotIn(List<Byte> values) {
            addCriterion("student_ans not in", values, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsBetween(Byte value1, Byte value2) {
            addCriterion("student_ans between", value1, value2, "studentAns");
            return (Criteria) this;
        }

        public Criteria andStudentAnsNotBetween(Byte value1, Byte value2) {
            addCriterion("student_ans not between", value1, value2, "studentAns");
            return (Criteria) this;
        }

        public Criteria andIstrueIsNull() {
            addCriterion("istrue is null");
            return (Criteria) this;
        }

        public Criteria andIstrueIsNotNull() {
            addCriterion("istrue is not null");
            return (Criteria) this;
        }

        public Criteria andIstrueEqualTo(Byte value) {
            addCriterion("istrue =", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueNotEqualTo(Byte value) {
            addCriterion("istrue <>", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueGreaterThan(Byte value) {
            addCriterion("istrue >", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueGreaterThanOrEqualTo(Byte value) {
            addCriterion("istrue >=", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueLessThan(Byte value) {
            addCriterion("istrue <", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueLessThanOrEqualTo(Byte value) {
            addCriterion("istrue <=", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueIn(List<Byte> values) {
            addCriterion("istrue in", values, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueNotIn(List<Byte> values) {
            addCriterion("istrue not in", values, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueBetween(Byte value1, Byte value2) {
            addCriterion("istrue between", value1, value2, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueNotBetween(Byte value1, Byte value2) {
            addCriterion("istrue not between", value1, value2, "istrue");
            return (Criteria) this;
        }

        public Criteria andRightAnsIsNull() {
            addCriterion("right_ans is null");
            return (Criteria) this;
        }

        public Criteria andRightAnsIsNotNull() {
            addCriterion("right_ans is not null");
            return (Criteria) this;
        }

        public Criteria andRightAnsEqualTo(Byte value) {
            addCriterion("right_ans =", value, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsNotEqualTo(Byte value) {
            addCriterion("right_ans <>", value, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsGreaterThan(Byte value) {
            addCriterion("right_ans >", value, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsGreaterThanOrEqualTo(Byte value) {
            addCriterion("right_ans >=", value, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsLessThan(Byte value) {
            addCriterion("right_ans <", value, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsLessThanOrEqualTo(Byte value) {
            addCriterion("right_ans <=", value, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsIn(List<Byte> values) {
            addCriterion("right_ans in", values, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsNotIn(List<Byte> values) {
            addCriterion("right_ans not in", values, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsBetween(Byte value1, Byte value2) {
            addCriterion("right_ans between", value1, value2, "rightAns");
            return (Criteria) this;
        }

        public Criteria andRightAnsNotBetween(Byte value1, Byte value2) {
            addCriterion("right_ans not between", value1, value2, "rightAns");
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