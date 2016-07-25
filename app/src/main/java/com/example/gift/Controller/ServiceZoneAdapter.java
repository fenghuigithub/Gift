package com.example.gift.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gift.R;
import com.example.gift.View.detail_list;

import java.util.List;

/**
 * Created by fenghui on 6/18/16.
 */
public class ServiceZoneAdapter extends BaseAdapter
{
    /**
     * Get view from xml layout.
     */
    private LayoutInflater mInflater     = null;
    /**
     * A list to encapsulate servcie information.
     */
    private List<String> mServiceBeans = null;

    public ServiceZoneAdapter(Context c, List<String> serviceBeans)
    {
        this.mServiceBeans = serviceBeans;
        this.mInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    /**
     * Get list's size.
     *
     * @return the size of list.
     */
    public int getCount()
    {
        return mServiceBeans == null ? 0 : mServiceBeans.size();
    }
    /**
     * Get item.
     *
     * @param position
     * @return the item according to the position.
     */
    public Object getItem(int position)
    {
        return mServiceBeans == null ? null : mServiceBeans.get(position);
    }

    /**
     * Get id.
     *
     * @param position
     * @return the item's id according to the position.
     */
    public long getItemId(int position)
    {
        return position;
    }
    /**
     * Get item's view.
     *
     * @return the item view according to the position.
     */
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            if (detail_list.isGridView)
            {
                convertView = mInflater.inflate(R.layout.grid_view, parent, false);
            }
            else
            {
                convertView = mInflater.inflate(R.layout.list_view, parent, false);
            }
        }
        String service = (String)getItem(position);
        if (service == null)
        {
            return convertView;
        }
//        ImageView imageView = (ImageView)convertView.findViewById(R.id.app_icon);
        TextView text = (TextView)convertView.findViewById(R.id.app_name);
//        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        imageView.setImageResource(service.getIconId());
        text.setText(service);
        return convertView;
    }


}
