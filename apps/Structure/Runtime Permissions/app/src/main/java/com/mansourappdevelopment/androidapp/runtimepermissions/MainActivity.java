package com.mansourappdevelopment.androidapp.runtimepermissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 922;
    private static final String TAG = "MainActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestContactsPermission();
    }

    private void requestContactsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            //permission isn't granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                //show your ui to tell the user why this is needed
                /*new AlertDialog.Builder(this)
                        .setTitle("Permission Needed")
                        .setMessage("Read Contacts Permission Is Needed To Function Properly")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);


                            }
                        }).show();*/

                Log.i(TAG, "requestContactsPermission: executed shouldShowRequestPermissionRationale");
            }

            Log.i(TAG, "requestContactsPermission: executed requestPermissions()");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "onRequestPermissionsResult: granted");
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                boolean showRelation = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS);    //false if the user checks never ask again
                if (showRelation) {
                    //handle degraded mode
                    //asking again until it is allowed, WTF xD
                    Log.i(TAG, "onRequestPermissionsResult: executed re-asking");
                    //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);

                } else {
                    //checked never ask again
                    Toast.makeText(this, "Permission permanently denied", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "onRequestPermissionsResult: denied forever");
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }
}
