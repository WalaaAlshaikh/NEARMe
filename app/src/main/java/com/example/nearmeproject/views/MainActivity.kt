package com.example.nearmeproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nearmeproject.R
import com.example.nearmeproject.repositories.ApiRepo

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ApiRepo.init(this)
       // supportFragmentManager.beginTransaction().add(R.id.frameLayout1,imageFragment()).commit()
            //ده كومت من جود
        //كومنت من أمل
        //كومنت من ابتهال
        //كومنت من وعد



}


}
