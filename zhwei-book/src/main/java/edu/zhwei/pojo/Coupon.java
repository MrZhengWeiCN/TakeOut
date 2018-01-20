package edu.zhwei.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Coupon {
    private Integer couponId;

    private String couponName;

    private String couponDesc;

    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private Date couponStartTime;

    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private Date couponEndTime;

    private Integer couponDiscount;

    private Integer couponThreshold;

    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private Integer couponNum;

    private Date couponKilltime;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc == null ? null : couponDesc.trim();
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public Integer getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Integer couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Integer getCouponThreshold() {
        return couponThreshold;
    }

    public void setCouponThreshold(Integer couponThreshold) {
        this.couponThreshold = couponThreshold;
    }

    public Integer getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(Integer couponNum) {
        this.couponNum = couponNum;
    }

    public Date getCouponKilltime() {
        return couponKilltime;
    }

    public void setCouponKilltime(Date couponKilltime) {
        this.couponKilltime = couponKilltime;
    }
}