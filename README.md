# Run Selenium Tests With Selenide — TestMu AI (Formerly LambdaTest)


![image](https://user-images.githubusercontent.com/70570645/172183152-cbcd0281-6847-49a9-af55-c966a9a48b91.png)

<p align="center">
  <a href="https://www.testmuai.com/blog/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample" target="_bank">Blog</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample" target="_bank">Docs</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample" target="_bank">Learning Hub</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/newsletter/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample" target="_bank">Newsletter</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/certifications/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample" target="_bank">Certifications</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.youtube.com/@TestMuAI" target="_bank">YouTube</a>
</p>
&emsp;
&emsp;
&emsp;

*Learn how to configure and run your Java automation testing scripts on TestMu AI platform using Selenide.*

[<img height="58" width="200" src="https://user-images.githubusercontent.com/70570645/171866795-52c11b49-0728-4229-b073-4b704209ddde.png">](https://accounts.lambdatest.com/register?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample)

## Table Of Contents

* [Pre-requisites](#pre-requisites)
* [Run Your First Test](#run-your-first-test)
* [Parallel Testing With Selenide](#run-parallel-tests-using-selenide)
* [Local Testing With Selenide](#testing-locally-hosted-or-privately-hosted-projects)

## Pre-requisites

Before you can start performing Java automation testing with Selenide, you would need to:

- Install the latest **Java development environment** i.e. **JDK 1.6** or higher. We recommend using the latest version.

- Download the latest **Selenium Client** and its **WebDriver bindings** from the [official website](https://www.selenium.dev/downloads/). Latest versions of Selenium Client and WebDriver are ideal for running your automation script on TestMu AI Selenium cloud grid.

- Install **Maven** which supports **JUnit** framework out of the box. **Maven** can be downloaded and installed following the steps from [the official website](https://maven.apache.org/). Maven can also be installed easily on **Linux/MacOS** using [Homebrew](https://brew.sh/) package manager.

### Cloning Repo And Installing Dependencies

**Step 1:** Clone the TestMu AI’s selenide-testng-sample repository and navigate to the code directory as shown below:

```bash
git clone https://github.com/LambdaTest/selenide-testng-sample
cd selenide-testng-sample
```

You may also want to run the command below to check for outdated dependencies.

```bash
mvn versions:display-dependency-updates
```

### Setting Up Your Authentication

Make sure you have your TestMu AI credentials with you to run test automation scripts. You can get these credentials from the [TestMu AI Automation Dashboard](https://automation.lambdatest.com/build?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample) or by your [TestMu AI Profile](https://accounts.lambdatest.com/login?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample).

**Step 2:** Set TestMu AI **Username** and **Access Key** in environment variables.

* For **Linux/macOS**:
  
  ```bash
  export LT_USERNAME="YOUR_USERNAME" 
  export LT_ACCESS_KEY="YOUR ACCESS KEY"
  ```
  * For **Windows**:
  ```bash
  set LT_USERNAME="YOUR_USERNAME" 
  set LT_ACCESS_KEY="YOUR ACCESS KEY"

## Run Your First Test

>**Test Scenario**: Checkout sample [LambdaTestSetup.java](https://github.com/LambdaTest/selenide-testng-sample/blob/master/src/test/java/com/lambdatest/LambdaTestSetup.java) file. This Selenide script tests a sample to-do list app by marking couple items as done, adding a new item to the list and finally displaying the count of pending items as output.

### Configuring your Test Capabilities

**Step 3:** In the test script, you need to update your test capabilities. In this code, we are passing browser, browser version, and operating system information, along with LambdaTest Selenium grid capabilities via capabilities object. The capabilities object in the above code are defined as:

```java
DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
```

You can generate capabilities for your test requirements with the help of our inbuilt [Desired Capability Generator](https://www.testmuai.com/capabilities-generator/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample).

### Executing the Test

**Step 4:** Install the mandatory Selenium dependencies for Maven by running the below command:

```bash
mvn compile
```

**Step 5:** The tests can be executed in the terminal using the following command:

```bash
mvn test -P single
```

## Run Parallel Tests Using Selenide


Refer to the [parallel.testng.xml](https://github.com/LambdaTest/selenide-testng-sample/blob/master/config/parallel.testng.xml) file which would help you to run a single test on various browsers at the same time, you would also need to generate a config file [parallel.config.json](https://github.com/LambdaTest/selenide-testng-sample/blob/master/src/test/resources/conf/parallel.conf.json) to define capabilities of the browsers.

To run parallel tests using Selenide, we would have to execute the below command in the terminal:

```bash
mvn test -P parallel
```

## Testing Locally Hosted Or Privately Hosted Projects

You can test your locally hosted or privately hosted projects with TestMu AI Selenium grid using TestMu AI Tunnel. All you would have to do is set up an SSH tunnel using tunnel and pass toggle `tunnel = True` via desired capabilities. TestMu AI Tunnel establishes a secure SSH protocol based tunnel that allows you in testing your locally hosted or privately hosted pages, even before they are live.

Refer our [TestMu AI Tunnel documentation](https://www.testmuai.com/support/docs/testing-locally-hosted-pages/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample) for more information.

Here’s how you can establish TestMu AI Tunnel.

Download the binary file of:
* [TestMu AI Tunnel for Windows](https://downloads.lambdatest.com/tunnel/v3/windows/64bit/LT_Windows.zip)
* [TestMu AI Tunnel for macOS](https://downloads.lambdatest.com/tunnel/v3/mac/64bit/LT_Mac.zip)
* [TestMu AI Tunnel for Linux](https://downloads.lambdatest.com/tunnel/v3/linux/64bit/LT_Linux.zip)

Open command prompt and navigate to the binary folder.

Run the following command:

```bash
LT -user {user’s login email} -key {user’s access key}
```
So if your user name is lambdatest@example.com and key is 123456, the command would be:

```bash
LT -user lambdatest@example.com -key 123456
```
Once you are able to connect **TestMu AI Tunnel** successfully, you would just have to pass on tunnel capabilities in the code shown below :

**Tunnel Capability**

```java
DesiredCapabilities capabilities = new DesiredCapabilities();        
        capabilities.setCapability("tunnel", true);
```

## Documentation & Resources :books:

      
Visit the following links to learn more about TestMu AI's features, setup and tutorials around test automation, mobile app testing, responsive testing, and manual testing.

* [TestMu AI Documentation](https://www.testmuai.com/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample)
* [TestMu AI Blog](https://www.testmuai.com/blog/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample)
* [TestMu AI Learning Hub](https://www.testmuai.com/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample)    

## TestMu AI Community :busts_in_silhouette:

The [TestMu AI Community](https://community.testmuai.com/?utm_source=github&utm_medium=repo&utm_campaign=selenide-testng-sample) allows people to interact with tech enthusiasts. Connect, ask questions, and learn from tech-savvy people. Discuss best practises in web development, testing, and DevOps with professionals from across the globe 🌎

## What's New At TestMu AI ❓

To stay updated with the latest features and product add-ons, visit [Changelog](https://changelog.lambdatest.com/)

## 🚀 LambdaTest is Now TestMu AI

👋 Welcome to TestMu AI, the next evolution of LambdaTest. As of January 2026, [LambdaTest is Now TestMu AI](https://www.testmuai.com/lambdatest-is-now-testmuai/) - we have evolved from a cross-browser testing cloud into a unified, AI-native quality engineering platform designed for the modern DevOps era.

Whether you have been part of the LambdaTest community for years or are just discovering TestMu AI, our mission remains the same: to help you ship faster with high-scale test execution, autonomous testing, and deep quality analytics.

**🔄 Our Rebrand Journey**

We chose the name TestMu AI to reflect our shift towards intelligent, autonomous testing. While our identity has changed, our core technology and commitment to the testing community stay the same.

👉 Find [LambdaTest's New Home](https://www.testmuai.com/).

**🔭 Explore TestMu AI**

The same infrastructure LambdaTest customers relied on, now delivered through autonomous AI agents.

- [KaneAI](https://www.testmuai.com/kane-ai/)
- [Agent-to-Agent Testing](https://www.testmuai.com/agent-to-agent-testing/)
- [HyperExecute](https://www.testmuai.com/hyperexecute/)
- [Real Device Cloud](https://www.testmuai.com/real-device-cloud/)
- [Pricing](https://www.testmuai.com/pricing/)
- [Documentation](https://www.testmuai.com/support/docs/)