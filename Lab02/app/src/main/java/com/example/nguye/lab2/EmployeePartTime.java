package com.example.nguye.lab2;

public class EmployeePartTime extends Employee {

    @Override
    public double TinhLuong() {
        // TODO Auto-generated method stub
        return 150;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" -->PartTime="+TinhLuong();
    }
    @Override
    public boolean isManager(){
        if(this.getPosition() == 1){
            return true;
        }
        return false;
    }
}