package com.example.abc;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class CustomAdapter extends ArrayAdapter<MyDataClass> {
	//private ValueFilter valuefilter ;
	ArrayList<MyDataClass> obj;
	Context c;
    int layoutFile;
    ArrayList<MyDataClass> data;
    public CustomAdapter(Context context, int resource, ArrayList<MyDataClass> objects) {

        super(context, resource, objects);
        c = context;
        layoutFile = resource;
        data = objects;
    }
    public void set_data(ArrayList<MyDataClass> ob)
    {
    	obj=ob;
    }
    @Override
    public int getCount()
    {
    	if(data != null)
    		return data.size();
    	else
    		return 0;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v, row;
        int i=position;
        if(convertView == null)
        {
        	LayoutInflater inflater = LayoutInflater.from(c);
            row = inflater.inflate(R.layout.sample_layout, parent, false);
        }
        else
        {
            row = (View) convertView;
            ImageButton bookmark = (ImageButton)row.findViewById(R.id.imageButton2);
        	
			ImageButton share = (ImageButton) row.findViewById(R.id.imageButton1);
//
			if(data.get(i).isCheck()==true)
			{				
				bookmark.setVisibility(View.VISIBLE);
				share.setVisibility(View.VISIBLE);
			}
			else
			{
				bookmark.setVisibility(View.GONE);
				share.setVisibility(View.GONE);
			}

        }
//       if(position==0)
//        {
//        
//        }
//        
//       
       //else{
        TextView txt = (TextView)row.findViewById(R.id.textView1);
        txt.setText(data.get(position).getTitle());
        TextView date = (TextView)row.findViewById(R.id.textView2);
        date.setText(data.get(position).getdate());
        TextView cate=(TextView)row.findViewById(R.id.textView3);
        cate.setText(data.get(position).getCategory());
        final int temp=position;
        final int ii=position;
        ImageButton z=(ImageButton)row.findViewById(R.id.imageButton2);
      
        z.setOnClickListener(new OnClickListener() 
        { 
     	   @Override
 	       public void onClick(View v) 
 	       {
     		 
     		   DatabaseHandler obj=new DatabaseHandler(c);
     		   MyDataClass con=new MyDataClass();
     		   con.setTitle(data.get(ii).getTitle());
     		  con.setdate(data.get(ii).getdate());
     		 con.setDescription(data.get(ii).getDescription());
     		 con.setImg(data.get(ii).getImg());
     		   obj.addContact(con);
     		   
     		}

         });

        
       
        row.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(c,description.class);
				i.putExtra("title",data.get(temp).getTitle());
				i.putExtra("date",data.get(temp).getdate());
				i.putExtra("description",data.get(temp).getDescription());
				i.putExtra("image", data.get(temp).getImg());
				c.startActivity(i);	
				
			}
			
		});
       // final View r=row;
    
//        row.setOnLongClickListener(new View.OnLongClickListener()
//		{
//        	
//			@Override
//			public boolean onLongClick(View v) {
//				
				
			
				
				
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//		});


//        TextView tx = (TextView)row.findViewById(R.id.textView2);
//        tx.setText(data.get(position).getAname());
//        
//        TextView t = (TextView)row.findViewById(R.id.textView3);
//        t.setText(data.get(position).getMarks());
        ImageButton bookmark = (ImageButton)row.findViewById(R.id.imageButton2);
    	
		ImageButton share = (ImageButton) row.findViewById(R.id.imageButton1);
				bookmark.setFocusable(false);
				share.setFocusable(false);
      
				row.setLongClickable(true);
      // }
        return row;
    }
//    @Override
//    public android.widget.Filter getFilter() {
//        if (valuefilter == null) 
//        {
//            valuefilter = new ValueFilter();
//        }
//        return valuefilter;
//    }
    
//    private class ValueFilter extends android.widget.Filter {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//
//            FilterResults results = new FilterResults();
//
//            if (constraint != null && constraint.length() > 0) {
//                ArrayList<MyDataClass> filterList = new ArrayList<MyDataClass>();
//                for (int i = 0; i < data.size(); i++) 
//	{
//                    if ( (data.get(i).getCourseName().toUpperCase())
//                            .contains(constraint.toString().toUpperCase()) || (data.get(i).getAname().toUpperCase())
//                            .contains(constraint.toString().toUpperCase()) || (data.get(i).getMarks().toUpperCase())
//                            .contains(constraint.toString().toUpperCase()) ) {
//
//                               MyDataClass newObj = new MyDataClass(data.get(i).getCourseName(), data.get(i).getAname(),data.get(i).getMarks(),data.get(i).getImg());
//                        filterList.add(newObj);
//                    }
//                }
//                results.count = filterList.size();
//                results.values = filterList;
//            } else {
//                results.count = obj.size();
//                results.values = obj;
//            }
//            return results;  }
//
//        @Override
//        protected void publishResults(CharSequence constraint,
//                FilterResults results) {
//        	// obj=data;
//            data= (ArrayList<MyDataClass>) results.values;
//            if (results.count > 0) {
//                notifyDataSetChanged();
//            }
////            else {
////                data=obj;
////                notifyDataSetChanged();
////                }
//        }
//        
//       
//
//    }

    
    
    
}
