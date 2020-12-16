

Woolworth (Coundown app)

1) JDK and also set JAVA_HOME environment variable
2) Maven and set MAVEN_HOME also add path variable to point to maven bin folder(example:  C:\Program Files\apache-maven-3.5.4-bin\apache-maven-3.5.4\bin )
3) Android Studio and also set ANDROID_HOME environment variable
4) Appium Server.
5) Ensure that JAVA_HOME and ANDROID_HOME are properly set in Appium server UI.
6) Intellij IDEA


Steps to run the code
1) Connect the Android device to the machine, and turn on USB debugging in developer options
chech "adb devices"  ( verify the device or emmulator is connect and up)
2) Clone the repo to the local machine
2) 
3) Start the appium server ( up it with default ip)
4) Open a new command line from the Project location
5) In the command line, enter mvn clean verify
6) The test cases would start to run
7) Once the run is complete, the Tasterthought report would be available in the location given below

target/FinalReport/cucumber-html-reports


8) To run any specific feature, find the tag of that feature, and run the below command from command line.

mvn clean "-Dcucumber.options=--tags @smoke" verify

Note: Replace FeatureTag with the actual name of that feature. All the feature files are found in
ProjectLocation\src\test\java\woolworth\features folder

9) In order to make changes or view the code, it is recommended to use an IDE like intellij IDEA or eclipse
