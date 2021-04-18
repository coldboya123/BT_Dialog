package com.example.bt_gennerateview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handle{

    Button btn;
    ListView listView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn.setOnClickListener(v -> {
            CustomDialog.CreateDialog(this, this);
        });

    }

    private void init() {
        btn = findViewById(R.id.btn);
        listView = findViewById(R.id.listview);
        title = findViewById(R.id.title);
    }

    @Override
    public void onSubmit(List<String> list) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
        title.setVisibility(View.VISIBLE);
    }
}