package ru.alexandrkozlovskiy.test;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
class myview extends TextView {
private final myProvider p=new myProvider();
private class myProvider extends AccessibilityNodeProvider {

@Override
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        if(virtualViewId== View.NO_ID) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(myview.this);
info.addChild(myview.this,0);
            info.addChild(myview.this,1);
//announceForAccessibility(virtualViewId+" "+info);
            onInitializeAccessibilityNodeInfo(info);
return info;
        }
        else {
AccessibilityNodeInfo info =AccessibilityNodeInfo.obtain();
info.setSource(myview.this,virtualViewId);
info.setParent(myview.this);
info.setPackageName(getContext().getPackageName());
info.setClassName(TextView.class.getName());
int[] pos= {0,0};
getLocationOnScreen(pos);
info.setBoundsInParent(new Rect(pos[0],pos[1],pos[0],pos[1]));
info.setBoundsInScreen(new Rect(pos[0]+getLeft()*(virtualViewId+1),pos[1]+getTop()*(virtualViewId+1),pos[0]+getRight()*(virtualViewId+1),pos[1]+getBottom()*(virtualViewId+1)));
info.setVisibleToUser(true);
info.setImportantForAccessibility(true);
info.setEnabled(true);
info.setFocusable(true);
info.setFocused(true);
info.addAction(AccessibilityNodeInfo.ACTION_CLICK);
            info.setContentDescription("Test of contentDescription "+pos[0]+" "+pos[1]);
//announceForAccessibility(virtualViewId+" "+info);
return info;
}
}

    @Override
    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
if(action==AccessibilityNodeInfo.ACTION_CLICK ||action==AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS) {
    AccessibilityEvent event = AccessibilityEvent.obtain(action == AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS ? AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED : AccessibilityEvent.TYPE_VIEW_CLICKED);
    if (action == AccessibilityNodeInfo.ACTION_CLICK) announceForAccessibility(virtualViewId + "");
    event.setPackageName(getContext().getPackageName());
    event.setSource(myview.this, virtualViewId);
if(action==AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS) getParent().requestSendAccessibilityEvent(myview.this, event);
    return action == AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS ? true : false;
}
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
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
return p;
}

}