package com.mobilecomputing.reminder

import androidx.room.*

@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true) var uid: Int?,
    @ColumnInfo(name = "time") var time: Long?,
    @ColumnInfo(name = "location") var location: String?,
    @ColumnInfo(name = "message") var message: String
)

@Dao
interface ReminderDao {
    @Transaction @Insert
    fun insert(reminder: Reminder): Long

    @Query( "SELECT * FROM reminders")
    fun getReminders(): List<Reminder>

    @Query("DELETE FROM reminders WHERE uid = :id")
    fun delete(id: Int)
}