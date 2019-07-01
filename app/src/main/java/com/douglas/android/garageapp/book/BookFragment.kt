package com.douglas.android.garageapp.book


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.douglas.android.garageapp.R
import kotlinx.android.synthetic.main.book_fragment.*

class BookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.book_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // buttonTest.setOnClickListener {  view.findNavController().navigate(R.id.book_to_bookDetail) }
    }
}
