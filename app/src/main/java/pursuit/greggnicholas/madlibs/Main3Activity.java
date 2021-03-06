package pursuit.greggnicholas.madlibs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    TextView wordLocation;
    private String word;
    private String word2;
    private EditText lib;
    String st;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lib = (EditText) findViewById(R.id.word3);
        setRandomBackgroundColor();
    }

    public void onClick2(View view) {


        Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
        word = lib.getText().toString();
word2 = getIntent().getStringExtra("word1");

        intent.putExtra("userInput", word);
        startActivity(intent);
        finish();


    }






    private void setRandomBackgroundColor() {
        Random rand = new Random();
        int cl = rand.nextInt();
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(cl);
    }

    class OrientationUtils {
        private OrientationUtils() {
        }

        /**
         * Locks the device window in landscape mode.
         */
        public void lockOrientationLandscape(Activity activity) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        /**
         * Locks the device window in portrait mode.
         */
        public void lockOrientationPortrait(Activity activity) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        /**
         * Locks the device window in actual screen mode.
         */
        public void lockOrientation(Activity activity) {
            final int orientation = activity.getResources().getConfiguration().orientation;
            final int rotation = ((WindowManager) activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();

            // Copied from Android docs, since we don't have these values in Froyo 2.2
            int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
            int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;

            // Build.VERSION.SDK_INT <= Build.VERSION_CODES.FROYO

            if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_90) {
                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            } else if (rotation == Surface.ROTATION_180 || rotation == Surface.ROTATION_270) {
                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                }
            }
        }

        /**
         * Unlocks the device window in user defined screen mode.
         */
        public void unlockOrientation(Activity activity) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
        }

    }
}
