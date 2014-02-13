package com.canerce.userprofil;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentNumber extends Activity {
	private EditText etNumber; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_number);
        // finding controls
		etNumber = (EditText) findViewById(R.id.etNumber);
		Button btnOK = (Button) findViewById(R.id.btnOK);
		// set event
		etNumber.setText(getIntent().getStringExtra("SNumber"));
		btnOK.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.putExtra("StudentNumber", etNumber.getText().toString()); 
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
	}
}
