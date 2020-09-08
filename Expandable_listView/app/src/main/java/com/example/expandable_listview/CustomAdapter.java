package com.example.expandable_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {
    private Context context;
    List<String> listdataheader;
    HashMap<String,List<String>> chielddata;

    public CustomAdapter(Context context, List<String> listdataheader, HashMap<String, List<String>> chielddata) {
        this.context = context;
        this.listdataheader = listdataheader;
        this.chielddata = chielddata;
    }

    @Override
    public int getGroupCount() {
        return listdataheader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return chielddata.get(listdataheader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listdataheader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return chielddata.get(listdataheader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String Headtext = (String) getGroup(groupPosition);

        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_layout,null);
        }
        TextView text = convertView.findViewById(R.id.textgroupid);
        text.setText(Headtext);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String chieldtext = (String) getChild(groupPosition,childPosition);

        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chield_layout,null);
        }
        TextView text = convertView.findViewById(R.id.childlayoutid);
        text.setText(chieldtext);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
