package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DBInteraction;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {

    private static SelenideElement codeInput = $("[name=code]");
    private static SelenideElement continueButton = $("[data-test-id=action-verify]");
    private static SelenideElement verifiedBy = $x("//h2");
    private static SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public VerificationPage() {
        verifiedBy.shouldBe(Condition.exactText("Интернет Банк"));
    }

    public static DashboardPage enterCode() {
        codeInput.setValue(DBInteraction.getVerificationCode());
        continueButton.click();
        return new DashboardPage();
    }

    public static void enterInvalidCode() {
        codeInput.setValue("12345");
        continueButton.click();
        errorNotification.shouldBe(Condition.appear);
    }
}
