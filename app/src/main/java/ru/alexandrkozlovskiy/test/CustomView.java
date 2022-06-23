package ru.alexandrkozlovskiy.test;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

class CustomView extends View {
    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,00);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setImportantForAccessibility(IMPORTANT_FOR_ACCESSIBILITY_YES);
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClickable(true);
        SpannableStringBuilder sb= new SpannableStringBuilder("Test of clickable span");
        sb.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getContext(),"Test of clickable span",1).show();
                }
                catch (Exception e) {
                    info.setContentDescription(e.toString());
                    //setContentDescription(e.toString());
                }
            }
        }, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        info.setText(sb); //Set contentDescription here,to be sure,what no link appeared,but for urlSpan links works also with contentDescription.
    }
}