package com.example.celebritydatabase

const val DATABASE_NAME = "data_cel_database"
const val TABLE_NAME = "celebrity_table"
const val DATABASE_VERSION = 1
const val COL_FIRST_NAME = "first_name"
const val COL_LAST_NAME = "last_name"
const val COL_ALIAS = "alias"
const val COL_BIRTH_PLACE = "birth_place"
const val COL_HEIGHT = "height"
const val COL_WEIGHT = "weight"
const val COL_BIRTHDAY = "birthday"
const val COL_ZODIAC_SIGN = "zodiac_sign"
const val COL_NETWORTH = "networth"
const val COL_FAVORITE = "favorite"




const val CREATE_CELEB_TABLE =
    "CREATE TABLE $TABLE_NAME (" +
            "$COL_FIRST_NAME String," +
            "$COL_LAST_NAME String," +
            "$COL_HEIGHT String," +
            "$COL_WEIGHT String," +
            "$COL_BIRTH_PLACE String," +
            "$COL_BIRTHDAY String," +
            "$COL_ZODIAC_SIGN String," +
            "$COL_NETWORTH String," +
            "$COL_FAVORITE Boolean," +
            "$COL_ALIAS String PRIMARY_KEY)"