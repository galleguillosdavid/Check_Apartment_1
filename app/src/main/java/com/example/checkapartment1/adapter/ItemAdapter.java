package com.example.checkapartment1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checkapartment1.Model.Apartment;
import com.example.checkapartment1.databinding.ItemViewOneDepBinding;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.WordViewHolder> {
    private List<Apartment>wordList;
    private PassElementSelect mListener;


    public ItemAdapter(List<Apartment> wordList, PassElementSelect mListener) {
        this.wordList = wordList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewOneDepBinding mBinding = ItemViewOneDepBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return  new WordViewHolder(mBinding);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Apartment mProyecto = wordList.get(position);
        String mTextoProyecto = mProyecto.getBuildingName();
        holder.jtv_proyecto.setText(mTextoProyecto);

        Apartment mUnidad = wordList.get(position);
        String mTextoUnidad = mUnidad.getUnitId();
        holder.jtv_unidad.setText(mTextoUnidad);

        Apartment mDireccion = wordList.get(position);
        String mTextoDireccion = mDireccion.getAddress();
        holder.jtv_direccion.setText(mTextoDireccion);

        Apartment mUrl = wordList.get(position);
        String mTextoUrl = mUrl.getUrlImageBuilding();
        //holder.jiv_url.setImageURI();
        Glide.with(holder.itemView.getContext()).load(mUrl.getUrlImageBuilding()).into(holder.jiv_url);
    }

    @Override
    //Obtiene el tamaño de la vista, para saber cuentos elementos dibujar
    public int getItemCount() {
        return wordList.size();
    }

 /*   @Override
    public void onClick(View view) {
    //mListener.passElement(wordList.get(null());
        // mListener.passElement(mListener.get(getItemCount()));
        ;
    }
*/
    public interface PassElementSelect {
        void passElement (Apartment apartment);
    }


    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {//DepartamentosView Holder

        private TextView  jtv_proyecto   ;
        private TextView  jtv_unidad     ;
        private TextView  jtv_direccion  ;
        private ImageView jiv_url        ;


        public WordViewHolder(@NonNull ItemViewOneDepBinding mBinding) {
            super(mBinding.getRoot());
            //super(itemView);
            jtv_proyecto  = mBinding.xtvAproyecto    ;
            jtv_unidad    = mBinding.xtvAunidad      ;
            jtv_direccion = mBinding.xtvAunidad   ;
            jiv_url       = mBinding.xivAurl         ;
            itemView.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onClick(View view) {
            mListener.passElement(wordList.get(getAdapterPosition()));
        }
    }


}
