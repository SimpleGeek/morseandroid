package com.simplegeek.morseandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.simplegeek.morseandroid.parser.Parser;
import com.simplegeek.morseandroid.signals.SignalController;
import com.simplegeek.morseandroid.signals.TorchController;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    private Button playMsgBtn;
    private EditText msgTxt;
    private SignalController signalController;
    private Parser parser = new Parser();

    // Storing camera related objects as globals here
    // as well as passing them to the signal controller
    // since we need to be sure that we turn them off
    // when the app terminates.  (See finish().)
    private CameraManager cameraManager = null;
    private String cameraId = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registering the ToggleButton
        playMsgBtn = findViewById(R.id.play_msg);

        // Registering the EditText
        msgTxt = findViewById(R.id.msg);

        // Initializing camera manager
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        if (cameraManager != null && cameraId != null) {
            signalController = new TorchController(cameraManager, cameraId);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void playMsg(View view) {
        // Parsing the text into a list of Word objects to represent the message
        List<Word> msg = parser.getMessage(msgTxt.getText().toString());

        // Looping over the message, and playing each word with the signal controller
        msg.forEach(w -> w.playWord(signalController));

        // Catch-all to make sure the signal controller is off at this point
        signalController.turnOff();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void finish() {
        super.finish();

        // Shut off the torch when shutting down
        try {
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

}