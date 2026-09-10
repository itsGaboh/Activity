package com.example.projectgroup4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.app.AlertDialog
import android.widget.Toast

class TaskAdapter(
    private var tasks: List<Task>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTaskTitle: TextView = itemView.findViewById(R.id.tvTaskTitle)
        val tvTaskDescription: TextView =
            itemView.findViewById(R.id.tvTaskDescription)
        val tvTaskDueDate: TextView =
            itemView.findViewById(R.id.tvTaskDueDate)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {

        val task = tasks[position]

        holder.tvTaskTitle.text = task.title
        holder.tvTaskDescription.text = task.description
        holder.tvTaskDueDate.text = "Due: ${task.dueDate}"

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, EditTaskActivity::class.java)

            intent.putExtra("TASK_ID", task.id)

            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Task")
                .setMessage("Are you sure you want to delete this task?")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Delete") { _, _ ->

                    val database = TaskDatabase.getInstance(holder.itemView.context)

                    database.taskDao().delete(task)

                    Toast.makeText(
                        holder.itemView.context,
                        "Task deleted",
                        Toast.LENGTH_SHORT
                    ).show()

                    tasks = database.taskDao().getAllTasks()

                    notifyDataSetChanged()
                }
                .show()

            true
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}