package qlearn.qualcomm.com.videokeeper;

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
    private String targetFile;

    public DownloadFinishTrigger(VGet vget) {
        this.vget = vget;
    }

    @Override
    public void run() {
        videoInfo = vget.getVideo();
        States state = videoInfo.getState();
        if (state == States.DONE) {
            targetFile = vget.getTarget().getAbsolutePath();
        }
        Log.d("State", state.toString());
    }

    public String getTitle() {
        return targetFile;
    }

}
