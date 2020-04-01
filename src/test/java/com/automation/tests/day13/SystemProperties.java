package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        String pathDownLoads = System.getProperty("user.home")+"\\Downloads";
        System.out.println(pathDownLoads);
        System.out.println(System.getProperty("os.arch"));
    }
}
