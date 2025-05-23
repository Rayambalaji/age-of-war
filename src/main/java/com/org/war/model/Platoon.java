package com.org.war.model;

public class Platoon {

    private PlatoonType type;
    private int count;

    public PlatoonType getType() {
        return type;
    }

    public void setType(PlatoonType type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Platoon(PlatoonType type, int count){
        this.type=type;
        this.count=count;
    }

    public String toString() {
        return type.name().charAt(0) + type.name().substring(1).toLowerCase().replaceAll("_", "") + "#" + count;
    }
}
