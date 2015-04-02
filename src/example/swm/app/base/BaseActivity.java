package example.swm.app.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * 所有的Activity继承的基类Activity
 * @author miss
 * 
 */
public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setView();
		initView();
		setListener();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	//设置布局文件
	public abstract void setView();

	//初始化布局文件中的控件
	public abstract void initView();
	//设置控件的监听
	public abstract void setListener();

}
