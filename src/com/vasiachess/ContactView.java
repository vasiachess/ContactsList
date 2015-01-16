package com.vasiachess;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.*;

/**
 * Created by Vasiliy on 14.01.2015.
 */
public class ContactView extends LinearLayout {

    private TextView tvName;
    private TextView tvNumber;
    private TextView tvEmail;

    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.contact_view, this);

        tvName = (TextView) findViewById(R.id.name);
        tvNumber = (TextView) findViewById(R.id.number);
        tvEmail = (TextView) findViewById(R.id.email);

    }

}
