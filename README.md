# 🤰 Pregnancy Vitals Tracker

An Android app built with **Jetpack Compose**, **Room Database**, **WorkManager**, and **MVVM architecture** that helps pregnant mothers record and monitor their health vitals like heart rate, blood pressure, weight, and baby kicks.

---

## ✨ Features

- 📋 **Log Vitals:** Easily add heart rate, blood pressure, weight, and baby kicks.
- 📊 **View History:** Automatically saved entries displayed in a clean scrollable list.
- ⏰ **Reminders:** Get a notification every 5 hours to log your vitals.
- 📱 **Jetpack Compose UI:** Modern, sleek, and responsive UI with Material Design.
- 💾 **Offline Storage:** Uses Room database to store vitals locally.
- 🔔 **Notification Integration:** Taps on reminders open the app directly to the logging screen.

---

## 🧱 Built With

- **Kotlin**
- **Jetpack Compose**
- **Room (Jetpack Persistence)**
- **WorkManager**
- **MVVM Architecture**
- **Android ViewModel**
- **StateFlow**
- **Coroutines**

---
-**Getting Started**
Prerequisites
1.Android Studio (Flamingo or above)

2.Android SDK 24+

3.Kotlin 1.8+

4.Gradle 8+

-**Run Locally**

git clone https://github.com/misba2002/-pregnancy-vitals-tracker.git
cd -pregnancy-vitals-tracker
Open the project in Android Studio and click Run ▶️

-**Permissions**
On Android 13+, the app requests:

POST_NOTIFICATIONS – Required to show reminder notifications.


-**📅 WorkManager Reminder**
The app schedules a periodic notification every 5 hours.

Clicking the notification opens the vitals logging screen directly.

-**📁 Project Structure**
app
├── MainActivity.kt
├── ui/
│   ├── MainScreen.kt
│   ├── AddVitalsDialog.kt
│   └── VitalsCard.kt
├── data/
│   ├── VitalsDatabase.kt
│   ├── VitalsDao.kt
│   └── ReminderWorker.kt
├── model/
│   └── Vitals.kt
├── viewmodel/
│   ├── VitalsViewModel.kt
│   └── VitalsViewModelFactory.kt

👩‍💻 Author
Misba 
