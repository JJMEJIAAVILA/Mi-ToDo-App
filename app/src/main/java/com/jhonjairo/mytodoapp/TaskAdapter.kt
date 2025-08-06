package com.jhonjairo.mytodoapp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val tasks: MutableList<Task>,
    private val onDeleteClickListener: (Task) -> Unit,
    private val onTaskCheckedChangeListener: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTaskName: TextView = view.findViewById(R.id.textViewTaskName)
        val buttonDelete: Button = view.findViewById(R.id.buttonDelete)
        val checkBoxTaskCompleted: CheckBox = view.findViewById(R.id.checkBoxTaskCompleted)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        val taskNumber = position + 1
        holder.textViewTaskName.text = "$taskNumber. ${task.name}"

        holder.checkBoxTaskCompleted.isChecked = task.isCompleted

        if (task.isCompleted) {
            holder.textViewTaskName.paintFlags = holder.textViewTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.textViewTaskName.paintFlags = holder.textViewTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        holder.buttonDelete.setOnClickListener {
            onDeleteClickListener(task)
        }

        holder.checkBoxTaskCompleted.setOnCheckedChangeListener { _, isChecked ->
            val updatedTask = task.copy(isCompleted = isChecked)
            tasks[position] = updatedTask
            onTaskCheckedChangeListener(updatedTask)
        }
    }

    override fun getItemCount() = tasks.size
}