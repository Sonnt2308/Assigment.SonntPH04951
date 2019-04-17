
package com.example.quynh.assigment.model.model_latest;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FragmentLatest {

    @SerializedName("HD_WALLPAPER")
    @Expose
    private List<HDWALLPAPER_LATEST> hDWALLPAPER = null;

    public List<HDWALLPAPER_LATEST> getHDWALLPAPER() {
        return hDWALLPAPER;
    }

    public void setHDWALLPAPER(List<HDWALLPAPER_LATEST> hDWALLPAPER) {
        this.hDWALLPAPER = hDWALLPAPER;
    }

}
