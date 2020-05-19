package com.javatutorial;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public void printContact(){
        System.out.println(String.format("Name: %s, Number: %s", name, number));
    }

    public String getName() {
        return name;
    }

    public void update(String name, String number){
        setName(name);
        setNumber(number);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }
}
