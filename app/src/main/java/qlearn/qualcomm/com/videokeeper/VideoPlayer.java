package qlearn.qualcomm.com.videokeeper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoPlayer extends Activity{
    private VideoView videoView;
    private MediaController mCtrl;
    String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView = (VideoView) findViewById(R.id.videoPlayer);
        filePath = this.getIntent().getStringExtra("filePath");
        mCtrl = new MediaController(this);

        playMedia();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void playMedia() {
        videoView.setMediaController(mCtrl);
        videoView.setVideoPath(filePath);
        videoView.start();
    }


}
