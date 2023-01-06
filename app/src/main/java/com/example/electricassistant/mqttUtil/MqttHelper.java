package com.example.electricassistant.mqttUtil;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.StandardCharsets;

public class MqttHelper {

    MqttConnectOptions mOptions;
    MqttAndroidClient mClient;
    String TOPIC = "device";
    Context c ;


    public MqttHelper(Context context){
        c = context;
        mOptions = new MqttConnectOptions();
        mOptions.setUserName("user");
        mOptions.setPassword("testtest".toCharArray());
        mClient = new MqttAndroidClient(context, "tcp://192.168.8.20:1883", MqttClient.generateClientId());
        connect();
    }


    private IMqttActionListener mConnectCallback = new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken token) {
            Log.d("Main","mConnectCallback onSuccess");
            subscribe();
        }

        @Override
        public void onFailure(IMqttToken token, Throwable ex) {
            Log.d("Main","mConnectCallback onFailure " + ex);
        }
    };

    private IMqttActionListener mSubscribeCallback = new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken token) {
            Log.d("Main","mSubscribeCallback onSuccess");
        }

        @Override
        public void onFailure(IMqttToken token, Throwable ex) {
            Log.d("Main","mSubscribeCallback onFailure " + ex);
        }
    };

    private IMqttActionListener mPublishCallback = new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken token) {
            Log.d("Main","mPublishCallback onSuccess");
        }

        @Override
        public void onFailure(IMqttToken token, Throwable ex) {
            Log.d("Main","mPublishCallback onFailure " + ex);
            disconnect();
            connect();
        }
    };

    private MqttCallback mMessageListener = new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {

        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            Log.d("Main","mMessageListener onSuccess topic=" + topic + ", message=" + message);
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {

        }
    };

    void connect() {
        try {
            mClient.connect(mOptions, null, mConnectCallback);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            mClient.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        mClient.unregisterResources();
    }

    void subscribe() {
        try {
            IMqttToken subToken = mClient.subscribe(TOPIC, 1, c, mSubscribeCallback);
            mClient.setCallback(mMessageListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void publish(String example) {
        MqttMessage message = new MqttMessage(example.getBytes(StandardCharsets.UTF_8));
        try {
            mClient.publish(TOPIC, message, c, mPublishCallback);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
