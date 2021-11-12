# Performance Tuning in Spring Apps
This is the repository for the LinkedIn Learning course `Performance Tuning in Spring Apps`. The full course is available from [LinkedIn Learning][lil-course-url].

_See the readme file in the main branch for updated instructions and information._
## Instructions
This repository has one branch that serves all the lessons in the course. The application in the main branch has several lesson modes which can be toggled in a properties file as instructed in the individual lessons.

The main branch of this repository contains the accumulated work of the entire course. There are notes at different points in the source code to point the learner to the lesson where the material is covered.

There are two spring boot applications contained in this repository: `demo-client` and `demo-api`. These are used to create lesson demonstrations as instructed in the individual lessons.

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

**Kathy D. Flint**

_Software Engineer and Application Architect_

Check out my other courses on [LinkedIn Learning](https://www.linkedin.com/learning/instructors/kathy-flint?u=104).

[lil-course-url]: https://www.linkedin.com/learning/spring-spring-integration
[lil-thumbnail-url]: https://cdn.lynda.com/course/2848253/2848253-1611257542249-16x9.jpg
    

