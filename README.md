# Focus Points Challenge


## Objective
Build a simplified Android app to demonstrate your ability to design a basic UI and simulate device communication relevant to EEG-based focus monitoring.  <br>

## Approach

My goal was to simulate a focus score that changes every 5 seconds and to mock a Bluetooth scan.

The first step was understanding the fundamentals of the app. Implementing the focus score logic, which updates every 5 seconds, was straightforward as it was similar to a random number generator I made before. I started with this logic to establish a solid foundation for the app. The focus points logic was fairly simply and has only 3 functions and a StateFlow that holds the initial value for the score and the button press which is located in the viewmodel.

Once the focus score functionality was in place, I moved on to implementing the Bluetooth scan feature. This presented a significant challenge, as I had never worked with Bluetooth in an app before. After hours of researching YouTube tutorials and diving into Stack Overflow discussions, I successfully implemented the Bluetooth logic and was able to scan for other devices. This logic was a bit more complex compared to the focus score. In the viewmodel, the bluetooth logic has 2 functions for scanning and stop scanning, a Stateflow that handles the list of paired/scanned devices, and the mock connection UI flow when trying to pair to a device. 

With both features functional, I cleaned up the UI using Jetpack Compose and finished off the project using Clean Architecture and the MVVM design pattern. I organized the app into 4-5 well-defined packages.




## Quick Look (Focus Score Logic & Bluetooth scan)

<img src="https://github.com/user-attachments/assets/2e411287-645f-49f6-86c7-6cdef9677d7e" alt="focus" width="300"  />

<img src="https://github.com/user-attachments/assets/d93d98e8-91be-42b7-87be-939a3110dd7b" alt="bluetooth" width="300"  />



## Getting Started
To build and run this project, follow these steps:

1) Clone the repository to your local machine. <br>
2) Open the project in Android Studio. <br>
3) Build and run the project on an Android device or emulator. *Bluetooth function only works on remote physical android device!* <br>
4) Press start to change focus points
5) Turn on bluetooth and click Bluetooth button. Click scan, done! (Does not work on emulator)

## APK File & Junit Test
[Apk Download](https://github.com/eaglenguyen/Neurable-Android-Challenge-Eagle/raw/refs/heads/master/app-debug.apk)


## Technologies Used
* Kotlin
* Jetpack Compose
* Dagger/Hilt
* [Junit](https://github.com/eaglenguyen/Neurable-Android-Challenge-Eagle/blob/master/app/src/test/java/com/example/focusscore/presentation/focus/FocusScoreViewModelTest.kt)





























