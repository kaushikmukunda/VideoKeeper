package qlearn.qualcomm.com.videokeeper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String testUrl = "https://www.youtube.com/watch?v=e7tr4hVY7Ig";
        VideoDownloader vdwnldr = new VideoDownloader();
        vdwnldr.fetchFile(testUrl, this);
    }
}
