# Android CodePath Tutorials  
Following the tutorials by [CodePath](https://github.com/codepath/android_guides/wiki)  



## Getting Started  

- [x] **Installing Genymotion Emulator**  

- [x] **Architecture of Mobile Apps**  

    **There are two categories of mobile apps**  
    1. **View heavy data driven**  
        ex. email, social, news, Todo  
    2. **Graphics heavy drawing**  
        ex. games and photo editing  

    **Screen Archetypes are**  
    1. Login
    2. Register
    3. Stream
    4. Detail
    5. Creation
    6. Profile
    7. Settings
    8. Maps

    **Learning to build real data-driven apps requires a few core concepts**  
    1. **Views:** Common controls and view layout
    2. **Events:** Interaction and event handling
    3. **Navigation:** Screen flows and navigation
    4. **Data:** Models, networking and persistence
    5. **Platform:** OS services, hardware and sensors

    ![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Getting%20Started/mobile%20client%20arch.png "Mobile Client Architecture")

    >Real data-driven apps usually require an API.  
    >Most mobile apps rely on server-side APIs for data.  

    ![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Getting%20Started/app%20api%20arch.png "Mobile API Architecture")

    **Models reflect the server state for the data retrieved via APIs**  
    1. Model definitions (properties, relationships)
    2. JSON/XML serialization/deserialization
    3. Persistence storage (database)
    4. Data formatters

    **Networking on mobile means interacting with a server in one of the following ways**  
    1. Interacting with models via a REST API  
    2. Displaying external images in the view  
    3. Audio/Video playback  
    4. Socket programming  

    >Mobile apps conisit of MVC + Networking + Hardware  


- [x] **Mobile Screen Archetypes**  
    In mobile application development, mobile apps tend to adhere to a set of standard screen "archetypes" that appear again and again. There are over a dozen screen archetypes but there are six core archetypes that appear in nearly every app:

    1. **Login/Register** - User signs up or logs intro their account
    2. **Stream** - User can scroll through resources in a list
    3. **Details** - User can view the specifics of particular resource
    4. **Creation** - User can create new resource
    5. **Profile** - User can view their identity and stats
    6. **Settings** - User can configure app options
    7. **Splash Pages** - Displayed when the app is loading
    8. **Onboarding** - First time user visual tutorial for how the app works
    9. **Map View** - Visualizing location based information
    10. **Messaging** - Real time chat conversation
    11. **Calendar** - visualize dates or events into calendar form
    12. **Media Players** - Allowing the control of media playback  

- [ ] **Effective Java for Android**

- [x] **Debugging Exceptions within your App**  
    The following high-level principles should be applied when faced with an unexpected app behavior during investigation:

    1. **Replicate**. Convince yourself that there is an issue in the code that can be repeatedly reproduced by following the same steps. Before assuming the code is broken, try restarting the emulator, trying the app on a device and/or fully re-building the app.  
    2. **Reduce**. Try to isolate or reduce the code surrounding the issue and figure out the simplest way to reproduce what’s occurring. Comment out or remove extraneous code that could be complicating the issue.  
    3. **Research**. If you are running into a major unexpected issue, you are probably not alone. Search Google for the behavior using any descriptive identifiers. Visit the issue tracker for the component you are seeing issues with. Search stackoverflow for posts about the same issue.  


    **Debugging Procedure**
    1. Find the final exception stack trace within the Android Monitor (logcat)
    2. Identify the exception type, message, and file with line number
    3. Open the file within your app and find the line number
    3. Look at the exception type and message to diagnose the problem
    4. If the problem is not familiar, google around searching for answers
    5. Make fixes based on the proposed solutions and re-run the app
    6. Repeat until the crash no longer occurs

    **Investigation Methodologies**
    1. Toasts
    2. Logging
    3. Breakpoints


- [x] **Beginning Android Resources**  
    1. **Exceptions**  
        **Flow of code execution**  
        1. **Normal main sequential code execution**, the program doing what it meant to accomplish.  
        2. **Execption handling code execution**, he main program flow was interrupted by an error or some other condition that prevent the continuation of the normal main sequential code execution.  

        **Exception Object**  
        This is the object that is "thrown" as a parameter from the error, and passed to the catch block. Exception object encapsulates the information about the error's location and its nature. All Exception objects must be inherited from the java.lang.Throwable.

    2. **Threads**  
    A thread is the smallest unit of processing that can be scheduled by an operating system. Therefore, using threads, a programmer can effectively create two or more tasks, that run at the same time.  

        **Runnable**
        A Runnable process block is a simple class that implements a run() method. Within the run() method is the actual task that needs to be executed by a running thread. By implementing a class with the Runnable interface, we ensure that the class holds a run() method.  

        ```java
        public class RunnableProcess implements Runnable {
        ...
        public void run() {
            ...
        }
        }
        ```

        **Creating a thread**  
        
        ```java
        Thread thread1 = new Thread(new RunnableProcess(...));
        ```

        **Starting a thread**

        ```java
        thread1.start();
        ```

        **Manipulating threads**
        
        ```java
        Thread.currentThread()              //returns the currently executing thread

        Thread.sleep(long millis)           //halts the exeuction of the current thread for the given amount of time

        Thread.yield()                      //pauses the execution of the current thread to allow other threads to execute
        ```

        **Synchronization**  
        Synchronization is used when a thread is using a resource, others should wait until the resource has been released.  

        To do so, we use the keyword `synchronized` before the block of code we need the access to it to be synchronized.  

    3. **Interfaces**  
    An interface is an abstraction of class with no implementation details. **You cannot instantiate an interface**. **An interface is not a class** but it is written the same way. The first difference is that you do not use the `class` keyword but the `interface` keyword to define it. Then, there are fields and methods you cannot define here.  

        A field must be a constant: always `public`, `static` and `final`.  

        A method must be `public` and `abstract`.  

        Constructors are forbidden.  

        ```java
        public interface SimpleInterface {
            public static final int CONSTANT1 = 1;
            public abstract method1(String parameter);
        }
        ```  

        An interface can extend several interfaces, similar to the way that a class can extend another class, using the `extends` keyword.  

## Structure  
- [ ] Using Context  
A context provide access to information about the application state. It provides Activities, Fragments and Services access to resource files, images and extrnal directory locations. It also enables access to Android's built-in services such as those used for layout inflation, keyboard and finding content providers.  

In many cases when the "context is required", we simply need to pass in the instance of the current activity. In situations where we are inside objects created by the activity such as adapters or fragments, we need to pass in the activity instance into those objects. In situations where we are outside of an activity (in an application or service), we can use the "application" context instead.  

**Context Usage**
1. **Explicitly starting a component**  

    ```java
    Intent intent = new Intent(context, MyActivity.class);
    startActivity(intent);
    ```

    When starting a component two pieces of information are required:
    1. **package name**, which identifies the application that contains the component.
    2. **fully qualified java class name** for the component.

    if we are starting an internal component the context could be passed since we could get the package name by `context.getPackageName()`.

2. **Creating a view**  
    Contexts contains the following information that views require
    1. device screen size and dimensions for converting dp,sp to pixels  
    2. styled attributes
    3. activity reference for onClick attributes  

3. **Inflating an  XML layout file**  
    We use the context to fetch the `LayoutInflater` in order to inflate an XML layout into memory  
    

4. **Sending a local broadcast**  
    We use the context to fetch the `LocalBroadcastManager` when sending out or registering a receiver for a broadcast  

5. **Retrieving a System Service**  
    To send notifications from an application, the NotificationManager system service is required.  

    [list](https://github.com/codepath/android_guides/wiki/Using-Context) of all the available system services that can be retrieved through a context.  

6. **Application vs Activity context**  
    There is an **Application** Context and an **Activity** Context, which last for the duration of their respective lifecycle. Most Views should be passed an Activity Context in order to gain access to what themes, styles, dimensions should be applied. If no theme is specified explicitly for the Activity, the default is to use the one specified for the application.  

    In most cases, you should use the Activity Context. Normally, the keyword `this` in Java references the instance of the class and can be used whenever Context is needed inside an Activity.  

7. **Anonymous functions**  
    When using anonymous functions when implementing listeners, the keyword `this` in Java applies to the most immediate class being declared. In these cases, the outer class `MainActivity` has to be specified to refer to the Activity instance.  

    ```java
    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView tvTest = (TextView) findViewById(R.id.abc);
        tvTest.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
              }
          });
        }
    }
    }
    ```

8. **Adapters**
    1. Array Adapter  
    2. RecyclerView Adapter  

**Avoiding memory leaks**  
The Application Context is typically used when singleton instances need to be created, such as a custom manager class that requires Context information to gain access to system services but gets reused across multiple Activities. Since retaining a reference to the Activity context would cause memory not to be reclaimed after it is no longer running, it's important to use the Application Context instead.  

To avoid memory leaks, never hold a reference to a context beyond its lifecycle. Check any of your background threads, pending handlers, or inner classes that may be holding onto context objects as well.  

Use the application context when a context reference is needed beyond the lifespan of a component, or if it should be independent of the lifecycle of the context being passed in.  


    

