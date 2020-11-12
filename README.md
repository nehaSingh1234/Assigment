# Assigment
Download the code.
Make sure maven is installed in your laptop.
Use below command to build the code-
  1. From <>/Assigment folder run below command-
  2. ./mvnw clean install
You should get below message after code is compiled successfully.

[INFO] Installing /Users/nehasingh/Documents/MyAssignment/Assignment/Assigment/pom.xml to /Users/nehasingh/.m2/repository/Assigment/Assignment/0.0.1-SNAPSHOT/Assignment-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  10.280 s
[INFO] Finished at: 2020-11-12T14:24:42-08:00
[INFO] -----------------------------------------

  3. A target folder will be created post above command in Assigment
  4. An artifact named as "Assignment-0.0.1-SNAPSHOT.jar" will be created in Assigment/target folder
  5. You can execute this jar file directly for running the application or use below steps for running on docker.
  
  Steps to run jar on docker container-
  1. Make sure docker is installed
  2. Open a terminal or command prompt
  3. Go to assignment folder <<>/documents/MyAssignment/Assignment/Assigment>
  4. You should see a docker file here. Run below command-
  docker build -t assignment .
  5. Once docker image is built, check the image with command- docker images ls
  6. 
  

