package com.example.sp_lab_3_2_http;

import android.view.View;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.lang.*;

public class NetworkThread extends Thread {
    String osoite;
    String palautus;
    MainActivity main = new MainActivity();

    public interface MyInterface {
        void palauta(String palautus);
    }

    public NetworkThread(MyInterface myInterface, String o) {
        callBackInterface = myInterface;
        osoite = o;
    }

    MyInterface callBackInterface = null;

    public void run() {

        try {
                 URL url = new URL(osoite);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                palautus = scanner.hasNext() ? scanner.next() : "";
                callBackInterface.palauta(palautus);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}


