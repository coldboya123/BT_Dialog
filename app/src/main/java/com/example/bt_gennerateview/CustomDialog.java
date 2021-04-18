package com.example.bt_gennerateview;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.List;

public class CustomDialog {
    private static Dialog dialog = null;
    private static LinearLayout linear, linear1;

    private static List<String> list = new ArrayList<>();
    public static void CreateDialog(Context context, Handle handle){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog_layout);
        AppCompatButton btn_addorder = dialog.findViewById(R.id .btn_addorder);
        AppCompatButton btn_submit = dialog.findViewById(R.id.btn_submit);
        AppCompatButton btn_add = dialog.findViewById(R.id.btn_add);
        AppCompatButton btn_del = dialog.findViewById(R.id.btn_del);
        EditText txtorder = dialog.findViewById(R.id.txtorder);
        linear = dialog.findViewById(R.id.linear);
        linear1 = dialog.findViewById(R.id.linear1);

        btn_addorder.setOnClickListener(v -> {
            CreateView(context);
        });

        btn_submit.setOnClickListener(v -> {
            handle.onSubmit(list);
            dialog.hide();
        });

        btn_add.setOnClickListener(v ->{
            onAdd(txtorder, btn_add, btn_del, context);
        });

        btn_del.setOnClickListener(v -> {
            onDel(linear1);
        });

        dialog.show();
    }

    private static void CreateView(Context context){
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setHorizontalGravity(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);

        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        EditText editText = new EditText(context);
        editText.setHint("Order");
        editText.setLayoutParams(layoutParams1);

        AppCompatButton mbtnadd = new AppCompatButton(context);
        mbtnadd.setText("+");
        mbtnadd.setTextSize(20);

        AppCompatButton mbtndel = new AppCompatButton(context);
        mbtndel.setText("-");
        mbtndel.setTextSize(20);
        mbtndel.setVisibility(View.GONE);

        linearLayout.addView(editText);
        linearLayout.addView(mbtnadd);
        linearLayout.addView(mbtndel);
        mbtnadd.setOnClickListener(v -> onAdd(editText, mbtnadd, mbtndel, context));
        mbtndel.setOnClickListener(v -> onDel(linearLayout));
        linear.addView(linearLayout);
    }

    private static void onAdd(EditText editText, AppCompatButton btnadd, AppCompatButton btndel, Context context){
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(context, "Khong duoc de trong!", Toast.LENGTH_SHORT).show();
        } else {
            list.add(editText.getText().toString().trim());
            editText.setEnabled(false);
            btndel.setVisibility(View.VISIBLE);
            btnadd.setVisibility(View.GONE);
        }
    }

    private static void onDel(LinearLayout linearLayout){
        linearLayout.removeAllViews();
    }
}
