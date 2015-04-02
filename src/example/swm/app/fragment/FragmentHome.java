package example.swm.app.fragment;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import example.swm.app.R;
import example.swm.app.widget.KeywordsFlow;

/**
 * 
 * @Description 首页 Fragment
 * 
 * @author MR.Wang
 * 
 * @date 2014-7-5 上午12:32:06
 * 
 * @version V1.0
 */

@SuppressLint("ValidFragment")
public class FragmentHome extends Fragment implements OnClickListener {

	// view
	public static View rootView;
	private Context context;
	private LinearLayout loadingLayout;
	private LinearLayout loadFaillayout;
	private Button btn_refresh;
	public String[] keywords = { "C++", "Java", "English", "Php", "Ruby",
			"Phython", "Chinese", "MacBook Pro", "SPY Mouse", "Thinkpad E40",
			"CSDN leak", "3D", "4743G", "mmShow", "iciba", "App", "Internet",
			"Time", "Chrome", "Safari", "Siri", "A5", "iPhone4S", "ME525",
			" M9", "S2500" };
	private KeywordsFlow keywordsFlow;
	private Button btnLast, btnNext;
	private ImageView ivDeleteText;
	private EditText etSearch;
	private Button btnSearch;
	private String searchName;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		context = getActivity();
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.fragment_home, container,
					false);
			findId();
			initView(rootView);
			initEvent();
		}
		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}
		return rootView;
	}

	private void findId() {
		// TODO Auto-generated method stub
		loadFaillayout = (LinearLayout) rootView
				.findViewById(R.id.view_load_fail);
		loadingLayout = (LinearLayout) rootView.findViewById(R.id.view_loading);
		loadFaillayout.setVisibility(View.GONE);
		loadingLayout.setVisibility(View.GONE);
		btn_refresh = (Button) rootView.findViewById(R.id.bn_refresh);
		btn_refresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// loadNews(1, true);
				// loadNotice();
				// LoginUtil.Login(context);
			}
		});
		btnLast = (Button) rootView.findViewById(R.id.btn_last);
		btnNext = (Button) rootView.findViewById(R.id.btn_next);
		ivDeleteText = (ImageView) rootView.findViewById(R.id.ivDeleteText);
		etSearch = (EditText) rootView.findViewById(R.id.etSearch);
		btnSearch = (Button) rootView.findViewById(R.id.btnSearch);

		keywordsFlow = (KeywordsFlow) rootView.findViewById(R.id.keywordsflow);
		keywordsFlow.setDuration(800l);
		KeyWordClick mClick = new KeyWordClick();
		keywordsFlow.setOnItemClickListener(mClick);
		// 添加
		feedKeywordsFlow(keywordsFlow, keywords);
		keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);

	}

	private void initView(View rootView2) {
		// TODO Auto-generated method stub
		btnLast.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		ivDeleteText.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
		searchName = etSearch.getText().toString();

		etSearch.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					ivDeleteText.setVisibility(View.GONE);
				} else {
					ivDeleteText.setVisibility(View.VISIBLE);
				}
			}
		});

	}

	private void initEvent() {
		// TODO Auto-generated method stub
		btnLast.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		ivDeleteText.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
		searchName = etSearch.getText().toString();

		etSearch.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					ivDeleteText.setVisibility(View.GONE);
				} else {
					ivDeleteText.setVisibility(View.VISIBLE);
				}
			}
		});

	}

	private static void feedKeywordsFlow(KeywordsFlow keywordsFlow, String[] arr) {
		Random random = new Random();
		for (int i = 0; i < KeywordsFlow.MAX; i++) {
			int ran = random.nextInt(arr.length);
			String tmp = arr[ran];
			keywordsFlow.feedKeyword(tmp);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_last:
			keywordsFlow.rubKeywords();
			// keywordsFlow.rubAllViews();
			feedKeywordsFlow(keywordsFlow, keywords);
			keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
			break;
		case R.id.btn_next:
			keywordsFlow.rubKeywords();
			// keywordsFlow.rubAllViews();
			feedKeywordsFlow(keywordsFlow, keywords);
			keywordsFlow.go2Show(KeywordsFlow.ANIMATION_OUT);
			break;
		case R.id.ivDeleteText:
			etSearch.setText("");
			break;

		case R.id.btnSearch:
			if (!searchName.equals(etSearch.getText().toString())) {
				searchName = etSearch.getText().toString();
				/*
				 * loadLayout.setVisibility(View.VISIBLE); adapter.clear();
				 * page=0; searchName= etSearch.getText().toString();
				 * loadSeek(1,true); InputMethodManager imm =
				 * (InputMethodManager
				 * )getActivity().getSystemService(Context.INPUT_METHOD_SERVICE
				 * );
				 * imm.hideSoftInputFromWindow(getActivity().getCurrentFocus()
				 * .getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
				 */
			}
			break;

		default:
			break;
		}

	}

	public class KeyWordClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v instanceof TextView) {
				String keyword = ((TextView) v).getText().toString();
				System.out.println(keyword);
				Intent intent = new Intent();
				// intent.setClass(getActivity(), GroupListActivity.class);
				// intent.setAction(Intent.ACTION_VIEW);
				// intent.addCategory(Intent.CATEGORY_DEFAULT);
				// intent.setData(Uri.parse("http://www.google.com.hk/#q=" +
				// keyword));
				// startActivity(intent);
			}
		}

	}

}
