package com.github.IndianMax03.lab_5_programming;
import java.time.ZonedDateTime;

public class Human {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer height; //Значение поля должно быть больше 0
    private java.time.ZonedDateTime birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

}
