package utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.application.usaysurvey.R;

public class Hashmarks extends LinearLayout {
	private ImageView[] hashmarks;
	private int currentIndex = 0;
	private Drawable selected;
	private Drawable idle;
	private OnPaginationItemClickListener mOnPaginationItemClickListener;
    private static final int MAX_HASHMARKS = 22;

	public Hashmarks(Context context) {
		super(context);
        DisplayMetricsUtil.getInstance(context);
	}

	public Hashmarks(Context context, AttributeSet attrs) {
		super(context, attrs);
        DisplayMetricsUtil.getInstance(context);
	}

	public interface OnPaginationItemClickListener {
		void onPaginationItemClick(int position);
	}

	public void initialize(int pageCount) {

		removeAllViews();
		currentIndex = 0;
		selected = getContext().getResources().getDrawable(R.drawable.pagination__off);
		idle = getContext().getResources().getDrawable(R.drawable.pagination__on);

		hashmarks = new ImageView[pageCount];
		for (int i = 0; i < hashmarks.length && i < MAX_HASHMARKS; i++) {
			hashmarks[i] = addHashmark(idle, i);
		}
	}

	public void setHighlightedIndex(int index) {
		if (hashmarks.length > currentIndex) {

			if (currentIndex < MAX_HASHMARKS - 1) {
				hashmarks[currentIndex].setImageDrawable(idle);
			} else {
				hashmarks[MAX_HASHMARKS - 1].setImageDrawable(idle);
			}

			currentIndex = index;
			if (currentIndex < MAX_HASHMARKS - 1) {
				hashmarks[currentIndex].setImageDrawable(selected);
			} else {
				// Highlighted square indicator must be stayed at last square
				// indicator (22th) when user swipes beyond to 66th modules.
				hashmarks[MAX_HASHMARKS - 1].setImageDrawable(selected);
			}
		}
	}

	private ImageView addHashmark(Drawable hashMark, int position) {
		ImageView imageView = new ImageView(getContext());
		imageView.setImageDrawable(hashMark);
        imageView.setPadding(DisplayMetricsUtil.convertPixelsToDp(6), 0, DisplayMetricsUtil.convertDpToPixel(6), 0);
		if (mOnPaginationItemClickListener != null)
			imageView.setOnClickListener(onItemClicked(position));
		addView(imageView);
		return imageView;
	}

	public void setOnPaginationItemClickListener(OnPaginationItemClickListener listener) {
		mOnPaginationItemClickListener = listener;

		int count = hashmarks.length;
		for (int index = 0; index < count; index++)
			hashmarks[index].setOnClickListener(onItemClicked(index));

	}

	private OnClickListener onItemClicked(int position) {
		final int pos = position;
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnPaginationItemClickListener.onPaginationItemClick(pos);
			}
		};
	}
}
