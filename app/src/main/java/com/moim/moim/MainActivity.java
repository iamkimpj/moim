package com.moim.moim;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.moim.moim.Model.Http.Conn;
import com.moim.moim.Model.Http.Schema.AuthSchema;
import com.moim.moim.Model.Http.Schema.TestSchema;
import com.moim.moim.group.GroupFragment;
import com.moim.moim.meet.MeetFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

//    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_meet:


                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, new MeetFragment())
                            .commit();

                    return true;
                case R.id.navigation_group:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, new GroupFragment())
                            .commit();


                    return true;
                case R.id.navigation_setting:
//                    mTextMessage.setText(R.strig.title_setting);

                    //
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        if( true ){
//            final Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
////            finish();
//        }


//        if( true ){
////            KakaoHelper.ready().requestAccessTokenInfo();
//            KakaoHelper.ready().requestMe();
//
//        }

        testKoten();
//        Call<AuthSchema> call = Conn.ready().api().authTest();
//        call.enqueue(new Callback<AuthSchema>() {
//            @Override
//            public void onResponse(Call<AuthSchema> call, Response<AuthSchema> response) {
//                if (response.isSuccessful()) {
//
//                    AuthSchema test = response.body();
//
//                    test.test();
//
//
//                } else {
//                    Log.d("test","failed to get respose");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AuthSchema> call, Throwable t) {
//                Log.d("test","failed to connect");
//            }
//
//        });



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.content, new MeetFragment())
//                .commit();




    }

    private void testKoten () {
        Call<AuthSchema> call = Conn.ready().api().authTest();
//        Call<AuthSchema> call = Conn.ready().api().tokenTest11();
        call.enqueue(new Callback<AuthSchema>() {
            @Override
            public void onResponse(Call<AuthSchema> call, Response<AuthSchema> response) {
                if (response.isSuccessful()) {
                    Log.d("test","sucesss to get respose");
                    AuthSchema test = response.body();

                    test.test();
                } else {
                    Log.d("test","failed to get respose");
                }
            }

            @Override
            public void onFailure(Call<AuthSchema> call, Throwable t) {
                Log.d("test","failed to connect");
            }

        });

    }

}
