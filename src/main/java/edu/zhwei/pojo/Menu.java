package edu.zhwei.pojo;

public class Menu {
    private Integer menuId;

    private String menuName;

    private Integer menuPrice;

    private String menuPicAddr;

    private Integer menuTypeId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuPicAddr() {
        return menuPicAddr;
    }

    public void setMenuPicAddr(String menuPicAddr) {
        this.menuPicAddr = menuPicAddr == null ? null : menuPicAddr.trim();
    }

    public Integer getMenuTypeId() {
        return menuTypeId;
    }

    public void setMenuTypeId(Integer menuTypeId) {
        this.menuTypeId = menuTypeId;
    }
}