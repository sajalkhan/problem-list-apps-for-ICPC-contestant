package com.newdeveloper.onlinejudgeprogramlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void easy(View view) {
        Intent intent=new Intent(MainActivity.this,EasyProgramList.class);
        startActivity(intent);
    }

    public void medium(View view) {
        Intent intent=new Intent(MainActivity.this,medium_program_list.class);
        startActivity(intent);
    }

    public void hard(View view) {
        Intent intent=new Intent(MainActivity.this,Hard_program_list.class);
        startActivity(intent);
    }
}
