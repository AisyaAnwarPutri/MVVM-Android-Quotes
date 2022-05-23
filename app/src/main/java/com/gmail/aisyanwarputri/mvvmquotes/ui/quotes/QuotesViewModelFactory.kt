package com.gmail.aisyanwarputri.mvvmquotes.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.aisyanwarputri.mvvmquotes.data.QuoteRepository

// Repositori yang sama yang dibutuhkan untuk QuotesViewModel
// juga diteruskan ke pabrik

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}