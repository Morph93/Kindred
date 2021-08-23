# Kindred

### This project purpose is to automate Test cases for https://www.unibet.co.uk/blog search functionality.

- I'm using page object pattern to organize project so that the adaptability can be done quickly.
- Cucumber is used to organize the test cases and regulate test data. 
- The pages are located inside of main.java.pages folder and separated based on the part of the application we want to interact with.
- For storing elements I'm using HashMap because it gives me flexibility to map name of the element with the locator. 
- I'm initiating the elements in the constructor of the Class together with the driver that's inherited from FunctionsPage Class.


- The driver is and capabilities are set inside the DriverFactory Class.
- All the custom functions are located inside the FunctionsPage Class.


- Everything regarding testing is located inside the test.java folder. 
- The Class ApplicationHooks regulates the flow of execution using cucumber annotations.
- The Cass RunUI is a runner class is used to run all desired scenarios. 
- In order to target specific scenarios you have to change "tags" that you target. For example, we will target @Kindred to run all tests that is defined inside the resources.parallel.ui folder 

## How to run tests?
 
- Before running tests make sure that you check following things: 
  - capabilities inside DriverFactory class, for example: device name and android version.
  - Start appium server 
  - Connect your device or if you are using AVD start the AVD 
  

- There are multiple ways to run tests:

  - First is runner class RunUI, just right click it and  run it
  - Second is through cucumber feature file, go to the resources.parallel.ui.featureFile.feature, and you can start each scenario individual.
  - Third is through XML file located in xmlExecution.ui folder, just right click it and run it.  


- The report is generated once you run tests through either Runner class or xml file.
- Two types of report are generated, HTML and PDF located in test-output folder.


## What would I automate if I had more time: 

- I would cover login feature as it is the most important part for this kind of the application 
- Also, I would cover opening of all pages to check if all pages are implemented correctly.
- Redirection to the applications such as casino, live casino...etc
- I would also test the translations if there is a file that contains all translations, we can create JSON file and compare if the translations are implemented correctly.
