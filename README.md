# Android CodePath Tutorials  
Following the tutorials by [CodePath](https://github.com/codepath/android_guides/wiki)

--- 

## Getting Started  

- [x] **Installing Genymotion Emulator**  

- [x] **Architecture of Mobile Apps**  

    **There are two categories of mobile apps:**  
        1. View heavy data driven  
        ex. email, social, news, Todo  
        2. Graphics heavy drawing  
        ex. games and photo editing  

    **Screen Archetypes are:**  
        1. Login
        2. Register
        3. Stream
        4. Detail
        5. Creation
        6. Profile
        7. Settings
        8. Maps

    **Learning to build real data-driven apps requires a few core concepts:**  
        1. Views: Common controls and view layout
        2. Events: Interaction and event handling
        3. Navigation: Screen flows and navigation
        4. Data: Models, networking and persistence
        5. Platform: OS services, hardware and sensors

    ![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Getting%20Started/mobile%20client%20arch.png "Mobile Client Architecture")

    >Real data-driven apps usually require an API.  
    >Most mobile apps rely on server-side APIs for data.  

    ![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Getting%20Started/app%20api%20arch.png "Mobile API Architecture")

    **Models reflect the server state for the data retrieved via APIs:**  
        1. Model definitions (properties, relationships)
        2. JSON/XML serialization/deserialization
        3. Persistence storage (database)
        4. Data formatters

    **Networking on mobile means interacting with a server in one of the following ways:**  
        1. Interacting with models via a REST API
        2. Displaying external images in the view
        3. Audio/Video playback
        4. Socket programming

    >Mobile apps conisit of MVC + Networking + Hardware  


- [x] **Mobile Screen Archetypes**  
    In mobile application development, mobile apps tend to adhere to a set of standard screen "archetypes" that appear again and again. There are over a dozen screen archetypes but there are six core archetypes that appear in nearly every app:

    1. Login/Register - User signs up or logs intro their account
    2. Stream - User can scroll through resources in a list
    3. Details - User can view the specifics of particular resource
    4. Creation - User can create new resource
    5. Profile - User can view their identity and stats
    6. Settings - User can configure app options
    7. Splash Pages - Displayed when the app is loading
    8. Onboarding - First time user visual tutorial for how the app works
    9. Map View - Visualizing location based information
    10. Messaging - Real time chat conversation
    11. Calendar - visualize dates or events into calendar form
    12. Media Players - Allowing the control of media playback

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


