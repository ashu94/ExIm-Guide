package com.ExIm_guide;

import java.util.ArrayList;
import java.util.List;






import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
/**
 * 
 * @author manish.s
 *
 */

public class SQLiteConnector extends Activity{
	
	private SQLiteDatabase database;
	private SQLiteHelper sqlHelper;
	private Cursor cursor;
	boolean flag=false;
	private String state=Statewise.Statewisesearch;
	private String desc=Descr.Statewisesearch;
	private static final String TABLE_RECORD = "import";
	
	public SQLiteConnector(Context context) {
		sqlHelper = new SQLiteHelper(context);
		
	}
	
	// Getting All records

			
public List<String> statewise() {
				int n=0;
		
				List<String> studentList = new ArrayList<String>();
				
				
				String selectQuery = "SELECT  distinct itc,hs8_des,policy,conditions FROM " + TABLE_RECORD + " where itc LIKE '"+state+"' ; ";

				database = sqlHelper.getReadableDatabase();
				cursor = database.rawQuery(selectQuery, null);
				if (cursor.moveToFirst()) {
					do {
						studentList.add("ITCHS- "+cursor.getString(0));
						studentList.add("ITEM DESCRIPTION- "+cursor.getString(1));
						studentList.add("POLICY- "+cursor.getString(2));
						studentList.add("CONDITIONS- "+cursor.getString(3));
						
						
					} while (cursor.moveToNext());
				}
				else{
					studentList.add("no result found");
				}
				
				
			
				database.close();
				return studentList;
				
			}
		
				


public List<String> description() {
	
	List<String> studentList = new ArrayList<String>();
	
	String selectQuery = "SELECT  distinct itc,hs8_des,policy,conditions FROM " + TABLE_RECORD + " where hs8_des LIKE '%"+desc+"%' ; ";

	database = sqlHelper.getReadableDatabase();
	cursor = database.rawQuery(selectQuery, null);
	if (cursor.moveToFirst()) {
		do {
			studentList.add("ITCHS- "+cursor.getString(0));
			studentList.add("ITEM DESCRIPTION- "+cursor.getString(1));
			studentList.add("POLICY- "+cursor.getString(2));
			studentList.add("CONDITIONS- "+cursor.getString(3));
			studentList.add("");
			
		} while (cursor.moveToNext());
	}
	else{
		studentList.add("no result found");
	}
	database.close();
	return studentList;
}

	
}
