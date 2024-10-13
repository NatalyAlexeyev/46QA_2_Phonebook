package com.phonebook;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
    }

    @Test
    public void createAccountPositiveTest1() {
        String email = "delete_account_" + System.currentTimeMillis() + "@gmail.com";
        app.getUserhelper().clickLoginLink();
        app.getUserhelper().fillInRegistrationForm(new User()
                .setEmail(email)
                .setPassword("Password1@"));
        app.getUserhelper().clickRegistrationButton();
        Assert.assertTrue(app.getUserhelper().isSignOutButtonPresent());
    }

    @Test
    public void createAccountPositiveTest2() {
        String email = "delete_account_" + System.currentTimeMillis() + "@gmail.com";
        String password = "Password1@";
        app.getUserhelper().register(email, password);
    }

    @Test
    public void createAccountLoginPositiveTest() {
        String email = "delete_account_" + System.currentTimeMillis() + "@gmail.com";
        String password = "Password1@";
        app.getUserhelper().register(email, password);
        app.getUserhelper().logout();
        app.getUserhelper().login(email, password);
    }

    @Test
    public void createAccountNegativeTest() {
        String email = "delete_account_" + System.currentTimeMillis() + "@gmail.com";
        SoftAssert softAssert = new SoftAssert();
        app.getUserhelper().clickLoginLink();
        app.getUserhelper().fillInRegistrationForm(new User()
                .setEmail(email)
                .setPassword("Password1@"));
        app.getUserhelper().clickRegistrationButton();
        //Assert.assertFalse(isSignOutButtonPresent());
        //Assert.assertTrue(isAlertPresent());
        //Assert.assertTrue(isError409Present());
        /*

        softAssert.assertTrue(app.getUserhelper().isAlertPresent());
        softAssert.assertTrue(app.getUserhelper().isError409Present());
        softAssert.assertAll();
        /*

         */
    }

    @AfterMethod
    public void postCondition() {
        try {
            app.getUserhelper().logout();
        } catch (Exception e) {
            // throw new RuntimeException(e);
        }
    }
}
