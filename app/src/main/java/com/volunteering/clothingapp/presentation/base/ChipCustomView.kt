package com.volunteering.clothingapp.presentation.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.CheckedTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.volunteering.clothingapp.R

class ChipCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val LOG_TAG: String = "LT_ChipCustomView"
    private val checkedTextView: CheckedTextView
    private val checkBox: CheckBox

    private var _state: Boolean = false
    private var _text: String

    var state: Boolean
        get() = _state
        set(value) {
            _state = value
            updateUIBasedOnState(value)
        }

    var text: String
        get() = _text
        set(value) {
            _text = value
            updateText(value)
        }


    //TODO change this to use data binding
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_item_chip_internal, this, true)
        checkedTextView = findViewById(R.id.tv_title_chip)
        checkBox = findViewById(R.id.iv_view_background)


        context.obtainStyledAttributes(attrs, R.styleable.ChipCustomView).apply {
            _state = getBoolean(R.styleable.ChipCustomView_state, false)
            _text = getString(R.styleable.ChipCustomView_text) ?: "default"
            recycle()
        }
        updateUIBasedOnState(_state)
        updateText(_text)
    }

    private fun updateUIBasedOnState(state: Boolean) {
        checkedTextView.isChecked = state
        checkBox.isChecked = state
        invalidate()
        requestLayout()
    }

    private fun updateText(text: String) {
        checkedTextView.text = text
        invalidate()
        requestLayout()
    }
}