package com.baseproject.data.local

import androidx.room.TypeConverter
import com.baseproject.data.model.Login
import com.baseproject.data.model.Name
import com.baseproject.data.model.Picture

/**
 * Converter method for custom object in room library
 */
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
    fun fromLogin(uuid: String): Login {
        return Login(uuid)
    }

    @TypeConverter
    fun toLogin(login: Login): String {
        return login.uuid
    }
}