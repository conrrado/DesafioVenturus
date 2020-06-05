package com.ccamacho.desafioventurus.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ccamacho.desafioventurus.R;
import com.ccamacho.desafioventurus.databinding.FragmentImageBinding;
import com.ccamacho.desafioventurus.model.GalleryData;
import com.ccamacho.desafioventurus.util.ImageUtil;

public class ImageFragment extends Fragment {

    FragmentImageBinding binding;

    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentImageBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            try {
                GalleryData galleryData = ImageFragmentArgs.fromBundle(getArguments()).getGalleryData();
                ImageUtil.setImageView(binding.imageView, galleryData.getGalleryImageList().get(0).getLink());
                binding.textViewTitle.setText(galleryData.getTitle());
                binding.textViewViews.setText(String.valueOf(galleryData.getViews() + " " + getString(R.string.views)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}