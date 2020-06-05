package com.ccamacho.desafioventurus.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.ccamacho.desafioventurus.R;
import com.ccamacho.desafioventurus.adapters.CatListAdapter;
import com.ccamacho.desafioventurus.databinding.FragmentCatListBinding;
import com.ccamacho.desafioventurus.viewmodel.CatListViewModel;

import java.util.ArrayList;

public class CatListFragment extends Fragment {

    private FragmentCatListBinding binding;
    private CatListViewModel viewModel;
    private CatListAdapter adapter;

    public CatListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCatListBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CatListViewModel.class);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        adapter = new CatListAdapter(new ArrayList<>());
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);

        viewModel.getCatGalleryList();
        receiveGalleryList();
    }

    private void receiveGalleryList() {
        viewModel.galleryListMutableLiveData.observe(getViewLifecycleOwner(), galleryList -> {
            adapter.updateList(galleryList);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.information_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_information) {
            openInformationScreen();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openInformationScreen() {
        NavDirections action = CatListFragmentDirections.actionToInformationFragment();
        Navigation.findNavController(requireView()).navigate(action);
    }
}