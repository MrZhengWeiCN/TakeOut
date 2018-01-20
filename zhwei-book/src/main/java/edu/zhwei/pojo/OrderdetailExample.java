package edu.zhwei.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Integer value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Integer value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Integer value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Integer value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Integer> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Integer> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdIsNull() {
            addCriterion("detail_order_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdIsNotNull() {
            addCriterion("detail_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdEqualTo(Integer value) {
            addCriterion("detail_order_id =", value, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdNotEqualTo(Integer value) {
            addCriterion("detail_order_id <>", value, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdGreaterThan(Integer value) {
            addCriterion("detail_order_id >", value, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_order_id >=", value, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdLessThan(Integer value) {
            addCriterion("detail_order_id <", value, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("detail_order_id <=", value, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdIn(List<Integer> values) {
            addCriterion("detail_order_id in", values, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdNotIn(List<Integer> values) {
            addCriterion("detail_order_id not in", values, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("detail_order_id between", value1, value2, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_order_id not between", value1, value2, "detailOrderId");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameIsNull() {
            addCriterion("detail_menu_name is null");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameIsNotNull() {
            addCriterion("detail_menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameEqualTo(String value) {
            addCriterion("detail_menu_name =", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameNotEqualTo(String value) {
            addCriterion("detail_menu_name <>", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameGreaterThan(String value) {
            addCriterion("detail_menu_name >", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("detail_menu_name >=", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameLessThan(String value) {
            addCriterion("detail_menu_name <", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameLessThanOrEqualTo(String value) {
            addCriterion("detail_menu_name <=", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameLike(String value) {
            addCriterion("detail_menu_name like", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameNotLike(String value) {
            addCriterion("detail_menu_name not like", value, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameIn(List<String> values) {
            addCriterion("detail_menu_name in", values, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameNotIn(List<String> values) {
            addCriterion("detail_menu_name not in", values, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameBetween(String value1, String value2) {
            addCriterion("detail_menu_name between", value1, value2, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuNameNotBetween(String value1, String value2) {
            addCriterion("detail_menu_name not between", value1, value2, "detailMenuName");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceIsNull() {
            addCriterion("detail_menu_price is null");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceIsNotNull() {
            addCriterion("detail_menu_price is not null");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceEqualTo(Integer value) {
            addCriterion("detail_menu_price =", value, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceNotEqualTo(Integer value) {
            addCriterion("detail_menu_price <>", value, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceGreaterThan(Integer value) {
            addCriterion("detail_menu_price >", value, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_menu_price >=", value, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceLessThan(Integer value) {
            addCriterion("detail_menu_price <", value, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceLessThanOrEqualTo(Integer value) {
            addCriterion("detail_menu_price <=", value, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceIn(List<Integer> values) {
            addCriterion("detail_menu_price in", values, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceNotIn(List<Integer> values) {
            addCriterion("detail_menu_price not in", values, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceBetween(Integer value1, Integer value2) {
            addCriterion("detail_menu_price between", value1, value2, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailMenuPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_menu_price not between", value1, value2, "detailMenuPrice");
            return (Criteria) this;
        }

        public Criteria andDetailAmountIsNull() {
            addCriterion("detail_amount is null");
            return (Criteria) this;
        }

        public Criteria andDetailAmountIsNotNull() {
            addCriterion("detail_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAmountEqualTo(Integer value) {
            addCriterion("detail_amount =", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotEqualTo(Integer value) {
            addCriterion("detail_amount <>", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountGreaterThan(Integer value) {
            addCriterion("detail_amount >", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_amount >=", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountLessThan(Integer value) {
            addCriterion("detail_amount <", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountLessThanOrEqualTo(Integer value) {
            addCriterion("detail_amount <=", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountIn(List<Integer> values) {
            addCriterion("detail_amount in", values, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotIn(List<Integer> values) {
            addCriterion("detail_amount not in", values, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountBetween(Integer value1, Integer value2) {
            addCriterion("detail_amount between", value1, value2, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_amount not between", value1, value2, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkIsNull() {
            addCriterion("detail_remark is null");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkIsNotNull() {
            addCriterion("detail_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkEqualTo(String value) {
            addCriterion("detail_remark =", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkNotEqualTo(String value) {
            addCriterion("detail_remark <>", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkGreaterThan(String value) {
            addCriterion("detail_remark >", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("detail_remark >=", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkLessThan(String value) {
            addCriterion("detail_remark <", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkLessThanOrEqualTo(String value) {
            addCriterion("detail_remark <=", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkLike(String value) {
            addCriterion("detail_remark like", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkNotLike(String value) {
            addCriterion("detail_remark not like", value, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkIn(List<String> values) {
            addCriterion("detail_remark in", values, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkNotIn(List<String> values) {
            addCriterion("detail_remark not in", values, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkBetween(String value1, String value2) {
            addCriterion("detail_remark between", value1, value2, "detailRemark");
            return (Criteria) this;
        }

        public Criteria andDetailRemarkNotBetween(String value1, String value2) {
            addCriterion("detail_remark not between", value1, value2, "detailRemark");
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