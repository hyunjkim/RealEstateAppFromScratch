package nyc.c4q.hyun.fourthdayappfromscratch;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import nyc.c4q.hyun.fourthdayappfromscratch.network.HouseResponse;
import nyc.c4q.hyun.fourthdayappfromscratch.network.RealEstateService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hyun on 12/20/16.
 */

public class RealEstateFragment extends Fragment {
    private final String API_URL ="http://jsjrobotics.nyc/";

    private View view;
    private Retrofit retrofit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        view = inflater
                .inflate(R.layout.realestate_fragment,container, false);

        getResponse();
        return view;
    }

    private void getResponse() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RealEstateService service = retrofit.create(RealEstateService.class);
        Call<HouseResponse> posts = service.getHouseResponse();
        posts.enqueue(new Callback<HouseResponse>() {
            @Override
            public void onResponse(Call<HouseResponse> call, Response<HouseResponse> response) {
                Toast.makeText(getActivity(),"HOUSE RESPONSE SUCCESSFUL",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<HouseResponse> call, Throwable t) {
                Toast.makeText(getActivity(),"HOUSE RESPONSE FAILED",Toast.LENGTH_LONG).show();
            }
        });
    }
}
