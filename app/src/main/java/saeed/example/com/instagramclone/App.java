package saeed.example.com.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("c5Edgvsxarypqx2h3BNa8CduPYLwlo1hpvoR8zaE")
                // if defined
                .clientKey("9w3n2XALLQd8EQYOfNAg7CjWDgqOhQ1sUtLNLpmY")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
