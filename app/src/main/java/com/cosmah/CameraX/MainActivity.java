package com.cosmah.CameraX;


import android.Manifest;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


    }

    //CAMERA PERMISSION
    private static final String[] PERMISSIONS = {
            Manifest.permission.CAMERA
    };

    private static final int REQUEST_PERMISSIONS = 34;

    //storage permission
    private  static final int PERMISSIONS_COUNT = 1;

    //CHECK IF PERMISSION DENIED
    @SuppressLint("NewApi")
    private boolean arePermissionsDenied(){
        for (int i = 0; i < PERMISSIONS_COUNT; i++){

                if (checkSelfPermission(PERMISSIONS[i])!= PackageManager.PERMISSION_GRANTED){
                    return true;
                }

        }
        return false;
    };

    //REQUEST PERMISSION
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission,
                                          int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permission, grantResults);

        if (requestCode == REQUEST_PERMISSIONS && grantResults.length > 0){
            if (arePermissionsDenied()){
                ((ActivityManager)(this.getSystemService(ACTIVITY_SERVICE))).clearApplicationUserData();
                recreate();
            }else {
                onResume();
            }
        }
    }

    private boolean isCameraInitialized;

    private Camera nCamera = null;


    @Override
    protected void onResume() {
        super.onResume();
        //CHECK IF ANDROID VERSION IS SAME OR GRETER THAN ANDROID MASHMELLOW
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && arePermissionsDenied()){
            //ASK FOR PERMISSION
            requestPermissions(PERMISSIONS, REQUEST_PERMISSIONS);
            return;
        }

        if (!isCameraInitialized){

        }
    }
}