package com.example.apple.bottomsheetdialogdemo;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherBottomDialogActivity extends AppCompatActivity {

    private Button mShowBottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_bottom_dialog);
        View design_bottom_sheet= findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(design_bottom_sheet);
        //默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mShowBottomSheet = (Button) findViewById(R.id.button);
        mShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(behavior);
            }
        });

    }

    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            mShowBottomSheet.setText("隐藏");
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            mShowBottomSheet.setText("显示");
        }
    }

}
