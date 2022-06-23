package ru.alexandrkozlovskiy.test;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.Toast;

class CustomView extends TextView {
    private SpannableStringBuilder sb;
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
if(sb==null) {
    sb = new SpannableStringBuilder("Test of clickable span");
    sb.setSpan(new URLSpan("test://text?text=1") {

        @Override
        public void onClick(View v) {
            try {
                Toast.makeText(getContext(), "Test of clickable span", 1).show();
            } catch (Exception e) {
                //setContentDescription(e.toString());
            }
        }
    }, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
}
setText(sb);
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClickable(true);
        info.setContentDescription(sb);
        //Explain me someone please,why when i set text for this node,and call links via talkback menu and click to some link,it works as ClickableSpan,but when i set contentDescription for this node,using the same text and do the same,talkback recognize link as URLSpan (second case expected behaviour). But i have an example (https://github.com/AlexandrKozlovskiy/orthodoxcalendar/blob/main/app/src/main/java/oleksandr/kotyuk/orthodoxcalendar/fragments/PageFragmentViewPagerDay.java),in which links works as URLSpans even for text.
    }
}