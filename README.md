MISTERM ACTIVITY

Sure — the simplest project idea that satisfies all the requirements is:

📱 Student Task Manager

An Android app where students can add, view, edit, and delete tasks.

Main screens

1. Home / Task List



Shows all tasks using RecyclerView.

Example: Study for Math Exam

2. Add Task



Task title

Description

Due date

Save button

3. Edit Task



Change task information.

Update or Delete buttons.

4. Settings



Dark mode ON/OFF

Save preference using SharedPreferences.

How it meets the requirements

Requirement	Simple implementation

Room / SQLite	Store tasks in Room Database
CRUD	Add, view, edit, delete tasks
RecyclerView	Display task list
Navigation	Home → Add/Edit → Settings
SharedPreferences	Save dark mode or notification preference

Suggested structure

MainActivity
├── HomeFragment
│    └── RecyclerView
├── AddTaskFragment
├── EditTaskFragment
└── SettingsFragment

Room Database
└── Task
├── id
├── title
├── description
└── dueDate

Why this is good: It's easy to build, easy to demonstrate CRUD, and directly solves an everyday student problem.

Would mind teach me how to create this?