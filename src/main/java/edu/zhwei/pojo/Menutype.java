package edu.zhwei.pojo;

public class Menutype {
    private Integer menuTypeId;

    private Integer menuTypeNum;

    private String menuTypeName;

    public Integer getMenuTypeId() {
        return menuTypeId;
    }

    public void setMenuTypeId(Integer menuTypeId) {
        this.menuTypeId = menuTypeId;
    }

    public Integer getMenuTypeNum() {
        return menuTypeNum;
    }

    public void setMenuTypeNum(Integer menuTypeNum) {
        this.menuTypeNum = menuTypeNum;
    }

    public String getMenuTypeName() {
        return menuTypeName;
    }

    public void setMenuTypeName(String menuTypeName) {
        this.menuTypeName = menuTypeName == null ? null : menuTypeName.trim();
    }
}