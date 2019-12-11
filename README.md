# BigBank Web Page Test
Author: Miroshnichenko Mikhail
Email: hikari.no.mikem@gmail.com

Uses:
- Selenium
- JUnit
- PageFactory
- IntelliJ Idea

Requirements:
- Chrome Browser 78+ (tested on 79.0.3904.70)
- Allure to view reports (http://allure.qatools.ru/) after test
- 'Lombok' Idea plugin to correctly display some commands (you can run test without it) 

Usage:
- 'mvn test' to execute tests (2 test in one class) on Chrome browser
- 'mvn -Dbrowser=*** test' to run test on defined browser. Can be 'chrome' or 'safari'
- 'mvn allure:serve' to generate HTML report

Note:
- Test should work with Safari, but I can check it right now: I have only Win10 PC.
- Test can be launched on Windows, macOS ans Linux: corresponding Chrome drivers included to project, and test will use one that is suitable for current OS



