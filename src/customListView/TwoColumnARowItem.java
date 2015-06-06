package customListView;

import java.net.URI;

public class TwoColumnARowItem {
	
	private int leftImageOfLeftSide,
			  	leftImageOfRightSide,
			  	rightImageOfLeftSide,
			  	rightImageOfRightSide,
			  	profileImageOfLeftSide,
			  	profileImageOfRightSide;
	
	private String textInfoOfLeftSide,
				   textInfoOfRightSide,
				   textProfileOfLeftSide,
				   textProfileOfRightSide,
				   textBackgroundOfLeftSide,
				   textBackgroundOfRightSide;
	
	private String leftLink,
				   rightLink;
	
	public static final int LEFT_IMAGE = 0,
							RIGHT_IMAGE = 1,
							PROFILE_IMAGE = 2;
	
	public static final int TEXT_INFO = 0,
							TEXT_PROFILE = 1,
							TEXT_BACKGROUND = 2;
	
	public static final int LEFT_SIDE = 0,
							RIGHT_SIDE = 1;
	
	/**
	 * invoked this method to get the resource of image of position you want.May return 0 if position doesn't exist.
	 * @param position the ImageView you want.Use static int in this class.
	 * 		  LEFT_IMAGE: left ImageView on the top.
	 * 		  RIGHT_IMAGE: right ImageView on the top.
	 * 		  PROFILE_IMAGE: profile ImageView on the bottom part.
	 * @param side two option,LEFT_SIDE or RIGHT_SIDE.
	 * @return resource of image.
	 */
	public int getImage(final int position,final int side){
		switch(side){
		case LEFT_SIDE:
			switch(position){
			case LEFT_IMAGE:
				return leftImageOfLeftSide;
			case RIGHT_IMAGE:
				return rightImageOfLeftSide;
			case PROFILE_IMAGE:
				return profileImageOfLeftSide;
			}
			break;
		case RIGHT_SIDE:
			switch(position){
			case LEFT_IMAGE:
				return leftImageOfRightSide;
			case RIGHT_IMAGE:
				return rightImageOfRightSide;
			case PROFILE_IMAGE:
				return profileImageOfRightSide;
			}
		}
		
		//if not match one of above.
		return 0;
	}
	
	/**
	 * invoked this method to get String of the position you want.May throw null if position doesn't exist.
	 * @param position the textView you want.Use static int in this class.
	 * 		  TEXT_INFO: textView on the middle part.
	 * 		  TEXT_PROFILE: textView beside the image on the bottom.
	 * 	      TEXT_BACKGROUND: textView on the bottom that behind image & text on the bottom. Its usage is setting color of background.i.e:#ffffff is black.
	 * @param side two option,LEFT_SIDE or RIGHT_SIDE.
	 * @return string of textView shown.
	 */
	public String getTextViewString(final int position,final int side){
		switch(side){
		case LEFT_SIDE:
			switch(position){
			case TEXT_INFO:
				return textInfoOfLeftSide;
			case TEXT_PROFILE:
				return textProfileOfLeftSide;
			case TEXT_BACKGROUND:
				return textBackgroundOfLeftSide;
			}
			break;
		case RIGHT_SIDE:
			switch(position){
			case TEXT_INFO:
				return textInfoOfRightSide;
			case TEXT_PROFILE:
				return textProfileOfRightSide;
			case TEXT_BACKGROUND:
				return textBackgroundOfRightSide;
			}
		}
				
		//if not match one of above.
		return null;
	}
	
	/**
	 * get link of assign side.
	 * @param side LEFT_SIDE or RIGHT_SIDE.
	 * @return string of link.Use {@link URI.prase(String)}.May return null if error side were assigned.
	 */
	public String getLink(int side){
		switch(side){
		case LEFT_SIDE:
			return leftLink;
		case RIGHT_SIDE:
			return rightLink;
		}
		return null;
	}
	
	/**
	 * set image resource of assign position.
	 * @param resource resource of imageView.
	 * @param position position of imageView.
	 * @param side two option,LEFT_SIDE or RIGHT_SIDE.
	 */
	public void setImage(final int resource,final int position,final int side){
		switch(side){
		case LEFT_SIDE:
			switch(position){
			case LEFT_IMAGE:
				leftImageOfLeftSide = resource;
				break;
			case RIGHT_IMAGE:
				rightImageOfLeftSide = resource;
				break;
			case PROFILE_IMAGE:
				profileImageOfLeftSide = resource;
			}
			break;
		case RIGHT_SIDE:
			switch(position){
			case LEFT_IMAGE:
				leftImageOfRightSide = resource;
				break;
			case RIGHT_IMAGE:
				rightImageOfRightSide = resource;
				break;
			case PROFILE_IMAGE:
				profileImageOfRightSide = resource;
			}
		}		
	}
	
	/**
	 * set string of textView of assign position.
	 * Notice:if you want to set TEXT_BACKGROUND,you should key in like #ffffff.
	 * @param string string of textView will show.
	 * @param position position of textView.
	 * @param side two option,LEFT_SIDE or RIGHT_SIDE.
	 */
	public void setTextViewString(final String string,final int position,final int side){
		switch(side){
		case LEFT_SIDE:
			switch(position){
			case TEXT_INFO:
				textInfoOfLeftSide = string;
				break;
			case TEXT_PROFILE:
				textProfileOfLeftSide = string;
				break;
			case TEXT_BACKGROUND:
				textBackgroundOfLeftSide = string;
			}
			break;
		case RIGHT_SIDE:
			switch(position){
			case TEXT_INFO:
				textInfoOfRightSide = string;
				break;
			case TEXT_PROFILE:
				textProfileOfRightSide = string;
				break;
			case TEXT_BACKGROUND:
				textBackgroundOfRightSide = string;
			}
		}
	}
	
	/**
	 * set string of link of assigned side.If not assign correct side,there won't any link of side to set.
	 * @param link a string for uri.prase to use.
	 * @param side LEFT_SIDE or RIGHT_SIDE.
	 */
	public void setLink(String link,int side){
		switch(side){
		case LEFT_SIDE:
			leftLink = link;
			break;
		case RIGHT_SIDE:
			rightLink = link;
			break;
		default:
		}
	}
	
}
