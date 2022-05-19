package com.example.core.ext

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.shortToast(message: String): Toast {
    return Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
}

fun Fragment.longToast(message: String): Toast {
    return Toast.makeText(requireContext(), message, Toast.LENGTH_LONG)
}