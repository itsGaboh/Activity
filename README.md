Student Task Manager

A simple Android application for managing student tasks. The app allows
users to create, view, edit, and delete tasks, while also providing a
Dark Mode setting that is saved between app sessions.


Features


Create tasks with:
Task title
Description
Due date

View tasks in a RecyclerView

Edit existing tasks

Delete tasks with confirmation

Dark Mode / Light Mode

Persistent settings using SharedPreferences

Persistent task storage using Room Database

Multiple screens using Android Activities and Intents


Technologies Used


Android Studio

Kotlin

Java

XML

Room Database

SQLite (through Room)

RecyclerView

SharedPreferences

AndroidX AppCompat

Material Components


Project Structure

app/
└── src/
    └── main/
        ├── java/com/example/projectgroup4/
        │   ├── MainActivity.kt
        │   ├── AddTaskActivity.kt
        │   ├── EditTaskActivity.kt
        │   ├── SettingsActivity.kt
        │   ├── TaskAdapter.kt
        │   ├── Task.java
        │   ├── TaskDao.java
        │   └── TaskDatabase.java
        │
        ├── res/layout/
        │   ├── activity_main.xml
        │   ├── activity_add_task.xml
        │   ├── activity_edit_task.xml
        │   ├── activity_settings.xml
        │   └── item_task.xml
        │
        └── AndroidManifest.xml

Database

The application uses Room Database to store tasks locally on the
device.


Task Entity

The Task class represents the tasks database table.


Each task contains:



id - Automatically generated unique ID

title - Task title

description - Task description

dueDate - Task due date


CRUD Operations

The TaskDao provides the four main database operations:


  Operation   Room Code         Purpose



  Create      insert(task)    Adds a new task
  Read        getAllTasks()   Retrieves all tasks
  Update      update(task)    Changes an existing task
  Delete      delete(task)    Removes a task


RecyclerView

RecyclerView is used on the Home screen to display the list of tasks.


TaskAdapter.kt connects the task data from the Room database to the
item_task.xml layout.


The adapter:



Receives a list of tasks.

Creates a view for each task.

Displays the task title, description, and due date.

Opens the Edit screen when a task is tapped.

Provides the delete functionality through a long press.


Navigation

The application uses Android Intent objects to navigate between
Activities.


Main screens:



Home - Displays all saved tasks.

Add Task - Creates a new task.

Edit Task - Updates an existing task.

Settings - Controls the application's appearance.


Dark Mode

Dark Mode is controlled using AppCompatDelegate.


The user's preference is stored with SharedPreferences using the key:


dark_mode

When the application starts, MainActivity reads the saved preference
and applies either Dark Mode or Light Mode.


This allows the user's selected theme to remain after closing and
reopening the application.


How to Use

Add a Task


Open the application.

Tap Add Task.

Enter a task title.

Enter a description.

Enter a due date.

Tap SAVE TASK.


The task is saved to the Room database and appears on the Home screen.


Edit a Task


Tap an existing task.

Change the information.

Save the changes.


The updated information is stored in the database.


Delete a Task


Long-press an existing task.

Confirm the deletion.

The task is removed from the database and the list is refreshed.


Change Theme


Open Settings.

Toggle Dark Mode.

The application changes between Dark Mode and Light Mode.

The selected setting is saved for the next time the application is opened.


Installation


Clone or download this repository.

Open the project in Android Studio.

Allow Gradle to sync and download the required dependencies.

Connect an Android device or start an Android emulator.

Run the application.


Requirements


Android Studio

Android SDK

Minimum Android version: Android 7.0 (API 24)

Compile SDK: API 33


Learning Objectives

This project demonstrates:



Android Activity development

XML-based user interface design

Kotlin and Java interoperability

Room Database

SQLite persistence

CRUD operations

RecyclerView and Adapter usage

Android navigation with Intents

SharedPreferences

Application theme management


Project:

Project Group 4


Student Task Manager --- Midterm Activity Project.

