package com.mansourappdevelopment.androidapp.permissiondispatcher;

import android.Manifest;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //requestPermission();
        MainActivityPermissionsDispatcher.requestPermissionWithPermissionCheck(this);   //after building(compiling) the project

    }

    @NeedsPermission(Manifest.permission.READ_CONTACTS)
    public void requestPermission() {
        //this method needs read contacts permission to function properly.

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnShowRationale(Manifest.permission.READ_CONTACTS)
    public void showRationaleForContacts(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setTitle("Permission needed")
                .setMessage("Read contacts permission is needed for this feature to function properly")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .show();
    }

    @OnPermissionDenied(Manifest.permission.READ_CONTACTS)
    public void onContactsPermissionDenied() {
        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();

    }


    @OnNeverAskAgain(Manifest.permission.READ_CONTACTS)
    public void onContactsPermissionNeverAskAgain() {
        Toast.makeText(this, "Never ask again", Toast.LENGTH_SHORT).show();
    }

}
