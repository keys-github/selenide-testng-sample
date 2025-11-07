package com.lambdatest;

import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.codeborne.selenide.WebDriverRunner;

public class LambdaTestSetup {
	public RemoteWebDriver driver;
	public String status="failed";

	public static String username;
	public static String accessKey;
	public static String sessionId;

	@BeforeMethod(alwaysRun = true)
	@Parameters(value = { "config", "environment" })
	public void setUp(String config_file, String environment) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
		JSONObject envs = (JSONObject) config.get("environments");

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Map<String, Object> ltOptions = new HashMap<>();

        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            ltOptions.put(pair.getKey().toString(), pair.getValue().toString());
        }

        // Read common capabilities
        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (!ltOptions.containsKey(pair.getKey().toString())) {
                String value = pair.getValue().toString();
                if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                    ltOptions.put(pair.getKey().toString(), Boolean.parseBoolean(value));
                } else {
                    ltOptions.put(pair.getKey().toString(), value);
                }
            }
        }

        ltOptions.put("name", this.getClass().getName());

        username = System.getenv("LT_USERNAME");
        if (username == null) {
            username = (String) config.get("user");
        }

        accessKey = System.getenv("LT_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) config.get("key");
        }

        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("latest");
        options.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        sessionId = driver.getSessionId().toString();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
