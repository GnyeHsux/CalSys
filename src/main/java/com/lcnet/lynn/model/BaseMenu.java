package com.lcnet.lynn.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by lynn on 2017/4/14.
 */
@Table("BASE_MENU")
public class BaseMenu {
    @Id
    @Column("menu_id")
    private Integer menuId;

    @Column("menu_code")
    private String menuCode;

    @Column("menu_pCode")
    private String menuPCode;

    @Column("menu_name")
    private String menuName;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuPCode() {
        return menuPCode;
    }

    public void setMenuPCode(String menuPCode) {
        this.menuPCode = menuPCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
