package com.example.nguye.lab2;

public abstract class Employee {
    private String id;
    private String name;
    private int position;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public abstract double TinhLuong();
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.id+" - "+this.name;
    }

    public abstract boolean isManager();
}
