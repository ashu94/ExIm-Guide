package com.ExIm_guide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Descr extends Activity {
	
	public static String Statewisesearch;
	ListView liststatewise;
	SQLiteConnector sqlConnect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_desc);
		
	}

	

	public void onClickDesc(View v) {
		 EditText  statewise=(EditText)findViewById(R.id.statewiseText);
		 Statewisesearch=statewise.getText().toString();
		 ListView liststatewise = (ListView) findViewById(R.id.statewiselist);
			sqlConnect = new SQLiteConnector(this);

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, sqlConnect.description());
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.color, sqlConnect.description());
			liststatewise.setAdapter(adapter1);
       }
	
}
