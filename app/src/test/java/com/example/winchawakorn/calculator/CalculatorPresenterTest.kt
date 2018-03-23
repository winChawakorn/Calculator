package com.example.winchawakorn.calculator

import com.example.winchawakorn.calculator.presenters.CalculatorPresenter
import com.example.winchawakorn.calculator.presenters.CalculatorView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class CalculatorPresenterTest {
    lateinit var view: CalculatorView
    lateinit var presenter: CalculatorPresenter

    @Before
    fun init() {
        view = mock(CalculatorView::class.java)
        presenter = CalculatorPresenter(view)
    }

    @Test
    fun testStart() {
        presenter.start()
        verify(view).setDisplayValue("0")
    }

    @Test
    fun testDigitClicked() {
        presenter.start()
        presenter.onDigitClicked(6)
        presenter.onDigitClicked(9)

        var inOrder = inOrder(view)
        inOrder.verify(view).setDisplayValue("0")
        inOrder.verify(view).setDisplayValue("6")
        inOrder.verify(view).setDisplayValue("69")
    }

    @Test
    fun testDelClicked() {

    }

    @Test
    fun testClear() {
        presenter.start()
        presenter.onDigitClicked(7)
        presenter.onClearClicked()

        var inOrder = inOrder(view)
        inOrder.verify(view).setDisplayValue("0")
        inOrder.verify(view).setDisplayValue("7")
        inOrder.verify(view).setDisplayValue("0")
    }
}