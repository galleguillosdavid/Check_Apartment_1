package com.example.checkapartment1.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkapartment1.R;
import com.example.checkapartment1.adapter.ItemAdapter;
import com.example.checkapartment1.databinding.FragmentFirstBinding;

import static com.example.checkapartment1.adapter.Apartment.apartmentList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding mBinding;
    private RecyclerView mRecyclerView;
    private ItemAdapter mItemAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        mBinding = FragmentFirstBinding.inflate(inflater,container,false);

        mRecyclerView = mBinding.myRecycler;
        mItemAdapter = new ItemAdapter(apartmentList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mItemAdapter);

        return mBinding.getRoot();
        //return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}