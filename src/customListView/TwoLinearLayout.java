package customListView;

import android.view.View;
import android.widget.LinearLayout;

/**
 * @deprecated See {@link MyListItemAdapter},because of view of layout cannot deploy correctly. 
 * @author RONG
 *
 */

public class TwoLinearLayout{

	private LinearLayout leftLayout,
						 rightLayout;	
	private int leftLayoutResource,
				rightLayoutResource;
	
	/**
	 * set leftLayout and rightLayout.Use getLayout of {@link MyListItem}.
	 * @param leftLayout layout of left side.
	 * @param rightLayout layout of right side.
	 */
	public TwoLinearLayout(View leftLayout,View rightLayout) {
		this.leftLayout = (LinearLayout) leftLayout;
		this.rightLayout = (LinearLayout) rightLayout;
	}
	
	/**
	 * set layout by R.layout.yourlayout int resource.
	 * @param leftLayout left layout resource.
	 * @param rightLayout right layout resource.
	 */
	public TwoLinearLayout(int leftLayout,int rightLayout){
		leftLayoutResource = leftLayout;
		rightLayoutResource = rightLayout;
	}

	/**
	 * get layout of left side. 
	 * @return leftLayout
	 */
	public View getLeftLayout(){
		return leftLayout;
	}
	
	/**
	 * get layout of right side.
	 * @return rightLayout
	 */
	public View getRightLayout(){
		return rightLayout;
	}
	
	/**
	 * get layout resource of left side.See also {@link #TwoLinearLayout(int, int)}.
	 * @return left layout id.
	 */
	public int getLeftLayoutIdResource(){
		return leftLayoutResource;
	}
	
	/**
	 * get layout resource of right side.See also {@link #TwoLinearLayout(int, int)}.
	 * @return right layout id.
	 */
	public int getRightLayoutIdResource(){
		return rightLayoutResource;
	}
}
