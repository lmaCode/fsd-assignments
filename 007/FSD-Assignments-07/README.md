# FSD-Assignments-07
Maven, Junit, Tomcat & GIT

### git
https://github.com/lmaCode/fsd-assignments/tree/temp/007/FSD-Assignments-07

### Getting started
1. create a new maven project：mvn archetype:generate -DgroupId=com.lipengwei.fsd -DartifactId=FSD-Assignments-07 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
2. run Application.java
3. rest api : http://localhost:8080/welcome
4. com.lipengwei.fsd.AppTest is a Junit Test case to test the com.lipengwei.fsd.util.Calculation class for the business logic
5. compile the project : mvn clean compile
6. package the built project : mvn clean package
7. execute the jar : java -jar FSD-Assignments-07-0.0.1-SNAPSHOT.jar
8. clean all the compiled class files and jar files in target folder : mvn clean
