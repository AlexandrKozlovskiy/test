package ru.alexandrkozlovskiy.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
private WebView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long ms=System.currentTimeMillis();
setContentView(R.layout.activity_main);
ms=System.currentTimeMillis()-ms;
//setTitle(ms+"");
text=(WebView) findViewById(R.id.text);
        text.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        text.getSettings().setJavaScriptEnabled(true);
        text.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        registerForContextMenu(text);
text.loadDataWithBaseURL("", """
<div class="entry">
<p><a href="https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768.jpg"><img loading="lazy" src="https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768.jpg" alt="image" width="1024" height="768" class="aligncenter size-full wp-image-15439" srcset="https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768.jpg 1024w, https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768-300x225.jpg 300w, https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768-768x576.jpg 768w" sizes="(max-width: 1024px) 100vw, 1024px" /></a></p>
<p>Test par</p>
</div>
""","text/html; charset=utf-8", "utf-8", "");
}

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        WebView.HitTestResult result =((WebView)v).getHitTestResult();
        AlertDialog d=new AlertDialog.Builder(this).setTitle(getString(android.R.string.dialog_alert_title)).setMessage(" result type is: "+result.getType()+" and result extra is: "+result.getExtra()).setPositiveButton(getString(android.R.string.ok),null).create();
        d.show();
    }
}