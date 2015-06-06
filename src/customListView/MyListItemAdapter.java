package customListView;

import java.util.List;

import com.example.testfragment.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

/**
 * @deprecated because view will be mass,I remain this class just want to tip me behavior of layoutInfalter.
 * @author RONG
 *
 */
public class MyListItemAdapter extends ArrayAdapter<TwoLinearLayout>{

	private boolean D = true;
	private String tag = "MyListItemAdapter";
	
	private int resource;
	
	private List<TwoLinearLayout> items;
	
	public MyListItemAdapter(Context context, int resource,
			List<TwoLinearLayout> objects) {
		super(context, resource, objects);
		this.resource = resource;
		this.items = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(D)Log.d(tag, "getView,current position is: " + position);
		
		LinearLayout itemView;
		LinearLayout leftView = new LinearLayout(getContext()),
					 rightView = new LinearLayout(getContext());
		
		final TwoLinearLayout item = getItem(position);
		
		//if convertView cannot reuse,inflate a new view.
		if(convertView == null){
			if(D)Log.d(tag, "convertView is null...");
			itemView = new LinearLayout(getContext());	
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
			li.inflate(resource, itemView, true);
			
			li.inflate(item.getLeftLayoutIdResource(), leftView, true);
			li.inflate(item.getRightLayoutIdResource(), rightView, true);
			
		}else{
			if(D)Log.d(tag, "convertView exist...");
			itemView = (LinearLayout) convertView;
		}
		
		//deploy all object of itemView.
		LinearLayout leftLayout = (LinearLayout) itemView.findViewById(R.id.leftSide);
		LinearLayout rightLayout = (LinearLayout) itemView.findViewById(R.id.rightSide);
		
		//if I inflate layout in here that getView() will be called multiple times and lead to view become out of control.
//		li.inflate(item.getLeftLayoutIdResource(), leftView, true);
//		li.inflate(item.getRightLayoutIdResource(), rightView, true);
		
		leftLayout.addView(leftView);
		rightLayout.addView(rightView);
		
		return itemView;
	}
	
}
