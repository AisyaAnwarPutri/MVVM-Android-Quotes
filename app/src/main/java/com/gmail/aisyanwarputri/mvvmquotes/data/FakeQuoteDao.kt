package com.gmail.aisyanwarputri.mvvmquotes.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    // Tabel database palsu
    private val quoteList = mutableListOf<Quote>()
    // MutableLiveData berasal dari Perpustakaan Komponen Arsitektur
    // LiveData dapat diamati untuk perubahan
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        // Segera sambungkan yang sekarang kosong quoteList
        // ke MutableLiveData yang dapat diamati
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        // Setelah menambahkan kutipan ke "database",
        // perbarui nilai MutableLiveData
        // yang akan memberi tahu pengamat aktifnya
        quotes.value = quoteList
    }

    // Casting MutableLiveData ke LiveData karena nilainya
    // tidak boleh diubah dari kelas lain
    fun getQuotes() = quotes as LiveData<List<Quote>>
}