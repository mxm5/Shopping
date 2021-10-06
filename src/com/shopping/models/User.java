package com.shopping.models;

public class User extends Model{

    @Override
    public int getId() {
        return super.getId();
    }

    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String pass;
    public User(int id, String phoneNumber, String firstName, String lastName) {
        super(id);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String phoneNumber, String pass) {
        super(0);
        this.phoneNumber = phoneNumber;
        this.pass =pass;
    }

    public User( String firstName, String lastName, String phoneNumber, String pass) {
        super(0);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass =pass;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPass() {
        return pass;
    }


}
