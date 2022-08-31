package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    //import io.cucumber and not junit

    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){

        //scenario class from cucumber holds the complete information of the execution
        byte[] pic;

        if(scenario.isFailed()){
            pic = takeScreenshot("failed/" + scenario.getName());
        }else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }

        //it will attach the screenshot in report
        //pic holds the screenshot, image/png defines the extension of image
        // scenario.getname is to provide the name of screeshot in the report
        scenario.attach(pic, "image/png", scenario.getName());
        closeBrowser();
    }

}
