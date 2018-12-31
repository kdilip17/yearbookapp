package com.example.hmspl.yearbookapp.modules;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.example.hmspl.yearbookapp.modules.webservices.RequestPopulateHandler;

public class ServiceAvailable {
    private static ServiceAvailable sServiceAvailable = null;

    public static ServiceAvailable getInstance() {
        if (sServiceAvailable == null) {
            sServiceAvailable = new ServiceAvailable();
        }
        return sServiceAvailable;
    }
    public boolean haveNetworkConnection(Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
