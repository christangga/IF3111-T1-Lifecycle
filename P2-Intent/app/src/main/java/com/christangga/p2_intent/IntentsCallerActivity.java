package com.christangga.p2_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class IntentsCallerActivity extends ActionBarActivity {

    private Spinner spinner;
    private Button buttonGo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_caller);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinner.getSelectedItemPosition();
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.google.com"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_CALL,
                                Uri.parse("tel:(+62)8997170052"));
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(+62)8997170052"));
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:50.123,7.1434?z=19"));
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=query"));
                        break;
                    case 5:
                        intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 6:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/"));
                        break;
                    case 7:
                        intent = new Intent(Intent.ACTION_EDIT,
                                Uri.parse("content://contacts/people/1"));
                        break;
                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            String result = data.toURI();
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
    }
}
