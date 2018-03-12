package com.tajal.user.databasesqliteassainment;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2,e3,e4;
    private Button btn;
    private mysqlite my;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.tajal);
        e2=(EditText) findViewById(R.id.sopnil);
        e3=(EditText) findViewById(R.id.ridoy);
        e4=(EditText) findViewById(R.id.royet);
        btn=(Button) findViewById(R.id.kajal);
        txt=(TextView) findViewById(R.id.Sabina);
        my=new mysqlite(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkers=my.addtoTable(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString());

                if(checkers==true){
                    Toast.makeText(MainActivity.this,"Sucsessfull inserted",Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(MainActivity.this,"Unsucsessfull inserted",Toast.LENGTH_LONG).show();
                }
            }
        });}
    public void viewdata(View view){
        Cursor res=my.display();
        if(res.getCount()==0){
            Toast.makeText(this,"No dat found",Toast.LENGTH_LONG).show();
            return;}
            res.moveToFirst();
        StringBuffer buffer=new StringBuffer();
        do {
            buffer.append(" ID " + res.getString(0) + "\n");
            buffer.append(" Frist_name " + res.getString(1) + "\n");
            buffer.append(" Last_name " + res.getString(2) + "\n");
            buffer.append(" Email " + res.getString(3) + "\n");
        }while (res.moveToNext());
       Display(buffer.toString());
}
public void Display(String data){
        txt.setText(data);
}




}
