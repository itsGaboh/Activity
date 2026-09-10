package com.example.projectgroup4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditTaskActivity : AppCompatActivity() {

    private var taskId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_task)

        val etTitle = findViewById<EditText>(R.id.etEditTitle)
        val etDescription = findViewById<EditText>(R.id.etEditDescription)
        val etDueDate = findViewById<EditText>(R.id.etEditDueDate)
        val btnUpdateTask = findViewById<Button>(R.id.btnUpdateTask)

        taskId = intent.getIntExtra("TASK_ID", -1)

        val database = TaskDatabase.getInstance(this)

        val tasks = database.taskDao().getAllTasks()

        val task = tasks.find { it.id == taskId }

        if (task != null) {
            etTitle.setText(task.title)
            etDescription.setText(task.description)
            etDueDate.setText(task.dueDate)
        }

        btnUpdateTask.setOnClickListener {

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

                task?.let {

                    it.title = title
                    it.description = description
                    it.dueDate = dueDate

                    database.taskDao().update(it)

                    Toast.makeText(
                        this,
                        "Task updated successfully!",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()
                }
            }
        }
    }
}