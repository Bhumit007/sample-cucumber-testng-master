package com.example.PageClass;

import com.example.Utils.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BaseClass {

    public String fullName;

    @FindBy(id = "txtUsername")
    protected WebElement userName;

    @FindBy(id = "txtPassword")
    protected WebElement password;

    @FindBy(id="btnLogin")
    protected WebElement loginBtn;

    @FindBy(id = "welcome")
    protected WebElement txtWelcomeAdmin;

    @FindBy(id = "menu_pim_viewPimModule")
    protected WebElement clickOnPIM;

    @FindBy(id = "menu_pim_addEmployee")
    protected WebElement clickOnAddEmployee;

    @FindBy(id = "firstName")
    protected WebElement txtFirstName;

    @FindBy(id = "lastName")
    protected WebElement txtLastName;

    @FindBy(id = "photofile")
    private WebElement btnChooseFile;

    @FindBy(id = "chkLogin")
    protected WebElement checkBoxLogin;

    @FindBy(id = "user_name")
    protected WebElement txtUserName;

    @FindBy(id = "user_password")
    protected WebElement txtPassword;

    @FindBy(id = "re_password")
    protected WebElement txtConfirmPassword;

    @FindBy(id = "btnSave")
    protected WebElement btnSave;

    @FindBy(xpath = "//div[contains(@class,'message success')]")
    protected WebElement successMessage;

    /**
     * Check Orange HRM home page.
     * @return
     */
    public LoginPage getOrangeHRMHome(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(driver.getTitle()));
        return this;
    }
    /**
     * Send Username.
     * @return
     */
    public LoginPage sendUserName(String username){
        Utilities.getUtilities().waitForVisibilityOfElement(userName,driver);
        userName.sendKeys(username);
        return this;
    }

    /**
     * send password.
     * @return
     */
    public LoginPage sendPassword(String pass){
        Utilities.getUtilities().waitForVisibilityOfElement(password,driver);
        password.sendKeys(pass);
        return this;
    }

    /**
     * Click on login btn.
     * @return
     */
    public LoginPage clickOnLoginBtn(){
        Utilities.getUtilities().waitForVisibilityOfElement(loginBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(loginBtn,driver);
        loginBtn.click();
        return this;
    }

    /**
     * System login.
     * @return
     */
    public LoginPage systemLogin(String username,String password){
        sendUserName(username);
        sendPassword(password);
        clickOnLoginBtn();
        verifyHomePage();
        return this;
    }


    /**
     * Verify home page.
     * @return
     */
    public LoginPage verifyHomePage() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtWelcomeAdmin, driver);
        return this;
    }

    /**
     * click on PIM
     *
     * @return
     */
    public LoginPage clickOnPIM() {
        Utilities.getUtilities().clickOnElement(clickOnPIM, driver);
        return this;
    }

    /**
     * click on Add Employee Tab
     *
     * @return
     */
    public LoginPage clickOnAddEmployee() {
        Utilities.getUtilities().clickOnElement(clickOnAddEmployee, driver);
        return this;
    }

    /**
     * Enter FirstName and LastName in Add Employee tab
     *
     * @return
     */
    public LoginPage enterFirstNameAndLastName() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtFirstName, driver);
        String firstName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtFirstName, firstName);
        Utilities.getUtilities().waitForVisibilityOfElement(txtLastName, driver);
        String lastName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtLastName, lastName);
        fullName = firstName + " " + lastName;
        return this;
    }

    /**
     * File Upload
     *
     * @return
     */
    public LoginPage fileUpload() {
        Utilities.getUtilities().waitForElementTobeClickable(btnChooseFile, driver);
        Utilities.getUtilities().uploadFile(btnChooseFile, prop.getProperty("filePath"));
        return this;
    }

    /**
     * Check box for Create Login Detail
     *
     * @return
     */
    public LoginPage checkBoxCreateLoginDetail() {
        Utilities.getUtilities().clickOnElement(checkBoxLogin, driver);
        return this;
    }

    /**
     * Enter Login Detail
     *
     * @return
     */
    public LoginPage enterLoginDetail() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(txtUserName, driver);
        String userName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtUserName, userName);
        Utilities.getUtilities().waitForVisibilityOfElement(txtPassword, driver);
        Utilities.getUtilities().sendKey(txtPassword, prop.getProperty("password"));
        Utilities.getUtilities().waitForVisibilityOfElement(txtConfirmPassword, driver);
        Utilities.getUtilities().sendKey(txtConfirmPassword, prop.getProperty("confirmPassword"));
        Utilities.getUtilities().clickOnElement(btnSave, driver);
        Thread.sleep(3000);
        return this;
    }

    /**
     * Verify Success Message
     * @return
     */
    public LoginPage verifySuccessMessage(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessage")));
        return this;
    }

    public LoginPage verifySuccessMessageForAdd(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessageForAdd")));
        return this;
    }

}
