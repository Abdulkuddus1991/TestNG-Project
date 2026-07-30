# OrangeHRM-Selenium-TestNG
End-to-end test automation for the OrangeHRM Demo site using **Selenium WebDriver + TestNG + Gradle + Extent Reports**.

## About This Project
- Admin login via CLI parameters
- Create new employee manually and from JSON data
- Generate random alphanumeric password
- Save employee details to JSONArray file
- Verify employee in Directory
- Logout and re-login with new credentials
- Confirm profile name and update personal info (Gender + Blood Type B+)
- Full regression suite with Extent reporting

**Test URL:** https://opensource-demo.orangehrmlive.com/
**Admin Credentials:** `Admin` / `admin123`


## Tools & Technologies
- Java 11+
- Selenium WebDriver
- TestNG
- Gradle
- Extent Reports 5
- WebDriverMana

## Prerequisites
- Java JDK 11+ installed with `JAVA_HOME` configured
- Gradle (or use the included Gradle Wrapper)
- Chrome / Firefox browser
- Git
  
## How to Run Project
```bash
./gradlew clean test -Psuitename=EmployeeRegression
```

## Extent Report Photo
<img width="731" height="374" alt="Screenshot 2026-07-31 001833" src="https://github.com/user-attachments/assets/086ae960-4ac0-4596-a7bf-b9ba58dd0bdb" />

## Allure Report Photo
<img width="731" height="374" alt="Screenshot 2026-07-31 003127" src="https://github.com/user-attachments/assets/bb1b11bb-266f-452d-89a2-7c909e1a7d71" />
