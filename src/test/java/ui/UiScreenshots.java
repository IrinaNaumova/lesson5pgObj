package ui;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class UiScreenshots implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {

        callBack.runTestMethod(testResult);
        if ((testResult.getThrowable() != null) &&
                (Arrays.toString(testResult.getMethod().getGroups()).contains("Ui"))) {
            try {
                takeScreenShot(testResult.getMethod().getMethodName());
            } catch (IOException e) {
                System.out.print("OOOOOPS");// Must be a logger!
            }
        }
    }


    @Attachment(value = "Failure in method {0}", type = "image/png")
    private static byte[] takeScreenShot(String methodName) throws IOException {
        File lastSelenideScreenshot = Screenshots.takeScreenShotAsFile();

        return Files.toByteArray(lastSelenideScreenshot);
    }
}
