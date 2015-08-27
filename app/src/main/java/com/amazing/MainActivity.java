package com.amazing;

import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amazing.adapters.ItemAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.amazing.view.AmazingListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private RelativeLayout rlMain;
    private AmazingListView listView;
    private ItemAdapter itemAdapter;
    private LinearLayout sideIndex;
    private int sideHeight;
    private int heightPerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlMain= (RelativeLayout) findViewById(R.id.rlMain);
        listView= (AmazingListView) findViewById(R.id.listView);
        listView.setPinnedHeaderView(LayoutInflater.from(this).inflate(R.layout.item_header,listView,false));
        itemAdapter=new ItemAdapter(this,getCityData());
        listView.setAdapter(itemAdapter);
        sideIndex= (LinearLayout) findViewById(R.id.sideIndex);
        rlMain.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                genIndexBar();
                rlMain.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });

    }

    private void genIndexBar(){
        sideHeight=sideIndex.getHeight();
        sideIndex.removeAllViews();
        List<Pair<String, List<String>>> data = itemAdapter.getData();
        for(int i=0;i<data.size();i++){
            TextView tmpTV = new TextView(this);
            String tmpLetter = data.get(i).first;
            tmpTV.setText(tmpLetter);
            tmpTV.setGravity(Gravity.CENTER);
            tmpTV.setTextColor(0xff1ba9ba);
            tmpTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
            LayoutParams params = new LayoutParams(-1, LayoutParams.WRAP_CONTENT, 1);
            tmpTV.setLayoutParams(params);
            sideIndex.addView(tmpTV);
        }

        if (itemAdapter.getData().size() > 0) {
            heightPerItem = sideHeight / sideIndex.getChildCount();
            sideIndex.setTouchDelegate(new TouchDelegate(new Rect(), sideIndex) {
                @Override
                public boolean onTouchEvent(MotionEvent event) {
                    int index = (int) (event.getY() / heightPerItem);
                    int position = itemAdapter.getPositionForSection(index);
                    listView.setSelection(position);
                    return true;
                }
            });
        }
    }

    private List<Pair<String,List<String>>> getCityData(){
        List<Pair<String,List<String>>> data=new ArrayList<Pair<String,List<String>>>();
        String[] arrA=new String[]{"阿克苏","安庆","安阳","鞍山"};
        String[] arrB=new String[]{"北京","北海","本溪","滨州","蚌埠","滨州"};
        String[] arrC=new String[]{"重庆","长沙","长春","成都","赤峰","滨州"};
        String[] arrD=new String[]{"大理","大连","东莞","大同","丹东"};
        String[] arrE=new String[]{"鄂州"};
        String[] arrF=new String[]{"抚顺","福州","阜新","阜阳","佛山"};
        String[] arrG=new String[]{"桂林","贵州","广州"};
        String[] arrH=new String[]{"哈尔滨","海口","合肥","汉中","鹤岗","杭州","黑河","衡水"};
        String[] arrJ=new String[]{"济南","鸡西","嘉兴","江阴","吉林"};
        String[] arrK=new String[]{"昆明","开封","昆山"};
        String[] arrL=new String[]{"拉萨","丽江","丽水","连云港","辽阳"};
        String[] arrM=new String[]{"马鞍山","绵阳"};
        String[] arrN=new String[]{"南昌","南京","南宁","内江"};
        String[] arrP=new String[]{"盘锦","攀枝花","平遥","蓬莱","平凉"};
        String[] arrQ=new String[]{"青岛","七台河"};
        String[] arrR=new String[]{"日照","饶阳"};
        String[] arrS=new String[]{"苏州","上海","三亚","汕头"};
        String[] arrT=new String[]{"天津","通辽","吐鲁番"};
        String[] arrW=new String[]{"威海","无锡","武汉"};
        String[] arrX=new String[]{"西安","西宁","襄阳","新乡","盱眙"};
        String[] arrY=new String[]{"烟台","扬州","伊犁","延安","雅安"};
        String[] arrZ=new String[]{"张家界","枣庄","庄河","驻马店"};
        List<String> listA = Arrays.asList(arrA);
        List<String> listB = Arrays.asList(arrB);
        List<String> listC = Arrays.asList(arrC);
        List<String> listD = Arrays.asList(arrD);
        List<String> listE = Arrays.asList(arrE);
        List<String> listF = Arrays.asList(arrF);
        List<String> listG = Arrays.asList(arrG);
        List<String> listH = Arrays.asList(arrH);
        List<String> listJ = Arrays.asList(arrJ);
        List<String> listK = Arrays.asList(arrK);
        List<String> listL = Arrays.asList(arrL);
        List<String> listM = Arrays.asList(arrM);
        List<String> listN = Arrays.asList(arrN);
        List<String> listP = Arrays.asList(arrP);
        List<String> listQ = Arrays.asList(arrQ);
        List<String> listR = Arrays.asList(arrR);
        List<String> listS = Arrays.asList(arrS);
        List<String> listT = Arrays.asList(arrT);
        List<String> listW = Arrays.asList(arrW);
        List<String> listX = Arrays.asList(arrX);
        List<String> listY = Arrays.asList(arrY);
        List<String> listZ = Arrays.asList(arrZ);

        data.add(new Pair("A",listA));
        data.add(new Pair("B",listB));
        data.add(new Pair("C",listC));
        data.add(new Pair("D",listD));
        data.add(new Pair("E",listE));
        data.add(new Pair("F",listF));
        data.add(new Pair("G",listG));
        data.add(new Pair("H",listH));
        data.add(new Pair("J",listJ));
        data.add(new Pair("K",listK));
        data.add(new Pair("L",listL));
        data.add(new Pair("M",listM));
        data.add(new Pair("N",listN));
        data.add(new Pair("P",listP));
        data.add(new Pair("Q",listQ));
        data.add(new Pair("R",listR));
        data.add(new Pair("S",listS));
        data.add(new Pair("T",listT));
        data.add(new Pair("W",listW));

        data.add(new Pair("X",listX));

        data.add(new Pair("Y",listY));
        data.add(new Pair("Z",listZ));
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
