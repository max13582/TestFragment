package com.example.testfragment;

import btnListener.BtnListener;
import FragmentPage.MainFragment;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

	private String tag = "Main";
	private boolean D = true;
	
	private Fragment currentFrag = null;
	private BtnListener btnListener;
	private FrameLayout mFrame;
	private TextView mTextView;
	private TextView badgeA;
	private FragmentTransaction mFragmentTransaction;
	private float xCoord;
	private int width;	
	
	public static final int NEW_MESSAGE = 100;
	public static final int READ_MESSAGE = 101;
	
	public static final int BTN1 = 200;
	public static final int BTN2 = 201;
	
	private static int newMessageNote = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mFrame = (FrameLayout) findViewById(R.id.showFragment);
		mTextView = (TextView) findViewById(R.id.textView1);
		badgeA = (TextView) findViewById(R.id.textViewOfBtnA);
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		
		btnListener = new BtnListener(mFrame,mTextView,handler);
		
		btn1.setOnClickListener(btnListener);
		btn2.setOnClickListener(btnListener);
		
		currentFrag = new MainFragment(handler);
		
		if (savedInstanceState == null) {
			btn1.callOnClick();
		}
		
		obtainWidth();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if(ev.getAction() == MotionEvent.ACTION_UP){
			float x = ev.getX();
			setXcrood(x);
			if(D)Log.d(tag, "x is:" + x);
		}
		return super.dispatchTouchEvent(ev);
	}

	//set width of this activity.it is associate list view of other fragment part.
	private void obtainWidth(){
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		width = displaymetrics.widthPixels;
		if(D)Log.d(tag, "width is:" + width);
	}
	//get width of this activity.it is associate list view of other fragment part.
	public int getWidth(){
		return width;
		
	}
	//it is associate list view of other fragment part.
	public void setXcrood(float x){
		xCoord = x;
	}
	//it is associate list view of other fragment part.
	public float getXcrood(){
		return xCoord;
	}
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case NEW_MESSAGE:
				newMessageNote += 1;
				badgeA.setText(newMessageNote+"");
				if(badgeA.getVisibility() == Button.INVISIBLE){
					badgeA.setVisibility(Button.VISIBLE);
				}
				break;
			case READ_MESSAGE:
				newMessageNote -= 1;
				badgeA.setText(newMessageNote+"");
				if(newMessageNote <= 0){
					badgeA.setVisibility(Button.INVISIBLE);
				}
			}
		}		
	};
	
}
