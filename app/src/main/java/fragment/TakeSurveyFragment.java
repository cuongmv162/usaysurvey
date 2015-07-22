package fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.application.usaysurvey.R;
import com.squareup.picasso.Picasso;

import adapter.SurveyPagerAdapter;
import utils.customlayout.VerticViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class TakeSurveyFragment extends PlaceholderFragment {
    public static final String TAG = TakeSurveyFragment.class.getSimpleName();

    private ImageView imageView;
    private VerticViewPager mViewPager;
    private SurveyPagerAdapter mAdapter;

    public TakeSurveyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_take_survey, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    public void init(){
        View currentView = getView();
        mViewPager = (VerticViewPager) currentView.findViewById(R.id.survey_view_pager);
        mAdapter = new SurveyPagerAdapter(getFragmentManager(),mContext);
        mViewPager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
