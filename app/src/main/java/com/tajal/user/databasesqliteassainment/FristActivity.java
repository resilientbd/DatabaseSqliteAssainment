package com.tajal.user.databasesqliteassainment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FristActivity extends AppCompatActivity implements View.OnClickListener{
    private Button attendanceId,resultId;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        attendanceId=(Button)findViewById(R.id.attandanceid);
        resultId=(Button)findViewById(R.id.resultid);
        attendanceId.setOnClickListener(this);
        resultId.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.attandanceid){
          intent=new Intent(FristActivity.this,MainActivity.class);
          startActivity(intent);
        }
        if(view.getId()==R.id.resultid){
          intent=new Intent(FristActivity.this,ResultActivity.class);
          startActivity(intent);
        }

    }
}
