# test

This is a test repository,which shows two issues of clickable spans with talkback.

## steps to reproduce

1. Compile and run this app,when talkback is running.
2. focus on view with text "test of clickable span".
3. Go to talkback menue/links and do double tab on a link.
4. sure,what nothing happens,and no toast appear.

This problem exists with talkback 12.2 android 11 xiaomi redmi note 9 s miui 12.05.

## Steps to reproduce the second issue

1. Open class myview java.
2. replace info.setText on info.setContentDescription.
3. compile and run app,when talkback is running.
4. focus on view with text "test of clickable span" and sure,what no links here.