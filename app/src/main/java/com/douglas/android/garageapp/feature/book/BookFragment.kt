package com.douglas.android.garageapp.feature.book


import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.douglas.android.garageapp.R
import com.douglas.android.garageapp.feature.vehicle.VehicleAdapter
import com.douglas.android.garageapp.feature.vehicle.VehicleDetailFragmentArgs
import com.douglas.android.garageapp.feature.vehicle.VehicleModel
import com.douglas.android.garageapp.misc.AppExecutors
import com.douglas.android.garageapp.misc.launchSilent
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.book_fragment.*
import kotlinx.android.synthetic.main.vehicle_fragment.*
import org.jetbrains.anko.support.v4.toast
import java.util.*


class BookFragment : Fragment() {

    private val bookAdapter = BookAdapter()
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val args: VehicleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.book_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
        loadBook()
        setUpToolbar()
    }

    private fun setUpToolbar() {
        activity?.title = "Booking"
    }

    private fun initComponent() {
        bookingServiceRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context!!)
            adapter = bookAdapter
            setHasFixedSize(true)
        }
        addBookButton?.setOnClickListener { findNavController().navigate(R.id.actionBookToBookDetailFragment) }
    }

    private fun loadBook() {
        launchSilent(AppExecutors.uiContext) {
            databaseReference.child("bookModel").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(databaseError: DatabaseError) {
                    toast("Database error: $databaseError.message")
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    //val vehicleSelected = dataSnapshot.getValue(VehicleModel::class.java)
                    val books = dataSnapshot.children.mapNotNull { it.getValue(BookModel::class.java) }
                    bookAdapter.load(books)
                }
            })
        }
    }
}
