package com.example.data.mappers

import com.example.data.entities.ReadyEntity
import com.example.domain.entities.Ready

class ReadyEntityMapper {

    fun toReadyEntity(ready : Ready): ReadyEntity {
        return ReadyEntity(
            id = ready.id,
            text = ready.text,
            isCompleted = ready.isCompleted,
            icon = ready.icon
        )
    }

    fun toReady(ready: ReadyEntity): Ready {
        return Ready(
            id = ready.id,
            text = ready.text,
            isCompleted = ready.isCompleted,
            icon = ready.icon
        )
    }

    fun toReadyEntityList(ready : List<Ready>): List<ReadyEntity> {
        val readyList = mutableListOf<ReadyEntity>()
        for (i in ready){
            val id = i.id
            val text = i.text
            val isCompleted = i.isCompleted
            val icon = i.icon

            val readyEntity = ReadyEntity(id = id, text = text, isCompleted = isCompleted, icon = icon)

            readyList.add(readyEntity)
        }

        return readyList
    }
}