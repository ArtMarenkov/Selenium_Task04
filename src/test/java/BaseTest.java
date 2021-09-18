import org.junit.After;
import util.TestService;


public class BaseTest {


    private TestService testService = new TestService();
    protected void getDriverBaseURL(){
        testService.getInitDriver().get(testService.getBaseURL());
    }

    @After
    public void tearDown() {
        testService.getInitDriver().quit();
    }


}