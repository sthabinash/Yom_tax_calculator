package com.example.yom_taxation;



import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initlayout();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	protected void initlayout(){
		final EditText tsalary = (EditText)this.findViewById(R.id.total_salary);
		final EditText extrasalary = (EditText)this.findViewById(R.id.extra_salary);
		final EditText festsalary = (EditText)this.findViewById(R.id.festival_salary);
		final EditText citperc = (EditText)this.findViewById(R.id.cit);
		final RadioGroup radiopf = (RadioGroup)this.findViewById(R.id.radiopf);
		final RadioGroup radiogender = (RadioGroup)this.findViewById(R.id.radiogender);
		final RadioGroup radiomarital = (RadioGroup)this.findViewById(R.id.radiomarital);
		
		final EditText insurance = (EditText)this.findViewById(R.id.insuranceamt);
		
		Button calc = (Button)this.findViewById(R.id.calc);
		
		calc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int cit = Integer.parseInt(citperc.getText().toString());
				
				if(cit<=33)
				{
					int salary = Integer.parseInt(tsalary.getText().toString());
					int esalary = Integer.parseInt(extrasalary.getText().toString());
					int fsalary = Integer.parseInt(festsalary.getText().toString());
					
					int selectedgender = radiogender.getCheckedRadioButtonId();
					RadioButton gender = (RadioButton) findViewById(selectedgender);
					
					int selectedmarital = radiomarital.getCheckedRadioButtonId();
					RadioButton marital = (RadioButton) findViewById(selectedmarital);
					
					int selectedpf = radiopf.getCheckedRadioButtonId();
					RadioButton pf = (RadioButton) findViewById(selectedpf);
					
					int insuranceval = Integer.parseInt(insurance.getText().toString());
					
					
					
					//ArrayList ret = new ArrayList();
					//SalaryItem SalaryItem = new SalaryItem();
					
					SalaryItem.setCitperc(cit);
					SalaryItem.setSalary(salary);
					SalaryItem.setExtrasalary(esalary);
					SalaryItem.setFestivesal(fsalary);
					if(gender.getText().toString().equals("Male"))
					{
						SalaryItem.setGender(1);
					}
					else
					{
						SalaryItem.setGender(2);
					}
					
					if(pf.getText().toString().equals("0%"))
					{
						SalaryItem.setPfperc(1);
					}
					else
					{
						SalaryItem.setPfperc(2);
					}
					
					if(marital.getText().toString().equals("Married"))
					{
						SalaryItem.setMarital(1);
					}
					else
					{
						SalaryItem.setMarital(2);
					}
					
					SalaryItem.setInsurance(insuranceval);
					
					
					//ret.add(SalaryItem);
					Intent res_clc = new Intent(MainActivity.this,Outputres.class);
					
					startActivity(res_clc);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "CIT value must be less than 33%", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
	}
	
	
	
	
	

}
