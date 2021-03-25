package com.example.rainfallprediction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rainfallprediction.Predictiondata.Report;
import com.example.rainfallprediction.Predictiondata.Weather;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PredictionDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PredictionDetailFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String WEATHER_DIR = "weather";


    private String selectedMonth;
    private String selectedCrop;
    private String selectedYear;
    private Map<WeatherType, Weather> weatherReport;


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
            Bundle bundle = getArguments();
            selectedMonth = bundle.getString(MainFragment.PREDICTION_MONTH, "Jan");
            selectedCrop = bundle.getString(MainFragment.PREDICTION_CROP, "Rice");
            selectedYear = bundle.getString(MainFragment.PREDICTION_YEAR, "2010");
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
        Button nextButton = view.findViewById(R.id.nxt_btn);
        nextButton.setOnClickListener((v)-> {
            Bundle bundle = new Bundle();
            bundle.putString(NewFragment.SELECTED_CROP, selectedCrop);
            Navigation.findNavController(v).navigate(R.id.action_predictionDetailFragment_to_newFragment, bundle);
        });
        weatherReport = loadJSONFromAsset();
        temperatureTextView.setText(getPredictionValue(weatherReport.get(WeatherType.Temperature).getReport()));
        rainfallTextView.setText(getPredictionValue(weatherReport.get(WeatherType.Rainfall).getReport()));
        humidityTextView.setText(getPredictionValue(weatherReport.get(WeatherType.Humidity).getReport()));
        pressureTextView.setText(getPredictionValue(weatherReport.get(WeatherType.Pressure).getReport()));
        windTextView.setText(getPredictionValue(weatherReport.get(WeatherType.Wind).getReport()));

        return view;
    }

    private String getPredictionValue(List<Report> reportList) {
        double avg = 0.0;
        for (Report report : reportList) {
            avg += Double.parseDouble(getData(report));
        }
        return NumberFormat.getInstance().format(avg / reportList.size());
    }

    private String getData(Report report) {

        switch (selectedMonth) {
            case "Jan":
                return report.getJan();
            case "Feb":
                return report.getFeb();
            case "Mar":
                return report.getMar();
            case "Apr":
                return report.getApr();
            case "May":
                return report.getMay();
            case "Jun":
                return report.getJun();
            case "Jul":
                return report.getJul();
            case "Aug":
                return report.getAug();
            case "Sep":
                return report.getSep();
            case "Oct":
                return report.getOct();
            case "Nov":
                return report.getNov();
            case "Dec":
                return report.getDec();
            default:
                return report.getJan();
        }
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
                    try (InputStream is = getActivity().getAssets().open(WEATHER_DIR + "/" + fileName)) {
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