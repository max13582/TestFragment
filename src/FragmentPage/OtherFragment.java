package FragmentPage;

import java.util.ArrayList;
import java.util.List;

import com.example.testfragment.MainActivity;
import com.example.testfragment.R;

import customListView.MyListItem;
import customListView.MyListItemAdapter;
import customListView.TwoColumnARowAdapter;
import customListView.TwoColumnARowItem;
import customListView.TwoLinearLayout;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OtherFragment extends Fragment{
	
	private String tag = "OtherFragment";
	private boolean D = true;
	
	private float widthSeprate;
	
	private Handler mHandler;
	
	//listView that will be use.
	private ListView mListView;
//	private List<TwoLinearLayout> itemList;
//	private MyListItemAdapter adapter;
	private List<TwoColumnARowItem> itemList;
	private TwoColumnARowAdapter adapter;
	
	//item View object
//	private TwoLinearLayout row1,row2,row3;
	private TwoColumnARowItem row1,row2,row3;
	
	public OtherFragment(Handler handler) {
		mHandler = handler;		
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		//get width of mainActivity for listView usage.Let list view judge what link will be called.
		MainActivity main = (MainActivity) activity;
		int width = main.getWidth();
		widthSeprate = width/2;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(D)Log.d(tag, "onCreateView");
		View rootView = inflater.inflate(R.layout.fragment_other, container, false);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		View view = getView();
		
		mListView= (ListView) view.findViewById(R.id.itemListView);

		/* This part is for test usage.The view of listView shown were written in hard code way.
		 * But this method is easy to set resource of all object of view by set item_viewN.xml.
		 * 
		 * Each item of two linearLayout.one row map to two column. 		
			row1 = new TwoLinearLayout(R.layout.item_view, R.layout.item_view2);
			row2 = new TwoLinearLayout(R.layout.item_view3, R.layout.item_view4);
			row3 = new TwoLinearLayout(R.layout.item_view5, R.layout.item_view6);
			
			itemList = new ArrayList<TwoLinearLayout>();
			itemList.add(row1);
			itemList.add(row2);
			itemList.add(row3);
			
			adapter = new MyListItemAdapter(getActivity(), R.layout.two_linear_view, itemList);
			
			mListView.setAdapter(adapter);
		*/
		
		setData();
		
		adapter = new TwoColumnARowAdapter(getActivity(), R.layout.two_column_a_row_view, itemList);
		
		mListView.setAdapter(adapter);
		
		mListView.setOnItemClickListener(new ItemListener());
	}
	
	private void setData(){
		int [] srcImg = {R.drawable.aoe_castle,R.drawable.aoe_ship,
						 R.drawable.eu_far,R.drawable.eu_near,
						 R.drawable.ff_ice,R.drawable.ff_light,
						 R.drawable.gta_deff,R.drawable.gta_page,
						 R.drawable.pd2_bank,R.drawable.pd2_screen,
						 R.drawable.tes_knife,R.drawable.tes_tiger};
		
		String [] srcInfo = {"TYPE:SLG\nNAME:Age Of Empire",
							 "TYPE:SLG\nNAME:Europe",
							 "TYPE:RPG\nNAME:Final Fantasy",
							 "TYPE:ACT\nNAME:Grand Theif Auto V",
							 "TYPE:FPS\nNAME:Payday",
							 "TYPE:RPG\nNAME:The Elder Scroll V"};
		
		String [] linkArray = {"http://www.ageofempires3.com/",
							   "http://www.europauniversalis4.com/",
							   "http://www.finalfantasyxiv.com/",
							   "http://www.rockstargames.com/V/zh_tw",
							   "http://www.crimenet.info/gate?returnUrl=/",
							   "http://www.elderscrolls.com/"};
		
		itemList = new ArrayList<TwoColumnARowItem>();
		row1 = new TwoColumnARowItem();
		row2 = new TwoColumnARowItem();
		row3 = new TwoColumnARowItem();
		itemList.add(row1);
		itemList.add(row2);
		itemList.add(row3);
		for(int i = 0; i < 3;i++){
			TwoColumnARowItem item = itemList.get(i);
				
			item.setImage(srcImg[i*4], TwoColumnARowItem.LEFT_IMAGE, TwoColumnARowItem.LEFT_SIDE);
			item.setImage(srcImg[i*4+1], TwoColumnARowItem.RIGHT_IMAGE, TwoColumnARowItem.LEFT_SIDE);
			item.setImage(R.drawable.ic_action_account_box, TwoColumnARowItem.PROFILE_IMAGE, TwoColumnARowItem.LEFT_SIDE);			
			item.setTextViewString(srcInfo[i*2], TwoColumnARowItem.TEXT_INFO, TwoColumnARowItem.LEFT_SIDE);
			item.setTextViewString("SomeInfo", TwoColumnARowItem.TEXT_PROFILE, TwoColumnARowItem.LEFT_SIDE);
			item.setTextViewString("#00ffff", TwoColumnARowItem.TEXT_BACKGROUND, TwoColumnARowItem.LEFT_SIDE);

			item.setImage(srcImg[i*4+2], TwoColumnARowItem.LEFT_IMAGE, TwoColumnARowItem.RIGHT_SIDE);
			item.setImage(srcImg[i*4+3], TwoColumnARowItem.RIGHT_IMAGE, TwoColumnARowItem.RIGHT_SIDE);
			item.setImage(R.drawable.ic_action_account_box, TwoColumnARowItem.PROFILE_IMAGE, TwoColumnARowItem.RIGHT_SIDE);			
			item.setTextViewString(srcInfo[i*2+1], TwoColumnARowItem.TEXT_INFO, TwoColumnARowItem.RIGHT_SIDE);
			item.setTextViewString("SomeInfo", TwoColumnARowItem.TEXT_PROFILE, TwoColumnARowItem.RIGHT_SIDE);
			item.setTextViewString("#ff00ff", TwoColumnARowItem.TEXT_BACKGROUND, TwoColumnARowItem.RIGHT_SIDE);
			
			item.setLink(linkArray[i*2], TwoColumnARowItem.LEFT_SIDE);
			item.setLink(linkArray[i*2+1], TwoColumnARowItem.RIGHT_SIDE);
			}	
	}
	
	private class ItemListener implements AdapterView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			MainActivity main = (MainActivity) getActivity();
			TwoColumnARowItem item = (TwoColumnARowItem) mListView.getItemAtPosition(position);
			float xCrood = main.getXcrood();
			String link;
			
			if(xCrood >= widthSeprate){
				link = item.getLink(TwoColumnARowItem.RIGHT_SIDE);				
			}else{
				link = item.getLink(TwoColumnARowItem.LEFT_SIDE);
			}
			Intent openWebIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
			startActivity(openWebIntent);
		}
		
	}
	
}
