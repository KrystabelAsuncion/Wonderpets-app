package com.eightgroupdev.finalwp.fragments

import CartItem
import CartSharedViewModel
import android.content.Intent
import com.eightgroupdev.finalwp.adapters.ViewPagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.activity.AllProducts
import com.eightgroupdev.finalwp.activity.Cats_category
import com.eightgroupdev.finalwp.adapters.arrivalsAdapter
import com.eightgroupdev.finalwp.adapters.favoritesAdapter
import com.eightgroupdev.finalwp.domain.arrivalDomain
import com.eightgroupdev.finalwp.domain.FavoritesDomain
import com.google.android.gms.analytics.ecommerce.Product

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var recyclerViewArrivalList: RecyclerView
    private lateinit var recyclerFaveList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager = view.findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(requireContext(), viewPager)
        viewPager.adapter = viewPagerAdapter

        // Call the method for auto-scrolling here (if your com.eightgroupdev.finalwp.adapters.ViewPagerAdapter supports it)
        viewPagerAdapter.startAutoScroll()

        //viewallprods_a
        val viewAll0 = view.findViewById<TextView>(R.id.viewAll_0)
        viewAll0.setOnClickListener {
            val intent = Intent(requireContext(),AllProducts::class.java)
            startActivity(intent)
        }

        //viewallprods_b
        val viewAll1 = view.findViewById<TextView>(R.id.viewAll_1)
        viewAll1.setOnClickListener {
            val intent = Intent(requireContext(),AllProducts::class.java)
            startActivity(intent)
        }

        //cats
        val category_cat = view.findViewById<LinearLayout>(R.id.cats_btn)
        val category_cat_b = view.findViewById<ImageView>(R.id.CatsImgBtn)
        category_cat.setOnClickListener{
            val intent = Intent(requireContext(), Cats_category::class.java)
            startActivity(intent)
        }
        category_cat_b.setOnClickListener{
            val intent = Intent(requireContext(), Cats_category::class.java)
            startActivity(intent)
        }

        //arrivalsView
        recyclerViewArrivalList = view.findViewById(R.id.rc_arrivals)
        recyclerViewArrivalList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val arrivalsAdapter = arrivalsAdapter(arrList())
        recyclerViewArrivalList.adapter = arrivalsAdapter
        recyclerViewArrivalList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //favesRecyclerView

        recyclerFaveList = view.findViewById(R.id.rc_favorites)
        recyclerFaveList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val favoritesAdapter = favoritesAdapter(valList())
        recyclerFaveList.adapter = favoritesAdapter
        recyclerFaveList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        //view
        return view
    }
    fun arrList(): List<FavoritesDomain>{
        return listOf(
            FavoritesDomain("Whiskas", "maraShop", R.drawable.whiskas_a, 150.00),
            FavoritesDomain("Aozi Cat Food 20kg", "pochieShop", R.drawable.aa_aozi20_3300, 3300.00),
            FavoritesDomain("MeowMix Wet Cat food", "pochieShop", R.drawable.cc_meowmixwet_150, 150.00),
            FavoritesDomain("Cozy Tree for Cats", "pochieShop", R.drawable.cc_cozytree_1100, 1100.00)
        )

    }
    fun valList(): List<FavoritesDomain> {
        return listOf(
            FavoritesDomain("Pet Travel Cage", "pochieShop", R.drawable.ab_travelcage_450, 450.00),
            FavoritesDomain("Aozi Cat Food 20kg", "pochieShop", R.drawable.aa_aozi20_3300, 3300.00),
            FavoritesDomain("Pet Bed", "pochieShop", R.drawable.cc_bed_1200, 1200.00),
            FavoritesDomain("Cozy Tree for Cats", "pochieShop", R.drawable.cc_cozytree_1100, 1100.00)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop auto-scrolling when the fragment is destroyed to prevent memory leaks
        // Call the method to stop auto-scrolling here (if your com.eightgroupdev.finalwp.adapters.ViewPagerAdapter supports it)
        viewPagerAdapter.stopAutoScroll()
    }

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    //dagdag
    private lateinit var cartSharedViewModel: CartSharedViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        cartSharedViewModel = ViewModelProvider(requireActivity()).get(CartSharedViewModel::class.java)

        // Observe changes in the cart data
        cartSharedViewModel.cartItemsLiveData.observe(viewLifecycleOwner) { cartItems ->
            // Update your UI with the latest cart data
            updateUI(cartItems)
        }

        // ...
    }

    private fun updateUI(cartItems: List<CartItem>) {
        // Example: Update a RecyclerView with the cart items
        // adapter.submitList(cartItems)
        val totalTextView: TextView = requireView().findViewById(R.id.totalPrice)

        // Example: Recalculate and update the total price
        val totalPrice = calculateTotalPrice(cartItems)
        totalTextView.text = "P$totalPrice"
    }
    private fun calculateTotalPrice(cartItems: List<CartItem>): Double {
        var totalPrice = 0.0
        for (item in cartItems) {
            totalPrice += item.productPrice * item.quantity
        }
        return totalPrice
    }
}
