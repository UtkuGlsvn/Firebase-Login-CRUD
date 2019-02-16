package com.example.myfirebase;

public class Model {


    private String data,name,surname,gender,id;
    public Model()
    {

    }
    public Model(String id,String data, String name, String surname, String gender) {
        this.id=id;
        this.data = data;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Model(String name, String surname, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
