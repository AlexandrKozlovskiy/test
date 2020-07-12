package ru.alexandrkozlovskiy.test;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

class myview extends TextView {
private final myProvider p=new myProvider();
private class myProvider extends AccessibilityNodeProvider {

@Override
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        if(virtualViewId== View.NO_ID) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(myview.this);
onInitializeAccessibilityNodeInfo(info);
info.setParent((View) getParentForAccessibility());
info.setVisibleToUser(true);
            info.setImportantForAccessibility(true);
info.addAction(AccessibilityNodeInfo.ACTION_CLICK);
info.addAction(AccessibilityNodeInfo.ACTION_FOCUS);
info.setSelected(true);
info.setFocusable(true);
info.setAccessibilityFocused(true);
info.setContentDescription("Test of contentDescription of parent");
info.addChild(myview.this,0);
//Toast.makeText(getContext(),""+info,1).show();
return info;
        }
        else {
AccessibilityNodeInfo info =AccessibilityNodeInfo.obtain();
info.setContentDescription("Test of contentDescription");
info.setSource(myview.this,virtualViewId);
info.setParent(myview.this);
info.setPackageName(getContext().getPackageName());
info.setClassName(TextView.class.getName());
            info.addAction(AccessibilityNodeInfo.ACTION_CLICK);
int[] pos= {0,0};
getLocationOnScreen(pos);
info.setBoundsInScreen(new Rect(pos[0]+getLeft(),pos[1]+getTop(),pos[0]+getRight(),pos[1]+getBottom()));
info.setVisibleToUser(true);
info.setImportantForAccessibility(true);
info.setText("test of text");
info.setEnabled(true);
info.setFocusable(true);
info.setFocused(true);
            info.addAction(AccessibilityNodeInfo.ACTION_CLICK);
            info.addAction(AccessibilityNodeInfo.ACTION_FOCUS);
//Toast.makeText(getContext()," test"+info,1).show();
return info;
}
}

    @Override
    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
if(action==AccessibilityNodeInfo.ACTION_CLICK) Toast.makeText(getContext(),virtualViewId+"",1).show();
return super.performAction(virtualViewId, action, arguments);
    }
}
public myview(Context context) {
        super(context);
}
    public myview(Context context, AttributeSet attrs) {
super(context, attrs);
}
    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
return p;
}

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
//Toast.makeText(getContext(),""+info,1).show();
}
}