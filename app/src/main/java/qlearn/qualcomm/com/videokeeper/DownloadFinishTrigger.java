package qlearn.qualcomm.com.videokeeper;

import android.content.Context;
import android.util.Log;

import com.github.axet.vget.VGet;
import com.github.axet.vget.info.VideoInfo;

import static com.github.axet.vget.info.VideoInfo.*;

/**
 * © 2015 Qualcomm Education, Inc. All right reserved.
 */
public class DownloadFinishTrigger implements Runnable {
    private VGet vget;
    private VideoInfo videoInfo;

    public DownloadFinishTrigger(VGet vget) {
        this.vget = vget;
    }

    @Override
    public void run() {
        videoInfo = vget.getVideo();
        States state = videoInfo.getState();
        Log.d("State", state.toString());
    }

    public String getTitle() {
        return videoInfo.getTitle();
    }

}
