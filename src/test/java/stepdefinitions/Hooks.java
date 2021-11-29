package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import utilities.Driver;


public class Hooks {
    //@Before TestNG deki @BeforeMethod gibidir
    //GLOBAL Hooks annotation
    //her scenario dan once calisir
    @Before
    public void setUp(){
        //System.out.println("Hooks class- Setup Method");
    }

    @After
    public void tearDown(){
        //System.out.println("Hooks class - tearDown Method ");

        //screenshot almak icin
        //final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        //screenshotu frameworke bir image olarak yerlestiriyoruz.
        //Her FAIL olan scenario dan sonra screenshot almaliyiz.

        //Scenario basarisiz olursa image ekleyelim
        //if(scenario.isFailed()){
        //    scenario.embed(screenshot,"image/png");
        //  }

        Driver.closeDriver();
    }


}
