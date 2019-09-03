package com.example.abc;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main_interface extends Activity {
	
	ArrayList<MyDataClass> boj=new ArrayList<MyDataClass>();
	 ArrayList<String> urls=new ArrayList<String>();
	 ArrayList<Boolean> checks=new ArrayList<Boolean>();
	 ListView lv;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_interface);
        //getApplication().setTheme(android.R.style.Theme_Holo_Light); 
        lv=(ListView)findViewById(R.id.listView1);
        String url="http://mcs.geo.tv/jang/jang.xml";
        urls.add(url);
        checks.add(0,true);
        checks.add(1,false);
        checks.add(2,false);
        checks.add(3,false);
        checks.add(4,false);
        checks.add(5,false);
        //urls.add("http://mcs.geo.tv/GeoUrdu/geo_pakistan.xml");
    //	checks.add(1,true);
        ProgressBar s=(ProgressBar)findViewById(R.id.progressBar1);
        TextView text=(TextView)findViewById(R.id.textView10);
        ImageView upper_img=(ImageView)findViewById(R.id.imageView2);
        TextView upper_text=(TextView)findViewById(R.id.textView1);
        TextView upper_date=(TextView)findViewById(R.id.textView2);
        new RSSAsync(lv,urls,this,s,text,upper_img,upper_text,upper_date,checks).execute();
       
       // String text=" :asfsafadasfasdsafsafasdsafsa ";
//        for(int i=0; i<boj.size(); i++)
//        {
//        	text=text+boj.get(i).getTitle()+": ";
//        }
       // TextView t=(TextView)findViewById(R.id.textView10);
        //t.setText(text);
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.upper_menu, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.unread_news:
	        {
	        		allocate_news();
	        		return true;
	        }
	        case R.id.action_refresh:
	        {
	        	finish();
    	        startActivity(getIntent());
    	        return true;
	        }
	            
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void allocate_news()
	{
			Context c=this.getApplicationContext();
			
	   	 //	String t="adasfas";
	   	 	Intent i=new Intent(c,Saved_news.class);
	   		//i.putExtra("temp", t);
	   	 	//i.putExtra("saved news", new DataWrapper(contactList));
	   	 //	i.putParcelableArrayListExtra("saved news", (ArrayList<? extends Parcelable>) contactList);
	   	 	startActivity(i);
		
	}
	
	public void add_category(View v)
	{
		Intent i=new Intent(this,Select_Category.class);
    	startActivityForResult(i, 1);
	}
	
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	    {
		
	        switch(requestCode) {
	        case 1:
	            if (resultCode == RESULT_OK) {
	                Bundle res = data.getExtras();
	                Boolean check1=res.getBoolean("c1");
	                Boolean check2=res.getBoolean("c2");
	                Boolean check3=res.getBoolean("c3");
	                Boolean check4=res.getBoolean("c4");
	                Boolean check5=res.getBoolean("c5");
	                if(check1)
	                {
	                	urls.add("http://mcs.geo.tv/GeoUrdu/geo_pakistan.xml");
	                	checks.add(1,check1);
	                }
	                if(check2)
	               	{
	                	urls.add("http://mcs.geo.tv/GeoUrdu/geo_world.xml");
	                	checks.add(2,check2);
	               	}
	               	if(check3)
	               	{
	                	urls.add("http://mcs.geo.tv/GeoUrdu/geo_business.xml");
	                	checks.add(3,check3);
	               	}
	               	if(check4)
	               	{
	                	urls.add("http://mcs.geo.tv/GeoUrdu/geo_sports.xml");
	                	checks.add(4,check4);
	               	}
	               	if(check5)
	               	{
	                	urls.add("http://mcs.geo.tv/GeoUrdu/geo_Entertainment.xml");
	                	checks.add(5,check5);
	               	}
	                ProgressBar s=(ProgressBar)findViewById(R.id.progressBar1);
	                TextView text=(TextView)findViewById(R.id.textView10);
	                ImageView upper_img=(ImageView)findViewById(R.id.imageView2);
	                TextView upper_text=(TextView)findViewById(R.id.textView1);
	                TextView upper_date=(TextView)findViewById(R.id.textView2);
	                new RSSAsync(lv,urls,this,s,text,upper_img,upper_text,upper_date,checks).execute();
	            
	            
	            }
	            break;
	        }
	    }
	
	public void show()
	{
		
		 String text=" : ";
	        for(int i=0; i<boj.size(); i++)
	        {
	        	text=text+boj.get(i).getTitle()+": ";
	        }
	        TextView t=(TextView)findViewById(R.id.textView10);
	        t.setText(text);
	}
	
	public void set_data(ArrayList<MyDataClass> temp)
	{
		boj=temp;
	}
	
	

}
