package com.ExIm_guide;



import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.ExIm_guide.R;

public class Statewise extends Activity {
	
	public static String Statewisesearch;
	ListView liststatewise;
	SQLiteConnector sqlConnect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statewise);
		
	}

	

	public void onClickStatewise(View v) {
		 EditText  statewise=(EditText)findViewById(R.id.statewiseText);
		 Statewisesearch=statewise.getText().toString();
		 ListView liststatewise = (ListView) findViewById(R.id.statewiselist);
			sqlConnect = new SQLiteConnector(this);

		
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Statewise.this, R.layout.color, sqlConnect.statewise());
			liststatewise.setAdapter(adapter1);
       }
	
}
