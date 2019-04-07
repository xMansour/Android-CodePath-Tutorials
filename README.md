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
- [x] Using Context  
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

        [list](https://developer.android.com/reference/android/content/Context.html#getSystemService(java.lang.String)) of all the available system services that can be retrieved through a context.  

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

- [x] **Android Directory Structure**  
    1. `src` - Java source files associated with your project. This includes the Activity "controller" files as well as your models and helpers.  
    2. `res` - Resource files associated with your project. All graphics, strings, layouts, and other resource files are stored in the resource file hierarchy under the res directory.  
    3. `res/layout` - XML layout files that describe the views and layouts for each activity and for partial views such as list items.  
    4. `res/values` - XML files which store various attribute values. These include strings.xml, dimens.xml, styles.xml, colors.xml, themes.xml, and so on.  
    5. `res/drawable` - Here we store the various density-independent graphic assets used in our application.  
    6. `res/drwable-hdpi` - Series of folders for density specific images to use for various resolutions.  
    7. `res/mipmap` - most commonly used for application icons.  
    8. `assets` - Uncompiled source files associated with your project; Rarely used.  
    9. `libs` - Before the introduction of Gradle build system, this directory was used for any secondary libraries (jars) you might want to link to your app.  

- [x] **Organizing your Source Files**  
    Android applications should always be neatly organized with a clear folder structure that makes your code easy to read. In addition, proper naming conventions for code and classes are important to ensure your code is clean and maintainable.  

    **Android Folder Structure**  
    
    **Organize packages by category**  
        `com.example.myapp.activities` - contains all activities.  
        `com.example.myapp.adapters` - contains all custom adapters.  
        `com.example.myapp.models` - contains all our data models.  
        `com.example.myapp.network` - contains all networking code.  
        `com.example.myapp.fragments` - contains all fragments.  
        `com.example.myapp.utils` - contains all helper supporting code.  
        `com.example.myapp.interfaces` contains all interfaces.  

- [x] **Architecture of Android Apps**  
    When first building Android apps, many developers might start by relying on Model View Controller (MVC) patterns and usually end up writing most of the core business logic in activities or fragments. The challenge is that writing tests that can validate the app's behavior is difficult to do because the code is often so closely tied to the Android framework and the various lifecycle events.  

    **Architectural Patterns**  
    1. **Standard Android**  
        `MVC` Model-View-Controller, the default approach with layout files. Activities and Fragments acting as the controller and models used for data and persistence. MVC allows the activities to process the data and update the views, so they act as a controller with some extra responsibilites that should be part of the view. Thus Activities and Fragments can become very large and very difficult to test.  

    2. **Clean Architecture**  
        `MVP` Model-View-Presenter allows Activities and Fragments to become part of the view layer and delegate most of the work to presenter objects. Each activity has a matching presenter that handles all the access to the model. The presenters also notify the Activities when the data is ready to display.  

    3. **Data-binding MVVM**  
        `MVVM` Model-View-ViewModel retrieve data from the model when requested from the view via the Android data binding framework. With this pattern, Activities and Fragments become very lightweight. Moreover, writing unit tests becomes easier because the ViewModels are decoupled from the view.  

    **Clean Architecture**  
    separates the architecture of app into three major layers:  
    1. **Presentation Layer**: how the app shows the data to the user, the presentation layer sits as the outermost layer.  
    2. **Domain**: what are the core functions of the app, the domain layer sits in the middle layer.  
    3. **Data Layer**: how the data can be accessed. the data layer resides in the inner layer.  

    **MVP**  
    The Model-View-Presenter architecture comprises:  
    1. **Model**: the data layer.  
    2. **View**: the UI layer, displays the data received from Presenter, reacts to the user input. Activities, Fragments and android.view.View are treated as View in the MVP.  
    3. **Presenter**: responds to the actions performed on the UI layer, performs actions on the Model objects and passes the results back to the Views.  

    >What we want to achieve by using MVP are simpler tasks, smaller objects, and fewer dependencies between Model and Views layers. This, in turns makes our code easier to manage and test.  

    **Differences from MVC**
    1. View is more separated from Model. The Presenter is a mediator between them.  
    2. Easier to create unit tests.  


- [x] **Understanding App Resources**  
    Resources are used for anything from defining colors, images, layouts, menus, and string values. The value of this is that nothing is hardcoded. Everything is defined in these resource files and then can be referenced within your application's code.  

    |Name|Folder|Description|
    |----|------|-----------|
    |Propery Animations|animator|XML files that define propery animations|
    |Tween Animations|anim|XML files that define tween animations|
    |Drawables|drawable|Bitmap files or XML files that act as graphics|
    |Layout|layout|XML files that define a user interface layout|
    |Menu|menu|XML files that define menues or action bar items|
    |Values|values|XML files with values such as strings, integers and colors|


    |Name|File|Description|
    |----|------|-----------|
    |Colors|`res/values/colors.xml`|For color definitions such as text color|
    |Dimensions|`res/values/dimens.xml`|For dimension values such as padding|
    |Strings|`res/values/strings.xml`|For string values such as text or a title|
    |Styles|`res/values/styles.xml`|For style values|

    **Defining a String Resource**
    ```
    <resources>
        <string name="submit_label">Submit</string>
    </resources>
    ```

    **Referencing a String Resource**  
    From XMl:  
        `android:text="@string/submit_label"`

    Form Java Code:  
    ```java
    String submitText = getResources().getString(R.string.submit_label);  
    ```  
    
    **Defining Color Resources**
    ```
    <resources>
        <color name="white">#FFFFFF</color>
    </resources>
    ```
    **Referencing a Color Resource**  
    From XMl:  
    `android:textColor="@color/white"`

    Form Java Code:  
    ```java
        int color = getResources().getString(R.string.submit_label);        //deprecated

        int color = ContextCompat.getColor(context, R.color.white); 
    ```  

    >It is important to note that the most current way of accessing color resources (since API 24) requires providing context in order to resolve any custom theme attributes.  

    **Defining Dimension Resources**  
    ```
    <resources>
    <dimen name="textview_height">25dp</dimen>
    <dimen name="font_size">16sp</dimen>
    </resources>
    ```  
    **Referencing a Color Resource**  
    From XMl:  
    `android:textSize="@dimen/font_size"`

    Form Java Code:  
    ```java
        float fontSize = getResources().getDimension(R.dimen.font_size);
    ```  

    **Providing Alternate Resources**  
    To specify configuration-specific alternatives for a set of resources, we create a new directory in res in the form of `resource`-`qualifiers`.  

    |Configuration|Examples|Description|
    |----|------|-----------|
    |Language|`en`, `fr`|Language code selected on the device|
    |Screen size|`sw480dp`, `sw600dp`|Minimum width of the screen's height or width|
    |Screen orientation|`port`, `land`|Screen is in portrait or landscape mode|
    |Screen density|`hdpi`, `xhdpi`|Screen density used for alternate images|
    |Platform version|`v7`, `v11`, `v21`|Platform version often used for styles|  

    >You can specify multiple qualifiers for a single set of resources, separated by dashes. For example, `drawable-en-sw600dp-land` applies to English tablets in landscape orientation.  

    **Determining Configuration at Runtime**  
    ```java
    String image;
    int orientation = getResources().getConfiguration().orientation;
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
    image = "image_portrait.png";
    // ...
    } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
    image = "image_landscape.png";
    // ...
    }

    ```  

    >We can similarly access this within any object by getting access to a Context object: `getContext().getResources().getConfiguration()` to access the configurations.  

    **Alternate Layout Files**  
    Often alternative resources are used to specify different layout files for phones and tablets. This can be done using the "smallest width" qualifier of sw.  


- [x] **Activity Lifecycle**  
    As a user navigates throughout an app, Android maintains the visited activities in a stack, with the currently visible activity always placed at the top of the stack.  

    
    At any point in time a particular activity can be in one of the following 4 states:  

    |Activity State|Description|
    |--------------|-----------|
    |Running|Activity is visible and interacting with the user|
    |Paused|Activity is visible but not interacting with the user|
    |Stopped|Activity is now longer visible|
    |Killed|Activity has been killed by the system due to low memory or its `finish()` method|  

    ![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Structure/activityLifeCycle.png "Activity Life Cycle")  

    |Lifecycle Method|Description|Common Uses|
    |----------------|-----------|-----------|
    |`onCreate()`|The activity is starting but not visible to the user|Most of the activity initialization code goes here. This is where you setContentView() for the activity, initialize views, set up any adapters, etc.|
    |`onStart()`|The activity is now visible to the user but not ready for user interaction|This lifecycle method isn't used much, but can come in handy to register a BroadcastReceiver to monitor for changes that impact the UI (since the UI is now visible to the user)|
    |`onResume()`|The activity is now in the foreground and ready for user interaction|This is a good place to start animations, open exclusive-access devices like the camera, etc.|
    |`onPause()`|Counterpart to onResume(). The activity is about to go into the background and has stopped interacting with the user. This can happen when another activity is launched in front of the current activity.|t's common to undo anything that was done in onResume() and to save any global state (such as writing to a file).|
    |`onStop()`|Counterpart to onStart(). The activity is no longer visible to the user.|It's common to undo anything that was done in onStart().|
    |`onDestroy()`|Counterpart to onCreate(...). This can be triggered because finish() was called on the activity or the system needed to free up some memory.|It's common to do any cleanup here. For example, if the activity has a thread running in the background to download data from the network, it may create that thread in `onCreate()` and then stop the thread here in `onDestroy()`|
    |`onRestart()`|Called when the activity has been stopped, before it is started again|It isn't very common to need to implement this callback.|  

    >Activities are also re-created whenever the orientation changes.  

    **During initialization, you should always call the superclass first**  
    ```java
    public void onCreate() {
    super.onCreate();
    // do work after super class function
    // setContentView(R.layout.main);
    }
    ```  

    **During de-initialization, you should do the work first before calling the super class**  
    ```java
    public void onPause() {
    // do work here first before super class function
    // LocalBroadcastManager.getInstance(this)   .unregisterReceiver(mMessageReceiver);
    super.onPause();
    }
    ```  

- [x] **Handling Configuration Changes**  
    There are various situations such as when the screen orientation is rotated where the Activity can actually be destroyed and removed from memory and then re-created from scratch again. In these situations, the best practice is to prepare for cases where the Activity is re-created by properly saving and restoring the state.  


    **Saving and Restoring Activity State Using Shared Preferences**  

    Saving the data in the onPause():  
    ```java
    @Override
    protected void onPause() {
      SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = settings.edit();
      editor.putInt(SOME_VALUE, someIntValue);
      editor.putString(SOME_OTHER_VALUE, someStringValue);

      editor.apply();
    }
    ```  
    Restore the data in the onResume():  
    ```java
    @Override
    public void onResume() {
      SharedPreferences settings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
      someIntValue = settings.getInt(SOME_VALUE, 0);
    }
    ```  

    **Saving and Restoring Activity State Using savedInstanceState**  
    You need to override the method `onSaveInstanceState(Bundle savedInstanceState)` and store the data within it.

    ```java
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putInt(SOME_VALUE, someIntValue);
        savedInstanceState.putString(SOME_OTHER_VALUE, someStringValue);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
    ```  

    The system will call that method before an Activity is destroyed. Then later the system will call `onRestoreInstanceState` where we can restore state from the bundle:  

    ```java
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      // Always call the superclass so it can restore the view hierarchy
      super.onRestoreInstanceState(savedInstanceState);
      // Restore state members from saved instance
      someIntValue = savedInstanceState.getInt(SOME_VALUE);
      someStringValue = savedInstanceState.getString(SOME_OTHER_VALUE);
    }
    ```  

    **Saving and Restoring Fragment State**  
    Fragments also have a `onSaveInstanceState()` method which is called when their state needs to be saved:  
    ```java
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SOME_VALUE_KEY, someStateValue);
        super.onSaveInstanceState(outState);
    }
    ```  
    Then we can pull data out of this saved state in onCreateView:  
    ```java
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_simple_fragment, container, false);
        if (savedInstanceState != null) {
            someStateValue = savedInstanceState.getInt(SOME_VALUE_KEY);
            // Do something with value if needed
        }
        return view;
    }
    ```  
    **Locking Screen Orientation**
    If you want to lock the screen orientation change of any screen (activity) of your android application you just need to set the `android:screenOrientation` property of an `<activity>` within the `AndroidManifest.xml`:  

    ```
    <activity
    android:name="com.techblogon.screenorientationexample.MainActivity"
    android:screenOrientation="portrait"
    android:label="@string/app_name" >
    <!-- ... -->
    </activity>
    ```  

- [x] **Understanding App Permissions**  
    Before Marshmallow permissions were granted at install time, now permissions are granted at run time.  

    [This](https://developer.android.com/guide/topics/permissions/overview#normal_permissions) is a list of permissions and their category.  

    >Normal Permissions must be added to the AndroidManifest:  
    ```
        <uses-permission android:name="android.permission.INTERNET" />
    ```  

    **Runtime Permissions**
    If the permission you need to add isn't listed under the normal permissions, you'll need to deal with "Runtime Permissions".  

    The first step when adding a "Runtime Permission" is to add it to the AndroidManifest:  

    ```
        <uses-permission android:name="android.permission.READ_CONTACTS" />
    ```  
    Next, you'll need to initiate the permission request and handle the result.  

    ```java
    private static final int REQUEST_CODE = 922;
    ...
    private void requestContactsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            //permission isn't granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                //if the user denied the permission and trying to access it again.
                //show your ui to tell the user why this is needed
                new AlertDialog.Builder(this)
                        .setTitle("Permission Needed")
                        .setMessage("Read Contacts Permission Is Needed To Function Properly")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create().show();

            } else {
                //requesting the permission
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
    ```  

    **Permission Groups**  
    ![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Structure/permissions.png "Aksing for permissions patterns")  

    1. **Pattern 1: educate up-front**  
        For **critical** and **unclear** permissions, you should use a warm welcome screen to explain why these permissions are needed before asking for them.  
    
    2. **Pattern 2: ask up-front**  
        For **critical** and **clear** permissions, they are expected by the users without explanation.  

    3. **Pattern 3: ask in context**  
        For **secondary** and **clear** permissions, you should ask for them when a feature needs them.  
    
    4. **Pattern 4: educate in context**  
        For **secondary** and **unclear** permissions, you should explain that using `shouldShowRequestPermissionRational`.  

    **Storage permissions**  
    Rethink about whether you need read/write storage permissions (i.e. `android.permission.WRITE_EXTERNAL_STORAGE` or `android.permission.READ_EXTERNAL_STORAGE`), which give you all files on the SD card. Instead, you should use methods on Context to access package-specific directories on external storage. Your app always have access to read/write to these directories,so there is no need to permissions to request it:  

    ```java
    File dir = MyActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    ```  

    **Managing Permissions using ADB**  
    ```
    $ adb shell pm list permissions -d -g                       //shows all permissions

    $adb shell pm grant com.PackageName.enterprise some.permission.NAME                                        //grant all permissions


    $adb shell pm revoke com.PackageName.enterprise android.permission.READ_CONTACTS                            //revoke all permissions

    $adb install -g myAPP.apk                                   //installing an app with all permissions granted
    ```  


- [x] **Managing Runtime Permissions with PermissionsDispatcher**  
    **Usage**  
    First you need to add the gradle **dependencies**  
    ```
    dependencies {
    implementation 'com.github.hotchemi:permissionsdispatcher:4.1.0'
    annotationProcessor 'com.github.hotchemi:permissionsdispatcher-processor:4.1.0'
    }
    ```  
    Then,  
    1. Annotate the activity or fragment with `@RuntimePermissions`  
    ```java
    @RuntimePermissions
    public class MainActivity extends AppCompatActivity {
    // ...
    }
    ```  
    2. Annotate the method that requires the permission with `@NeedsPermission`  
    ```java
    @NeedsPermission(Manifest.permission.CALL_PHONE)
    void callPhone() {
        // Trigger the calling of a number here
    }
    ```  
    3. Delegate the permissions events to a compiled helper class  
    ```java
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
    ```  
    4. Invoke the helper class in order to trigger the action with permission request  
    ```java
    MainActivityPermissionsDispatcher.callPhoneWithPermissionCheck(this);
    ```  

    **Permission Event Handling**  
    We can also optionally configure the rationale dialog, handle the denial of a permission or manage when the user requests never to be asked again:  

    ```java
    // Annotate a method which explains why the permission/s is/are needed. 
    // It passes in a `PermissionRequest` object which can continue or abort the current permission
    @OnShowRationale(Manifest.permission.CALL_PHONE)
    void showRationaleForPhoneCall(PermissionRequest request) {
        new AlertDialog.Builder(this)
            .setMessage(R.string.permission_phone_rationale)
            .setPositiveButton(R.string.button_allow, (dialog, button) -> request.proceed())
            .setNegativeButton(R.string.button_deny, (dialog, button) -> request.cancel())
            .show();
    }

    // Annotate a method which is invoked if the user doesn't grant the permissions
    @OnPermissionDenied(Manifest.permission.CALL_PHONE)
    void showDeniedForPhoneCall() {
        Toast.makeText(this, R.string.permission_call_denied, Toast.LENGTH_SHORT).show();
    }

    // Annotates a method which is invoked if the user 
    // chose to have the device "never ask again" about a permission
    @OnNeverAskAgain(Manifest.permission.CALL_PHONE)
    void showNeverAskForPhoneCall() {
        Toast.makeText(this, R.string.permission_call_neverask, Toast.LENGTH_SHORT).show();
    }
    ```  

- [x] **Understanding the Android Application Class**  
    The `Application` class in Android is the base class within an Android app that contains all other components such as activities and services. The `Application` class, or any subclass of the `Application` class, is instantiated before any other class when the process for your application/package is created. This class is primarily used for initialization of global state before the first Activity is displayed.  

    **Uses of a custom application class**  
    1. Specialized tasks that need to run before the creation of your first activity.  
    2. Global initialization that needs to be shared across all components (crash reporting, persistence).  
    3. Static methods for easy access to static immutable data such as a shared network client object.  



    >If we do want a custom application class, we start by creating a new class which extends `android.app.Application` as follows

    ```java
    public class MyCustomApplication extends Application {
        ...
    }
    ```  


    >And specify the `android:name` property in the the `<application>` node in `AndroidManifest.xml`:  

    ```
    <application 
    android:name=".MyCustomApplication"
    android:icon="@drawable/icon" 
    android:label="@string/app_name" 
   ...>
   ``` 










    















