package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.VerificationPage;

public class LoginUserTest extends SetUp {

    @Test
    void validLoginTest() {
        var validUser = DataHelper.insertAuthInfo();
        LoginPage loginPage = new LoginPage();
        loginPage.loginUser(validUser);
        VerificationPage.enterCode();
    }

    @Test
    void invalidEnterCodeTest() {
        var validUser = DataHelper.insertAuthInfo();
        LoginPage loginPage = new LoginPage();
        loginPage.loginUser(validUser);
        VerificationPage.enterInvalidCode();
    }

    @Test
    void invalidLoginTest() {
        var invalidUser = DataHelper.getInvalidAuthInfo();
        LoginPage loginPage = new LoginPage();
        loginPage.invalidUser(invalidUser);
    }

    @Test
    void invalidLoginLockingTest() {
        var invalidUser = DataHelper.getInvalidAuthInfo();
        LoginPage loginPage = new LoginPage();
        for (int i = 0; i < 3; i++) {
            loginPage.invalidUser(invalidUser);
        }
        loginPage.blockedUser();
    }
}
