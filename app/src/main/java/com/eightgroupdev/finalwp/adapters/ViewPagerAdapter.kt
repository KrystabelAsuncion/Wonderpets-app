package com.eightgroupdev.finalwp.adapters

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.eightgroupdev.finalwp.R

class ViewPagerAdapter(private val context: Context, private val viewPager: ViewPager) : PagerAdapter() {
    private val imgArray = arrayOf(
        R.drawable.banana_cat,
        R.drawable.cat_eating,
        R.drawable.purpol_cat
    )

    private var autoScrollHandler: Handler? = Handler(Looper.getMainLooper())
    private val autoScrollDelay: Long = 2000

    fun startAutoScroll() {
        autoScrollHandler?.postDelayed(autoScrollRunnable, autoScrollDelay)
    }

    fun stopAutoScroll() {
        autoScrollHandler?.removeCallbacks(autoScrollRunnable)
    }

    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            val nextItem = (viewPager.currentItem + 1) % count
            viewPager.setCurrentItem(nextItem, true)
            autoScrollHandler?.postDelayed(this, autoScrollDelay)
        }
    }

    override fun getCount(): Int {
        return imgArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.slider, container, false)
        val img = view.findViewById<ImageView>(R.id.image)
        img.setImageResource(imgArray[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
