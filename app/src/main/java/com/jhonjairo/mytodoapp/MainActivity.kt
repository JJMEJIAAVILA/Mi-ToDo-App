package com.jhonjairo.mytodoapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: TaskDatabaseHelper
    private lateinit var taskList: MutableList<Task>
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = TaskDatabaseHelper(this)
        taskList = dbHelper.getTasks()

        val recyclerViewTasks: RecyclerView = findViewById(R.id.recyclerViewTasks)
        val editTextTask: EditText = findViewById(R.id.editTextTask)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)

        taskAdapter = TaskAdapter(
            taskList,
            onDeleteClickListener = { task ->
                dbHelper.deleteTask(task)
                taskList.remove(task)
                taskAdapter.notifyDataSetChanged()
            },
            onTaskCheckedChangeListener = { task ->
                dbHelper.updateTask(task)
                taskAdapter.notifyDataSetChanged()
            }
        )

        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.adapter = taskAdapter

        buttonAdd.setOnClickListener {
            val taskName = editTextTask.text.toString().trim()
            if (taskName.isNotEmpty()) {
                val newTask = Task(name = taskName)
                val newTaskId = dbHelper.addTask(newTask)

                taskList.add(Task(taskName, id = newTaskId))
                taskAdapter.notifyItemInserted(taskList.size - 1)

                editTextTask.text.clear()
            }
        }
    }
}