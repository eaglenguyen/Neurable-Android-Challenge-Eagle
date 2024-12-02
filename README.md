# AndroidDev
Technical Challenge
# Neurable Android Technical Challenge

## Objective
Build a simplified Android app to demonstrate your ability to design a basic UI and simulate device communication relevant to EEG-based focus monitoring.

---

## Requirements

### User Interface
- Use **Jetpack Compose** to create a simple screen that displays a "focus score" (simulated) that updates in real-time.
- Include a button to start/stop the focus monitoring.

### Data Simulation
- Simulate receiving a "focus score" (e.g., a random number generator between 0 and 100) that updates every 5 seconds.
- Ensure the app can start and stop the data simulation when the button is clicked.

### BLE Simulation
- Simulate connecting to a **BLE device** (no need for actual device communication).
- Implement a basic BLE scan and connection UI flow (simulating this with state management is sufficient).

### Asynchronous Programming
- Use **Kotlin Coroutines** to handle the simulated focus score updates asynchronously, ensuring the UI remains responsive.

### Code Quality
- Structure your code to be modular and clean, showcasing your understanding of best practices.

---

## Bonus (Optional)
- Write a single **unit test** for the focus score simulation logic using **JUnit**.

---

## Evaluation Criteria
Your submission will be assessed based on the following:

1. **UI Design**  
   - Clean, minimal interface using Jetpack Compose.

2. **Data Simulation**  
   - Proper simulation of focus score and BLE interaction.

3. **Asynchronous Handling**  
   - Effective use of Kotlin Coroutines to manage data updates.

4. **Code Structure**  
   - Clean, modular code that follows best practices.

---

## Submission Instructions

1. **Clone the Repository**
   - Clone the repository to your local machine:
     ```bash
     git clone https://github.com/Thrive-Staffing/AndroidDev.git
     ```
   - Switch to the **submissions branch**:
     ```bash
     git checkout submissions
     ```

2. **Complete the Challenge**
   - Implement the required features as outlined above in your local repository.
   - Include a `README.md` file in your submission with:
     - Your approach to solving the challenge.
     - Steps to build and run the app.
     - Any additional notes or assumptions.

3. **Build and Include an APK (Optional but Recommended)**  
   - Generate an APK file:
     - Open the project in Android Studio.
     - Go to `Build > Build Bundle(s)/APK(s) > Build APK(s)`.
   - Add the APK to your submission or include a link in your `README.md` file.

4. **Push Your Submission to the `submissions` Branch**
   - Add and commit your changes:
     ```bash
     git add .
     git commit -m "Completed Neurable Android Technical Challenge"
     ```
   - Push your submission to the `submissions` branch:
     ```bash
     git push origin submissions
     ```

5. **Notify the Team**
   - Notify us via email or your designated contact person once your submission is complete.

---

## Expected Time Commitment
- This challenge is designed to take **2-3 hours** for an experienced developer.
- Focus on core tasks like UI design, data simulation, and state management.
