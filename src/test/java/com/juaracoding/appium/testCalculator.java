package com.juaracoding.appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.appium.pages.Calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class testCalculator {

    private static AndroidDriver<MobileElement> driver;
    private Calculator calculator;



    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "vivo 1915");
        capabilities.setCapability("uuid", "YHDYGYFUOVBACMUS");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        calculator = new Calculator(driver);
    }

    @Test
    public void testAdd() {
        calculator.calcAdd();
        System.out.println("Hasil = "+calculator.getTxtResult());
        assertEquals(calculator.getTxtResult(), "3");
    }

    @Test
    public void testAddKali() {
        calculator.calcAddKali();
        System.out.println("Hasil = "+calculator.getTxtResult());
        assertEquals(calculator.getTxtResult(), "12");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}
