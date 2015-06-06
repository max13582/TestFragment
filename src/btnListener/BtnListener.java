package btnListener;

import com.example.testfragment.R;

import FragmentPage.MainFragment;
import FragmentPage.OtherFragment;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BtnListener implements View.OnClickListener{

	private String tag = "btnListener";

	private FrameLayout mFrame;
	private TextView mTextView;
	private Handler mHandler;
	
	private Context context;

	public BtnListener(FrameLayout frame,TextView textView,Handler handler){
		mFrame = frame;
		mTextView = textView;
		mHandler = handler;
	}
	
	@Override
	public void onClick(View v) {
		context = v.getContext();
		
		Log.d(tag, "listener is:" + v.getId());
		
		FragmentTransaction fragmentTransaction = ((Activity) context).getFragmentManager().beginTransaction();
		
		switch(v.getId()){
		case R.id.button1:
			fragmentTransaction.replace(mFrame.getId(),new MainFragment(mHandler), "Main").addToBackStack(null);
			fragmentTransaction.commit();
			mTextView.setText("A");
			break;
		case R.id.button2:
			fragmentTransaction.replace(mFrame.getId(),new OtherFragment(mHandler), "Other").addToBackStack(null);
			fragmentTransaction.commit();
			mTextView.setText("B");
			break;
		default:
		}
	}

}
