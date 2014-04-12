package com.example.paymobile;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		JSONObject info = new JSONObject();
		String ad = null, soyad = null;
		int faturaNo = 0;
		double tutar = 0;
		
		try{
		
		info.put("adi", "Burcu");
		info.put("soyadi", "Guler");
		info.put("fatura", 25);
		info.put("tutari", 120);
		
		
		}
		catch(JSONException e){
		 e.printStackTrace();
		}
		
		try {
			
		ad = info.getString("adi");
		soyad = info.getString("soyadi");
		faturaNo = info.getInt("fatura");
		tutar = info.getDouble("tutari");
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TextView name = (TextView) this.findViewById(R.id.ad);
		name.setText(name.getText() + "\t" + ad);
		
		TextView surname = (TextView) this.findViewById(R.id.soyad);
		surname.setText(surname.getText() + "\t" + soyad);
		
		TextView billNo = (TextView) this.findViewById(R.id.faturaNo);
		billNo.setText(billNo.getText() + "\t" + String.valueOf(faturaNo));
		
		TextView payment = (TextView) this.findViewById(R.id.tutar);
		payment.setText(payment.getText()+ "\t" + String.valueOf(tutar));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void btnHelloOnClick(View view)
	{
		this.finish();
	}
}
