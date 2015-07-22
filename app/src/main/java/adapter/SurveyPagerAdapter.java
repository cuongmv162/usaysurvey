package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fragment.SurveyFragment;
import model.Survey;

/**
 * Created by SleepyLee on 7/22/15.
 */
public class SurveyPagerAdapter extends FragmentPagerAdapter {
    List<Survey> mList;
    List<SurveyFragment> mListDisplayFragment;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public SurveyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mList = Survey.getTestSurveyList();
        mListDisplayFragment = new ArrayList<>();
        for(int i = 0; i < mList.size(); i++){
            mListDisplayFragment.add(SurveyFragment.newInstance(i, mList.get(i)));
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object instantiateItem(View container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position) {
        return mListDisplayFragment.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }


}
