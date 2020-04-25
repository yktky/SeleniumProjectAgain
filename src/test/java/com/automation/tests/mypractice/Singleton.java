package com.automation.tests.mypractice;

public class Singleton {

    //singleton class will have private constructor
    //it means other classes can not create object of this class
    private  Singleton(){

    }
    static  String str;
    public static  String getInstance(){
        //if str has not value, initialize it and rreturn

        if(str==null){
            System.out.println("str is null. assigning value to it");
            str = "ice cream was good";
            //else just return it
        }else {
            System.out.println("it already has value");
        }
        return str;
    }
}
