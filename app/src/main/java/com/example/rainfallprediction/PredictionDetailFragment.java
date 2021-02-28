package com.example.rainfallprediction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rainfallprediction.Predictiondata.MonthlyReport;
import com.example.rainfallprediction.Predictiondata.Weather;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PredictionDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PredictionDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String WEATHER_DIR = "weather";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<MonthlyReport> temperature;
    private List<MonthlyReport> rainfall;
    private List<MonthlyReport> humidity;
    private List<MonthlyReport> pressure;
    private List<MonthlyReport> wind;

    public PredictionDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PredictionDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PredictionDetailFragment newInstance(String param1, String param2) {
        PredictionDetailFragment fragment = new PredictionDetailFragment();
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
        View view = inflater.inflate(R.layout.fragment_prediction_detail, container, false);
        TextView temperatureTextView = view.findViewById(R.id.temperature);
        TextView rainfallTextView = view.findViewById(R.id.rainfall);
        TextView humidityTextView = view.findViewById(R.id.humidity);
        TextView pressureTextView = view.findViewById(R.id.pressure);
        TextView windTextView = view.findViewById(R.id.wind);

        Map<WeatherType, Weather> weatherReport = loadJSONFromAsset();
        temperature = weatherReport.get(WeatherType.Temperature).getGetMonthlyReport();
        for (MonthlyReport month: temperature){
            temperatureTextView.setText(month.getJan());
        }
        rainfall = weatherReport.get(WeatherType.Rainfall).getGetMonthlyReport();
        for (MonthlyReport month: rainfall){
            rainfallTextView.setText(month.getJan());
        }
        humidity = weatherReport.get(WeatherType.Humidity).getGetMonthlyReport();
        for (MonthlyReport month: humidity){
            humidityTextView.setText(month.getJan());
        }
        pressure = weatherReport.get(WeatherType.Pressure).getGetMonthlyReport();
        for (MonthlyReport month: pressure){
            pressureTextView.setText(month.getJan());
        }
        wind = weatherReport.get(WeatherType.Wind).getGetMonthlyReport();
        for (MonthlyReport month: wind){
            windTextView.setText(month.getJan());
        }

        return view;
    }


    public Map<WeatherType, Weather> loadJSONFromAsset() {
        String json = null;
        String[] fileList;
        Map<WeatherType, Weather> weatherInfoData = new HashMap<>();
        Gson gson = new Gson();
//        Type collectionType = new TypeToken<Collection<Weather>>() {}.getType();
//        StringBuilder sb = new StringBuilder();
         String jsonString = null;

        try {
            byte[] buffer;
            if (getActivity() != null) {
                fileList = getActivity().getAssets().list(WEATHER_DIR);
                for (String fileName : fileList) {
                    try (InputStream is = getActivity().getAssets().open(WEATHER_DIR +"/"+ fileName)) {
                        int size = is.available();
                        buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        json = new String(buffer, StandardCharsets.UTF_8);
//                        jsonString = sb.append(json).toString();
                        String[] weatherName = fileName.split("\\.");
                        weatherInfoData.put(WeatherType.valueOf(weatherName[0]), gson.fromJson(json, Weather.class));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return weatherInfoData;
    }
}