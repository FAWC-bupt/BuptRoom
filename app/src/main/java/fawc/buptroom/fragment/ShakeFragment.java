package fawc.buptroom.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import fawc.buptroom.R;

/**
 * Created by think on 20162016/10/11 001121:07
 * PACKAGE:fawc.buptroom
 * PROJECT:BuptRoom
 */

public class ShakeFragment extends Fragment {
    private boolean shakedflag = false;
    public Button startbt;
    public Button endbt;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shake, container, false);
    }


}