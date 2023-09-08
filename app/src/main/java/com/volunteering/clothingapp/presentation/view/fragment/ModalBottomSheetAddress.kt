package com.volunteering.clothingapp.presentation.view.fragment

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.volunteering.clothingapp.R


class ModalBottomSheetAddress : BottomSheetDialogFragment() {


    private val LOG_TAG: String = "LT_ModalBottomSheet"

    val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            Log.d(LOG_TAG, "bottomSheetCallback() -> onStateChanged() newState:$newState ")
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            Log.d(LOG_TAG, "bottomSheetCallback() -> onSlide() slideOffset:$slideOffset")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LOG_TAG,"onAttach() -> ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG,"onCreate() -> ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG,"onCreateView() -> ")
        return inflater.inflate(R.layout.layout_modal_bottom_sheet_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(LOG_TAG,"onViewCreated() -> ")
        super.onViewCreated(view, savedInstanceState)
        (this.dialog as BottomSheetDialog).behavior.apply {
            state = STATE_EXPANDED
            addBottomSheetCallback(bottomSheetCallback)
        }

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(LOG_TAG,"onViewStateRestored() -> ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG,"onStart() -> ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG,"onResume() -> ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG,"onPause() -> ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG,"onStop() -> ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(LOG_TAG,"onSaveInstanceState() -> ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG,"onDestroyView() -> ")
        (this.dialog as BottomSheetDialog).behavior.apply {
            removeBottomSheetCallback(bottomSheetCallback)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG,"onDestroy() -> ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG_TAG, "onDetach() -> ")
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        Log.d(LOG_TAG, "onDismiss() -> ")
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Log.d(LOG_TAG, "onCancel() -> ")
    }



    companion object {
        const val TAG = "ModalBottomSheet"
    }
}