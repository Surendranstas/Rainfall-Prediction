package com.example.rainfallprediction.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rainfallprediction.Predictiondata.Crop;
import com.example.rainfallprediction.Predictiondata.CropsList;
import com.example.rainfallprediction.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String SELECTED_CROP = "SELECTED CROP";

    // TODO: Rename and change types of parameters
    private String selectedCrop;
    private String mParam2;

    public NewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewFragment newInstance(String param1, String param2) {
        NewFragment fragment = new NewFragment();
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
            selectedCrop = getArguments().getString(SELECTED_CROP, "Rice");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new, container, false);
        TextView cropName = view.findViewById(R.id.cropname);
        TextView soilType = view.findViewById(R.id.soiltype);
        TextView cultivateMonths = view.findViewById(R.id.cultivatemonths);
        TextView soilTemp = view.findViewById(R.id.soiltemp);
        CropsList cropsList = loadJSONFromAsset();
        for (Crop crop : cropsList.getCropList()) {
            if (selectedCrop.equalsIgnoreCase(crop.getCropName())) {
                cropName.setText(crop.getCropName());
                soilType.setText(crop.getSoil());
                cultivateMonths.setText(crop.getCultivate().toString().replaceAll("(^\\[|]$)", ""));
                soilTemp.setText(crop.getTemp());
                break;
            }
        }
        return view;
    }

    public CropsList loadJSONFromAsset() {
        String json;
        Gson gson = new Gson();

        try {
            byte[] buffer;
            if (getActivity() != null) {
                    try (InputStream is = getActivity().getAssets().open("Crops" + "/" + "Crops.json")) {
                        int size = is.available();
                        buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        json = new String(buffer, StandardCharsets.UTF_8);
                      return  gson.fromJson(json, CropsList.class);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}