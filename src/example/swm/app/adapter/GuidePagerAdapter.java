package example.swm.app.adapter;

import example.swm.app.R;
import java.util.ArrayList;

import example.swm.app.ui.MainActivity;
import example.swm.app.util.SharedPreferencesUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author miss
 *
 */
public class GuidePagerAdapter extends PagerAdapter {

	private ArrayList<View> views;
	private Activity activity;

	public GuidePagerAdapter(ArrayList<View> views) {

		this.views = views;
	}

	public GuidePagerAdapter(ArrayList<View> views, Activity activity) {
		this.views = views;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		if (views != null) {
			return views.size();
		}
		return 0;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));
	}

	@Override
	public void finishUpdate(View arg0) {
	}

	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position));
		if (position == views.size() - 1) {
			Button button = (Button) container
					.findViewById(R.id.start_button);

			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					SharedPreferencesUtil.writeIsFirstUse(activity);
					goMain();
				}

			});
		}
		return views.get(position);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
	}

	private void goMain() {
		// ��ת
		Intent intent = new Intent(activity, MainActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}
}
