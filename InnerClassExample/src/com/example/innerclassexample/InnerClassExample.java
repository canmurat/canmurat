package com.example.innerclassexample;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InnerClassExample extends Activity {

	private View mColorRegion;
	private int[] mColorChoices =
	{ Color.BLACK, Color.BLUE};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inner_class_example);
		
		mColorRegion = findViewById(R.id.textView1);
		Button colorButton = (Button)findViewById(R.id.button1);
		colorButton.setOnClickListener(new ColorRandomizer());
	}

	private void setRegionColor(int color) {
		mColorRegion.setBackgroundColor(color);
		}
	
	private class ColorRandomizer implements OnClickListener {
	@Override
	public void onClick(View v) {
	Random generator = new Random();
	int index = generator.nextInt(mColorChoices.length);
	setRegionColor(mColorChoices[index]);
	}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inner_class_example, menu);
		return true;
	}

}
