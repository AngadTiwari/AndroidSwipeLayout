package com.daimajia.swipedemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;
import com.daimajia.swipedemo.Model;
import com.daimajia.swipedemo.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseSwipeAdapter {

    private Context mContext;
    private ArrayList<Model> data;

    public ListViewAdapter(Context mContext,ArrayList<Model> data) {
        this.mContext = mContext;
        this.data=data;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, null);

            viewHolder=new ViewHolder();
            viewHolder.dataview=(TextView)convertView.findViewById(R.id.position);

            //SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));
            viewHolder.fav=(ImageView)convertView.findViewById(R.id.fav);
            viewHolder.note=(ImageView)convertView.findViewById(R.id.note);
            viewHolder.visit=(ImageView)convertView.findViewById(R.id.visit);

            viewHolder.favsmall=(ImageView)convertView.findViewById(R.id.favsmall);
            viewHolder.notesmall=(ImageView)convertView.findViewById(R.id.notesmall);
            viewHolder.visitsmall=(ImageView)convertView.findViewById(R.id.visitsmall);

            viewHolder.fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean selection = view.isSelected();
                    data.get(position).setIsSelection1(!selection);
                    notifyDataSetChanged();
                }
            });
            viewHolder.note.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean selection = view.isSelected();
                    data.get(position).setIsSelection2(!selection);
                    notifyDataSetChanged();
                }
            });
            viewHolder.visit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean selection = view.isSelected();
                    data.get(position).setIsSelection3(!selection);
                    notifyDataSetChanged();
                }
            });
            viewHolder.setId(position);

            convertView.setTag(viewHolder);
        }
        else
        {
            if(((ViewHolder)convertView.getTag()).getId()!=position)
            {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_item, null);

                viewHolder=new ViewHolder();
                viewHolder.dataview=(TextView)convertView.findViewById(R.id.position);

                //SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));
                viewHolder.fav=(ImageView)convertView.findViewById(R.id.fav);
                viewHolder.note=(ImageView)convertView.findViewById(R.id.note);
                viewHolder.visit=(ImageView)convertView.findViewById(R.id.visit);

                viewHolder.favsmall=(ImageView)convertView.findViewById(R.id.favsmall);
                viewHolder.notesmall=(ImageView)convertView.findViewById(R.id.notesmall);
                viewHolder.visitsmall=(ImageView)convertView.findViewById(R.id.visitsmall);

                viewHolder.fav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean selection = view.isSelected();
                        data.get(position).setIsSelection1(!selection);
                        notifyDataSetChanged();
                    }
                });
                viewHolder.note.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean selection = view.isSelected();
                        data.get(position).setIsSelection2(!selection);
                        notifyDataSetChanged();
                    }
                });
                viewHolder.visit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean selection = view.isSelected();
                        data.get(position).setIsSelection3(!selection);
                        notifyDataSetChanged();
                    }
                });
                viewHolder.setId(position);

                convertView.setTag(viewHolder);
            }
            else
            {
                viewHolder=(ViewHolder)convertView.getTag();
            }
        }

        viewHolder.dataview.setText(data.get(position).getText());

        viewHolder.fav.setSelected(data.get(position).isSelection1());
        viewHolder.note.setSelected(data.get(position).isSelection2());
        viewHolder.visit.setSelected(data.get(position).isSelection3());

        viewHolder.favsmall.setVisibility(data.get(position).isSelection1() ? View.VISIBLE : View.GONE);
        viewHolder.notesmall.setVisibility(data.get(position).isSelection2() ? View.VISIBLE : View.GONE);
        viewHolder.visitsmall.setVisibility(data.get(position).isSelection3() ? View.VISIBLE : View.GONE);

        return convertView;
    }

    @Override
    public void fillValues(int position, View convertView) {
        /*TextView t = (TextView)convertView.findViewById(R.id.position);
        t.setText(data.get(position));*/
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder
    {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;
        TextView dataview;
        ImageView fav,note,visit;
        ImageView favsmall,notesmall,visitsmall;
    }
}
