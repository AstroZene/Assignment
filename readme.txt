Instruction to run the application:

1. Using Eclipse/Intellij:   Run the file "AssignmentApplication.java" as java application.

2. Using cmd:    type command "mvnw spring-boot:run"(Using local mvn) or "mvn spring-boot:run"(Using globally installed mvn) and execute it.

3. Using Jar file:   
	(i) use command "mvnw clean package" in the command prompt. It will generate a JAR file in the folder target.	

	(ii) find the jar file in target folder and run the command "java -jar assignment-0.0.1-SNAPSHOT.jar" in command prompt.

Requirement:

As a admin user I want to be able to see all user information with their related posts so that I can track in one place what users are posting to the site.

APIs used:

There are two api that are created they are:

1. "http://localhost:8080/admin/users" -  findAllDetails():  

	this api returns all the user details along with their respective posts posted in the blog

2. "http://localhost:8080/admin/users/{id}"   -  findUserById(id):   

	this api returns the specific of the user with mentioned id along with their respective posts posted in the blog.