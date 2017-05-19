package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dialog.DateChooseWheelViewDialog;

public class MainActivity extends AppCompatActivity {

    private String strDate;
    private String strtime;
    private String strDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListener();
    }

    private void initListener() {
        // 日期 格式 yyyy-MM-dd
        ((TextView) findViewById(R.id.tv_date)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(MainActivity.this,
                        new DateChooseWheelViewDialog.DateChooseInterface() {
                            @Override
                            public void getDateTime(String time, boolean longTimeChecked) {
                                strDate = time;
                                ((TextView) findViewById(R.id.tv_date)).setText(strDate);
                            }
                        });
                endDateChooseDialog.setTimePickerGone(true);
                endDateChooseDialog.setDateDialogTitle("自定义标题部分");
                endDateChooseDialog.showDateChooseDialog();
            }
        });

        //时间
        ((TextView) findViewById(R.id.tv_time)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(MainActivity.this,
                        new DateChooseWheelViewDialog.DateChooseInterface() {
                            @Override
                            public void getDateTime(String time, boolean longTimeChecked) {
                                strtime = time;
                                ((TextView) findViewById(R.id.tv_time)).setText(strtime);
                            }
                        });
                endDateChooseDialog.setTimePickerGone(false);
                endDateChooseDialog.setDateDialogTitle("自定义标题部分");
                endDateChooseDialog.showDateChooseDialog();
            }
        });
    }
}
