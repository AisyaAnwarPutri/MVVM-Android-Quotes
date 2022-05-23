package com.gmail.aisyanwarputri.mvvmquotes.utilities

import com.gmail.aisyanwarputri.mvvmquotes.data.FakeDatabase
import com.gmail.aisyanwarputri.mvvmquotes.data.QuoteRepository
import com.gmail.aisyanwarputri.mvvmquotes.ui.quotes.QuotesViewModelFactory

// Akhirnya singleton yang tidak membutuhkan apa pun diteruskan ke konstruktor
object InjectorUtils {

    // Ini akan dipanggil dari QuotesActivity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory membutuhkan repositori, yang pada gilirannya membutuhkan DAO dari database
        // Seluruh pohon ketergantungan dibangun di sini, di satu tempat
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}