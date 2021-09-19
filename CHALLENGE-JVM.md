## Instructions

This JVM performance challenge has two parts.

**Part 1**

Force an OutOfMemory runtime error to be thrown when you run the demo-client application using property setting ```demo.mode=visual-vm```

HINT: Set the ```demo.mode``` property in ```resources/application.properties```

HINT: Set your max JVM heap runtime parameter for the demo-client application to something around 50 MB. 

* In IntelliJ, you can do this by left clicking the java class ```DemoClientApplication.java``` Select "Modify Run Configuration" to add your JVM arguments. You may need to click on the link "Modify Options" in order to expose the 'VM Options' form field. 

HINT: If you get this right, it will take about 10 seconds for the error to be thrown in your console after you Run.

**Part 2**

Fix the OutOfMemory error

HINT: In java class HeapObjects.java, remove the static modifier from the attribute ```staticList```

**Extra Credit**

Observe the different behaviors in your Visual-VM Heap Monitor.

