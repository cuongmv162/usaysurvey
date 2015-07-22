package fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.usaysurvey.R;
import com.squareup.picasso.Picasso;

import model.Survey;

/**
 * A simple {@link Fragment} subclass.
 */
public class SurveyFragment extends Fragment {
    public static final String TAG = SurveyFragment.class.getSimpleName();
    private static final String BUNDLE_KEY_PAGE = "intPage";
    private static final String BUNDLE_SURVEY_PACK = "survey";

    private Context mContext;
    private String mId;
    private TextView mNameText;
    private TextView mDescription;
    private ImageView mBackground;
    private Button mButtonTakeSurvey;

    private Survey mCurrentSurvey;
    private int mPage;

    public SurveyFragment() {
        // Required empty public constructor
    }

    public static SurveyFragment newInstance(int page, Survey survey) {
        SurveyFragment fragmentFirst = new SurveyFragment();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_KEY_PAGE, page);
        args.putParcelable(BUNDLE_SURVEY_PACK, survey);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    public void setContext(Context cont){
        this.mContext = cont;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Trung", "Fragment Pager - onActivityCreated");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mPage = args.getInt(BUNDLE_KEY_PAGE);
        Log.d("Trung", "Fragment Pager - onCreate, Page: "+mPage );
        mCurrentSurvey = args.getParcelable(BUNDLE_SURVEY_PACK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d("Trung", "Fragment Pager - onCreateView");
        View view = inflater.inflate(R.layout.survey_view_pager_item, container, false);
        init(view);

        return view;
    }

    public void init(View view){
        mNameText = (TextView)view.findViewById(R.id.place_name);
        mDescription = (TextView)view.findViewById(R.id.place_description);
        mBackground = (ImageView)view.findViewById(R.id.imageView);
        mButtonTakeSurvey = (Button)view.findViewById(R.id.button_take_survey);
        mNameText.setText(mCurrentSurvey.getName());
        mDescription.setText(mCurrentSurvey.getDescription());
        Picasso.with(getActivity())
                .load(mCurrentSurvey.getImageUrl())
                .into(mBackground);

        Log.d("Trung", "Finish init: \n "+mCurrentSurvey.toString());
    }



    @Override
    public void onResume() {
        super.onResume();
    }
}
