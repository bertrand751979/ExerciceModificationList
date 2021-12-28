package com.example.exercicemodificationlist.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicemodificationlist.OnImgCancelClicked;
import com.example.exercicemodificationlist.OnMatCardClicked;
import com.example.exercicemodificationlist.OnModificateImageClickedAction;
import com.example.exercicemodificationlist.R;
import com.example.exercicemodificationlist.model.Voiture;
import com.google.android.material.card.MaterialCardView;

public class VoitureViewHolder extends RecyclerView.ViewHolder {
    private TextView vhModel;
    private TextView vhMarque;
    private ImageView vhDelete;
    private MaterialCardView materialCardView;
    private TextView vhStatut;
    private ImageView vhModificate;

    public VoitureViewHolder(@NonNull View view) {
        super(view);
        vhModel = view.findViewById(R.id.rawModel);
        vhMarque = view.findViewById(R.id.rawMarque);
        vhDelete = view.findViewById(R.id.rawImgDelete);
        materialCardView = view.findViewById(R.id.matCard);
        vhStatut = view.findViewById(R.id.rawClicked);
        vhModificate = view.findViewById(R.id.rawModificate);
    }

    public TextView getVhModel() {
        return vhModel;
    }

    public void setVhModel(TextView vhModel) {
        this.vhModel = vhModel;
    }

    public TextView getVhMarque() {
        return vhMarque;
    }

    public void setVhMarque(TextView vhMarque) {
        this.vhMarque = vhMarque;
    }

    public ImageView getVhDelete() {
        return vhDelete;
    }

    public void setVhDelete(ImageView vhDelete) {
        this.vhDelete = vhDelete;
    }

    public MaterialCardView getMaterialCardView() {
        return materialCardView;
    }

    public void setMaterialCardView(MaterialCardView materialCardView) {
        this.materialCardView = materialCardView;
    }

    public ImageView getVhModificate() {
        return vhModificate;
    }

    public void setVhModificate(ImageView vhModificate) {
        this.vhModificate = vhModificate;
    }

    public TextView getVhStatut() {
        return vhStatut;
    }

    public void setVhStatut(TextView vhStatut) {
        this.vhStatut = vhStatut;
    }

    public void bind(Voiture voiture, OnImgCancelClicked onImgCancelClicked, OnMatCardClicked onMatCardClicked, OnModificateImageClickedAction onModificateImageClickedAction){
        vhModel.setText(voiture.getModel());
        vhMarque.setText(voiture.getMarque()); ;
        vhDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImgCancelClicked.delete(voiture);
            }
        });
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMatCardClicked.displayOnEditText(voiture);
                vhStatut.setText("Clické");
            }
        });
        vhModificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onModificateImageClickedAction.modification(voiture);
            }
        });



    }
}
