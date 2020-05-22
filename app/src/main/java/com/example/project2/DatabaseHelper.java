package com.example.project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {
    //Database
    public static final String DATABASE_NAME = "FriendsFurLife.db";

    //Adopter Table
    public static final String Ad_Table_Name = "registerAdopter";
    public static final String Ad_Col_1 = "ID";
    public static final String Ad_Col_2 = "Username";
    public static final String Ad_Col_3 = "Password";
    public static final String Ad_Col_4 = "Email";

    //Shelter Table
    public static final String Sh_Table_Name = "registerShelter";
    public static final String Sh_Col_1 = "ID";
    public static final String Sh_Col_2 = "OrganizationName";
    public static final String Sh_Col_3 = "ShelterName";
    public static final String Sh_Col_4 = "Password";
    public static final String Sh_Col_5 = "Email";

    //Animals
    public static final String An_Table_Name = "registerAnimal";
    public static final String An_Col_1 = "ID";
    public static final String An_Col_2 = "Name";
    public static final String An_Col_3 = "Type";
    public static final String An_Col_4 = "Breed";
    public static final String An_Col_5 = "Description";
    //public static final Byte An_Col_6 = "Image";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //Creating Database tables
    @Override
    public void onCreate(SQLiteDatabase FriendsFurLife) {
        FriendsFurLife.execSQL("CREATE TABLE " + Ad_Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Username TEXT, Password TEXT, Email TEXT)");
        FriendsFurLife.execSQL("CREATE TABLE " + Sh_Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, OrganizationName TEXT, ShelterName TEXT, Password TEXT, Email TEXT)");
        FriendsFurLife.execSQL("CREATE TABLE " + An_Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Type TEXT, Description TEXT /*Image BYTE*/)");

    }

    //Not creating the tables if they already exist
    @Override
    public void onUpgrade(SQLiteDatabase FriendsFurLife, int a, int b){
        FriendsFurLife.execSQL(" DROP TABLE IF EXISTS " + Ad_Table_Name);
        FriendsFurLife.execSQL(" DROP TABLE IF EXISTS " + Sh_Table_Name);
        FriendsFurLife.execSQL(" DROP TABLE IF EXISTS " + An_Table_Name);
        onCreate(FriendsFurLife);
    }

    //Adding user to adopter table
    public long add_User(String user, String password, String email){
        SQLiteDatabase adopter_registration = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username", user);
        contentValues.put("Password", password);
        contentValues.put("Email", email);
        long res = adopter_registration.insert(Ad_Table_Name, null, contentValues);
        adopter_registration.close();
        return res;
    }

    //Adding user to shelter table
    public long add_Sh_User(String org, String user, String password, String email){
        SQLiteDatabase shelter_registration = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("OrganizationName", org);
        contentValues.put("ShelterName", user);
        contentValues.put("Password", password);
        contentValues.put("Email", email);
        long res = shelter_registration.insert(Sh_Table_Name, null, contentValues);
        shelter_registration.close();
        return res;
    }

    //Adding Animal to database
    public long add_Animal(String name, String type, String breed, String description /*byte[] animal_image*/){
        SQLiteDatabase animal_registration = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Type", type);
        contentValues.put("Breed", breed);
        contentValues.put("Description", description);
        long res = animal_registration.insert(An_Table_Name, null, contentValues);
        animal_registration.close();
        return res;
    }

    //Checking to see if adopter exists
    public boolean check_ad_user(String username, String password) {
        String[] columns = {Ad_Col_1};
        SQLiteDatabase adopter_registration = getReadableDatabase();
        String ad_selection = Ad_Col_2 + "=?" + " and " + Ad_Col_3 + "=?";
        String[] ad_selectionArgs = { username, password};
        Cursor cursor = adopter_registration.query(Ad_Table_Name, columns, ad_selection, ad_selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        adopter_registration.close();

        if (count > 0)
            return true;
        else
            return false;
    }

    //Checking to see if shelter exists
    public boolean check_sh_user(String organization, String name, String password) {
        String[] columns = {Sh_Col_1};
        SQLiteDatabase shelter_registration = getReadableDatabase();
        String sh_selection = Sh_Col_2 + "=?" + " and " + Sh_Col_3 + "=?" + " and " + Sh_Col_4 + "=?";
        String[] sh_selectionArgs = { organization, name, password};
        Cursor cursor = shelter_registration.query(Sh_Table_Name, columns, sh_selection, sh_selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        shelter_registration.close();

        if (count > 0)
            return true;
        else
            return false;
    }

    //Checking to see if Animal already exists
    public boolean check_animal(String name, String type, String breed) {
        String[] columns = {An_Col_1};
        SQLiteDatabase shelter_registration = getReadableDatabase();
        String an_selection = An_Col_2 + "=?" + " and " + An_Col_3 + "=?" + " and " + An_Col_4 + "=?";
        String[] an_selectionArgs = { name, type, breed};
        Cursor cursor = shelter_registration.query(An_Table_Name, columns, an_selection, an_selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        shelter_registration.close();

        if (count > 0)
            return true;
        else
            return false;
    }

//Query of added animals list
//    public Cursor viewAnimals(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "Select * from "+An_Table_Name;
//        Cursor cursor = db.rawQuery(query, null);
//        return cursor;
//    }


}
