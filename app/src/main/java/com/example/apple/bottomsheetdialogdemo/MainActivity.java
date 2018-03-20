package com.example.apple.bottomsheetdialogdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.apple.bottomsheetdialogdemo.adapter.BottomRecyclerViewDialogAdapter;
import com.example.apple.bottomsheetdialogdemo.callback.OnItemClickListener;
import com.example.apple.bottomsheetdialogdemo.databinding.ActivityMainBinding;
import com.example.apple.bottomsheetdialogdemo.databinding.ViewBottomDialogBinding;
import com.example.apple.bottomsheetdialogdemo.databinding.ViewBottomRecyclerviewDialogBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    BottomSheetDialog  view_bottom_dialog;
    BottomSheetDialog  view_bottom_recyclerview_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityMainBinding activityMainBinding =
               DataBindingUtil.setContentView(this,R.layout.activity_main);
       activityMainBinding.btn1.setOnClickListener(this);
       activityMainBinding.btn2.setOnClickListener(this);
       activityMainBinding.btn3.setOnClickListener(this);
       LayoutInflater inflater = LayoutInflater.from(this);
       ViewBottomDialogBinding viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.view_bottom_dialog,null,false);
        viewDataBinding.tvCall.findViewById(R.id.tv_call).setOnClickListener(this);
        viewDataBinding.tvCamera.findViewById(R.id.tv_camera).setOnClickListener(this);
       view_bottom_dialog =new BottomSheetDialog(this);
       view_bottom_dialog.setContentView(viewDataBinding.getRoot());
       view_bottom_dialog.setCanceledOnTouchOutside(false);


       final ViewBottomRecyclerviewDialogBinding view_bottom_recyclerview= DataBindingUtil.inflate(inflater,R.layout.view_bottom_recyclerview_dialog,null,false);

        view_bottom_recyclerview.recyclerview.setItemAnimator(new DefaultItemAnimator());
        view_bottom_recyclerview.recyclerview.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));


        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 40; i++) {
            list.add("====="+ i+"=====");
        }
       BottomRecyclerViewDialogAdapter adapter =new BottomRecyclerViewDialogAdapter(this,list);
        view_bottom_recyclerview.recyclerview.setLayoutManager( new LinearLayoutManager(this));
        view_bottom_recyclerview.recyclerview.setAdapter(adapter);
        adapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(MainActivity.this,"点击了"+position,Toast.LENGTH_LONG).show();
               view_bottom_recyclerview_dialog.dismiss();
            }
        });
       view_bottom_recyclerview_dialog =new BottomSheetDialog(this);

       view_bottom_recyclerview_dialog.setContentView(view_bottom_recyclerview.getRoot());
       view_bottom_recyclerview_dialog.setCanceledOnTouchOutside(false);


    }

    @Override
    public void onClick(View view) {
       int viewId= view.getId();
       switch (viewId){
           case R.id.btn1:
               view_bottom_dialog.show();
               break;
           case  R.id.btn2:
               view_bottom_recyclerview_dialog.show();
               break;
           case R.id.btn3:
               startActivity(new Intent(MainActivity.this,OtherBottomDialogActivity.class));
               break;
           case R.id.tv_call:
                 view_bottom_dialog.dismiss();
               break;
           case R.id.tv_camera:
               view_bottom_dialog.dismiss();
               break;
       }
    }
}
