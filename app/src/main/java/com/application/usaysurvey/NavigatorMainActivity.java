package com.application.usaysurvey;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import fragment.AboutFragment;
import fragment.PlaceholderFragment;
import fragment.TakeSurveyFragment;


public class NavigatorMainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, View.OnClickListener {
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;
    private ImageView mRefresh;

    public static final int MENU_TAKE_SURVEY = 0;
    public static final int MENU_ABOUT_THIS = 1;
    public static final int MENU_QUIT = 2;
    private static boolean isFirstLaunch = true;
    private boolean mIsOnSurveyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        PlaceholderFragment fragment = null;
        Bundle args = new Bundle();
        if(!isFirstLaunch && position != 2){
            slideToNext(true);
        }
        switch(position){
            case 0:
                fragment = new TakeSurveyFragment();
                fragment.setContext(this);
                args.putInt(PlaceholderFragment.ARG_SECTION_NUMBER, MENU_TAKE_SURVEY);
                mIsOnSurveyPage = true;
                break;
            case 1:
                fragment = new AboutFragment();
                fragment.setContext(this);
                args.putInt(PlaceholderFragment.ARG_SECTION_NUMBER, MENU_ABOUT_THIS);
                mIsOnSurveyPage = false;
                break;
            case 2:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(getString(R.string.quit_application_title))
                        .setMessage(getString(R.string.quit_application_text))
                        .setPositiveButton(getString(R.string.quit_application_positive), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        })
                        .setNegativeButton(getString(R.string.quit_application_negative), null)
                        .show();
        }
        if(fragment != null){
            fragment.setArguments(args);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

        }
        isFirstLaunch = false;
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(R.string.side_menu_section_1);
                break;
            case 1:
                mTitle = getString(R.string.side_menu_section_2);
                break;
            case 2:
                mTitle = getString(R.string.side_menu_section_3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_display_actionbar);
        mRefresh = (ImageView)findViewById(R.id.refresh_button);
        ((TextView)findViewById(R.id.title)).setText(mTitle);
        if(mIsOnSurveyPage){
            mRefresh.setVisibility(View.VISIBLE);
            mRefresh.setOnClickListener(this);
        }else{
            mRefresh.setVisibility(View.GONE);
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getString(R.string.quit_application_title))
                .setMessage(getString(R.string.quit_application_text))
                        .setPositiveButton(getString(R.string.quit_application_positive), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        })
                                .setNegativeButton(getString(R.string.quit_application_negative), null)
                                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        restoreActionBar();

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.refresh_button:
                break;
            default:
                break;
        }
    }

    private void slideToNext(boolean isRightToLeft) {
        ViewGroup view = (ViewGroup)findViewById(R.id.container);
        Animation in;
        if (isRightToLeft) {
            in = AnimationUtils.loadAnimation(this, R.anim.slide_left_to_right);
        } else {
            in = AnimationUtils.loadAnimation(this, R.anim.slide_right_to_left);
        }

        in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(in);
    }

    @Override
    protected void onStop() {
        super.onStop();
        isFirstLaunch = true;
    }
}
