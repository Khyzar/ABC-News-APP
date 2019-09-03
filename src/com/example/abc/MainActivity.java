package com.example.abc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView v=(ImageView)findViewById(R.id.imageView1);
        v.setImageResource(R.drawable.abc_start);
        TextView text=(TextView)findViewById(R.id.textView1);
        ProgressBar p=(ProgressBar)findViewById(R.id.progressBar1);
        new PostTask(this,text,p).execute();
      //  Intent i=new Intent(this,Main_interface.class);
    //	startActivity(i);
        
    }
   


}
