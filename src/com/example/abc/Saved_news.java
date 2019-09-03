package com.example.abc;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Saved_news extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_news);
       // Intent i=getIntent();
        Context c=getApplicationContext();
       // DataWrapper dw = (DataWrapper) i.getSerializableExtra("saved news");
      //  ArrayList<MyDataClass> list = i.getParcelableArrayListExtra("saved news");
        DatabaseHandler obj=new DatabaseHandler(c);
   	 	//ArrayList<MyDataClass> data=new ArrayList<MyDataClass>();
        ArrayList<MyDataClass> contactList = new ArrayList<MyDataClass>();
   	 	contactList=obj.getAllContacts();
        CustomAdapter_2 adap=new CustomAdapter_2(c,R.layout.xml2,contactList);
        ListView lv = (ListView) findViewById(R.id.listView1);
		   lv.setAdapter(adap);
		   
		   
		   final ArrayList<MyDataClass> ddd=new ArrayList<MyDataClass>(contactList);
		   
		   OnItemClickListener  rowListener = new OnItemClickListener() 
	        {
			  
			public void onItemClick(AdapterView parent,View v,int position,long id)
	        {
				 
				 Context con=getApplicationContext();
				 Intent i=new Intent(con,description.class);
					i.putExtra("title",ddd.get(position).getTitle());
					i.putExtra("date",ddd.get(position).getdate());
					i.putExtra("description",ddd.get(position).getDescription());
					i.putExtra("image", ddd.get(position).getImg());
					startActivity(i);	
		   	        		
			}
	        
	        };

		   lv.setOnItemClickListener(rowListener );


	}
	
}
