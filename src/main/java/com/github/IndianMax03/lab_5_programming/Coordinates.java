package com.github.IndianMax03.lab_5_programming;

public class Coordinates {
    private Double x; //Поле не может быть null
    private Double y; //Значение поля должно быть больше -628, Поле не может быть null

    public Coordinates(Double x, Double y){
        setX(x);
        setY(y);
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

}
