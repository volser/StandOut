package wei.mark.example;

import wei.mark.standout.StandOutWindow;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class StandOutExampleActivity extends AppCompatActivity
{
	private final static int PERMISSION_ASK_REQUEST_CODE = 0;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		checkPermission();
	}

	public void checkPermission()
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
		{
			if (!Settings.canDrawOverlays(this))
			{
				Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
				startActivityForResult(intent, PERMISSION_ASK_REQUEST_CODE);
				Toast.makeText(this, R.string.please_grant_permissions, Toast.LENGTH_SHORT).show();
			}
			else
			{
				onPermissionGranted();
			}
		}
		else
		{
			onPermissionGranted();
		}
	}

	@Override
	@TargetApi(Build.VERSION_CODES.M)
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == PERMISSION_ASK_REQUEST_CODE)
		{
			if (!Settings.canDrawOverlays(this))
				checkPermission();
			else onPermissionGranted();
		}
	}


	private void onPermissionGranted()
	{
		StandOutWindow.uiThreadRunner=new Handler(getMainLooper());

		StandOutWindow.closeAll(this, SimpleWindow.class);
//		StandOutWindow.closeAll(this, MultiWindow.class);
//		StandOutWindow.closeAll(this, WidgetsWindow.class);

		// show a MultiWindow, SimpleWindow

		StandOutWindow.show(StandOutExampleActivity.this, SimpleWindow.class,  1);
//		StandOutWindow.show(StandOutExampleActivity.this, MultiWindow.class,   2);
//		StandOutWindow.show(StandOutExampleActivity.this, WidgetsWindow.class, 3);

		// show a MostBasicWindow. It is commented out because it does not
		// support closing.

		/*
		 * StandOutWindow.show(this, StandOutMostBasicWindow.class,
		 * StandOutWindow.DEFAULT_ID);
		 */
	}
}