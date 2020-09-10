# Source Defense Automation Project


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Please verify that you got Chrome and Firefox (if you want to use firefox browser) installed on your local machine
* Please verify you got Java 8 and above installed on your local machine.
* You can run the program using your favorite IDE or using maven (will be explained later)

### Before Running 
* Before running please set all the requirement used under this file: 
```
src/main/java/org/example/resources/data.properties
```

You can set your browser (this program supports chrome & firefox browsers)
```
ui.browser.type=CHROME
```
### Running Tests
* running using maven: (verify you are located in the source path, e.g: '\SourceDefenseProject')
    
    please run this commands:
    
 ```
  1. mvn clean
  2. mvn compile
  3. mvn exec:java -Dexec.mainClass="src.main.java.org.example.BrowserManager.java"
  ```
  The above commands will run the program 
 
### Tests Results
 
* logs can be found under:

```
   logs
```
* output files (metrics for network & console logs) can be found under:
```
src/main/java/org/example/output
```
(only after the program ran at least once)
 
## Authors

 **Erez Naim** - *Senior Automation Engineer* 

Enjoy! :)