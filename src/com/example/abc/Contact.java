package com.example.abc;

public class Contact {
	 
    //private variables
	
	String title;
    String description;
    String date;
   // boolean t;
 
    // Empty constructor
    int id;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public Contact(){
 
    }
    // constructor
    
    public Contact(int i,String te,String d, String des ){
        this.id=i;
    	this.title = te;
        this.description = des;
        this.date = d;
        //this.t=temp;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String des) {
		this.description = des;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String dat) {
		this.date = dat;
	}
//	public boolean isT() {
//		return t;
//	}
//	public void setT(boolean t) {
//		this.t = t;
//	}
 
    // constructor
//    public Contact(String name, String _phone_number){
//        this._name = name;
//        this._phone_number = _phone_number;
//    }
   
}