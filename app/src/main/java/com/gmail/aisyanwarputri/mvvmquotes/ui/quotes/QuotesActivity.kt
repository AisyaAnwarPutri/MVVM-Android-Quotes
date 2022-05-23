package com.gmail.aisyanwarputri.mvvmquotes.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gmail.aisyanwarputri.mvvmquotes.R
import com.gmail.aisyanwarputri.mvvmquotes.data.Quote
import com.gmail.aisyanwarputri.mvvmquotes.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        // Dapatkan QuotesViewModelFactory dengan semua dependensinya dibangun
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        // Gunakan kelas ViewModelProviders untuk membuat / mendapatkan QuotesViewModel yang sudah dibuat
        // untuk tampilan ini (aktivitas)
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        // Mengamati LiveData dari QuotesViewModel yang pada gilirannya mengamati
        // LiveData dari repositori, yang mengamati LiveData dari DAO
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // Ketika tombol diklik, instantiate Quote dan tambahkan ke DB melalui ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }

}