package com.volunteering.clothingapp.presentation.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.clothingapp.core.data.remote.model.params.Status
import com.volunteering.clothingapp.R

class ItemStatusView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val LOG_TAG: String = "LT_ItemStatusView"
    private val stateTextView: TextView
    private val stateImageView: ImageView

    // Constants for states
    companion object {
        const val AVAILABLE = 0
        const val SOLD = 1
        const val INACTIVE = 2
    }

    private var _state: Status = Status.AVAILABLE

    var state: Status
        get() = _state
        set(value) {
            _state = value
            updateUIBasedOnState(value)
        }


    //TODO change this to use data binding
    init {
        LayoutInflater.from(context).inflate(R.layout.item_status_view, this, true)
        stateTextView = findViewById(R.id.tv_item_name)
        stateImageView = findViewById(R.id.iv_item_status)
        context.obtainStyledAttributes(attrs, R.styleable.ItemStatusView).apply {
            _state = when(getInt(R.styleable.ItemStatusView_status, 0)){
                0 -> Status.AVAILABLE
                1 -> Status.SOLD
                else -> Status.ARCHIVED
            }
            recycle()
        }
        updateUIBasedOnState(_state)
    }

    private fun updateUIBasedOnState(state: Status) {
        when (state) {
            Status.AVAILABLE -> { // Available
                stateTextView.text = resources.getText(R.string.text_status_available)
                stateImageView.setImageResource(R.drawable.ic_available)
            }

            Status.SOLD -> { // Sold
                stateTextView.text = resources.getText(R.string.text_status_sold)
                stateImageView.setImageResource(R.drawable.ic_sold)
            }

            else -> { // Inactive
                stateTextView.text = resources.getText(R.string.text_status_inactive)
                stateImageView.setImageResource(R.drawable.ic_inactive)
            }
        }
        invalidate()
        requestLayout()
    }

}