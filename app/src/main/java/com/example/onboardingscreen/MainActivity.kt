package com.example.onboardingscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    var viewpageradapter: viewpageradapter? = null
    var tabLayout: TabLayout? = null
    var viewpager: ViewPager? = null
    var next: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tab)
        next=findViewById((R.id.next))
        val onBoardingData:MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Explore", R.drawable.image))
        onBoardingData.add(OnBoardingData("Search", R.drawable.image))
        setviewadapter(onBoardingData)
        var position= viewpager!!.currentItem
        next?.setOnClickListener {
            if(position<onBoardingData.size){
                position++
                viewpager!!.currentItem = position

            }
        }

    }
    private fun setviewadapter(OnboardingData:List<OnBoardingData>){
        viewpager = findViewById(R.id.viewpager)
        viewpageradapter= viewpageradapter(this, OnboardingData )
        viewpager!!.adapter= viewpageradapter
        tabLayout?.setupWithViewPager(viewpager)
    }
}