package com.example.application;
import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String datedis;
    private String desc;
    private String time;

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public String getDatedis() {
        return datedis;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public void setDatedis(String datedis) {
        this.datedis = datedis;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
