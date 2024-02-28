package com.eightgroupdev.finalwp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.eightgroupdev.finalwp.R

class img_adapter(private val context: Context, imgPager: ViewPager) : PagerAdapter() {
    private val imgArray = arrayOf(
        R.drawable.whiskas_a,
        R.drawable.whiskas_a,
        R.drawable.whiskas_a
    )

    override fun getCount(): Int {
        return imgArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.img_slider, container, false)
        val img = view.findViewById<ImageView>(R.id.image_container)
        img.setImageResource(imgArray[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
