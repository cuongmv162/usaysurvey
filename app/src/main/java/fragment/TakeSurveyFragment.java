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

/**
 * A simple {@link Fragment} subclass.
 */
public class TakeSurveyFragment extends PlaceholderFragment {
    public static final String TAG = TakeSurveyFragment.class.getSimpleName();

    private ImageView imageView;

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
        imageView = (ImageView) getView().findViewById(R.id.imageView);
        Picasso.with(getActivity())
                .load("https://dhdbhh0jsld0o.cloudfront.net/m/b10685ce58b89ecbeef2_")
                .into(imageView);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
