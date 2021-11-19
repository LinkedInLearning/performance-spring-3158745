# Performance Tuning in Spring Apps
This is the repository for the LinkedIn Learning course Performance Tuning in Spring Apps. The full course is available from [LinkedIn Learning][lil-course-url].

![Performance Tuning in Spring Apps][lil-thumbnail-url] 

Resilient and reliable application performance is an essential aspect of every successful enterprise-scale application. Unfortunately, it can be quite challenging to deliver well-considered performance objectives and results. In this course, instructor Kathy Flint teaches Java professionals working with Spring apps how to address the multi-faceted aspects of performance engineering to deliver high-performing applications that respond to business needs. First, Kathy makes sure you understand Spring application performance. Then she shows you how to configure and use the Spring Actuator, as well as how to customize Spring performance logging. Kathy explains several common Spring performance challenges and what you can do about them. She goes over how to compile a performance profile and offers a few key practices and tools that a Spring developer can adopt in any situation. Kathy finishes up with ways you can discuss and demonstrate performance goals and metrics.

## Installing
1. To use these exercise files, you must have the following installed:
	- Java 8 or higher
	- Maven
2. Clone this repository into your local machine using the terminal (Mac), CMD (Windows), or a GUI tool like SourceTree.

## Run and Edit

### Intellij IDEA

1. From IDEA Welcome screen, select **Open or Import**
2. Choose the root directory of your newly cloned repository: `/performance-spring-3158745`
3. Within IntelliJ, make sure your Project SDK is set to Java 1.8 or higher. (File > Project Structure)
4. From the Project View, context-click on the file `demo-client/pom.xml`
5. Select **+ Add as Maven project**. This will cause project dependencies to download from the internet.
6. Context-click on the file `demo-client/src/main/java/com.lil.springperformance.DemoClientApplication.java`
7. Select **Run**
8. Open the demo-client application in your browser at `http://localhost:9091`
9. From the Project View, context-click on the file `demo-api/pom.xml`
10. Select **+ Add as Maven project**.
11. Context-click on the file `demo-api/src/main/java/com.lil.springperformance.DemoApiApplication.java`
12. Select **Run**
13. Open the demo-api application in your browser at `http://localhost:9092`


### Run from Command Line

1. In your terminal, navigate to either `/performance-spring-3158745/demo-client` or `/demo-api`
2. Execute `mvn clean package`
3. Execute `mvn spring-boot:run`
4. Open the app in your browser using the localhost address shown in the startup console log messages.

### Instructor

Kathy Flint 
                            

_Software Engineer and Application Architect_
                            

Check out my other courses on [LinkedIn Learning](https://www.linkedin.com/learning/instructors/kathy-flint).

[lil-course-url]: https://www.linkedin.com/learning/performance-tuning-in-spring-apps
[lil-thumbnail-url]: https://cdn.lynda.com/course/3158745/3158745-1637107870964-16x9.jpg
