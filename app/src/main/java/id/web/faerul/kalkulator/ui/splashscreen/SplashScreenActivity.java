package id.web.faerul.kalkulator.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import id.web.faerul.kalkulator.R;
import id.web.faerul.kalkulator.ui.main.MainActivity;
import rx.Observable;
import rx.schedulers.Schedulers;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        Observable.timer(5, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(aLong -> {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    finish();
                });
    }

}
