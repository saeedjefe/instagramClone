package saeed.example.com.instagramclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpAndLoginActivity extends AppCompatActivity {

    Button btnSignUp, btnLogIn;
    EditText edtSignUpUserName, edtSignUpPassword, edtLogInUserName, edtLogInPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.signup_login_activity );

        btnLogIn = findViewById( R.id.btnLogIn );
        btnSignUp= findViewById( R.id.btnSignUp );
        edtSignUpUserName = findViewById( R.id.edtSignUpUserName );
        edtSignUpPassword = findViewById( R.id.edtSignUpPassword);

        edtLogInPassword = findViewById( R.id.edtLogInPassword);
        edtLogInUserName = findViewById( R.id.edtLogInUserName);

        btnSignUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ParseUser parseUser = new ParseUser();

                parseUser.setUsername( edtSignUpUserName.getText().toString() );
                parseUser.setPassword( edtSignUpPassword.getText().toString() );

                parseUser.signUpInBackground( new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e== null)
                        {
                            FancyToast.makeText( SignUpAndLoginActivity.this,  "successfully sign upped", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();

                        }
                    }
                } );

            }
        } );

//        btnLogIn.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                        ParseUser.logInInBackground( edtLogInUserName.getText().toString(), edtLogInPassword.getText().toString());
//}

        btnLogIn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground( edtLogInUserName.getText().toString(), edtLogInPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        FancyToast.makeText( SignUpAndLoginActivity.this,  "successfully logged in", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();

                    }
                } );
            }
        } );

    }
}

