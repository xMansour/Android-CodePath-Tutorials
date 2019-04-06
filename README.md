# Android CodePath Tutorials
Following the tutorials by [CodePath](https://github.com/codepath/android_guides/wiki)

--- 

## Getting Started

- [x] **Installing Genymotion Emulator (Genymotion Guide)**

- [x] **Architecture of Mobile Apps (Concept Slides)**
There are two categories of mobile apps:
1. View heavy data driven
ex. email, social, news, Todo
2. Graphics heavy drawing
ex. games and photo editing

Screen Archetypes are:
1. Login
2. Register
3. Stream
4. Detail
5. Creation
6. Profile
7. Settings
8. Maps

Learning to build real data-driven apps requires a few core concepts: 
1. Views: Common controls and view layout
2. Events: Interaction and event handling
3. Navigation: Screen flows and navigation
4. Data: Models, networking and persistence
5. Platform: OS services, hardware and sensors

![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Getting%20Started/mobile%20client%20arch.png "Mobile Client Architecture")

Real data-driven apps usually require an API.
Most mobile apps rely on server-side APIs for data.

![alt text](https://github.com/xMansour/Android-CodePath-Tutorials/blob/master/Images/Getting%20Started/app%20api%20arch.png "Mobile API Architecture")

Models reflect the server state for the data retrieved via APIs:
1. Model definitions (properties, relationships)
2. JSON/XML serialization/deserialization
3. Persistence storage (database)
4. Data formatters

Networking on mobile means interacting with a server in one of the following ways:
1. Interacting with models via a REST API
2. Displaying external images in the view
3. Audio/Video playback
4. Socket programming

> Mobile apps conisit of MVC + Networking + Hardware

