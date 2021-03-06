package com.example.androidproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonthCalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonthCalendarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;
    View rootView2;
    public MonthCalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of`
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MonthCalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthCalendarFragment newInstance(int year, int month) {
        MonthCalendarFragment fragment = new MonthCalendarFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, year);
        args.putInt(ARG_PARAM2, month);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView2 = inflater.inflate(R.layout.fragment_month_calendar, container, false);

        // ????????? ?????? ??????
        String[] items = {"???", "???", "???", "???", "???", "???", "???"};

        //????????? ?????? (?????? ?????? ??????, simple_list_item_1 ????????? ??????
        ArrayAdapter<String> adapt
                = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items);

        // id??? ???????????? ?????? ??????????????? ????????? GridView ?????? ??????
        GridView gridview = rootView2.findViewById(R.id.gridView2);

        // ???????????? GridView ????????? ??????
        gridview.setAdapter(adapt);

        return inflater.inflate(R.layout.fragment_month_calendar, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();

        // ????????? ?????? ??????
        String[] items = {"???", "???", "???", "???", "???", "???", "???"};

        //????????? ?????? (?????? ?????? ??????, simple_list_item_1 ????????? ??????
        ArrayAdapter<String> adapt
                = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items);

        System.out.println("a");
        // id??? ???????????? ?????? ??????????????? ????????? GridView ?????? ??????
        GridView gridview = rootView2.findViewById(R.id.gridView2);

        System.out.println("b");

        // ???????????? GridView ????????? ??????
        gridview.setAdapter(adapt);

    }

}