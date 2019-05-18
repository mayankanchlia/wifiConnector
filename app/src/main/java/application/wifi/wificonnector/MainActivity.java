package application.wifi.wificonnector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
    private static String TAG = MainActivity.class.getSimpleName();
    private EditText ssidText ;
    private EditText passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.submit).setOnClickListener(this);
        findViewById(R.id.ssid_text).setOnClickListener(this);
        findViewById(R.id.wifipass).setOnClickListener(this);
        ssidText = (EditText)findViewById(R.id.ssid_text);
        passText = (EditText)findViewById(R.id.wifipass);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.submit:{
                String ssid = ssidText.getText().toString();
                String pass = passText.getText().toString();
                Log.d(TAG, "onClick: " + ssid + " " + pass);
                WifiConnector wifiConnector = new WifiConnector(getApplicationContext(),ssid,pass);
                wifiConnector.connect();
                Log.d(TAG, "onClick: submit" );
                break;
            }
        }
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
}
