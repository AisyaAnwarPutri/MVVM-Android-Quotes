package com.gmail.aisyanwarputri.mvvmquotes.data

// FakeQuoteDao harus diteruskan - ini adalah ketergantungan
// Kamu juga bisa membuat DAO langsung di dalam kelas tanpa ribet, kan?
// Tidak. Ini akan merusak kemampuan pengujian - Anda harus dapat melewati versi tiruan dari DAO
// ke repositori (mis. yang saat memanggil getQuotes() mengembalikan daftar dummy kutipan untuk pengujian)
// Ini adalah ide inti di balik DEPENDENCY INJECTION - membuat segala sesuatunya sepenuhnya modular dan independen.
class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    // Ini mungkin tampak berlebihan.
    // Bayangkan sebuah kode yang juga memperbarui dan memeriksa backend.
    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        // Instansiasi tunggal yang sudah Anda kenal dan cintai
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}