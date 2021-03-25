package com.example.rainfallprediction.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.rainfallprediction.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String PREDICTION_YEAR = "PREDICTION YEAR";
    public static final String PREDICTION_MONTH = "PREDICTION MONTH";
    public static final String PREDICTION_CROP = "PREDICTION CROP";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String[] months = {"MONTH","Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String[] year = {"YEAR","2021","2022", "2023", "2024", "2025", "2026", "2027"};
    private String[] crops = {"CROP","Rice","Sugarcane", "Groundnut", "Sorghum", "Tomato","Cotton","Maize"};
    private Spinner monthSpinner, cropSpinner, yearSpinner;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
         monthSpinner = view.findViewById(R.id.month_spinner);
        setMonthSpinner();
         yearSpinner = view.findViewById(R.id.year_spinner);
        setYearSpinner();
        cropSpinner = view.findViewById(R.id.crop_spinner);
        setCropYear();

        Button button = view.findViewById(R.id.Prediction_btn);
        button.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString(PREDICTION_MONTH, monthSpinner.getSelectedItem().toString());
            bundle.putString(PREDICTION_YEAR, yearSpinner.getSelectedItem().toString());
            bundle.putString(PREDICTION_CROP, cropSpinner.getSelectedItem().toString());
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_predictionDetailFragment, bundle);
        });
        return view;
    }

    private void setCropYear() {
        ArrayAdapter<String> monthArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, crops);
        monthArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        cropSpinner.setAdapter(monthArrayAdapter);
    }

    private void setYearSpinner() {
        ArrayAdapter<String> monthArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, year);
        monthArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        yearSpinner.setAdapter(monthArrayAdapter);
    }

    private void setMonthSpinner() {
        ArrayAdapter<String> monthArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, months);
        monthArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthArrayAdapter);
    }
}