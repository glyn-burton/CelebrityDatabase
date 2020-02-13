package com.example.celebritydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CelebrityCallback {



    val databaseHelper by lazy{ CelebrityDatabaseHelper(this)}
    val adapter by lazy { CelebrityRVAdapter(databaseHelper.getAllPeopleFromDatabase(), this, databaseHelper) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isFav = btnFavoriteToggle.isSelected.toString()
        databaseHelper.insertPersonIntoDatabase(Celebrity("Aya","Tanaka","Samurai","5'8","122pds","July 8th","Cancer","Osaka","6 Million",isFav))
        initRecyclerVeiw()
    }

    override fun passCelebrity(celebrity: Celebrity) {
        btnFavoriteToggle.isSelected = celebrity.favorite == "true"
    }

    fun initRecyclerVeiw (){
       rvCelebRV.layoutManager = LinearLayoutManager(this)
        rvCelebRV.adapter = adapter


    }

    fun onClick(view: View) {

        when(view.id){

            R.id.btnFavoriteToggle -> {}




        }


    }


}
