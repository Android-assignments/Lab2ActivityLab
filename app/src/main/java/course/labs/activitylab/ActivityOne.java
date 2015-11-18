package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";

	// Lifecycle counters

	// TODO:
	// Create variables named
	// mCreate, mRestart, mStart and mResume
    private int mCreate=0;
    private int mRestart=0;
    private int mStart=0;
    private int mResume=0;
	// to count calls to onCreate(), onRestart(), onStart() and
	// onResume(). These variables should not be defined as static.

	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called.

	// TODO: Create variables for each of the TextViews
	// named mTvCreate, mTvRestart, mTvStart, mTvResume.
    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvStart;
    private TextView mTvResume;
	// for displaying the current count of each counter variable

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method

				// Create an intent stating which Activity you would like to
				// start
				Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                startActivity(intent);
				// Launch the Activity using the intent

			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
            super.onRestoreInstanceState(savedInstanceState);
			// Only need 4 lines of code, one for every count variable
            mCreate = savedInstanceState.getInt("create");
            mRestart = savedInstanceState.getInt("restart");
            mStart = savedInstanceState.getInt("start");
            mResume = savedInstanceState.getInt("resume");

		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// TODO:
		mCreate++;// Update the appropriate count variable
		displayCounts();// Update the user interface via the displayCounts() method

	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// TODO:
		mStart++;// Update the appropriate count variable
		displayCounts();// Update the user interface

	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		// TODO:
		mResume++;// Update the appropriate count variable
		displayCounts();// Update the user interface

	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// TODO:
		mRestart++;// Update the appropriate count variable
		displayCounts();// Update the user interface

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
        // TODO:
        super.onSaveInstanceState(savedInstanceState);
        // Save counter state information with a collection of key-value pairs
        // 4 lines of code, one for every count variable
        savedInstanceState.putInt("create",mCreate);
        savedInstanceState.putInt("restart",mRestart);
        savedInstanceState.putInt("start",mStart);
        savedInstanceState.putInt("resume",mResume);

	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {
		// TODO - uncomment these lines

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

	}
}
