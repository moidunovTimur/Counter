package com.example.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CounterView {
    lateinit var binding: ActivityMainBinding

    private val presenter = Injector.getPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()

            }
            decrementBtn.setOnClickListener {
                presenter.decrement()

            }
        }
    }


        override fun showCount(count: Int) {
            binding.countTv.text = count.toString()
        }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun showColor(color: Int) {
       binding.countTv.setTextColor(color)
    }
}

