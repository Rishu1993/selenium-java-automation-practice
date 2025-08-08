# Selenium Java Automation Framework

## 📌 Overview
This is a Selenium Java Test Automation Framework built for UI test automation.  
It follows the **Page Object Model (POM)** design pattern and is integrated with **TestNG**, **Maven**, and **Allure Reports** for easy test management and reporting.

---

## 🛠 Tech Stack
- **Java** – Programming language
- **Selenium WebDriver** – UI automation
- **TestNG** – Test management & grouping
- **Maven** – Build & dependency management
- **Allure Reports** – Test reporting
- **WebDriverManager** – Automatic driver management
- **Page Object Model (POM)** – Maintainable test structure
- **Retry Mechanism** -Retries to run testcases twice if failed once

---

## 📂 Project Structure
src
├── test
│ └── java
│ ├── base # Base classes (WebDriver setup)
│ ├── pages # Page Object Model classes
│ ├── utils # Utilities (Screenshot, RetryAnalyzer, Listeners,Property file configuration)
│ ├── tests # Test classes
testng.xml # TestNG configuration
pom.xml # Maven dependencies
README.md # Project documentation

## ⚙️ Setup Instructions
1. **Clone the repository**  
   ```bash
   git clone https://github.com/Rishu1993/selenium-java-automation-practice.git
   
**2.Open in Eclipse or IntelliJ**

**3.Install Maven dependencies**
>>mvn clean install


▶ ##** How to Run Tests**

**Run all tests**
mvn clean test

**Run specific group**
mvn clean test -DsuiteXmlFile=testng.xml -Dgroups=Smoke

**Run specific TestNG suite**
mvn clean test -DsuiteXmlFile=testng.xml



📊** Reporting: Allure Reports**

1.Run the tests.
2.Generate report:
allure serve allure-results
3.A local server will open in the browser with a detailed report.


📸 **Screenshots on Failure**
If a test fails, the framework automatically:

1.Takes a screenshot
2.Attaches it to Allure reports



## 📊 Test Report (Allure)
Below is a sample Allure report generated after running the tests:
selenium-java-automation-practice\screenshots





📌 Author
Rishu Bajaj


