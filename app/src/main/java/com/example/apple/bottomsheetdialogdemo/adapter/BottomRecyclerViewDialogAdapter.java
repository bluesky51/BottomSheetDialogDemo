package com.example.apple.bottomsheetdialogdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple.bottomsheetdialogdemo.R;
import com.example.apple.bottomsheetdialogdemo.callback.OnItemClickListener;
import com.example.apple.bottomsheetdialogdemo.callback.OnItemLongClickListener;
import com.example.apple.bottomsheetdialogdemo.databinding.ViewItemRecyclerivewBinding;

import java.util.List;

/**
 * Created by bluesky on 2018/3/20.
 */

public class BottomRecyclerViewDialogAdapter extends RecyclerView.Adapter {
    private List<String> mList;
    private LayoutInflater mInflater;
    private Context mContext;
    private static  ViewItemRecyclerivewBinding itemBindbing;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    public BottomRecyclerViewDialogAdapter(Context context, List<String> list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setmOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemBindbing =DataBindingUtil.inflate(mInflater, R.layout.view_item_recyclerivew,parent,false);
        return new MyViewHolder(itemBindbing.getRoot());
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder =(MyViewHolder)holder;
        myViewHolder.text.setText("第"+position+"条数据");
        myViewHolder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClickListener(holder.getAdapterPosition());
                }
            }
        });
        myViewHolder.text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOnItemLongClickListener!=null){
                    mOnItemLongClickListener.onItemLongClickListener(holder.getAdapterPosition());
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private  static  class  MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
             text=  itemBindbing.itemTextview;


        }
    }
}
