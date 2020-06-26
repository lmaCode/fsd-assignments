package com.lipengwei.fsd.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TMentorCalendarCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMentorCalendarCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMentorIdIsNull() {
            addCriterion("mentor_id is null");
            return (Criteria) this;
        }

        public Criteria andMentorIdIsNotNull() {
            addCriterion("mentor_id is not null");
            return (Criteria) this;
        }

        public Criteria andMentorIdEqualTo(String value) {
            addCriterion("mentor_id =", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdNotEqualTo(String value) {
            addCriterion("mentor_id <>", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdGreaterThan(String value) {
            addCriterion("mentor_id >", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdGreaterThanOrEqualTo(String value) {
            addCriterion("mentor_id >=", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdLessThan(String value) {
            addCriterion("mentor_id <", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdLessThanOrEqualTo(String value) {
            addCriterion("mentor_id <=", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdLike(String value) {
            addCriterion("mentor_id like", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdNotLike(String value) {
            addCriterion("mentor_id not like", value, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdIn(List<String> values) {
            addCriterion("mentor_id in", values, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdNotIn(List<String> values) {
            addCriterion("mentor_id not in", values, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdBetween(String value1, String value2) {
            addCriterion("mentor_id between", value1, value2, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorIdNotBetween(String value1, String value2) {
            addCriterion("mentor_id not between", value1, value2, "mentorId");
            return (Criteria) this;
        }

        public Criteria andMentorNameIsNull() {
            addCriterion("mentor_name is null");
            return (Criteria) this;
        }

        public Criteria andMentorNameIsNotNull() {
            addCriterion("mentor_name is not null");
            return (Criteria) this;
        }

        public Criteria andMentorNameEqualTo(String value) {
            addCriterion("mentor_name =", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameNotEqualTo(String value) {
            addCriterion("mentor_name <>", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameGreaterThan(String value) {
            addCriterion("mentor_name >", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameGreaterThanOrEqualTo(String value) {
            addCriterion("mentor_name >=", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameLessThan(String value) {
            addCriterion("mentor_name <", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameLessThanOrEqualTo(String value) {
            addCriterion("mentor_name <=", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameLike(String value) {
            addCriterion("mentor_name like", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameNotLike(String value) {
            addCriterion("mentor_name not like", value, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameIn(List<String> values) {
            addCriterion("mentor_name in", values, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameNotIn(List<String> values) {
            addCriterion("mentor_name not in", values, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameBetween(String value1, String value2) {
            addCriterion("mentor_name between", value1, value2, "mentorName");
            return (Criteria) this;
        }

        public Criteria andMentorNameNotBetween(String value1, String value2) {
            addCriterion("mentor_name not between", value1, value2, "mentorName");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIsNull() {
            addCriterion("training_date is null");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIsNotNull() {
            addCriterion("training_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingDateEqualTo(Date value) {
            addCriterionForJDBCDate("training_date =", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("training_date <>", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateGreaterThan(Date value) {
            addCriterionForJDBCDate("training_date >", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("training_date >=", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateLessThan(Date value) {
            addCriterionForJDBCDate("training_date <", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("training_date <=", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIn(List<Date> values) {
            addCriterionForJDBCDate("training_date in", values, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("training_date not in", values, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("training_date between", value1, value2, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("training_date not between", value1, value2, "trainingDate");
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