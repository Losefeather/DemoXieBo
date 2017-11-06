package com.tablaoutviewpagerdemo.a1111.demoxiebo.ui.NiceSpinnerView;

import android.text.Spannable;
import android.text.SpannableString;

public class SimpleSpinnerTextFormatter implements SpinnerTextFormatter {

    @Override public Spannable format(String text) {
        return new SpannableString(text);
    }
}
