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
import com.douglas.android.garageapp.feature.vehicle.VehicleModel
import com.douglas.android.garageapp.misc.AppExecutors
import com.douglas.android.garageapp.misc.AppExecutors.Companion.uiContext
import com.douglas.android.garageapp.misc.launchSilent
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.book_detail_fragment.*
import kotlinx.android.synthetic.main.book_detail_fragment.bookDate
import kotlinx.android.synthetic.main.book_detail_fragment.bookVehicle
import kotlinx.android.synthetic.main.book_item.*
import kotlinx.android.synthetic.main.vehicle_detail_fragment.*
import org.jetbrains.anko.support.v4.toast

class BookDetailFragment : BottomSheetDialogFragment() {

    private val databaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.book_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initComponents()
        loadVehicle()
    }

    @SuppressLint("SetTextI18n")
    private fun initComponents() {
        context?.let {
            val adapter =
                ArrayAdapter(it, R.layout.dropdown_book_service_item, resources.getStringArray(R.array.plans))
            bookServicePlan.setAdapter(adapter)

            val datePickerDialog = DatePickerDialog(it)
            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                bookDate?.setText("$dayOfMonth/$month/$year")
            }
            bookDate?.setOnClickListener { datePickerDialog.show() }
            bookCheckoutBtn.setOnClickListener { payBook() }
        }
    }

    private fun payBook() {
        val key = databaseReference.child("bookModel").push().key
        val bookModel = BookModel(
            bookPrice = bookServicePlan?.text.toString(),
            bookVehicle = bookVehicle?.text.toString(),
            bookDate = bookDate?.text.toString()
        )
        launchSilent(uiContext) {
            key?.let {
                bookModel.uuid = key
                databaseReference.child("bookModel").child(key).setValue(bookModel)
                dismiss()
            }
        }
    }

    private fun loadVehicle() {
        launchSilent(uiContext) {
            databaseReference.child("vehicleModel").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(databaseError: DatabaseError) {
                    toast("Database error: $databaseError.message")
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val vehicles = dataSnapshot.children.mapNotNull { it.getValue(VehicleModel::class.java) }
                    val vehicleNames = mutableListOf<String>()
                    vehicles.forEach { vehicleNames.add(it.brand) }
                    context?.let {
                        val vehicleAdapter = ArrayAdapter(it, R.layout.dropdown_book_service_item, vehicleNames)
                        bookVehicle?.setAdapter(vehicleAdapter)
                    }
                }
            })
        }
    }
}
