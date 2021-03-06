package com.example.androidproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonthViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonthViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static int SUNDAY        = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GridView mGvCalendar;

    private ArrayList<DayInfo> mDayList;
    private CalendarAdapter mCalendarAdapter;

    Calendar mThisMonthCalendar;

    public MonthViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MonthViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthViewFragment newInstance(String param1, String param2) {
        MonthViewFragment fragment = new MonthViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println(("aaa"));

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        System.out.println(("aaa55"));
//
//
        View rootView = inflater.inflate(R.layout.fragment_month_view, container, false);

        mDayList = new ArrayList<DayInfo>();

        // ????????? ?????? ??????
        String[] items = {"???", "???", "???", "???", "???", "???", "???"};


        //????????? ?????? (?????? ?????? ??????, simple_list_item_1 ????????? ??????
        ArrayAdapter<String> adapt
                = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items);

        // id??? ???????????? ?????? ??????????????? ????????? GridView ?????? ??????
        GridView gridview = rootView.findViewById(R.id.gridView2);

        // ???????????? GridView ????????? ??????
        gridview.setAdapter(adapt);
//        TextView textView = rootView.findViewById(R.id.textView);
//
//        textView.setText("abc");

        System.out.println(("================================================="));

        GridView gridView = rootView.findViewById(R.id.gridView);
        GridListAdapter adapter = new GridListAdapter();
        gridView.setAdapter(adapter);

        mGvCalendar = rootView.findViewById(R.id.gridView);

        System.out.println(("bbb33"));
        ViewPager2 vpPager = rootView.findViewById(R.id.vpPager);
        FragmentStateAdapter frag_adapter = new MonthCalendarAdapter(this);
        vpPager.setAdapter(frag_adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        // ????????? ??? ????????? ??????????????? ????????????.
        mThisMonthCalendar = Calendar.getInstance();
        mThisMonthCalendar.set(Calendar.DAY_OF_MONTH, 1);
        getCalendar(mThisMonthCalendar);
    }

    /**
     * ????????? ????????????.
     *
     * @param calendar ????????? ???????????? ???????????? Calendar ??????
     */
    private void getCalendar(Calendar calendar)
    {
        int lastMonthStartDay;
        int dayOfMonth;
        int thisMonthLastDay;

        mDayList.clear();

        // ????????? ???????????? ????????? ?????????. ???????????? ???????????? ?????? ???????????? 1(?????????)?????? 8(????????? ?????????)??? ?????????.)
        dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
        thisMonthLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, -1);

        // ???????????? ????????? ????????? ?????????.
        lastMonthStartDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, 1);

        if(dayOfMonth == SUNDAY)
        {
            dayOfMonth += 7;
        }

        lastMonthStartDay -= (dayOfMonth-1)-1;


        // ????????? ?????????(?????? ??????)??? ????????????.
//        mTvCalendarTitle.setText(mThisMonthCalendar.get(Calendar.YEAR) + "??? "
//                + (mThisMonthCalendar.get(Calendar.MONTH) + 1) + "???");

        DayInfo day;

        for(int i=0; i<dayOfMonth-1; i++)
        {
            int date = lastMonthStartDay+i;
            day = new DayInfo();
            day.setDay(Integer.toString(date));
            day.setInMonth(false);

            mDayList.add(day);
        }
        for(int i=1; i <= thisMonthLastDay; i++)
        {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(true);

            mDayList.add(day);
        }
        for(int i=1; i<42-(thisMonthLastDay+dayOfMonth-1)+1; i++)
        {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(false);
            mDayList.add(day);
        }

        initCalendarAdapter();
    }

    private void initCalendarAdapter()
    {
        mCalendarAdapter = new CalendarAdapter(getActivity().getBaseContext(), R.layout.day, mDayList);
        mGvCalendar.setAdapter(mCalendarAdapter);
    }
}