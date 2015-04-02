package example.swm.app.config;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import example.swm.app.entity.User;

public class MyApplication extends Application {

	
	private boolean isDownload;
	public  static MyApplication mInstance;
	public  static User user ; //保存用户的基本信息
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	
	@Override
	public void onCreate() {

		super.onCreate();
		isDownload = false;
		mInstance = this;
		initImageLoader(getApplicationContext());
	}
	public static MyApplication getInstance() {
		return mInstance;
	}
	public static void initImageLoader(Context context) {
		// Create default options which will be used for every
		// displayImage(...) call if no options will be passed to this method
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
				.cacheInMemory(true)
				.cacheOnDisc(true)
				.build();
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
				.threadPoolSize(3)// default
				.threadPriority(Thread.NORM_PRIORITY - 1)// default
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSizePercentage(13) // default
				.defaultDisplayImageOptions(defaultOptions)
				//.writeDebugLogs() // Remove for release app 日志log
				.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}
	public boolean isDownload() {
		return isDownload;
	}

	public void setDownload(boolean isDownload) {
		this.isDownload = isDownload;
	}
}
