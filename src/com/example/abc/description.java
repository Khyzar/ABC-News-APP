package com.example.abc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class description extends Activity {
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
     setContentView(R.layout.desp);
     Intent i=getIntent();
     String t=i.getStringExtra("title");
     String da=i.getStringExtra("date");
     String de=i.getStringExtra("description");
    String img_url=i.getStringExtra("image");
     
    ImageView imagee=(ImageView)findViewById(R.id.imageView1);
    new DownloadImageTask(imagee,img_url).execute();
    
     TextView te=(TextView)findViewById(R.id.textView1);
     te.setText(t);
     TextView date=(TextView)findViewById(R.id.textView2);
     date.setText(da);
     TextView des=(TextView)findViewById(R.id.textView3);
     des.setText(de);
	 }
}
