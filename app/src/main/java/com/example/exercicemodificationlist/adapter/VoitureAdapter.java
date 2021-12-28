package com.example.exercicemodificationlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicemodificationlist.OnImgCancelClicked;
import com.example.exercicemodificationlist.OnMatCardClicked;
import com.example.exercicemodificationlist.OnModificateImageClickedAction;
import com.example.exercicemodificationlist.R;
import com.example.exercicemodificationlist.viewHolder.VoitureViewHolder;
import com.example.exercicemodificationlist.model.Voiture;

import java.util.ArrayList;

public class VoitureAdapter extends RecyclerView.Adapter<VoitureViewHolder> {
    private ArrayList<Voiture>listVoitureAdapter;
    private OnImgCancelClicked onImgCancelClicked;
    private OnMatCardClicked onMatCardClicked;
    private OnModificateImageClickedAction onModificateImageClickedAction;

    public VoitureAdapter(ArrayList<Voiture> listVoitureAdapter, OnImgCancelClicked onImgCancelClicked, OnMatCardClicked onMatCardClicked, OnModificateImageClickedAction onModificateImageClickedAction) {
        this.listVoitureAdapter = listVoitureAdapter;
        this.onImgCancelClicked = onImgCancelClicked;
        this.onMatCardClicked = onMatCardClicked;
        this.onModificateImageClickedAction = onModificateImageClickedAction;
    }

    public void setListVoitureAdapter(ArrayList<Voiture> listVoitureAdapter) {
        this.listVoitureAdapter = listVoitureAdapter;
    }

    @NonNull
    @Override
    public VoitureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_display,parent,false);
        return new VoitureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoitureViewHolder holder, int position) {
        holder.bind(listVoitureAdapter.get(position),onImgCancelClicked, onMatCardClicked, onModificateImageClickedAction);
    }

    @Override
    public int getItemCount() {
        return listVoitureAdapter.size();
    }
}
