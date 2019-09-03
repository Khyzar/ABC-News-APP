package com.example.abc;


import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 4;
 
    // Database Name
    private static final String DATABASE_NAME = "newDB";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "BookmarkNews";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DATE = "date";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_img = "image_url";
   // private static final String KEY_T = "t";
     Context c;
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        c=context;
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TITLE + " TEXT,"
                + KEY_DATE + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_img + " TEXT"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
    void addContact(MyDataClass contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        String text = "News stored";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(c, text, duration);
        toast.show();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, contact.getTitle()); // Contact Name
        values.put(KEY_DATE, contact.getdate());
        values.put(KEY_DESCRIPTION, contact.getDescription()); // Contact Phone
        values.put(KEY_img, contact.getImg());
       // values.put(KEY_T, contact.isT());
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single contact
    MyDataClass getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                KEY_TITLE, KEY_DESCRIPTION}, KEY_ID + "=? and" + KEY_DESCRIPTION + "=?" ,
                new String[] { String.valueOf(id),"abc" }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        MyDataClass contact = new MyDataClass(cursor.getString(1), cursor.getString(2),cursor.getString(3));
        // return contact
        return contact;
    }
 
    // Getting All Contacts
    public ArrayList<MyDataClass> getAllContacts() {
        ArrayList<MyDataClass> contactList = new ArrayList<MyDataClass>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	MyDataClass contact = new MyDataClass();
                //contact.s(Integer.parseInt(cursor.getString(0)));
                contact.setTitle(cursor.getString(1));
                contact.setDescription(cursor.getString(3));
                contact.setdate(cursor.getString(2));
                contact.setImg(cursor.getString(4));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
 
    // Updating single contact
//    public int updateContact(MyDataClass contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
// 
//        ContentValues values = new ContentValues();
//        values.put(KEY_TITLE, contact.getTitle());
//        values.put(KEY_DATE, contact.getdate());
//        values.put(KEY_DESCRIPTION, contact.getDescription());
// 
//        // updating row
//        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//                new String[] { String.valueOf(contact.getId()) });
//        
//    }
 
    // Deleting single contact
//    public void deleteContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//                new String[] { String.valueOf(contact.getId()) });
//        db.close();
//    }
 
    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();
 
        // return count
        return cursor.getCount();
    } 
}
