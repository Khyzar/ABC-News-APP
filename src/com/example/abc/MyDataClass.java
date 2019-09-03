package com.example.abc;


public class MyDataClass {
	
	String title;
    String link;
    String description;
    String date;
    String img;
    boolean check;
    String category;
    
    public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public MyDataClass()
    {
    	
    }
    public MyDataClass(MyDataClass obj)
    {
    	this.equals(obj);
    }
    public MyDataClass(String t ,String da,String d)
    {
        this.title = t;
        //this.link = l;
        this.description=d;
        this.date=da;
        //this.img=path;

    }


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getdate() {
		return date;
	}


	public void setdate(String da) {
		this.date = da;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
    
	    
    

}
