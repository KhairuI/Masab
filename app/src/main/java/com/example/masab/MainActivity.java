package com.example.masab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button button;
    private LinearLayout linearLayout;
    private EditText nameEditText,idEditText,semesterEditText;
    private TextView sGPA;
    private List<Model> modelList;
    private List<Model> modelList2;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findSection();
        setData1();
        setData2();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id= idEditText.getText().toString();
                if(id.equals("1")){
                    linearLayout.setVisibility(View.VISIBLE);
                    adapter= new MyAdapter(modelList);
                    recyclerView.setAdapter(adapter);

                }
                else if(id.equals("2")){
                    linearLayout.setVisibility(View.VISIBLE);
                    adapter= new MyAdapter(modelList2);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }

    private void setData1() {
        modelList= new ArrayList<>();
        modelList.add(new Model("CSE111","3.50"));
        modelList.add(new Model("CSE112","3.25"));
        modelList.add(new Model("CSE113","3.75"));
        modelList.add(new Model("CSE114","3.00"));
        modelList.add(new Model("CSE114","3.00"));

    }
    private void setData2() {
        modelList2= new ArrayList<>();
        modelList2.add(new Model("CSE311","3.50"));
        modelList2.add(new Model("CSE312","2.25"));
        modelList2.add(new Model("CSE313","3.75"));
        modelList2.add(new Model("CSE314","3.50"));
        modelList2.add(new Model("CSE314","3.50"));

    }

    private void findSection() {
        recyclerView=findViewById(R.id.recycleViewId);
        button= findViewById(R.id.resultButtonId);
        linearLayout= findViewById(R.id.bottomLinear);
        linearLayout.setVisibility(View.INVISIBLE);
        nameEditText= findViewById(R.id.nameEditTextId);
        idEditText= findViewById(R.id.idTextId);
        semesterEditText= findViewById(R.id.semesterEditTextId);
        sGPA= findViewById(R.id.sgpaId);
    }
}