package com.simplegeek.morseandroid.signals;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TorchController implements SignalController {

    private CameraManager cameraManager;
    private String cameraId;

    public TorchController(CameraManager cameraManager, String cameraId) {
        this.cameraManager = cameraManager;
        this.cameraId = cameraId;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void turnOn() {
        try {
            cameraManager.setTorchMode(cameraId, true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void turnOff() {
        try {
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
