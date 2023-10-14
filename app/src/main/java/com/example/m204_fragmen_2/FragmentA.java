package com.example.m204_fragmen_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        EditText txtNom = v.findViewById(R.id.nom);
        EditText txtPrix = v.findViewById(R.id.prix);
        EditText txtImage = v.findViewById(R.id.image);
        Switch swFPC = v.findViewById(R.id.FPC);
        Button btnSend = v.findViewById(R.id.calc);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nom = txtNom.getText().toString();
                Double prix = Double.valueOf(txtPrix.getText().toString());
                String image = txtImage.getText().toString();
                Boolean haveFPC = swFPC.isChecked();

                Bundle bun = new Bundle();
                bun.putString("n",nom);
                bun.putDouble("p",prix);
                bun.putString("url",image);
                bun.putBoolean("fpc",haveFPC);

                FragmentB fb = new FragmentB();
                fb.setArguments(bun);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,fb)
                        .commit();


            }
        });




        return v;



    }
}