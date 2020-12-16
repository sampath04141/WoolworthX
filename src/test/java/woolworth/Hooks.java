package woolworth;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import woolworth.common.utils.DriverUtils;

import java.net.MalformedURLException;

public class Hooks {
    @Before
    public void setupTest() throws MalformedURLException {
        DriverUtils.Capabilities();
    }

    @After
    public void closeDriver() throws MalformedURLException {
        DriverUtils.closeDriver();
    }
}
