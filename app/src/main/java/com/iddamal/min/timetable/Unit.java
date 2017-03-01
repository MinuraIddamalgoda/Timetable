package com.iddamal.min.timetable;

import android.graphics.drawable.Drawable;

public class Unit {
    private String name;
    private String unitCode;
    private int background;
    private String faculty;

    public Unit(String name, String unitCode, int background, String faculty) {
        this.name = name;
        this.unitCode = unitCode;
        this.background = background;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public int getBackground() {
        return background;
    }

    public String getFaculty() {
        return faculty;
    }
}
