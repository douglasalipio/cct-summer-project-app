package com.douglas.android.garageapp.feature.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.douglas.android.garageapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.book_detail_fragment.*

class BookDetailFragment : BottomSheetDialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.book_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initComponents()
    }

    private fun initComponents() {
        context?.let {
            val adapter =
                ArrayAdapter(it, R.layout.dropdown_book_service_item, resources.getStringArray(R.array.plans))
            servicePlanSpinner.setAdapter(adapter)
        }
    }

}
