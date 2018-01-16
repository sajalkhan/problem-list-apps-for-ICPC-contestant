package com.newdeveloper.onlinejudgeprogramlist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Hard_program_list extends AppCompatActivity {

    ArrayList<String> progrmaList;
    ArrayList<String> programLink;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_program_list);

        listView = (ListView) findViewById(R.id.listview3);
        progrmaList = new ArrayList<>();
        programLink = new ArrayList<>();

        //-------------------------------Read easy problem data from Assets folder------------------
        try {
            InputStream is = getAssets().open("info3.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();

            Log.e(String.valueOf(row), " row");

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Cell z = s.getCell(j, i);
                    progrmaList.add(z.getContents());
                }
            }
        } catch (Exception e) {
            Log.e("problem ache", e.getMessage());
        }
        //----------------------------------------------------------------------------------------//


        //-------------------------------Read easy problem Link from Assets folder------------------
        try {
            InputStream is = getAssets().open("link3.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();

            Log.e(String.valueOf(row), " row");

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Cell z = s.getCell(j, i);
                    programLink.add(z.getContents());
                }
            }
        } catch (Exception e) {
            Log.e("problem ache", e.getMessage());
        }
        //----------------------------------------------------------------------------------------//


        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.row3, R.id.row3, progrmaList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String link = programLink.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });
    }
}
