package com.example.listviewfromsqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	public SQLiteDatabase DB0;
	public String DBPath;
	public static String DBName = "sample0";
	public static final int version = '1';
	public static Context currentContext;
	public static String tableName = "Resource";
	

	public DBHelper(Context context) {
		super(context, DBName, null, version);
		currentContext = context;
		DBPath = "/data/data/" + context.getPackageName() + "/databases";
		createDatabase();

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	private void createDatabase() {
		boolean dbExists = checkDbExists();
		
		if (dbExists) {
			// do nothing
		} else {
			DB0 = currentContext.openOrCreateDatabase(DBName, 0, null);
			DB0.execSQL("CREATE TABLE IF NOT EXISTS " +
        			tableName +
        			" (FirstName VARCHAR(50));");
        	
        	DB0.execSQL("INSERT INTO " +
        			tableName +
        			" Values ('asdf');");
        	DB0.execSQL("INSERT INTO " +
        			tableName +
        			" Values ('zxcv');");
        	DB0.execSQL("INSERT INTO " +
        			tableName +
        			" Values ('keerthi');");
        	DB0.execSQL("INSERT INTO " +
        			tableName +
        			" Values ('niyas');");
        	DB0.execSQL("INSERT INTO " +
        			tableName +
        			" Values ('ranjith');");
        	DB0.execSQL("INSERT INTO " +
        			tableName +
        			" Values ('kjkh');");
		}
		
		
	}

	private boolean checkDbExists() {
		SQLiteDatabase checkDB = null;

		try {
			String myPath = DBPath + DBName;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.

		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}
}