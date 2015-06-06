package customListView;

import java.util.List;

import com.example.testfragment.R;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TwoColumnARowAdapter extends ArrayAdapter<TwoColumnARowItem>{

	private boolean D = true;
	private String tag = "Adapter";
	
	private int resource;
	private List<TwoColumnARowItem> items;
	
	public TwoColumnARowAdapter(Context context, int resource,
			List<TwoColumnARowItem> objects) {
		super(context, resource, objects);
		this.resource = resource;
		this.items = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(D)Log.d(tag, "current position is: " + position);
		
		LinearLayout itemView;
		
		final TwoColumnARowItem item = getItem(position);

		if(convertView == null){
			if(D)Log.d(tag, "convertView is null...");
			
			itemView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
			li.inflate(resource, itemView, true);
			
		}else{
			if(D)Log.d(tag, "convertView exist...");
			
			itemView = (LinearLayout) convertView;
		}
		
		//deploy objects of view.
		ImageView leftImageOfLeftSide = (ImageView) itemView.findViewById(R.id.imageLeftOfLeftSide),
				  rightImageOfLeftSide = (ImageView) itemView.findViewById(R.id.imageRightOfLeftSide),
				  profileImageOfLeftSide = (ImageView) itemView.findViewById(R.id.imageProfileOfLeftSide),
				  leftImageOfRightSide = (ImageView) itemView.findViewById(R.id.imageLeftOfRightSide),
				  rightImageOfRightSide = (ImageView) itemView.findViewById(R.id.imageRightOfRightSide),
				  profileImageOfRightSide = (ImageView) itemView.findViewById(R.id.imageProfileOfRightSide);
		
		TextView textInfoOfLeftSide = (TextView) itemView.findViewById(R.id.textInfoOfLeftSide),
				 textProfileOfLeftSide = (TextView) itemView.findViewById(R.id.textProfileOfLeftSide),
				 textBackgroundOfLeftSide = (TextView) itemView.findViewById(R.id.textBackgroundOfLeftSide),
				 textInfoOfRightSide = (TextView) itemView.findViewById(R.id.textInfoOfRightSide),
				 textProfileOfRightSide = (TextView) itemView.findViewById(R.id.textProfileOfRightSide),
				 textBackgroundOfRightSide = (TextView) itemView.findViewById(R.id.textBackgroundOfRightSide);

		//left side part.
		//image part.
		leftImageOfLeftSide.setImageResource(item.getImage(TwoColumnARowItem.LEFT_IMAGE, TwoColumnARowItem.LEFT_SIDE));
		rightImageOfLeftSide.setImageResource(item.getImage(TwoColumnARowItem.RIGHT_IMAGE, TwoColumnARowItem.LEFT_SIDE));
		profileImageOfLeftSide.setImageResource(item.getImage(TwoColumnARowItem.PROFILE_IMAGE, TwoColumnARowItem.LEFT_SIDE));
		//textView part.
		textInfoOfLeftSide.setText(item.getTextViewString(TwoColumnARowItem.TEXT_INFO, TwoColumnARowItem.LEFT_SIDE));
		textProfileOfLeftSide.setText(item.getTextViewString(TwoColumnARowItem.TEXT_PROFILE, TwoColumnARowItem.LEFT_SIDE));
		//textView background
		int colorL = Color.parseColor(item.getTextViewString(TwoColumnARowItem.TEXT_BACKGROUND, TwoColumnARowItem.LEFT_SIDE));
		textBackgroundOfLeftSide.setBackgroundColor(colorL);
		
		//right side part.
		//image part.
		leftImageOfRightSide.setImageResource(item.getImage(TwoColumnARowItem.LEFT_IMAGE, TwoColumnARowItem.RIGHT_SIDE));
		rightImageOfRightSide.setImageResource(item.getImage(TwoColumnARowItem.RIGHT_IMAGE, TwoColumnARowItem.RIGHT_SIDE));
		profileImageOfRightSide.setImageResource(item.getImage(TwoColumnARowItem.PROFILE_IMAGE, TwoColumnARowItem.RIGHT_SIDE));
		//textView part.
		textInfoOfRightSide.setText(item.getTextViewString(TwoColumnARowItem.TEXT_INFO, TwoColumnARowItem.RIGHT_SIDE));
		textProfileOfRightSide.setText(item.getTextViewString(TwoColumnARowItem.TEXT_PROFILE, TwoColumnARowItem.RIGHT_SIDE));
		//textView background
		int colorR = Color.parseColor(item.getTextViewString(TwoColumnARowItem.TEXT_BACKGROUND, TwoColumnARowItem.RIGHT_SIDE));	
		textBackgroundOfRightSide.setBackgroundColor(colorR);
		
		
		return itemView;
	}

	
}
