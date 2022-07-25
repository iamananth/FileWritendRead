package com.example.filewriteread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.e1);
        et2 = (EditText) findViewById(R.id.e2);
    }
    public void onSave(View view) throws IOException {
        FileOutputStream fout;
        fout = openFileOutput(et1.getText().toString(),0);
        OutputStreamWriter osw = new OutputStreamWriter(fout);
        osw.write(et2.getText().toString());
        osw.flush();
        osw.close();
    }
    public void onRead(View v) throws IOException {
        FileInputStream fin;
        fin = openFileInput(et1.getText().toString());
        InputStreamReader isw = new InputStreamReader(fin);
        char []b = new char[20];
        int n = isw.read(b,0,20);
        String str = new String(b,0,n);
        et2.setText(str);
        isw.close();
    }
}