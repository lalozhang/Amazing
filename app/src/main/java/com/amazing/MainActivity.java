package com.amazing;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amazing.adapters.ItemAdapter;
import com.amazing.amzing.AmazingListView;
import com.amazing.amzing.SideIndex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements ItemAdapter.OnItemPerformanceListener {
    private RelativeLayout rlMain;
    private AmazingListView listView;
    private ItemAdapter itemAdapter;
    private SideIndex sideIndex;
    private TextView letter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlMain= (RelativeLayout) findViewById(R.id.rlMain);
        letter= (TextView) findViewById(R.id.tv_letter);
        listView= (AmazingListView) findViewById(R.id.listView);
        listView.setPinnedHeaderView(LayoutInflater.from(this).inflate(R.layout.item_header,listView,false));
        itemAdapter=new ItemAdapter(this,getCityData());
        listView.setAdapter(itemAdapter);

        itemAdapter.setOnItemPerformanceListener(this);
        sideIndex= (SideIndex) findViewById(R.id.sideIndex);
        rlMain.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                sideIndex.setCenterLetterText(letter);
                sideIndex.genIndexBar(MainActivity.this,listView,0xff1ba9ba,13);
                rlMain.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });

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
        String[] arrW=new String[]{"威海","无锡","武汉","吴中","万州","芜湖","武昌"};
        String[] arrX=new String[]{"西安","西宁","襄阳","新乡","盱眙","兴城","邢台","西昌","锡林郭勒"};
        String[] arrY=new String[]{"烟台","扬州","伊犁","延安","雅安","雁荡山","沂蒙山","宜兴","银川"};
        String[] arrZ=new String[]{"张家界","枣庄","庄河","驻马店","漳州","张家港","张家口","涿州","郑州","湛江","肇庆","珠海","遵义","舟山","张掖","中卫"};
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
    public void onItemBodyClick(int position, View convertView, ViewGroup parent, String section) {
        String city = itemAdapter.getItem(position);
        Toast.makeText(this,city,Toast.LENGTH_SHORT).show();
    }
}
