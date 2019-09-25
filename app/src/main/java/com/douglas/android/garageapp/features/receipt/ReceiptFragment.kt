package com.douglas.android.garageapp.features.receipt


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.douglas.android.garageapp.R
import com.douglas.android.garageapp.misc.AppExecutors
import com.douglas.android.garageapp.misc.launchSilent
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.book_fragment.*
import kotlinx.android.synthetic.main.receipt_fragment.*
import org.jetbrains.anko.support.v4.toast


class ReceiptFragment : Fragment() {

    private val receiptAdapter = ReceiptAdapter()
    private val databaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.receipt_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
        loadReceipt()
        setUpToolbar()
    }

    private fun setUpToolbar(){
        activity?.title = "Receipts"
    }

    private fun initComponent() {

        receiptRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context!!)
            adapter = receiptAdapter
            setHasFixedSize(true)
        }
        addBookButton?.setOnClickListener { findNavController().navigate(R.id.actionBookToBookDetailFragment) }
    }

    private fun loadReceipt() {
        launchSilent(AppExecutors.uiContext) {
            databaseReference.child("receiptModel").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(databaseError: DatabaseError) {
                    toast("Database error: $databaseError.message")
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    //val vehicleSelected = dataSnapshot.getValue(VehicleModel::class.java)
                    val receipts = dataSnapshot.children.mapNotNull { it.getValue(ReceiptModel::class.java) }
                    receiptAdapter.load(receipts)
                }
            })
        }
    }

}
