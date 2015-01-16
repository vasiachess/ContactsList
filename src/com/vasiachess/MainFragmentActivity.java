package com.vasiachess;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.vasiachess.FragmentContacts.*;

/**
 * Created by Vasiliy on 11.01.2015.
 */
public class MainFragmentActivity extends Activity implements View.OnClickListener {

    private Button btnContacts;
    private Button btnBrowser;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment_activity);

        btnContacts = (Button) findViewById(R.id.buttonCont);
        btnBrowser = (Button) findViewById(R.id.buttonBrows);

        btnContacts.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == btnContacts) {
            onClickBtnCont();
        } else if (view == btnBrowser) {
            onClickBtnBrowser();
        }
    }

    private void onClickBtnCont() {

        FragmentContacts frag1 = new FragmentContacts();
        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(R.id.rlForFragment, frag1);
   //   fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

    }

    private void onClickBtnBrowser() {

        FragmentBrowser frag2 = new FragmentBrowser();
        FragmentManager fragmentManager2 = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager2.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(R.id.rlForFragment, frag2);
   //   fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

}
