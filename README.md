
# Selenium + TestNg testing framework

The framework has been build using Page Object Model Design Pattern where a class is created for each individual page of the website
Any reusable methods have been placed in ElementsUtils Class
Individual tests can be run from SwagLab_Tests Class
To run all tests and generate execution report, run testng.xml file
The execution report will be generated in test-output folder in html format

Please Note: In order to fix chrome unsafe issue in Mac, the ChromeDriver installation code has been slightly modified in BaseClass
If you face any issues, kindly de-comment System.setPropertery line in BaseClass.initialization method 






