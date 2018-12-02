package com.example.nguye.lab2;

public class EmployeeFullTime extends Employee {

    @Override
    public double TinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" -->FullTime="+TinhLuong();
    }
    @Override
    public boolean isManager(){
        if(this.getPosition() == 1){
            return true;
        }
        return false;
    }
}
