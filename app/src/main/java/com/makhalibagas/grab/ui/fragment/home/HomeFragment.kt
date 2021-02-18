package com.makhalibagas.grab.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.makhalibagas.grab.R
import com.makhalibagas.grab.adapter.DiscoverAdapter
import com.makhalibagas.grab.model.Discover
import com.makhalibagas.grab.ui.SearchActivity
import com.makhalibagas.grab.ui.bottomsheet.MenuBottomSheetDialog
import com.makhalibagas.grab.ui.bottomsheet.MenuBottomSheetDialog.Companion.TAG
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var searchView : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        v.rv_momen.layoutManager = GridLayoutManager(context, 2)
        v.rv_momen.adapter = DiscoverAdapter(listMomen())


        v.rv_discovering.layoutManager = GridLayoutManager(context, 2)
        v.rv_discovering.adapter = DiscoverAdapter(listDiscover())


        searchView = v.findViewById(R.id.sv_home)
        searchView.onActionViewCollapsed()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                startActivity(Intent(context, SearchActivity::class.java))
                return false
            }
        })


        v.ib_more.setOnClickListener {
            MenuBottomSheetDialog().show(parentFragmentManager, TAG)
        }

        return v
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun listMomen() = listOf(

            Discover(R.drawable.thumb1, "Kejar Diskon SKSD &\n menagkan EMAS*", "Until 29 Nov"),
            Discover(R.drawable.thumb9, "Kejar Diskon SKSD &\n menagkan EMAS*", "Until 29 Nov")
    )

    private fun listDiscover() = listOf(


            Discover(R.drawable.thumb11, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 29 Jan"),
            Discover(R.drawable.thumb2, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 23 Feb"),
            Discover(R.drawable.thumb3, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 12 Mar"),
            Discover(R.drawable.thumb4, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 23 Apr"),
            Discover(R.drawable.thumb5, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 26 Mei"),
            Discover(R.drawable.thumb6, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 25 Jun"),
            Discover(R.drawable.thumb7, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 26 Jul"),
            Discover(R.drawable.thumb8, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 27 Agt"),
            Discover(R.drawable.thumb9, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 21 Oct"),
            Discover(R.drawable.thumb10, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 19 Nov"),
            Discover(R.drawable.thumb11, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 25 Jan"),
            Discover(R.drawable.thumb12, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 21 Des"),
            Discover(R.drawable.thumb1, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 20 Jul"),
            Discover(R.drawable.thumb2, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 10 Nov"),
            Discover(R.drawable.thumb3, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 11 Mar"),
            Discover(R.drawable.thumb4, "Kejar Diskon SKSD &\nmenagkan EMAS*", "Until 32 Mei")
    )

}