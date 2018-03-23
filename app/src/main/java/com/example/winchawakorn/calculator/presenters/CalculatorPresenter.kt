package com.example.winchawakorn.calculator.presenters

class CalculatorPresenter(val view: CalculatorView) {

    var result: String = "0"

    fun start() {
        clear()
    }

    fun onDigitClicked(digit: Int) {
        if (result == "0") {
            result = digit.toString()
        } else {
            result += digit.toString()
        }
        updateResult()
    }

    fun updateResult() {
        view.setDisplayValue(result)
    }

    fun onClearClicked() {
        clear()
    }

    fun onDelClicked() {
        if (result != "0") {
            result = result.removeRange(result.lastIndex, result.length)
        }
        if (result == "") {
            result = "0"
        }
        updateResult()
    }

    fun clear() {
        result = "0"
        updateResult()
    }
}
