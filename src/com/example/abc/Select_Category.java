package com.example.abc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Select_Category extends Activity {
	 
	@Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
     setContentView(R.layout.select_category);
	}
	
	public void goback(View v)
	{
		CheckBox c1=(CheckBox)findViewById(R.id.checkBox1);
		CheckBox c2=(CheckBox)findViewById(R.id.checkBox2);
		CheckBox c3=(CheckBox)findViewById(R.id.checkBox3);
		CheckBox c4=(CheckBox)findViewById(R.id.checkBox4);
		CheckBox c5=(CheckBox)findViewById(R.id.checkBox5);
		//CheckBox c6=(CheckBox)findViewById(R.id.checkBox6);
		Intent i=this.getIntent();
		if(c1.isChecked())
			i.putExtra("c1", true);
		if(c2.isChecked())
			i.putExtra("c2", true);
		if(c3.isChecked())
			i.putExtra("c3", true);
		if(c4.isChecked())
			i.putExtra("c4", true);
		if(c5.isChecked())
			i.putExtra("c5", true);
		this.setResult(RESULT_OK, i);
		finish();	
	}
	
}
