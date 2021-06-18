package com.example.testdmmp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Score::class],version =1,exportSchema = false)
abstract class ScoreDatabase:RoomDatabase() {
    abstract fun scoreDao():DaoScore

    companion object{
        @Volatile
        private  var INSTANCE : ScoreDatabase?=null
        fun getDatabase(context: Context):ScoreDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScoreDatabase::class.java,
                    "score_data"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}