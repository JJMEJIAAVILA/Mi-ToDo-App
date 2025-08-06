package com.jhonjairo.mytodoapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TaskDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "tasks_db"
        private const val TABLE_TASKS = "tasks"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_IS_COMPLETED = "is_completed"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TASKS_TABLE = "CREATE TABLE $TABLE_TASKS($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT, $KEY_IS_COMPLETED INTEGER)"
        db.execSQL(CREATE_TASKS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_TASKS")
        onCreate(db)
    }

    fun addTask(task: Task): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, task.name)
        values.put(KEY_IS_COMPLETED, if (task.isCompleted) 1 else 0)
        val id = db.insert(TABLE_TASKS, null, values)
        db.close()
        return id
    }

    fun getTasks(): MutableList<Task> {
        val taskList: MutableList<Task> = mutableListOf()
        val selectQuery = "SELECT * FROM $TABLE_TASKS"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(0)
                val name = cursor.getString(1)
                val isCompleted = cursor.getInt(2) == 1
                val task = Task(name, isCompleted, id)
                taskList.add(task)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return taskList
    }

    fun deleteTask(task: Task) {
        val db = this.writableDatabase
        db.delete(TABLE_TASKS, "$KEY_ID=?", arrayOf(task.id.toString()))
        db.close()
    }

    fun updateTask(task: Task) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_IS_COMPLETED, if (task.isCompleted) 1 else 0)
        db.update(TABLE_TASKS, values, "$KEY_ID=?", arrayOf(task.id.toString()))
        db.close()
    }
}