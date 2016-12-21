package nyc.c4q.hyun.fourthdayappfromscratch.network;

import java.util.List;

/**
 * Created by Hyun on 12/20/16.
 */

public class HouseResponse {

    private Boolean success;
    private List<Houses> houses;


    public List<Houses> getHomes() {
        return houses;
    }

    public void setHomes(List<Houses> houses) {
        this.houses = houses;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
