package com.example.abc;

import java.io.Serializable;
import java.util.ArrayList;

public class DataWrapper implements Serializable {

	   private ArrayList<MyDataClass> parliaments;

	   public DataWrapper(ArrayList<MyDataClass> data) {
	      this.parliaments = data;
	   }

	   public ArrayList<MyDataClass> getParliaments() {
	      return this.parliaments;
	   }

}
