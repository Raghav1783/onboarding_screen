package com.example.onboardingscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class viewpageradapter(private var context:Context, private var onBoardingDataList : List<OnBoardingData>) : PagerAdapter() {

    override fun getCount(): Int {
        return  onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view :View = LayoutInflater.from(context).inflate(R.layout.slider_layout, null)
        val imageView: ImageView = view.findViewById(R.id.title_image)
        val title :TextView = view.findViewById(R.id.title_text)

        imageView.setImageResource(onBoardingDataList[position].imageurl)
        title.text=onBoardingDataList[position].title

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}