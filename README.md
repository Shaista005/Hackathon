# Pre-requisites:

1. Java is installed on your machine.
   
   * [Install JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
   
2. Eclipse IDE is installed on your machine, JAVA_HOME environment variable is created, added to PATH, path to Eclipse is added to PATH too
   * [Install Eclipse, configure enviroment variables](https://www.eclipse.org/ide/).

3. TestNg PlugIns also installed on your eclipse Ide.  

4. Chrome Webdriver,GeckoDriver and InternetExplorerDriver is on your machine and is in the PATH. Here are some resources from the internet that'll help you.
   * https://stackoverflow.com/questions/38081021/using-selenium-on-mac-chrome
   * https://www.youtube.com/watch?time_continue=182&v=dz59GsdvUF8


     

# Steps to run this Project

1. Unzip App-01 (2) Jar File.
   
2. Import this App-01 (2) folder in eclipse as Existing Maven Projects.

3. Get an API key by logging into Applitools > Person Icon > My API Key

4. Open in any editor file src\test\java\AppliToll_01\App_01\FirstTask.java  and set your ApiKey in string 'eyes.setApiKey("put your api key");' (or comment the string and set APPLITOOLS_API_KEY environment variable)  
5. Do same steps on SecondTask.java and ThirdTask.java File .

6. For Running the testcases on VersionV1 of the site Right click on TraditionalTestsV1.xml file and then click TestNGSuite.

6. If you want to run the testcases on VersionV2 then you have to perform following steps:

   6.1.Open in any editor file src\test\java\AppliToll_02\App_02\FirstTaskForV2.java  and set your ApiKey in string 'eyes.setApiKey("put your api key");' (or comment the string and set APPLITOOLS_API_KEY environment variable) 

   6.2 Do same steps on SecondTaskForv2.java and ThirdTaskForV2.java File .

   6.3 For Running the testcases on VersionV1 of the site Right click on TraditionalTestsV2.xml file and then click TestNGSuite.

   


