package com.douglas.android.garageapp.feature.receipt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglas.android.garageapp.R
import com.douglas.android.garageapp.feature.book.BookModel
import kotlinx.android.synthetic.main.book_item.view.*
import kotlinx.android.synthetic.main.book_item.view.bookDate
import kotlinx.android.synthetic.main.receipt_item.view.*


class ReceiptAdapter : RecyclerView.Adapter<ReceiptAdapter.BookViewHolder>() {

    private val receipts = mutableListOf<ReceiptModel>()

    fun load(receipts: List<ReceiptModel>) {
        this.receipts.clear()
        this.receipts.addAll(receipts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.receipt_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = receipts.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(receipts[position])
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(receipt: ReceiptModel) {
            with(itemView) {
                receiptPrice.text = receipt.servicePrice
                receiptDate.text = receipt.deliveryDate
                receiptBrand.text = receipt.vehicleBrand
            }
        }
    }
}