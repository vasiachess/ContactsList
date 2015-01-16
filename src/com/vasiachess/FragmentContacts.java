package com.vasiachess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.widget.AdapterView.OnItemLongClickListener;

/**
 * Created by Vasiliy on 11.01.2015.
 */
public class FragmentContacts extends ListFragment {

    private static final String TAG = "fragment";
    myFastAdapter mAdapter;
    public EditText etName;
    public EditText etNumber;
    public EditText etEmail;
    public ImageView ivPhoto;

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        getListView().setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           final int position, long id) {
//                Toast.makeText(getActivity(), "On long click listener", Toast.LENGTH_LONG).show();

                final String selection = mAdapter.getName(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Edit contact " + selection + "?");
                    builder.setCancelable(false);
                builder.setPositiveButton("Edit",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

//                                    Toast.makeText(getActivity(), "Edit " + selection, Toast.LENGTH_LONG).show();

                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                LayoutInflater inflater = getActivity().getLayoutInflater();

                                final View view = inflater.inflate(R.layout.dialog_edit, null);
                                etName = (EditText) view.findViewById(R.id.etName);
                                etNumber = (EditText) view.findViewById(R.id.etNumber);
                                etEmail = (EditText) view.findViewById(R.id.etEmail);
                                ivPhoto = (ImageView) view.findViewById(R.id.edPhoto);

                                final String selName = mAdapter.getName(position);
                                final String selNumber = mAdapter.getNumber(position);
                                final String selEmail = mAdapter.getEmail(position);
                                final Integer selPhoto = mAdapter.getPhoto(position);

                                etName.setText(selName);
                                etNumber.setText(selNumber);
                                etEmail.setText(selEmail);
                                ivPhoto.setImageResource(selPhoto);

                                builder.setView(view);
                                builder.setTitle("Edit contact");
                                builder.setPositiveButton("Edit",
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {
                                             String edName=etName.getText().toString();
                                             String edNumber=etNumber.getText().toString();
                                             String edEmail=etEmail.getText().toString();

                                                mAdapter.EditContact(position, edName, edNumber, edEmail);
                                                setListAdapter(mAdapter);
                                            }
                                        }).setNegativeButton("Cancel",
                                                                                                                                                                                                                    new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog,
                                                int which) {
                                                    dialog.cancel();
                                                }
                                            });

                                            builder.show();
                                            }
                                        }).setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {
                                                dialog.cancel();
                                            }
                                        });

                                builder.show();


                                return true;
                            }
                        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Log.d(TAG, "MyFragment#onCreate");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "MyFragment#onCreateView");

        View view = inflater.inflate(R.layout.main, container, false);

        mAdapter = new myFastAdapter(getActivity());
        setListAdapter(mAdapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.PauseDialog);
//        builder.setTitle(mAdapter.getName(position))
//                .setMessage(mAdapter.getInf(position))
//                .setIcon(mAdapter.getPhoto(position))
//                .setCancelable(false)
//                .setNegativeButton("OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//        AlertDialog alert = builder.create();
//        alert.show();

        v = mAdapter.getView(position, null, null);

        Dialog dialog = new Dialog(getActivity(), R.style.Dialog);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setTitle("Contact");
        dialog.setContentView(v);
        dialog.show();

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    //    menu.clear();
        inflater.inflate(R.menu.main_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.sort:
                ChooseSort();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void ChooseSort() {
        final String[] mChoise ={"Sort by name", "Sort by email", "Sort by number"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose sort method");

        builder.setItems(mChoise, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
                switch (item) {
                    case 0:
                        mAdapter.SortbyName();
                        setListAdapter(mAdapter);
                        break;

                    case 1:
                        mAdapter.SortbyEmail();
                        setListAdapter(mAdapter);
                        break;

                    case 2:
                        mAdapter.SortbyNumber();
                        setListAdapter(mAdapter);
                        break;
                }
            }
        });
        builder.show();
    }

}