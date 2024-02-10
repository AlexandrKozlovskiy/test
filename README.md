# WebView accessibility issue

This branch demonstrate to us accessibility issue on api 33 and probably hier,i.e when it impossible to do long click on image with talkback or any other screenreader.

# steps to reproduce for android 13 (api 33) and,probably,above

1. Find with talkback image (talkback should speak something like image link).
2. Do long click on this image,using standard double tap and hold gesture.
3. instead of alert dialog nothing happpens
4. Try switch off talkback and do long click on image(alertdialog should appear).
5. do steps from 1 to 3 (including step 3) with android 12 or bellow and make sure,what there is no issue.

# quick solution

You can decrease image scale and make this three steps for android 13,and it will be no issue too,but with standard scale issue exists for android 13 and,probably,above,so if you will increase image scale again,issue will repeat again. This issue exists not only with talkback,but,for example,with jieshuo screenreader and,probably,with any other screenreader.
