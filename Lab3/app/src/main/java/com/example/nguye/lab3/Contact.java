package com.example.nguye.lab3;

public class Contact {
    private int _id;
    private String _name;
    private String _phoneNumber;

    public Contact(){
        this._name = null;
        this._phoneNumber = null;
    }

    public Contact(String _name, String _phoneNumber){
        this._name = _name;
        this._phoneNumber = _phoneNumber;
    }

    public Contact(int _id, String _name, String _phoneNumber){
        this._id = _id;
        this._name = _name;
        this._phoneNumber = _phoneNumber;
    }

    public int getID() {
        return _id;
    }
    public void setID(int _id) {
        this._id = _id;
    }

    public String getName(){
        return this._name;
    }
    public void setName(String _name){
        this._name = _name;
    }

    public String getPhoneNumber(){
        return this._phoneNumber;
    }
    public void setPhoneNumber(String _phoneNumber){
        this._phoneNumber = _phoneNumber;
    }
    @Override
    public String toString(){
        return "Id: "+this.getID()+" ,Name: " + this.getName() + " ,Phone: " + this.getPhoneNumber();
    }
}
