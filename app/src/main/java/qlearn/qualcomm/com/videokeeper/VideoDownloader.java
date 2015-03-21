package qlearn.qualcomm.com.videokeeper;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.github.axet.vget.VGet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * © 2015 Qualcomm Education, Inc. All right reserved.
 */
public class VideoDownloader {
   private Context context;

   public void fetchFile(String videoUrl, Context context) {
       this.context = context;
       if (!fileExists(videoUrl)) {
           new DownloadTask().execute(videoUrl, context.getFilesDir().getAbsolutePath());
       } else {
           // launch player
           Log.d("DBG", "File already present, play it!");
       }
   }

    private boolean fileExists(String videoUrl) {
        return false;
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String videoUrl = params[0];
            String path = params[1];
            DownloadFinishTrigger dft;
            try {
                File f = new File(path);
                VGet vget = new VGet(new URL(videoUrl), f);
                dft = new DownloadFinishTrigger(vget);
                vget.download(new AtomicBoolean(false), dft);

                return dft.getTitle();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("File Path", context.getFilesDir().getAbsolutePath() + "/" + s);
        }
    }
}
