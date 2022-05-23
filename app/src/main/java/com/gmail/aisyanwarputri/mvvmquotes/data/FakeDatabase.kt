package com.gmail.aisyanwarputri.mvvmquotes.data

// Konstruktor utama pribadi tidak dapat diakses dari kelas lain
class FakeDatabase private constructor() {

    // Semua DAO pergi ke sini!
    var quoteDao = FakeQuoteDao()
        private set

    companion object {
        // @Volatile - Penulisan ke properti ini segera terlihat oleh utas lainnya
        @Volatile private var instance: FakeDatabase? = null

        // Satu-satunya cara untuk mendapatkan objek FakeDatabase
        fun getInstance() =
        // Sudah dipakai? - kembalikan instance
            // Jika tidak, instantiate dengan cara yang aman
            instance ?: synchronized(this) {
                // Jika masih belum dipakai, akhirnya buat objek
                // juga mengatur properti "instance" menjadi properti yang dibuat saat ini
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}