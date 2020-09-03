package com.example.grid_view_damo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customadapter extends BaseAdapter {
    Context contex;
    int [] flags;
    String [] countryname;
    private LayoutInflater inflater;

    customadapter(Context contex,String [] countryname, int [] flags)
    {
        this.contex=contex;
        this.countryname= countryname;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return countryname.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            inflater = (LayoutInflater) contex.getSystemService(contex.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.sample_view,parent,false);
        }

        ImageView imageview= (ImageView)convertView.findViewById(R.id.imageviewid);
        TextView textview = (TextView)convertView.findViewById(R.id.textviewid);

        imageview.setImageResource(flags[position]);
        textview.setText(countryname[position]);

        return convertView;
    }
}
