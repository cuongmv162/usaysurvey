package utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;


public class DisplayMetricsUtil {


	private static DisplayMetricsUtil INSTANCE = null;

	private static Context mContext;

	private DisplayMetricsUtil(Context context){
		mContext = context;
	}

	public static DisplayMetricsUtil getInstance(Context mContext){
		if(INSTANCE != null)
			return INSTANCE;
		else{
			return new DisplayMetricsUtil(mContext);
		}
	}
	
	/**
	 * This method convets dp unit to equivalent device specific value in pixels. 
	 * 
	 * @param dp A value in dp(Device independent pixels) unit. Which we need to convert into pixels
	 * @return A float value to represent Pixels equivalent to dp according to device
	 */
	public static int convertDpToPixel(float dp){
	    Resources resources = mContext.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    float px = dp * (metrics.densityDpi/160f);
	    return Math.round(px);
	}
	
	/**
	 * This method converts device specific pixels to device independent pixels.
	 * 
	 * @param px A value in px (pixels) unit. Which we need to convert into db
	 * @return A float value to represent db equivalent to px value
	 */
	public static int convertPixelsToDp(float px){
	    Resources resources = mContext.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    float dp = px / (metrics.densityDpi / 160f);
	    return Math.round(dp);
	}
	
	public static int getDeviceScreenWidth(Activity activity){
		return activity.getWindow().getWindowManager().getDefaultDisplay().getWidth();
	}
	
	public static int getDeviceScreenHeight(Activity activity){
		return activity.getWindow().getWindowManager().getDefaultDisplay().getHeight();
	}
}