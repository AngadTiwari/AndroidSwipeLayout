package com.daimajia.swipedemo.adapter;

import android.content.Context;
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
import com.daimajia.swipedemo.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseSwipeAdapter {

    private Context mContext;
    private ArrayList<String> data;

    public ListViewAdapter(Context mContext,ArrayList<String> data) {
        this.mContext = mContext;
        this.data=data;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(final int position, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);

        SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));
        final ImageView fav=(ImageView)v.findViewById(R.id.fav);
        final ImageView note=(ImageView)v.findViewById(R.id.note);
        final ImageView visit=(ImageView)v.findViewById(R.id.visit);
        final ImageView map=(ImageView)v.findViewById(R.id.map);

        swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Flash).duration(500).delay(100).playOn(fav);
                YoYo.with(Techniques.Flash).duration(500).delay(100).playOn(note);
                YoYo.with(Techniques.Flash).duration(500).delay(100).playOn(visit);
                YoYo.with(Techniques.Flash).duration(500).delay(100).playOn(map);
            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav.setSelected( !fav.isSelected());
                data.remove(position);
                notifyDataSetChanged();
            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setSelected(!note.isSelected());
            }
        });
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visit.setSelected(!visit.isSelected());
            }
        });
        fav.setSelected(false);
        note.setSelected(false);
        visit.setSelected(false);
        return v;
    }

    @Override
    public void fillValues(int position, View convertView) {
        TextView t = (TextView)convertView.findViewById(R.id.position);
        t.setText(data.get(position));
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
}
