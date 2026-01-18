# 📱 Final Project – Mobile App Development (Android)

## 📌 Project Overview

This project is an **Android mobile application** developed as part of my final project. The app consumes a **loan API provided by my professor** to display **profile information and activities** using **JSON data**. It focuses on clean UI, API integration, and dynamic data handling.

---

## 🚀 Features

* 🔗 Fetch data from REST API using **Retrofit**
* 📦 Parse JSON data into Kotlin data models
* 🧑 Display user **profile image, cover image, and personal details**
* 📅 Filter activities by **Year (Year 1, Year 2, Year 3)** using buttons
* 🔁 Toggle between **List View and Grid View**
* 🖼 Load images from URL using **Glide**
* ⚡ Asynchronous data loading using **Coroutines (lifecycleScope)**

---

## 🛠 Technologies Used

* **Language:** Kotlin
* **Architecture:** Activity-based
* **Networking:** Retrofit
* **Image Loading:** Glide
* **Async Tasks:** Kotlin Coroutines
* **UI:** RecyclerView, CardView, ViewBinding
* **API Format:** JSON

---

## 🧩 App Flow

1. App launches and calls the API
2. Profile data (name, major, images) is displayed at the top
3. Activities are loaded into a RecyclerView
4. User clicks **Year buttons** to filter activities
5. User clicks **Toggle button** to switch between List and Grid view

---

## 🔄 API Integration

* **ApiService** defines API endpoints
* **RetrofitClient** manages API instance
* Data is fetched using suspend functions
* Errors are handled using try-catch blocks

Example:

* `getProfile()` → fetch user profile
* `getActivities()` → fetch activity list

---

## 📂 Project Structure

```
com.example.final_project
│
├── adapter
│   └── ActivityAdapter
│
├── api
│   ├── model
│   │   ├── Profile
│   │   └── UserActivity
│   ├── service
│   │   └── ApiService
│   └── RetrofitClient
│
├── MainActivity
├── DetailActivity
```

---

## 🧪 Key Functionalities Explained

### 🔘 Year Filter Buttons

Each year button filters activities based on the selected year using existing API data.

### 🔁 List & Grid Toggle

Users can switch between:

* **List View** (LinearLayoutManager)
* **Grid View** (GridLayoutManager with 2 columns)

### 🖼 Image Handling

All images are loaded efficiently from URLs using Glide.

---

## 📷 UI Preview

* Profile section with cover and avatar
* Year filter buttons
* RecyclerView with dynamic layout

---

## ✅ Learning Outcomes

* Hands-on experience with **REST APIs**
* Understanding **Retrofit & JSON parsing**
* RecyclerView optimization
* UI/UX handling in Android
* Kotlin coroutines and lifecycle awareness

---

## 📎 Notes

This project demonstrates my understanding of **mobile app development**, **API integration**, and **dynamic UI handling** using modern Android development practices.

---

✨ *Developed by: ThenG*
