package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmFragment extends Fragment {
    Button logConfirm;
    EditText adminName, password4;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConfirmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfirmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfirmFragment newInstance(String param1, String param2) {
        ConfirmFragment fragment = new ConfirmFragment();
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
        View v = inflater.inflate(R.layout.fragment_confirm, container, false);



        password4 = v.findViewById(R.id.password2);
        adminName = v.findViewById(R.id.adminId);
        logConfirm = v.findViewById(R.id.btnLogIn);
        logConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String pass = password4.getText().toString();
                String admin = adminName.getText().toString();


                if (pass.equals("") || pass.equals(""))
                    Toast.makeText(getContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();


                else {
                    String checkUserPass ="1111";
                    if (pass.equals("1111") ) {
                        Toast.makeText(getContext(), "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent myInt = new Intent(getActivity(), AdminActivity.class);
                        myInt.putExtra("key",adminName.getText().toString());
                        startActivity(myInt);

                    } else {
                        Toast.makeText(getActivity(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



        return v;
    }
}