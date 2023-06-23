package bd.maruf.notesmvvm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
)
