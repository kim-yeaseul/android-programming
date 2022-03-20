package com.example.a6_19;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    MyTabFragment myFrag[] = new MyTabFragment[3];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        MyTabFragment myTabFrag = null;

        if(myFrags[tab.getPosition()] == null) {
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        } else myTabFrag = myFrags[tab.getPosition()];

        fragmentTransaction.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    public static class MyTabFragment extends Fragment {
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        } //onCreate

        @Nullable

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName == "음악별") baseLayout.setBackgroundColor(Color.RED);
            if(tabName == "가수별") baseLayout.setBackgroundColor(Color.GREEN);
            if(tabName == "앨범별") baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;
        } //onCreateView
    } // MyTabFragment
}
