package qlearn.qualcomm.com.videokeeper;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import static android.view.View.*;


public class MainActivity extends ActionBarActivity {
    private EditText videoText;
    private Button go;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go = (Button) findViewById(R.id.go_button);
        go.setOnClickListener(goOnClickListener);

        videoText = (EditText) findViewById(R.id.videoId);
        pbar = (ProgressBar) findViewById(R.id.pbar);
    }

    @Override
    protected void onPause() {
        super.onPause();
        go.setEnabled(true);
        pbar.setVisibility(INVISIBLE);
    }

    OnClickListener goOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            hideKeyboard();
            go.setEnabled(false);
            pbar.setVisibility(VISIBLE);

            String videoId = videoText.getText().toString();
            startVideoDownload(videoId);
        }
    };

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(videoText.getWindowToken(), 0);
    }

    private void startVideoDownload(String id) {
        String testUrl = "https://www.youtube.com/watch?v=" + id;
        VideoDownloader vdwnldr = new VideoDownloader();
        vdwnldr.fetchFile(testUrl, this);
    }
}
