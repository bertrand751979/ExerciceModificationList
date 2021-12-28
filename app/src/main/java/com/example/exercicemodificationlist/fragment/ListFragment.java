package com.example.exercicemodificationlist.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicemodificationlist.ApplicationData;
import com.example.exercicemodificationlist.OnImgCancelClicked;
import com.example.exercicemodificationlist.OnMatCardClicked;
import com.example.exercicemodificationlist.OnModificateImageClickedAction;
import com.example.exercicemodificationlist.R;
import com.example.exercicemodificationlist.activity.MainActivity;
import com.example.exercicemodificationlist.activity.ModificationActivity;
import com.example.exercicemodificationlist.adapter.VoitureAdapter;
import com.example.exercicemodificationlist.model.Voiture;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    public static String KEY_MODIFICATION = "keyModification";
    private VoitureAdapter voitureAdapter;
    public static ArrayList<Voiture> mylistVoiture = new ArrayList<>();
    private RecyclerView recyclerView;
    public EditText editMarque;
    public EditText editModel;
    private Button btnDisplayList;
    public static String MY_LIST_VOITURE = "listeVoiture";
    public static String EXTRA = "extra";
    private Voiture voiture;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Voiture voiture1 = new Voiture("Renault", "Picasso");
        Voiture voiture2 = new Voiture("Toyota", "Rav4");
        Voiture voiture3 = new Voiture("Nissan", "Note");
        Voiture voiture4 = new Voiture("Chrysler", "Voyager");
        Voiture voiture5 = new Voiture("Suzuky", "Compass");
        mylistVoiture.add(voiture1);
        mylistVoiture.add(voiture2);
        mylistVoiture.add(voiture3);
        mylistVoiture.add(voiture4);
        mylistVoiture.add(voiture5);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList(ApplicationData.getInstance().getVoitureAncienne(), ApplicationData.getInstance().getVoitureNouvelle());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewDisplay);
        editMarque = view.findViewById(R.id.edit_marque);
        editModel = view.findViewById(R.id.edit_model);
        btnDisplayList = view.findViewById(R.id.btn_display);
        btnDisplayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addVoiture();
            }
        });

        //if(ApplicationData.getInstance().getChanging(KEY_MODIFICATION)!=null){
        //updateList();
        // }
        setViewItem();
    }

    public void setViewItem() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnImgCancelClicked onImgCancelClicked = new OnImgCancelClicked() {
            @Override
            public void delete(Voiture voiture) {
                mylistVoiture.remove(voiture);
                voitureAdapter.setListVoitureAdapter(mylistVoiture);
                voitureAdapter.notifyDataSetChanged();
            }
        };
        OnMatCardClicked onMatCardClicked = new OnMatCardClicked() {
            @Override
            public void displayOnEditText(Voiture voiture) {
                editMarque.setText(voiture.getMarque());
                editModel.setText(voiture.getModel());
            }
        };

        OnModificateImageClickedAction onModificateImageClickedAction = new OnModificateImageClickedAction() {
            @Override
            public void modification(Voiture voiture) {
                Intent intent = new Intent(ListFragment.this.getContext(), ModificationActivity.class);
                intent.putExtra(EXTRA, voiture);
                startActivity(intent);
            }
        };
        voitureAdapter = new VoitureAdapter(mylistVoiture, onImgCancelClicked, onMatCardClicked, onModificateImageClickedAction);
        recyclerView.setAdapter(voitureAdapter);
    }

    private void addVoiture() {
        Voiture voiture = new Voiture();
        voiture.setMarque(editMarque.getText().toString());
        voiture.setModel(editModel.getText().toString());
        mylistVoiture.add(voiture);
        voitureAdapter.setListVoitureAdapter(mylistVoiture);
        voitureAdapter.notifyDataSetChanged();
        Toast.makeText(ListFragment.this.getContext(), "La taille de la liste est: " + mylistVoiture.size(), Toast.LENGTH_LONG).show();
    }

    private void updateList(Voiture oldCar, Voiture newCar) {
        if (oldCar.getMarque() == null|| (oldCar.getModel() == null)){
            return;
        }

        for (Voiture voiture : mylistVoiture) {
            if (oldCar.getMarque().equalsIgnoreCase(voiture.getMarque())
                    && (oldCar.getModel().equalsIgnoreCase(voiture.getModel()))) {
                voiture.setMarque(newCar.getMarque());
                voiture.setModel(newCar.getModel());
            }
        }
        voitureAdapter.setListVoitureAdapter(mylistVoiture);
        voitureAdapter.notifyDataSetChanged();
        Toast.makeText(ListFragment.this.getContext(), " modification effectuée !", Toast.LENGTH_SHORT).show();
    }

}
