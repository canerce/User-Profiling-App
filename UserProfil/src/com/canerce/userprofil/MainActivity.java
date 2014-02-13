package com.canerce.userprofil;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	private EditText etName;
	private TextView tvNumber;
	private String Number = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // finding controls
        TextView tvDate = (TextView) findViewById(R.id.tvDate); 
        tvNumber = (TextView) findViewById(R.id.tvNumber); 
        etName = (EditText) findViewById(R.id.etName); 
        Button btnHello = (Button) findViewById(R.id.btnHello);
        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        Button btnGetNumber = (Button) findViewById(R.id.btnGetNumber);
        // set Date
        tvDate.setText( new SimpleDateFormat("dd MMMM yyyy - EEEE", Locale.getDefault()).format(new Date()));
        // set Events to Buttons
        btnHello.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast toast= Toast.makeText(getApplicationContext(),getString(R.string.welcome) + " \r\n" + etName.getText().toString(),Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
				toast.show();
			}
		});
        btnAbout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), About.class);
			    startActivity(intent);
			}
		});
        btnGetNumber.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), StudentNumber.class);
				if(Number.length() > 0) { intent.putExtra("SNumber", Number);}
				startActivityForResult(intent,2);
		
			}
		});
       
        
    }
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data)
    {
        if (resCode == RESULT_OK && reqCode == 2)
        {
            Number = data.getStringExtra("StudentNumber");
            tvNumber.setText(getString(R.string.your_number) + " " + Number );
            
        }
    }
    // Cleaning Time on exit
    // delete cache and data
    @Override
    protected void onDestroy() {
       super.onDestroy();
       File dir = getCacheDir().getParentFile();
       if (dir != null && dir.isDirectory()) {
          deleteDir(dir);
       }
    }
    public static boolean deleteDir(File dir) {
       if (dir != null && dir.isDirectory()) {
          String[] children = dir.list();
          for (int i = 0; i < children.length; i++) {
        	  if (!children[i].equals("lib")) {			
             boolean success = deleteDir(new File(dir, children[i]));
             if (!success) return false;}
          }
       }
       return dir.delete();
    }
}
