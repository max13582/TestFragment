package customListView;

import com.example.testfragment.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @deprecated I use {@link TwoColumnARowItem} instead.
 * @author RONG
 *
 */
public class MyListItem {
	
	private Context context;
	private LinearLayout layout;
	
	private ImageView leftImage,
	 				  rightImage,
					  profileImage;
	private TextView textInfo,
				   textProfile,
				   textBackground;
	
	public static final int LEFT_IMAGE = 0,
							RIGHT_IMAGE = 1,
							PROFILE_IMAGE = 2;
	
	public static final int TEXT_INFO = 0,
							TEXT_PROFILE = 1,
							TEXT_BACKGROUND = 2;
	/**
	 * This will build a MyListItem with empty string of textInfo,textProfile and textBackground when
	 * leftImage, rightImage and profileImage will be null.
	 * @param context current activity.
	 * @param layoutResource this layout is what you want to deploy.Just parse item_view here.
	 */
	public MyListItem(Context context,int layoutResource){
		this.context = context;
		
		layout = new LinearLayout(context);
		
		//create a item_view.xml for deployment usage.
		String inflater = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li = (LayoutInflater) context.getSystemService(inflater);
		li.inflate(layoutResource, layout, true);
		
		//deploy all object.
		leftImage = (ImageView) layout.findViewById(R.id.imageLeft);
		rightImage = (ImageView) layout.findViewById(R.id.imageRight);
		profileImage = (ImageView) layout.findViewById(R.id.imageProfile);
		
		textInfo = (TextView) layout.findViewById(R.id.textInfo);
		textProfile = (TextView) layout.findViewById(R.id.textProfile);
		textBackground = (TextView) layout.findViewById(R.id.textBackground);
	}
	
	/**
	 * get layout of item_view.Use this as a argument pares to TwoLinearLayout.
	 * @return layout of this item_view.
	 */
	public LinearLayout getLayout(){
		return layout;
	}
	
	/**
	 * invoked this method to get the ImageView you want in item_View.xml.May throw null if position doesn't exist.
	 * @param position the ImageView you want.Use static int in this class.
	 * 		  LEFT_IMAGE: left ImageView on the top.
	 * 		  RIGHT_IMAGE: right ImageView on the top.
	 * 		  PROFILE_IMAGE: profile ImageView on the bottom part.
	 * @return a image map itemView.xml.
	 */
	public ImageView getImage(final int position){
		switch(position){
		case LEFT_IMAGE:
			return leftImage;
		case RIGHT_IMAGE:
			return rightImage;
		case PROFILE_IMAGE:
			return profileImage;
		}
		//if not match one of above.
		return null;
	}
	
	/**
	 * invoked this method to get textView that you want in item_View.xml.May throw null if position doesn't exist.
	 * @param position the textView you want.Use static int in this class.
	 * 		  TEXT_INFO: textView on the middle part.
	 * 		  TEXT_PROFILE: textView beside the image on the bottom.
	 * 	      TEXT_BACKGROUND: textView on the bottom that behind image & text on the bottom. Its usage is setting color of background.i.e:#ffffff is black.
	 * @return string of textView shown.
	 */
	public TextView getTextViewString(final int position){
		switch(position){
		case TEXT_INFO:
			return textInfo;
		case TEXT_PROFILE:
			return textProfile;
		case TEXT_BACKGROUND:
			return textBackground;
		}
		//if not match one of above.
		return null;
	}
	
	/**
	 * set image of imageView of assign position.
	 * @param resource resource of imageView.
	 * @param position position of imageView.
	 */
	public void setImage(final int resource,final int position){
		switch(position){
		case LEFT_IMAGE:
			leftImage.setImageResource(resource);
		case RIGHT_IMAGE:
			rightImage.setImageResource(resource);
		case PROFILE_IMAGE:
			profileImage.setImageResource(resource);
		}
	}
	
	/**
	 * set string of textView of assign position.
	 * Notice:if you want to set TEXT_BACKGROUND, use hexadecimal represent like 0xffffff.
	 * @param string string of textView will show.
	 * @param position position of textView.
	 */
	public void setTextViewString(final String string,final int position){
		switch(position){
		case TEXT_INFO:
			textInfo.setText(string);
		case TEXT_PROFILE:
			textProfile.setText(string);
		case TEXT_BACKGROUND:
			int color = Integer.decode(string);
			textBackground.setBackgroundColor(color);
		}
	}
	
}
