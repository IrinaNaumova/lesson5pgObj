package constants;

import java.io.File;

public class Drivers {

    public static final String CHROME = "drivers" + File.separator + "chromedriver.exe";
    public static final String IE = "drivers" + File.separator + "IEDriverServer.exe";
    public static final String FIREFOX = "drivers" + File.separator + "geckodriver.exe";


    private Drivers() {
        throw new IllegalStateException("Constants class");
    }
}
