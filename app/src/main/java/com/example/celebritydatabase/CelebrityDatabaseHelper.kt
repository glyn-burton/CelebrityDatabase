package com.example.celebritydatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import kotlin.math.ceil

class CelebrityDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(CREATE_CELEB_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {
        onCreate(sqLiteDatabase)
    }

    fun insertPersonIntoDatabase(celeb:Celebrity){
        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_FIRST_NAME, celeb.firstName)
        contentValues.put(COL_LAST_NAME, celeb.lastName)
        contentValues.put(COL_ALIAS, celeb.alias)
        contentValues.put(COL_BIRTH_PLACE, celeb.birthPlace)
        contentValues.put(COL_BIRTHDAY, celeb.birthday)
        contentValues.put(COL_ZODIAC_SIGN, celeb.zodiacSign)
        contentValues.put(COL_HEIGHT, celeb.height)
        contentValues.put(COL_WEIGHT, celeb.weight)
        contentValues.put(COL_NETWORTH, celeb.netWorth)
        contentValues.put(COL_FAVORITE, celeb.favorite)

        database.insert(TABLE_NAME, null, contentValues)
        database.close()

    }

    fun getOnePersonFromDatabase(alias : String) : Celebrity? {
        val database = readableDatabase
        var celebrity : Celebrity? = null
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_ALIAS = '$alias'",
                null)

        if(cursor.moveToFirst()) {
            val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
            val height = cursor.getString(cursor.getColumnIndex(COL_HEIGHT))
            val weight = cursor.getString(cursor.getColumnIndex(COL_WEIGHT))
            val birthPlace = cursor.getString(cursor.getColumnIndex(COL_BIRTH_PLACE))
            val birthday = cursor.getString(cursor.getColumnIndex(COL_BIRTHDAY))
            val zodiacSign = cursor.getString(cursor.getColumnIndex(COL_ZODIAC_SIGN))
            val networth = cursor.getString(cursor.getColumnIndex(COL_NETWORTH))
            val favorite = cursor.getString(cursor.getColumnIndex(COL_FAVORITE))
            val alias = cursor.getString(cursor.getColumnIndex(COL_ALIAS))
            celebrity = Celebrity(firstName,lastName,alias,height,weight,birthday,zodiacSign,birthPlace,networth,favorite)
        }
        cursor.close()
        database.close()
        return celebrity
    }

    fun getAllPeopleFromDatabase() : ArrayList<Celebrity> {
        val database = readableDatabase
        var celebrityList : ArrayList<Celebrity> = ArrayList<Celebrity>()
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME",
                null)

        if(cursor.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val height = cursor.getString(cursor.getColumnIndex(COL_HEIGHT))
                val weight = cursor.getString(cursor.getColumnIndex(COL_WEIGHT))
                val birthPlace = cursor.getString(cursor.getColumnIndex(COL_BIRTH_PLACE))
                val birthday = cursor.getString(cursor.getColumnIndex(COL_BIRTHDAY))
                val zodiacSign = cursor.getString(cursor.getColumnIndex(COL_ZODIAC_SIGN))
                val networth = cursor.getString(cursor.getColumnIndex(COL_NETWORTH))
                val favorite = cursor.getString(cursor.getColumnIndex(COL_FAVORITE))
                val alias = cursor.getString(cursor.getColumnIndex(COL_ALIAS))
                val celebrity = Celebrity(firstName,lastName,alias,height,weight,birthday,zodiacSign,birthPlace,networth,favorite)
                celebrityList.add(celebrity)
            } while(cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return celebrityList
    }

    fun updatePersonInDatabase(celeb: Celebrity) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, celeb.firstName)
        contentValues.put(COL_LAST_NAME, celeb.lastName)
        contentValues.put(COL_HEIGHT, celeb.height)
        contentValues.put(COL_WEIGHT, celeb.weight)
        contentValues.put(COL_BIRTH_PLACE, celeb.birthPlace)
        contentValues.put(COL_BIRTHDAY, celeb.birthday)
        contentValues.put(COL_ZODIAC_SIGN, celeb.zodiacSign)
        contentValues.put(COL_NETWORTH, celeb.netWorth)
        contentValues.put(COL_FAVORITE, celeb.favorite)
        contentValues.put(COL_ALIAS, celeb.alias)

        database.update(TABLE_NAME, contentValues, "$COL_ALIAS = ?", arrayOf(celeb.alias))
        database.close()
    }

    fun removePersonFromDatabase(alias: String) {
        val database = writableDatabase
        database.delete(TABLE_NAME, "$COL_ALIAS = ?", arrayOf(alias))
        database.close()
    }

    fun getAllFavoritesFromDatabase() : ArrayList<Celebrity>
    {
        val database = readableDatabase
        var celebrityList : ArrayList<Celebrity> = ArrayList<Celebrity>()
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_FAVORITE = 'true'",
                null)

        if(cursor.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val height = cursor.getString(cursor.getColumnIndex(COL_HEIGHT))
                val weight = cursor.getString(cursor.getColumnIndex(COL_WEIGHT))
                val birthPlace = cursor.getString(cursor.getColumnIndex(COL_BIRTH_PLACE))
                val birthday = cursor.getString(cursor.getColumnIndex(COL_BIRTHDAY))
                val zodiacSign = cursor.getString(cursor.getColumnIndex(COL_ZODIAC_SIGN))
                val networth = cursor.getString(cursor.getColumnIndex(COL_NETWORTH))
                val favorite = cursor.getString(cursor.getColumnIndex(COL_FAVORITE))
                val alias = cursor.getString(cursor.getColumnIndex(COL_ALIAS))
                val celebrity = Celebrity(firstName,lastName,alias,height,weight,birthday,zodiacSign,birthPlace,networth,favorite)
                celebrityList.add(celebrity)
            } while(cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return celebrityList
    }
}