package com.example.exercicemodificationlist.activity;

import static com.example.exercicemodificationlist.fragment.ListFragment.EXTRA;
import static com.example.exercicemodificationlist.fragment.ListFragment.KEY_MODIFICATION;
import static com.example.exercicemodificationlist.fragment.ListFragment.mylistVoiture;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicemodificationlist.ApplicationData;
import com.example.exercicemodificationlist.R;
import com.example.exercicemodificationlist.adapter.VoitureAdapter;
import com.example.exercicemodificationlist.model.Voiture;

import java.util.ArrayList;

public class ModificationActivity extends AppCompatActivity {
    private EditText changeMarque;
    private EditText changeModel;
    private Button btnSave;
    private Voiture voiture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);

        voiture = (Voiture) getIntent().getSerializableExtra(EXTRA);
        changeMarque = findViewById(R.id.modMarque);
        changeModel = findViewById(R.id.modModel);
        btnSave = findViewById(R.id.modButtonSav);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnSave == view){
                    //enregistre la valeur A;Etape1
                    ApplicationData.getInstance().setVoitureAncienne(voiture);
                    //enregistre la valeur B;
                    ApplicationData.getInstance().setVoitureNouvelle(new Voiture(changeMarque.getText().toString(),changeModel.getText().toString()));

                    Log.d("Les mots sont",  changeMarque.getText().toString()+changeModel.getText().toString());
                }
                finish();
            }

        });

        setViewItem();
    }

    private void setViewItem(){
        changeMarque.setText(voiture.getMarque());
        changeModel.setText(voiture.getModel());
    }

    /*private void updateList() {
        for (Voiture voiture1 : mylistVoiture) {
            if(voiture.getMarque().indexOf(0)==(voiture1.getMarque().indexOf(0))){
                voiture1.setMarque(changeMarque.getText().toString());
            }
            // if(voiture.getModel().equalsIgnoreCase(voiture1.getModel())){
            //    voiture1.setModel(changeModel.getText().toString());
            // }
            mylistVoiture.add(voiture);
            voitureAdapter.setListVoitureAdapter(mylistVoiture);
            voitureAdapter.notifyDataSetChanged();
        }
        //Log.d("le mot est: ", String.valueOf(voiture));
        Toast.makeText(ModificationActivity.this," modification effectuée !",Toast.LENGTH_SHORT).show();
    }*/



}
