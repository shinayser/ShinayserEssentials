package com.shinayser.essentials.jsonserializer

import com.shinayser.essentials.util.jsonOf
import org.json.JSONObject

/**
 * Created by denox on 15/12/2017.
 */
interface JSONSerializable {
    fun serialize(): JSONObject
    fun deserialize(json: JSONObject)
}

/*
   It can only serialize objects that implement JSONSerializable or primitive types.
 */
interface SimpleJSONSerializable : JSONSerializable {

    override fun serialize(): JSONObject {

        return jsonOf {

            this@SimpleJSONSerializable::class.java.declaredFields.forEach { field ->

//				if (field.name == "serialVersionUID")
//					return@forEach

				field.isAccessible = true

                try {
                    when (field.type) {

                        Boolean::class.javaObjectType,
                        Boolean::class.java,

                        Long::class.javaObjectType,
                        Long::class.java,

                        Int::class.javaObjectType,
                        Int::class.java,

                        Float::class.javaObjectType,
                        Float::class.java,

                        Double::class.javaObjectType,
                        Double::class.java,

                        Char::class.javaObjectType,
                        Char::class.java,

                        Short::class.javaObjectType,
						Short::class.java,

                        String::class.javaObjectType,
                        String::class.java -> field.name otopt field.get(this@SimpleJSONSerializable)


                        else -> {

                            if (JSONSerializable::class.java.isAssignableFrom(field.type)) {
                                field.name otopt (field.get(this@SimpleJSONSerializable) as JSONSerializable).serialize()
                            }

                        }

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }


            }

        }

    }

    override fun deserialize(json: JSONObject) {

        json.keys().forEach { key ->
            val field = this::class.java.declaredFields.firstOrNull { it.name == key }

            field?.let {

                field.isAccessible = true

                try {

                    when {

                        field.type == Long::class.javaObjectType -> field.set(this, json.getLong(key))
                        field.type == Int::class.javaObjectType -> field.set(this, json.getInt(key))
                        field.type == Float::class.javaObjectType -> field.set(this, json.getDouble(key))
                        field.type == Double::class.javaObjectType -> field.set(this, json.getDouble(key))
                        field.type == String::class.javaObjectType -> field.set(this, json.getString(key))

                        field.type == Boolean::class.javaObjectType -> {

                            if (json.get(key) is Boolean) {
                                field.set(this, json.getBoolean(key))
                            } else {
                                field.set(this, json.getInt(key) == 1)
                            }

                        }


                        JSONSerializable::class.java.isAssignableFrom(field.type) -> {
                            val newInstance = field.type.newInstance() as JSONSerializable
                            newInstance.deserialize(json.getJSONObject(key))
                            field.set(this, newInstance)
                        }

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

        }

    }

//    companion object {
//
//        fun isJsonSerializableClass(aClass: Class<*>) = when {
//            aClass == Long::class.javaObjectType -> true
//            aClass == Int::class.javaObjectType -> true
//            aClass == Float::class.javaObjectType -> true
//            aClass == Double::class.javaObjectType -> true
//            aClass == String::class.javaObjectType -> true
//            aClass == List::class.javaObjectType -> true
//            JSONSerializable::class.java.isAssignableFrom(aClass) -> true
//            else -> false
//        }
//    }

}