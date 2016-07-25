package com.example.gift.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gift.R;

import java.util.List;

/**
 * Created by fenghui on 6/9/16.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    public interface OnItemClickListener1{
        void OnItemClick1(View view, int position);
    }
    private OnItemClickListener1 mOnItemClickListener1;
    public void setOnItemClickListener1(OnItemClickListener1 mOnItemClickListener1){
        this.mOnItemClickListener1=mOnItemClickListener1;
    }

    private LayoutInflater mInflater;
    private List<Integer> mData;
    private List<String> tData;
    public PersonAdapter(Context context, List<Integer> mdata, List<String> tdata){
        mInflater=LayoutInflater.from(context);
        this.mData=mdata;
        this.tData=tdata;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ViewHolder(View arg0){
            super(arg0);
        }
        ImageView Img;
        TextView text;
    }
    @Override
    public int getItemCount(){
        return mData.size();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position){
        View view = mInflater.inflate(R.layout.person_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.Img = (ImageView)view.findViewById(R.id.person_image);
        viewHolder.text = (TextView)view.findViewById(R.id.person_text);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i){
        viewHolder.Img.setImageResource(mData.get(i));
        viewHolder.text.setText(tData.get(i));
        if(mOnItemClickListener1!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    mOnItemClickListener1.OnItemClick1(viewHolder.itemView,i);
                }
            });
        }
    }
}
