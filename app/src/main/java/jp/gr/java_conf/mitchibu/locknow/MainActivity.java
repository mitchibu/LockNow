package jp.gr.java_conf.mitchibu.locknow;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DevicePolicyManager dpm = (DevicePolicyManager)getSystemService(DEVICE_POLICY_SERVICE);
		ComponentName cn = new ComponentName(this, MyDeviceAdminReceiver.class);

		if(dpm.isAdminActive(cn)) {
			dpm.lockNow();
		} else {
			Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, cn);
			startActivity(intent);
		}
		finish();
	}
}
