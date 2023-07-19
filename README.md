# test

This is a branch,which demonstrate  crash of talkback,if we have URLSpan and if activities,which can open the link,have android:exported="false".

## steps to reproduce

1. Compile and run this app,when talkback is running.
2. focus on view with text "test of clickable span".
3. Go to talkback menue/links and do double tab on a link.
4. Sure,what talkvack crashed,so blind user should reboot device,or call sighted person,to rerun talkback.

Also please try comment or delete line 52 in file CustomView.java,i.e not set contentDescription for node. In this case it calls method onClick of URLSpan object. Whether it's issue of talkback or framework?

This problem exists with talkback 14.0 android 12 xiaomi redmi note 9 s miui 14.03.This problem exists with talkback 14.0 android 12 xiaomi redmi note 9 s miui 14.03.