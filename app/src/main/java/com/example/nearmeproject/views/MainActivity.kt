package com.example.nearmeproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.nearmeproject.R
import com.example.nearmeproject.repositories.ApiRepo

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ApiRepo.init(this)
       //val navhostfragment=supportFragmentManager.findFragmentById(R.id.imagenavigation) as NavHostFragment
            //ده كومت من جود
        //كومنت من أمل
        //كومنت من ابتهال
        //كومنت من وعد



}


}
