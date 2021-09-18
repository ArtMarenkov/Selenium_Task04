package steps;


import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
//import io.cucumber.java.After;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import util.TestService;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

public class ScenarioSteps {

    TestService testService = new TestService();{
        testService.getInitDriver().get(testService.getBaseURL());
    }

    private MainSteps mainSteps;
    private InsuranceSteps_2 insuranceSteps_2;
    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps = new MainSteps();
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран пункт меню -\"(.+)\"$")
    public void stepSelectSubMenu(String menuItem) {
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("^нажатие на кнопку Оформить онлайн$")
    public void stepTravelInsurance() {
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        travelInsuranceSteps.stepTravelInsurance();
    }

    @When("^нажатие на кнопку Оформить$")
    public void stepCheckoutInsurance() {
        InsuranceSteps_1 insuranceSteps_1 = new InsuranceSteps_1();
//        insuranceSteps_1.stepMinCheck();
        insuranceSteps_1.stepCheckoutInsurance();
    }


    @When("заполняются поля:")
    public void stepFillInsuranceFields(DataTable fields) {
        insuranceSteps_2 = new InsuranceSteps_2();
        Map<String, String> rows = fields.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : rows.entrySet()) {
            insuranceSteps_2.stepFillInsuranceField(entry.getKey(), entry.getValue());
        }
//        for (Map<String, String> columns : rows) {
//
//        }
//        fields.asMap(String.class, String.class).forEach(
//                (key, value) -> insuranceSteps_2.stepFillInsuranceField(key, value));

    }

    @When("^нажатие на кнопку Продолжить$")
    public void stepClickContinueButton() {
        insuranceSteps_2.stepClickContinueButton();
    }

    @Then("^выводится сообщение:\"(.+)\"$")
    public void stepCheckFieldErrorMessage(String error) {
        insuranceSteps_2.stepCheckFieldErrorMessage(error);
    }

    @After
    public void tearDown() {
        testService.getInitDriver().quit();
    }

}
