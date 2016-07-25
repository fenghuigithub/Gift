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
 * Created by fenghui on 6/8/16.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    private LayoutInflater mInflater;
    private List<Integer> mData;
    private List<String> tData;
    public GalleryAdapter(Context context, List<Integer> mdata,List<String> tdata){
        mInflater=LayoutInflater.from(context);
        mData=mdata;
        tData = tdata;
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
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View view=mInflater.inflate(R.layout.gallery_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.Img=(ImageView)view.findViewById(R.id.gallery_image);
        viewHolder.text=(TextView)view.findViewById(R.id.gallery_text);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i){
        viewHolder.Img.setImageResource(mData.get(i));
        viewHolder.text.setText(tData.get(i));
        if(mOnItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(viewHolder.itemView,i);
                }
            });
        }
    }


}
