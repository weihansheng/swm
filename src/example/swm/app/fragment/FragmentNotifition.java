package example.swm.app.fragment;

import example.swm.app.R;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import example.swm.app.config.ImageOptionsUtil;
import example.swm.app.entity.User;
import example.swm.app.xlistview.XListView;

/**
* @Description 辅导员 Fragment

* @author MR.Wang

* @date 2014-7-5 上午1:13:26 

* @version V1.0
*/

public class FragmentNotifition extends Fragment{

	//view
	private View rootView;
	private XListView xListView;
    private LinearLayout loadLayout;
    private LinearLayout loadFaillayout;
    private Button bn_refresh;
	private ImageView ivDeleteText;
	private EditText etSearch;
	private Button btnSearch;
	//config
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	DisplayImageOptions options;
	//data
	private List<User> userList = new ArrayList<User>();
	private int page=0;
	private String searchSubject;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		options = ImageOptionsUtil.headImageOptions();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_notification,
				container, false);
		return rootView;
	}

	
	
}
