package edu.zhwei.pojo;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuPriceIsNull() {
            addCriterion("menu_price is null");
            return (Criteria) this;
        }

        public Criteria andMenuPriceIsNotNull() {
            addCriterion("menu_price is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPriceEqualTo(Integer value) {
            addCriterion("menu_price =", value, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceNotEqualTo(Integer value) {
            addCriterion("menu_price <>", value, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceGreaterThan(Integer value) {
            addCriterion("menu_price >", value, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_price >=", value, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceLessThan(Integer value) {
            addCriterion("menu_price <", value, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceLessThanOrEqualTo(Integer value) {
            addCriterion("menu_price <=", value, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceIn(List<Integer> values) {
            addCriterion("menu_price in", values, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceNotIn(List<Integer> values) {
            addCriterion("menu_price not in", values, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceBetween(Integer value1, Integer value2) {
            addCriterion("menu_price between", value1, value2, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_price not between", value1, value2, "menuPrice");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrIsNull() {
            addCriterion("menu_pic_addr is null");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrIsNotNull() {
            addCriterion("menu_pic_addr is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrEqualTo(String value) {
            addCriterion("menu_pic_addr =", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrNotEqualTo(String value) {
            addCriterion("menu_pic_addr <>", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrGreaterThan(String value) {
            addCriterion("menu_pic_addr >", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrGreaterThanOrEqualTo(String value) {
            addCriterion("menu_pic_addr >=", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrLessThan(String value) {
            addCriterion("menu_pic_addr <", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrLessThanOrEqualTo(String value) {
            addCriterion("menu_pic_addr <=", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrLike(String value) {
            addCriterion("menu_pic_addr like", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrNotLike(String value) {
            addCriterion("menu_pic_addr not like", value, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrIn(List<String> values) {
            addCriterion("menu_pic_addr in", values, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrNotIn(List<String> values) {
            addCriterion("menu_pic_addr not in", values, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrBetween(String value1, String value2) {
            addCriterion("menu_pic_addr between", value1, value2, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuPicAddrNotBetween(String value1, String value2) {
            addCriterion("menu_pic_addr not between", value1, value2, "menuPicAddr");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdIsNull() {
            addCriterion("menu_type_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdIsNotNull() {
            addCriterion("menu_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdEqualTo(Integer value) {
            addCriterion("menu_type_id =", value, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdNotEqualTo(Integer value) {
            addCriterion("menu_type_id <>", value, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdGreaterThan(Integer value) {
            addCriterion("menu_type_id >", value, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_type_id >=", value, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdLessThan(Integer value) {
            addCriterion("menu_type_id <", value, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_type_id <=", value, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdIn(List<Integer> values) {
            addCriterion("menu_type_id in", values, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdNotIn(List<Integer> values) {
            addCriterion("menu_type_id not in", values, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_type_id between", value1, value2, "menuTypeId");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_type_id not between", value1, value2, "menuTypeId");
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