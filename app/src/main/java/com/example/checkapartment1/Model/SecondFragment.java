package com.example.checkapartment1.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.checkapartment1.R;
import com.example.checkapartment1.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding mBinding;
    private String nombre;
    private String unidad;
    private String imagen;

    @Override//sobreescribir el metodo
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            String imagen = getArguments().getString("imagen");
            String nombre = getArguments().getString("nombre");
            String unidad = getArguments().getString("unidad");

        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
//        mBinding.xtvSproyecto.setText(imagen);
//        mBinding.xtvSunidad.setText(nombre);
//        mBinding.xtvSdireccion.setText(unidad);
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });


    }

}