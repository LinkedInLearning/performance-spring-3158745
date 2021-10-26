## Instructions

This JVM performance challenge has two parts.

**Part 1**

Force an OutOfMemory runtime error to be thrown when you run the demo-client application using property setting ```demo.mode=challenge-jvm```

If you get this right, it will take about 10 seconds for the error to be thrown in your console after you Run.

HINT: Set the ```demo.mode``` property in ```resources/application.properties```

HINT: Set your max JVM heap runtime parameter for the demo-client application to 100 MB. See below for IntelliJ instructions.



**Part 2**

Explain and fix the OutOfMemory error

HINT: Have a look at java class ```HeapObjects.java```.

**Extra Credit**

Observe the corrected behavior in your Visual-VM Heap Monitor.

**IntelliJ Notes**

In IntelliJ, you can set JVM parameters by left clicking the java class ```DemoClientApplication.java```. Select "Modify Run Configuration" to add your JVM arguments. You may need to click on the link "Modify Options" in order to expose the 'VM Options' form field. 

![Annotation 2021-09-21 135736](https://user-images.githubusercontent.com/1907202/134231174-1ea62ce7-663f-4e7c-91b5-139ef7ceba83.jpg)
