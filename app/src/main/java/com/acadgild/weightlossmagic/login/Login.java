package com.acadgild.weightlossmagic.login;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.acadgild.weightlossmagic.R;
import com.acadgild.weightlossmagic.MainActivity;

import com.acadgild.weightlossmagic.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.Arrays;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by DivyaVipin on 2/26/2017.
 */

public class Login extends AppCompatActivity
{
    ViewPager viewPager;
    LoginViewPager adapter;
    int[] img;
    private static int currentpage=0;
    private static  int numpages=0;
    private Button btnLogout;
    private AdView mAdView;
    CallbackManager callbackManager;
    private LoginButton loginButton;
    private Button btnSkip;
    private boolean isHome = false;
Toolbar toolbar;
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //facebookSDKInitialize();
        facebookSDKInitialize();

        setContentView(R.layout.login);

    toolbar=(Toolbar)findViewById(R.id.toolbar) ;
    setSupportActionBar(toolbar);
    toolbar.setTitleTextColor(Color.WHITE);
    btnSkip=(Button) findViewById(R.id.btnSkip);

    mAdView = (AdView) findViewById(R.id.adView);
    viewPager=(ViewPager)findViewById(R.id.viewPager);
    img=new int[]{R.drawable.a3,R.drawable.a6,R.drawable.dream,R.drawable.done};
    adapter=new LoginViewPager(Login.this,img);
    viewPager.setAdapter(adapter);
    CircleIndicator indicator=(CircleIndicator)findViewById(R.id.indicator) ;
    indicator.setViewPager(viewPager);
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentpage=position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);
    btnSkip.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent skip=new Intent(Login.this,MainActivity.class);
            startActivity(skip);

        }
    });

        loginButton = (LoginButton) findViewById(R.id.fb_login_button);
    loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LoginManager.getInstance().logInWithReadPermissions(Login.this, Arrays.asList("public_profile"));
           // btnLogout.setVisibility(View.INVISIBLE);

        }
    });

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            public void onSuccess(LoginResult loginResult) {
                System.out.println("onSuccess");
                Intent mainLobby = new Intent(Login.this, MainActivity.class);
                //startActivity(mainLobby);
                if(!isHome) {
                    startActivity(mainLobby);
                    isHome = true;
                }
               /* GraphRequest request=GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        if (response.getError() == null) {
                            // handle error
                            System.out.println("ERROR");
                        } else {
                            Intent i=new Intent(Login.this,MainActivity.class);
                            startActivity(i);
                        }
                    }
                });*/

            }

            /*
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request=GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object , GraphResponse response) {
                                if (response.getError() != null) {
                                    // handle error
                                    System.out.println("ERROR");
                                } else {
                                    System.out.println("Success");
                                    try {
                                        ///Profile profile = Profile.getCurrentProfile();

                                        String jsonresult = String.valueOf(object);
                                        System.out.println("JSON Result"+jsonresult);
                                        String firstname = object.getString("first_name");
                                        String lastname=object.getString("last_name");
                                        String gender=object.getString("gender");
                                        String email = object.getString("email");
                                        String birthday=object.getString("birthday");

                                       // String userId=loginResult.getAccessToken().getUserId();
                                       // String authToken=loginResult.getAccessToken().getToken();
                                        Profile profile = Profile.getCurrentProfile();
                                        Intent home=new Intent(Login.this,MainActivity.class);
                                        home.putExtra("firstname",firstname);
                                        home.putExtra("lastname",lastname);
                                        home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        //startActivity(next);
                                        startActivity(home);


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                            }
                        }) ;

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, first_name, last_name, email,gender, birthday, location");
                request.setParameters(parameters);
                request.executeAsync();

            }
*/
            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });




}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void facebookSDKInitialize() {/**
 * This function initializes the Facebook SDK, the behavior of Facebook SDK functions are
 * undetermined if this function is not called. It should be called as early as possible.
 * @param applicationContext The application context
 */
         FacebookSdk.sdkInitialize(getApplicationContext());
         callbackManager = CallbackManager.Factory.create();// initialize your instance of CallbackManager using the CallbackManager.Factory.create method.
           // loginButton.registerCallback(callbackManager,);
        LoginManager.getInstance().logOut();

      AccessToken.setCurrentAccessToken(null);
        }
    @Override
    protected void onPause() {

        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAdView != null) {
            mAdView.destroy();
        }
    }
}
