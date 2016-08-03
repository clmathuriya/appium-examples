# appium-examples
Get appium examples with Java client.
#appium setup
1. Install java 8 as follows:
```
	$ sudo add-apt-repository ppa:webupd8team/java
	$ sudo apt-get update
	$ sudo apt-get install oracle-java8-installer
	
```

2. Download androud sdk from http://developer.android.com/sdk/index.html#Other 


3. Set ANDROID_HOME to your sdk folder

4. Download maven from http://mirror.fibergrid.in/apache/maven/maven-3/3.3.9/source/apache-maven-3.3.9-src.tar.gz
and add to classpath
5. Download node from https://nodejs.org/dist/v5.9.1/node-v5.9.1-linux-x64.tar.xz
and add node/bin to your classpath.
6. Install appium ``` npm install -g appium```
7. Clone repository
	``` git clone https://github.com/clmathuriya/appium-examples.git ```
8. Import maven project in eclipse

#development

1. Update maven project
   right click on project > maven> update project
2. Add Page class in package "com.appium.pages"
3. Add TestNG tests in  package "com.appium.tests"

#Running tests

1. Start appium server using 
    ``` appium --command-timeout 30000   ```
2. Run project as maven test
	``` mvn test```
	
#To run with headless emulator 
1. start emulator without ui 
 ``` emulator -avd test -no-window ```

