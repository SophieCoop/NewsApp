package com.example.home.newsapp.baseline;

import android.support.v4.app.Fragment;
import com.example.home.newsapp.events.UpdateActionBarTitleEvent;
import org.greenrobot.eventbus.EventBus;


public class BasicFragment extends Fragment {

    public void updateActionBarTitle(String title){
        EventBus.getDefault().post(new UpdateActionBarTitleEvent(title));
    }
}
