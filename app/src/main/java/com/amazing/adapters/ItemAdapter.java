package com.amazing.adapters;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amazing.R;
import com.amazing.amzing.BaseAmazingAdapter;

import java.util.List;

/**
 * Created by lalo.zhang on 2015/8/27.
 */
public class ItemAdapter extends BaseAmazingAdapter<String> {
    private Context context;
    private OnItemPerformanceListener l;
    public ItemAdapter(Context context,List<Pair<String, List<String>>> data){
        this.data=data;
        this.context=context;
    }

    @Override
    protected void bindSectionHeader(View view, int position, String section, boolean displaySectionHeader) {
        View header = view.findViewById(R.id.ll_header);
        TextView lSectionHeader= (TextView) header.findViewById(R.id.tv_city);
        if(displaySectionHeader){
            header.setVisibility(View.VISIBLE);
            lSectionHeader.setText(section);
        }else{
            header.setVisibility(View.GONE);
        }

    }

    @Override
    public View getAmazingView(final int position, View convertView, final ViewGroup parent, final String section) {
        ViewHolder holder;
        if (convertView==null) {
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.city_item_view,null);
            holder.city= (TextView) convertView.findViewById(R.id.tv_city_name);
            convertView.setTag(holder);

        }else{
            holder=(ViewHolder)convertView.getTag();
        }

        holder.city.setText(getItem(position));

        final View finalConvertView = convertView;
        holder.city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.onItemBodyClick(position, finalConvertView,parent,section);
            }
        });
        return convertView;
    }


    private static class ViewHolder{
        public TextView city;
    }

    @Override
    protected void configurePinnedHeader(View header, int position, String section, int alpha) {
        if(header!=null){
            TextView lSectionHeader=(TextView) header.findViewById(R.id.tv_city);
            lSectionHeader.setText(section);
//            lSectionHeader.setBackgroundColor(alpha << 24 | 0xf4f4f4);
//            lSectionHeader.setTextColor(alpha << 24 | 0x666666);
        }
    }

    public  void setOnItemPerformanceListener(OnItemPerformanceListener l){
        this.l=l;
    }

    public interface OnItemPerformanceListener{
        void onItemBodyClick(int position, View convertView, ViewGroup parent, String section);

    }
}
