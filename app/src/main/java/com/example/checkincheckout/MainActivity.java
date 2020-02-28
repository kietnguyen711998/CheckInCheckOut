package com.example.checkincheckout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.checkincheckout.Retrofit.RetrofitClient;
import com.example.checkincheckout.Retrofit.Smart_Time;
import com.example.checkincheckout.model.CheckOut;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private  int seconds = 0;
    private boolean running = false;
    private  boolean wasRunning;
    private Button btnCheckInCheckOut;
    private TextView time_view, txtEmployee, txtTimeTotal;
    private boolean check = false;
    Smart_Time smart_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
        btnCheckInCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!check) {
                    check = true;
                    btnCheckInCheckOut.setText("CHECK OUT");
                    btnCheckInCheckOut.setBackgroundResource(R.drawable.shape_drawable1);
                    running = true;
                    Toast.makeText(getApplicationContext(), "Check In", Toast.LENGTH_SHORT).show();

                    smart_time = RetrofitClient.getInstance().create(Smart_Time.class);
                    //request
                    Call<CheckOut> call = smart_time.getCheckout();
                    call.enqueue(new Callback<CheckOut>() {
                        //response
                        @Override
                        public void onResponse(Call<CheckOut> call, Response<CheckOut> response) {
                            CheckOut checkOut = response.body();
                            Log.i("xxx", checkOut.toString());
                            checkOut.getId().toString();
//                            Toast.makeText(getApplicationContext(),"GetID"+ checkOut.getId().toString(),Toast.LENGTH_SHORT).show();
                            txtEmployee.setText(checkOut.getEmployee());


                        }

                        @Override
                        public void onFailure(Call<CheckOut> call, Throwable t) {
                            Log.i("yyyy", t.getMessage());
                        }
                    });
                } else {
                    check = false;
                    btnCheckInCheckOut.setText("CHECK IN");
                    running = false;
                    seconds = 0;
                    btnCheckInCheckOut.setBackgroundResource(R.drawable.shape_drawable);
                    Toast.makeText(getApplicationContext(), "Check Out", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void runTimer(){
        final  TextView time_view = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable(){

            @Override
            public void run() {
                int hour = seconds / 3600;
                int minute = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%d:%02d:%02d", hour, minute, sec);
                time_view.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }



    private void initWidget() {
        btnCheckInCheckOut = findViewById(R.id.btnCheckInCheckOut);
        time_view = findViewById(R.id.time_view);
        txtEmployee = findViewById(R.id.txtEmployee);
        txtTimeTotal = findViewById(R.id.txtTimeTotal);

    }


}
