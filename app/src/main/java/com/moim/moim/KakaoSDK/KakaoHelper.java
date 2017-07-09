package com.moim.moim.KakaoSDK;

import android.util.Log;

import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.AuthService;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.network.ErrorResult;
import com.kakao.util.helper.log.Logger;
import com.moim.moim.Model.Http.Conn;

/**
 * Created by developer on 2017. 7. 9..
 */

public class KakaoHelper {

    private static class Singleton {
        private static final KakaoHelper instance = new KakaoHelper();
    }

    public static KakaoHelper ready() {

        return KakaoHelper.Singleton.instance;
    }
    private KakaoHelper(){}

    public void requestAccessTokenInfo() {
        Log.d("test", "12");
        AuthService.requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Log.d("test", "13");
//                redirectLoginActivity(self);
            }

            @Override
            public void onNotSignedUp() {
                // not happened
                Log.d("test", "no sign up");
            }

            @Override
            public void onFailure(ErrorResult errorResult) {
                Logger.e("failed to get access token info. msg=" + errorResult);
            }

            @Override
            public void onSuccess(AccessTokenInfoResponse accessTokenInfoResponse) {
                long userId = accessTokenInfoResponse.getUserId();
                Logger.d("this access token is for userId=" + userId);

                long expiresInMilis = accessTokenInfoResponse.getExpiresInMillis();
                Logger.d("this access token expires after " + expiresInMilis + " milliseconds.");
            }
        });
    }


}
