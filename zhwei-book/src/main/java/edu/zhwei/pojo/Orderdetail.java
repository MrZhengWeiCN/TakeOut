package edu.zhwei.pojo;

public class Orderdetail {
    private Integer detailId;

    private Integer detailOrderId;

    private String detailMenuName;

    private Integer detailMenuPrice;

    private Integer detailAmount;

    private String detailRemark;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailOrderId() {
        return detailOrderId;
    }

    public void setDetailOrderId(Integer detailOrderId) {
        this.detailOrderId = detailOrderId;
    }

    public String getDetailMenuName() {
        return detailMenuName;
    }

    public void setDetailMenuName(String detailMenuName) {
        this.detailMenuName = detailMenuName == null ? null : detailMenuName.trim();
    }

    public Integer getDetailMenuPrice() {
        return detailMenuPrice;
    }

    public void setDetailMenuPrice(Integer detailMenuPrice) {
        this.detailMenuPrice = detailMenuPrice;
    }

    public Integer getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(Integer detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getDetailRemark() {
        return detailRemark;
    }

    public void setDetailRemark(String detailRemark) {
        this.detailRemark = detailRemark == null ? null : detailRemark.trim();
    }
}