# test
This is a test repository,which shows telegram issue.
# steps to reproduce
1. Open official telegram client for android.
2. Open some group or channel,which have at least one voice message.
3. find this voice message (talkback will announce it and type of element as seekbar)
4. swipe right from it,and after focusing on share button swipe left.
5. talkback will not announce nothing,but with jieshuo screenreader all ok.

This problem exists with talkback 9.1 android 10 xiaomi redmi note 9 s miui 12.03. In previous versions of talkback and miui problem exists too.

So i opened telegram sources,found how in it creates virtual view structure,and did the app,which demonstrates this issue.