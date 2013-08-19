package com.example.yom_taxation;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;

public class Outputres extends Activity{

	float taxable=0;
	float festivalamt=0;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_output);
		initlayout();
	}
	
	protected void initlayout(){
		TextView gsals = (TextView)this.findViewById(R.id.ogsal);
	
		gsals.setText(""+SalaryItem.getSalary());
		
		TextView esal = (TextView)this.findViewById(R.id.oesal);
		esal.setText(""+SalaryItem.getExtrasalary());
		
		TextView fest = (TextView)this.findViewById(R.id.festiveamount);
		fest.setText(""+SalaryItem.getFestivesal());
		
		TextView gen = (TextView)this.findViewById(R.id.ogen);
		
		festivalamt=SalaryItem.getFestivesal();
		if(SalaryItem.getGender()==1)
		{
			gen.setText("Male");
			taxable = SalaryItem.getSalary()+SalaryItem.getExtrasalary()+festivalamt;
			
		}
		else
		{
			gen.setText("Female");
			festivalamt = (float) (festivalamt *0.9);
			float intialtaxable = SalaryItem.getSalary()+SalaryItem.getExtrasalary()+festivalamt;
			taxable = (float)(intialtaxable * 0.9);
			
		}
		
		TextView mar = (TextView)this.findViewById(R.id.omarital);
		if(SalaryItem.getMarital()==1)
		{
			mar.setText("Married");
		}
		else
		{
			mar.setText("Unmarried");
		}
		
		int insurance = SalaryItem.getInsurance();
		if(insurance>7000)
		{
			insurance = 7000;
		}
		
		
		TextView insur = (TextView)this.findViewById(R.id.oinsurance);
		insur.setText(""+insurance);
		
		int citperc = SalaryItem.getCitperc();
		
		float cit = (float)(citperc * SalaryItem.getSalary() / 100);
		int pfval = 0;
		if(SalaryItem.getPfperc()==1)
		{
			pfval=0;
		}
		else
		{
			pfval=10;
		}
		float pf = (float)(SalaryItem.getSalary()*pfval /100);
		
		TextView pfout = (TextView)this.findViewById(R.id.opf);
		pfout.setText(""+pf);
		
		TextView citout = (TextView)this.findViewById(R.id.ocit);
		citout.setText(""+cit);
		
		float h1=0;
		float h2=0;
		
		if(SalaryItem.getMarital()==0)
		{
			h1=250000;
			h2=350000;
		}
		else
		{
			h1=200000;
			h2=300000;
		}
		
		float mtaxable = taxable - cit;
		float ytaxable = mtaxable * 12 - insurance;
		
		float taxes = 0;
		float extras = 0;
		if(ytaxable > h2)
		{
			extras = ytaxable - h2;
			taxes = extras * 25/100;
			taxes = taxes + (h1/100)+15000;
		}
		else if(ytaxable>h1)
		{
			extras = ytaxable-h1;
			taxes = extras * 15/100;
			taxes = taxes + (h1/100);
		}
		else
		{
			taxes = ytaxable * 1 /100;
		}
		
		float mtaxes = taxes / 12;
		float fsalaries = SalaryItem.getSalary()+SalaryItem.getExtrasalary()-mtaxes-cit;
		
		TextView finalsalary = (TextView)this.findViewById(R.id.fsalary);
		finalsalary.setText(""+fsalaries);
		
		
		TextView taxamt = (TextView)this.findViewById(R.id.taxamt);
		taxamt.setText(""+mtaxes);
		
		
		Button recalc = (Button)this.findViewById(R.id.button1);
		
		recalc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent res_clc = new Intent(Outputres.this,MainActivity.class);
				
				startActivity(res_clc);
			}
		});
		
		//Toast.makeText(getApplicationContext(), ""+SalaryItem.getSalary(), Toast.LENGTH_SHORT).show();
		
	}
}
