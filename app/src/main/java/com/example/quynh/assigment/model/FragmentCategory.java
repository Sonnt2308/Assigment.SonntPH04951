
package com.example.quynh.assigment.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FragmentCategory {

    @SerializedName("HD_WALLPAPER")
    @Expose
    private List<HDWALLPAPER> hDWALLPAPER = null;

    public List<HDWALLPAPER> getHDWALLPAPER() {
        return hDWALLPAPER;
    }

    public void setHDWALLPAPER(List<HDWALLPAPER> hDWALLPAPER) {
        this.hDWALLPAPER = hDWALLPAPER;
    }

}
