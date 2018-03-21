package com.example.entern.testapp.poly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.entern.testapp.PersonInfo;
import com.example.entern.testapp.R;

public class PolyActivity extends AppCompatActivity {

    TextView mtextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poly);

        mtextView=findViewById(R.id.tv_Show_Message);

        BaseClass baseClass=new BaseClass();
        ChildClass childOBJ=new ChildClass();
        BaseClass pr = new ChildClass();



        //mtextView.setText(baseClass.TestMethod(10));
        mtextView.setText(pr.TestMethod());



    }
}
