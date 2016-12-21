package nyc.c4q.hyun.fourthdayappfromscratch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class RealEstateActivity extends AppCompatActivity {

    private ConnectivityManager cm;
    private NetworkInfo activeNetwork;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(networkAvailable()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_container, new RealEstateFragment())
                    .commit();
        } else {
            Toast.makeText(this,"network unavailable", Toast.LENGTH_LONG).show();
        }
    }

    private boolean networkAvailable() {
        cm =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
