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
<p><a href="https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768.jpg"><img loading="lazy" src="https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768.jpg" alt="изображение" width="1024" height="768" class="aligncenter size-full wp-image-15439" srcset="https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768.jpg 1024w, https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768-300x225.jpg 300w, https://xn----jtbhavgci6f.xn--p1ai/wp-content/uploads/2023/07/фото-святителя-митрофана1024x768-768x576.jpg 768w" sizes="(max-width: 1024px) 100vw, 1024px" /></a></p>
<p>Памятник первому епископу Воронежской епархии Святителю Митрофану Воронежскому Чудотворцу находится на территории Благовещенского собора.</p>
<p>Памятник представляет собой скульптурный ансамбль из фигуры Святителя Митрофана Воронежского в окружении четырёх ангелов.<br />
Скульптура Святителя лицевой стороной ориентирована на юго-западный вход на территорию собора, тыльной стороной обращен на Благовещенский собор. </p>
<p>Высота вертикального памятника восемь с половиной  метров. Вес около восьми тонн.</p>
<p>Бронзовая статуя Святителя Митрофана представлена на фото в полный рост. Левой рукой он опирается на посох, правая рука поднята в благословляющем жесте (соединенные большой и безымянный пальцы).</p>
<p><!--more--></p>
<p>Скульптура изображает человека преклонных лет, высокого роста, с глубоко посаженными глазами, впалыми щеками, небольшими усами и недлинной бородой. Взгляд  спокойный.</p>
<p>На епископе алое облачение до пола. Приподнятыми руками Святитель Митрофан раздвигает посередине верхнее одеяние – мантию – просторную одежду без рукавов, напоминающую плащ. Становится видно нижнее облачение – ряса &#8212; свободную одежду с очень широкими рукавами. </p>
<p>По груди спускается широкая полоса с изображением крестов, называемый епитрахиль. Поверх епитрахиля на груди висит на цепочке знак отличия &#8212; панагия &#8212; округлой формы с изображением Иисуса Христа. </p>
<p>На голове надет клобук, как капюшон, закрывающий голову до бровей и спускающийся на плечи, с вышитым на лбу крестом. Вокруг головы свечение &#8212; нимб, символизирующий в христианстве святость. </p>
<p>Скульптура установлена на постаменте, облицованном чёрным гранитом.</p>
<p>На всех сторонах постамента укреплены бронзовые доски.<br />
На лицевой стороне постамента надпись: «Святителю Митрофану – первому епископу Воронежскому» и изображение православного креста. На тыльной стороне надпись гласит: «Воздвигнут в память 300-летия со дня преставления Святителя Митрофана попечением Высокопреосвященного  Мефодия митрополита Воронежского и Липецкого». На южной стороне на барельефе изображена сцена благословения Митрофаном Петра I на строительство военно-морского флота. На северной стороне – освящение Митрофаном кораблей, построенных на воронежских верфях.</p>
<p>Фигуру святителя окружают четыре ангела в человеческом образе, с утонченными чертами лица, в длинных свободных одеждах, в высоких зашнурованных сапожках, с собранными волосами, укрепленную лентой. Ангелы касаются ногами бронзовых шаров на черном гранитном пьедестале.</p>
<p>     У каждого ангела за спиной по два больших крыла. Каждый из ангелов что-то держит в руках. В руках одного из ангелов &#8212; раскрытая книга, напоминающая о большой роли святителя в просвещении народа. Другой ангел держит кораблик, символизирующий участие Митрофана в деяниях по созданию русского военного флота. В руках третьего ангела &#8212; макет собора Петропавловской крепости. Это знак того, что святитель благословил Петра I на строительство Санкт-Петербурга. Ещё один ангел держит копьё &#8212; символ борьбы добра со злом.</p>
<p>***</p>
<p>Автор описания: Екатерина Мукасеева</p>
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