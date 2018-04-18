package com.sc.ty4.Controller.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sc.ty4.R;
public class MainFrag2 extends Fragment {
    private LinearLayout ll2;
    private String[] str;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_frag2,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ll2 = getActivity().findViewById(R.id.fenlei_ll2);
        str = getActivity().getResources().getStringArray(R.array.fenlei_wenzi_theme);
        for (int i = 0; i<str.length; i++){
            TextView text = new TextView(getActivity());
            text.setText(str[i]);
            text.setTextSize(20);
            //text.setBackgroundColor(Color.BLUE);
            text.setPadding(30,30,30,30);
            ll2.addView(text);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
