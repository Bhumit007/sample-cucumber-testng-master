package com.example.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public static LoginPage loginPage;

    public static void properties(){
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/generic.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setDriver(){
        properties();
        if(prop.getProperty("browser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
            driver = new ChromeDriver();
        }else {
//            FirefoxDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    public static void closeDriver(){
        driver.quit();
    }
}
