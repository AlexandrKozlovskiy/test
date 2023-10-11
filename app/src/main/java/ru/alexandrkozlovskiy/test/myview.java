package ru.alexandrkozlovskiy.test;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

class myview extends ViewGroup {
private final myProvider p=new myProvider();
private class myProvider extends AccessibilityNodeProvider {

@Override
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        if(virtualViewId== View.NO_ID) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(myview.this);
            onInitializeAccessibilityNodeInfo(info);
            info.setContentDescription("Test of parent view");
            info.setClassName(SeekBar.class.getName());
            info.addChild(myview.this,0);
            return info;
        }
        else {
AccessibilityNodeInfo info =AccessibilityNodeInfo.obtain();
info.setSource(myview.this,virtualViewId);
info.setParent(myview.this);
info.setPackageName(getContext().getPackageName());
info.setClassName(TextView.class.getName());
int[] pos= {0,0,0,0};
getLocationOnScreen(pos);
//info.setBoundsInParent(new Rect(pos[0],pos[1],pos[2],pos[3]));
info.setBoundsInScreen(new Rect(pos[0]+getLeft(),pos[1]+getTop(),pos[2]+getRight(),pos[3]+getBottom()));
info.setVisibleToUser(true);
info.setImportantForAccessibility(true);
info.setEnabled(true);
info.setFocusable(true);
info.setFocused(true);
info.addAction(AccessibilityNodeInfo.ACTION_CLICK);
info.addAction(AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS);
            info.setContentDescription("test of child view "+virtualViewId);
//announceForAccessibility(virtualViewId+" "+info);
return info;
}
}

    @Override
    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
    //if we will use string below,talkback will announce contentDescription and type of parent view,when we swipe right,but when we svipe left from child view,nothing will be announce. If we will comment line bellow,talkback will not announce contentDescription and element type of parent and child view. So,to reproduce official telegram client issue,uncomment line below.
        if(virtualViewId==NO_ID) return performAccessibilityAction(action,arguments); //Without this string talkback in parent node speak nothing.
if(action==AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS) {
    AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED);
    event.setPackageName(getContext().getPackageName());
    event.setSource(myview.this, virtualViewId);
    getParent().requestSendAccessibilityEvent(myview.this, event);
return true;
    }
else if(action ==AccessibilityNodeInfo.ACTION_CLICK) announceForAccessibility("virtual view id is "+virtualViewId+".");
return super.performAction(virtualViewId,action,arguments);
    }
}
public myview(Context context) {
        super(context);
}
    public myview(Context context, AttributeSet attrs) {
super(context, attrs);
}

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
return p;
}

}