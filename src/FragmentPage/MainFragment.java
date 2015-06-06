package FragmentPage;

import com.example.testfragment.MainActivity;
import com.example.testfragment.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment{

	private String tag = "MainFragment";
	private boolean D = true;
	private Button btnAdd,btnSub;
	private Handler mHandler;
	
	public MainFragment(Handler handler){
		mHandler = handler;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if(D)Log.d(tag, "onActivityCreated");
		
		View view = getView();
		btnAdd = (Button) view.findViewById(R.id.btnFragAdd1);
		
		btnAdd.setOnClickListener(new View.OnClickListener() {
			
			//send message to add number of badge.
			@Override
			public void onClick(View v) {
				mHandler.obtainMessage(MainActivity.NEW_MESSAGE, MainActivity.BTN1).sendToTarget();
			}
		});
		
		btnSub = (Button) view.findViewById(R.id.btnFragSub1);
		
		btnSub.setOnClickListener(new View.OnClickListener() {
			
			//send message to submit newMessage already read.
			@Override
			public void onClick(View v) {
				mHandler.obtainMessage(MainActivity.READ_MESSAGE, MainActivity.BTN1).sendToTarget();				
			}
		});
		
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(D)Log.d(tag, "onAttach");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(D)Log.d(tag, "onCreateView");
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		return rootView;
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}
	
}
