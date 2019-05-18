package application.wifi.wificonnector;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiConnector {
    private String mSSID ;
    private String mPassword;
    private Context mContext;
    WifiConnector(Context context, String ssid, String password){
        mSSID = ssid;
        mPassword = password;
        mContext = context;
    }
    public void connect(){
        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + mSSID + "\"";
        if(mPassword != ""){
            conf.preSharedKey = "\"" + mPassword +  "\"";
        }
        else{
            conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
        }
        WifiManager  wifiManager = (WifiManager)mContext.getSystemService(Context.WIFI_SERVICE);
        int netId = wifiManager.addNetwork(conf);
        Log.d("mayank", "connect: " + netId);
        if(netId == -1){
            Log.d("mayank", "connect: " + netId);
        }
        wifiManager.disconnect();
        wifiManager.enableNetwork(netId, true);
        boolean check = wifiManager.reconnect();
        Log.d("mayank", "connect: " + check);
    }
}
