package com.example.projectgroup4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_task)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val etDueDate = findViewById<EditText>(R.id.etDueDate)
        val btnSaveTask = findViewById<Button>(R.id.btnSaveTask)

        btnSaveTask.setOnClickListener {

            val title = etTitle.text.toString().trim()
            val description = etDescription.text.toString().trim()
            val dueDate = etDueDate.text.toString().trim()

            if (title.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter a task title",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val task = Task(
                    title,
                    description,
                    dueDate
                )

                val database = TaskDatabase.getInstance(this)

                database.taskDao().insert(task)

                Toast.makeText(
                    this,
                    "Task saved successfully!",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}