# Assigment
Download the code.
Make sure maven is installed in your laptop.
Use below command to build the code-
  1. From <>/Assigment folder run below command-
  2. $./mvnw clean install
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
  3. Go to assignment folder <<>/Assignment/Assigment>
  4. Run below command-
  $docker build -t assignment .
  
  You should see output like below:
  
  $ docker build -t assignment .
Sending build context to Docker daemon  16.79MB
Step 1/4 : FROM openjdk:8-jdk-alpine
 ---> a3562aa0b991
Step 2/4 : ARG JAR_FILE=target/*.jar
 ---> Using cache
 ---> 4ef945b4787c
Step 3/4 : COPY ${JAR_FILE} Assignment-0.0.1-SNAPSHOT.jar
 ---> ce16839ed6df
Removing intermediate container 515d5942cc2d
Step 4/4 : ENTRYPOINT java -jar /Assignment-0.0.1-SNAPSHOT.jar
 ---> Running in b28bdcfdc8a2
 ---> 18a65c736bd7
Removing intermediate container b28bdcfdc8a2
Successfully built 18a65c736bd7
Successfully tagged assignment:latest

  5. Once docker image is built, check the image with command- 
  docker images
 $ docker images
REPOSITORY                    TAG                 IMAGE ID            CREATED             SIZE
assignment                    latest              18a65c736bd7        2 minutes ago       121MB

  6. Now execute below commands for running the image.
  
  $ docker run -p 80:8080 assignment --name runningversion
  
  You should receive output like below-
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.5.RELEASE)

2020-11-12 23:00:56.277  INFO 1 --- [           main] A.Assignment.AssignmentApplication       : Starting AssignmentApplication v0.0.1-SNAPSHOT on d6ad53d8f203 with PID 1 (/Assignment-0.0.1-SNAPSHOT.jar started by root in /)
2020-11-12 23:00:56.301  INFO 1 --- [           main] A.Assignment.AssignmentApplication       : No active profile set, falling back to default profiles: default
2020-11-12 23:00:59.949  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-11-12 23:00:59.998  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-11-12 23:01:00.000  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.39]
2020-11-12 23:01:00.256  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-11-12 23:01:00.257  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3622 ms
2020-11-12 23:01:00.935  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-11-12 23:01:01.459  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-11-12 23:01:01.527  INFO 1 --- [           main] A.Assignment.AssignmentApplication       : Started AssignmentApplication in 6.611 seconds (JVM running for 7.988)


7. Now access the URL "http://localhost/units/si?units=degree/minute"

