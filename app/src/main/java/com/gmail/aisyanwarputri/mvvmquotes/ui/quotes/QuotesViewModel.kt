package com.gmail.aisyanwarputri.mvvmquotes.ui.quotes

import androidx.lifecycle.ViewModel
import com.gmail.aisyanwarputri.mvvmquotes.data.Quote
import com.gmail.aisyanwarputri.mvvmquotes.data.QuoteRepository

// Ketergantungan QuoteRepository akan diteruskan lagi di
// konstruktor menggunakan injeksi ketergantungan
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}