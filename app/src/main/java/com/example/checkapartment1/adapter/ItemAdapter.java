package com.example.checkapartment1.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkapartment1.Model.Apartment;
import com.example.checkapartment1.databinding.ItemViewOneDepBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.WordViewHolder> {
    private List<Apartment>wordList;

    public ItemAdapter(List<Apartment> wordList) {
        this.wordList = wordList;
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
        String mWord = String.valueOf(wordList.get(position));
        holder.textView.setText(mWord);
    }

    @Override
    //Obtiene el tamaño de la vista, para saber cuentos elementos dibujar
    public int getItemCount() {
        return wordList.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder {//DepartamentosView Holder

        private TextView textView;
        private ImageView imageView;
        private  String string;

        public WordViewHolder(@NonNull ItemViewOneDepBinding mBinding) {
            super(mBinding.getRoot());
            //super(itemView);
            textView = mBinding.wordTv;

        }

    }
}
