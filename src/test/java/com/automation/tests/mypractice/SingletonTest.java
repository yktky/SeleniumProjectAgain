package com.automation.tests.mypractice;

import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();
        System.out.println("s1: "+s1);
        System.out.println("s2: "+s2);
    }

}
