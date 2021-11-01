package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {


	private EditText text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_layout);
		 text = (EditText) findViewById(R.id.editText1);
	}

	public void myClickHandler(View view)
	{
		switch(view.getId())
		{
		case R.id.button1 : RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
							RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
							if(text.getText().length()==0)
							{
								Toast.makeText(this, "Please enter a valid number",
                                        Toast.LENGTH_LONG).show();
									return;
							}
							float inputValue= Float.parseFloat(text.getText().toString());
							if(celsiusButton.isChecked())
							{
								text.setText(String.valueOf(convertftoc(inputValue)));
								celsiusButton.setChecked(false);
								fahrenheitButton.setChecked(true);
							}
							else 
							{
								text.setText(String.valueOf(convertctof(inputValue)));
								fahrenheitButton.setChecked(false);
								celsiusButton.setChecked(true);
								
							}
							break;
							
		}
	}
	
	// Convert F to C 
	private float convertftoc(float f)
	{
		return((f-32)* 5 / 9 );
	}
	private float convertctof(float c)
	{
		return ((c*9)/5) +32;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
