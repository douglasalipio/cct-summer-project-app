package com.douglas.android.garageapp.feature.book

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.douglas.android.garageapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.book_detail_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast

class BookDetailFragment : BottomSheetDialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.book_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initComponents()
    }

    @SuppressLint("SetTextI18n")
    private fun initComponents() {
        context?.let {
            val adapter =
                ArrayAdapter(it, R.layout.dropdown_book_service_item, resources.getStringArray(R.array.plans))
            servicePlanSpinner.setAdapter(adapter)

            val datePickerDialog = DatePickerDialog(it)
            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                registrationEdit?.setText("$dayOfMonth/$month/$year")
            }
            registrationEdit?.setOnClickListener { datePickerDialog.show() }

        }
    }

}
