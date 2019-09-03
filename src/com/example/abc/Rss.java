package com.example.abc;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Rss extends AsyncTask<Void, Integer, String>
{
	 String slider=": ";
	 int index=0;
	private XmlPullParserFactory xmlFactoryObject;
	   public volatile boolean parsingComplete = true;    
	
	
		ListView lv;
		ArrayList<String> url_s;
		ArrayList<Boolean> check_s;
		ArrayList <MyDataClass> data;
		Context c;
		ProgressBar s;
		TextView t;
		ImageView f_img;
		TextView upper;
		TextView upper_date;
    Rss(ListView v,ArrayList<String> u,Context c_,ProgressBar s_,TextView t_,ImageView v_,TextView upper_,TextView date_,ArrayList<Boolean> ch)
    {
    	check_s=ch;
    	lv=v;
    	url_s=u;
    	c=c_;
    	s=s_;
    	t=t_;
    	f_img=v_;
    	upper=upper_;
    	upper_date=date_;
    }
	@Override
	protected String doInBackground(Void... params) {
		publishProgress(1);
		//index=0;
		data=new ArrayList<MyDataClass>();
		//  Thread thread = new Thread(new Runnable(){
			//   @Override
			  // public void run() {
		//int j=0;
		for( index=0;index<url_s.size();index++){
			
				try {
			         URL url = new URL(url_s.get(index));
			         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			         conn.setReadTimeout(10000 /* milliseconds */);
			         conn.setConnectTimeout(15000 /* milliseconds */);
			         conn.setRequestMethod("GET");
			         conn.setDoInput(true);
			         // Starts the query
			         conn.connect();
			         InputStream stream = conn.getInputStream();
			         xmlFactoryObject = XmlPullParserFactory.newInstance();
			         XmlPullParser myparser = xmlFactoryObject.newPullParser();
			         myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			         myparser.setInput(stream, null);
			      parseXMLAndStoreIt(myparser);
			         stream.close();
			      } catch (Exception e) {
			      }
		}
			   //   }
			   //   });
			   //   thread.start(); 
			   
		
		return null;
	}
	
	protected void onProgressUpdate(Integer... values) {
		   super.onProgressUpdate(values);
			s.setVisibility(View.VISIBLE);
		   }

	
	 public void parseXMLAndStoreIt(XmlPullParser myParser)
	 {
		 ArrayList<String> title=new ArrayList<String>();
		 ArrayList<String> link=new ArrayList<String>();
		 ArrayList<String> date=new ArrayList<String>();
		 ArrayList<String> desc=new ArrayList<String>();
		 ArrayList<String> image=new ArrayList<String>();
		 ArrayList<String> cat=new ArrayList<String>();
		// ArrayList<int> img=new ArrayList<int>();
		
		  int event;
	      String text=null;
	      try {
	         event = myParser.getEventType();
	         while (event != XmlPullParser.END_DOCUMENT) {
	        	 
	        	  
	         String name=myParser.getName();
	         switch (event){
	            case XmlPullParser.START_TAG:
		        break;
	            case XmlPullParser.TEXT:
			       text = myParser.getText();
	            break;
	            case XmlPullParser.END_TAG:
	            	
		           if(name.equals("title")){
	                 title.add(text);
	                  
	               }
	               else if(name.equals("link")){ 	
	              
	            	   link.add(text);
	                  
	               }
	               else if(name.equals("description")){
	                 desc.add(text);
	                
	               }
		           
	               else if (name.equals("pubDate"))
	               {
	            	   date.add(text);
	            	
	               }
		           
	               else if(name.equals("image") || name.equals("url"))
	               {
	            	   image.add(text);
	               }
	               else
	               {
	            	  
	               }
	               break;
	         }		 
	         
	         event = myParser.next();
	         
	       }
	        
	       parsingComplete = false;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	     
	    for (int i=0;i<title.size();i++)
	    {
	    	MyDataClass obj=new MyDataClass();
	    	String cate;
	    	if(check_s.get(index)){
	    		if(index==0)
	    		{
	    			obj.setCategory("Latest");
	    		}
	    		if(index==1 )
	    			obj.setCategory("National");
	    		if(index==2)
	    			obj.setCategory("World");
	    		if(index==3)
	    			obj.setCategory("Business");
	    		if(index==5)
	    			obj.setCategory("Sports");
	    		if(index==5)
	    			obj.setCategory("Entertainment");
	    	}
	    	
	    	obj.setTitle(title.get(i));
	    	obj.setLink(link.get(i));
	    	obj.setdate(date.get(i));
	    	obj.setDescription(desc.get(i));
	    	if(index==0)
	    	{obj.setImg(image.get(i));}
	    	else
	    		obj.setImg("");
	    	slider=slider+title.get(i)+": ";
	    	data.add(obj);
	    
	    	
	    }
	   }
	 
	   protected void onPostExecute(String result) {
		     // super.onPostExecute(result);
		   s.setVisibility(View.INVISIBLE);
		   
		   t.setText(slider);
		   f_img.setVisibility(View.VISIBLE);
		   upper.setVisibility(View.VISIBLE);
		   upper_date.setVisibility(View.VISIBLE);
		   upper.setText(data.get(1).getTitle());
		   upper_date.setText(data.get(1).getdate());
		   new DownloadImageTask(f_img,data.get(1).getImg()).execute();
		   CustomAdapter adap=new CustomAdapter(c,R.layout.sample_layout,data);
		   lv.setAdapter(adap);
		  
		   
		   lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			    public boolean onItemLongClick(AdapterView<?> parent, View v, int position,long id)
			    {
			    	ImageButton im1= (ImageButton) v.findViewById(R.id.imageButton1);
			    	ImageButton im2= (ImageButton) v.findViewById(R.id.imageButton2);
			    	//TextView tv=(TextView) v.findViewById(R.id.titlebox);
			    	for(int i=0;i<data.size();i++)
					{		    		
						data.get(i).setCheck(false);					
					}
					im1.setVisibility(View.VISIBLE);
					im2.setVisibility(View.VISIBLE);
					//tv.setTextColor(Color.GRAY);
					data.get(position).setCheck(true);
			    	return true;
			    }
			});
			
	
		   
		 
	   }


}
