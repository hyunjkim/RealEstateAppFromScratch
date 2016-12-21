package nyc.c4q.hyun.fourthdayappfromscratch.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hyun on 12/20/16.
 */

public interface RealEstateService {

    @GET("cgi-bin/class_12_20_2016.pl")
    Call<HouseResponse> getHouseResponse();
}
