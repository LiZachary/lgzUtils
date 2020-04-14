package com.zachary.util;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zachary.lgzutil.view.dialog.BaseDialog;
import com.zachary.lgzutil.view.dialog.MenuDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe：显示底部弹出框
 * Created by Zachary on 2020/04/14.
 */
public class MainActivity extends AppCompatActivity {

    private Button showBottomDialog;
    private MainActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;

        showBottomDialog = findViewById(R.id.btn_show_bottom_dialog);
        showBottomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 展示弹出框
                showDialog();
            }
        });
    }

    public void showDialog() {

        List<String> data = new ArrayList<>();
        data.add("相册");
        data.add("拍照");
        data.add("视频");

        // 底部选择框
        new MenuDialog.Builder(mActivity)
                // 设置 null 表示不显示取消按钮
                .setCancel(getString(R.string.cancel))
                // 设置点击按钮后不关闭对话框
                //.setAutoDismiss(false)
                .setList(data)
                .setListener(new MenuDialog.OnListener<String>() {
                    @Override
                    public void onSelected(BaseDialog dialog, int position, String string) {
                        Toast.makeText(mActivity, "position:" + position + ",内容：" + string, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(BaseDialog dialog) {
                        Toast.makeText(mActivity, getString(R.string.cancel), Toast.LENGTH_SHORT).show();
                    }
                })
                .setTitle(getString(R.string.prompt))
                .show();
    }
}
