# 💧 Hydration Tracker (Mobile App Project 5)

An offline-friendly Android application designed to track daily water consumption, view past hydration logs, and manage health metrics with local SQLite persistence.

---

## 🎯 Project Goals & Features
- **Local SQLite Database**: Built using the robust **Room** persistence library to store user data securely offline without internet dependency.
- **Room Entities & DAOs**: Clean data models (`WaterLog`) and data access objects (`WaterDao`) utilizing Kotlin Coroutines and `Flow` for reactive, non-blocking UI updates.
- **Scrollable RecyclerView**: Displays past water intake entries dynamically using `ListAdapter` and `DiffUtil`, complete with timestamps, optional notes, and instant item deletion.
- **Live Summary**: Automatically calculates and displays the total water consumed in real-time.
- **Modern UI / Material Design**: Built using Material Components, Edge-to-Edge window insets, and ConstraintLayouts.

---

## 🛠️ Tech Stack & Libraries
- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel) with Android Architecture Components
- **Database**: Room (v2.8.5)
- **UI Components**: RecyclerView, CardView, Material Design 3 Components
- **Asynchrony**: Kotlin Coroutines & StateFlow

---

## 🚀 Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/CalebHarris29/Mobile-App-Project-5.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle and run the app on an Android Emulator or physical device (Minimum SDK 24).
