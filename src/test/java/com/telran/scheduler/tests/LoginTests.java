package com.telran.scheduler.tests;

import com.telran.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void LoginPositiveTest() {
        app.getUser().login(new User().setEmail("irina@gmail.com").setPassword("Irina2021"));
                Assert.assertTrue(app.getEvent().isContainerReportPresent());
    }

    @Test
    public void LoginNegativeWithWrongPasswordTest() {
        app.getUser().login(new User().setEmail("irina@gmail.com").setPassword("Irina200021"));
        Assert.assertTrue(app.getEvent().isErrorMessagePresent());
    }

}
