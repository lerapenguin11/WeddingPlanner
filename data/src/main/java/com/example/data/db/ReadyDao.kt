package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.ReadyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadyDao {

    @Query("SELECT * FROM ready")
    fun getAllReady(): Flow<List<ReadyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(readyEntity: List<ReadyEntity>)

    @Update
    fun update(readyEntity: ReadyEntity)
}