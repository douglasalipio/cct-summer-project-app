package com.douglas.android.garageapp.feature.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglas.android.garageapp.R
import kotlinx.android.synthetic.main.book_item.view.*


class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private val books = mutableListOf<BookModel>()

    fun load(vehicles: List<BookModel>) {
        this.books.clear()
        this.books.addAll(vehicles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(book: BookModel) {
            with(itemView) {
                bookPrice.text = book.bookPrice
                bookStatus.text = book.bookStatus
                bookVehicle.text = book.bookVehicle
                bookDate.text = book.bookDate
            }
        }
    }
}