package com.example.winchawakorn.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.winchawakorn.calculator.presenters.CalculatorPresenter
import com.example.winchawakorn.calculator.presenters.CalculatorView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CalculatorView {

    lateinit var presenter: CalculatorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CalculatorPresenter(this)
        presenter.start()
    }

    override fun setDisplayValue(msg: String) {
        result.text = msg
    }

    fun digitClicked(view: View) {
        var button: Button = view as Button
        presenter.onDigitClicked(button.text.toString().toInt())
    }

    fun clearClicked(view: View) {
        presenter.onClearClicked()
    }

    fun delClicked(view: View) {
        presenter.onDelClicked()
    }
}
