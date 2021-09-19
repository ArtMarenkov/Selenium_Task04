package steps;

import io.qameta.allure.Step;
import pages.InsurancePage_1;

public class InsuranceSteps_1 extends BaseSteps{

    private InsurancePage_1 insurancePage_1;

    public InsuranceSteps_1() {
        insurancePage_1 = new InsurancePage_1(testService.getInitDriver());
    }

    @Step("поле {0} заполняется значением {1}")
    public void stepCheckoutInsurance() {
        insurancePage_1.checkoutInsurance.click();
    }
}
