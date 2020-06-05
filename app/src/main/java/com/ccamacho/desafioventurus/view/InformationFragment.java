package com.ccamacho.desafioventurus.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ccamacho.desafioventurus.BuildConfig;
import com.ccamacho.desafioventurus.R;
import com.ccamacho.desafioventurus.databinding.FragmentInformationBinding;

public class InformationFragment extends Fragment {

    FragmentInformationBinding binding;

    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInformationBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textViewAppName.setText(getString(R.string.app_name));
        binding.textViewAppVersion.setText(BuildConfig.VERSION_NAME);
        binding.textViewAppDescription.setText(getString(R.string.app_description));
        binding.textViewDeveloperBy.setText(getString(R.string.developer_by));
    }
}