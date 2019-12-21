package com.baseproject.data.local

import androidx.room.TypeConverter
import com.nytimes.articles.data.model.ID
import com.nytimes.articles.data.model.Name
import com.nytimes.articles.data.model.Picture

class Converters {

    @TypeConverter
    fun fromPicture(image: String): Picture {
        return Picture(image)
    }

    @TypeConverter
    fun toPicture(picture: Picture): String {
        return picture.large
    }

    @TypeConverter
    fun fromName(fullName: String): Name {
        val names = fullName.split(",")
        return Name(names[0], names[1], names[2])
    }

    @TypeConverter
    fun toName(name: Name): String {
        return name.title + "," + name.first + "," + name.last;
    }

    @TypeConverter
    fun fromID(value: String): ID {
        return ID(value)
    }

    @TypeConverter
    fun toID(id: ID): String {
        return id.value
    }
}