package ru.alexandrkozlovskiy.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long ms=System.currentTimeMillis();
setContentView(R.layout.activity_main);
ms=System.currentTimeMillis()-ms;
setTitle(ms+"");
}
}