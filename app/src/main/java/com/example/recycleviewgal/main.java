package com.example.recycleviewgal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.intellij.lang.annotations.JdkConstants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class main extends Fragment implements com.example.recycleviewgal.RecyclerView {
    private ArrayList<DataModel> dataSet;

    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment main.
     */
    // TODO: Rename and change types and number of parameters
    public static main newInstance(String param1, String param2) {
        main fragment = new main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recycleView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity()); // new GridLayoutManager
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<DataModel>();

        for(int i=0 ; i<MyData.nameArray.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    //MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]


            ));
        }



        CustomAdapter addapter = new CustomAdapter(getContext(),dataSet,this);
        recycleView.setAdapter(addapter);

        return view;
    }


    @Override
    public void OnItemClick(int pos, View view) {
        String[] strArr = {"alen","arthur","fern","francis","george"};
        int[] imgArr = {R.drawable.ic_launcher_background,R.drawable.arthur,R.drawable.fern,R.drawable.francin,R.drawable.george};
        Bundle bundle = new Bundle();
        bundle.putString("description",strArr[pos]);
        bundle.putInt("image",imgArr[pos]);
        getParentFragmentManager().setFragmentResult("bundle",bundle);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.moveToSecondFrag();
    }
}