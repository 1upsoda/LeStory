package home.lestory.controller;



import home.lestory.model.UserInfo;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends Activity implements SensorEventListener
{


	private Button startButton;
	public EditText userNameField;
	public UserInfo newUser;
	public String userName;
	private TextView textView2;
	private SensorManager orientation;
	private float[] orientationValues, rThing;
	private Sensor orientator;
	
	/**
	 * USE THE GYROSCOPE SENSOR AND JUST
	 * HAVE THE SCREEN ADD OR SUBTRACT THE VALUES
	 * WHENEVER IT IS CHANGED
	 * IE, IF THE Y IS 5 RAD/S ADDED
	 * IT WILL INCREASE BY 5 ROTATIONS
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		orientation = (SensorManager)getSystemService(SENSOR_SERVICE);
		orientator = orientation.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
		orientation.registerListener(this, orientator, SensorManager.SENSOR_DELAY_FASTEST);
		newUser = new UserInfo();
		orientationValues = new float[3];
		userName = "JIMMY JOHN";
		startButton = (Button) findViewById(R.id.startButton);
		userNameField = (EditText) findViewById(R.id.nameField);
		textView2 = (TextView) findViewById(R.id.textView2);
		/**
		 * this will be the way to get your orientation so you can have the scroll thing work
		 */
		rThing = new float[9];
//		SensorManager.getOrientation(rThing, orientationValues);
		setupListeners();
		

	}

	
	private void setupListeners()
	{
		
		startButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
				

				userName = userNameField.getText().toString();
//				newUser.setUserName(userName);
				Intent otherScreenIntent = new Intent(currentView.getContext(), game.class);
				otherScreenIntent.putExtra("name", userName);
				startActivityForResult(otherScreenIntent, 0);
			}
		});
	}

	 protected void onResume() {
         super.onResume();
         orientation.registerListener(this, orientator, SensorManager.SENSOR_DELAY_FASTEST);
     }

     protected void onPause() {
         super.onPause();
         orientation.unregisterListener(this);
     }

	@Override
	public void onSensorChanged(SensorEvent event)
	{
		/**
		 * so the sensors are being detected but I don't know if the orientation ones are
		 */
		
		SensorManager.getRotationMatrixFromVector(rThing,
                event.values);
        SensorManager
                .remapCoordinateSystem(rThing,
                        SensorManager.AXIS_X, SensorManager.AXIS_Z,
                        rThing);
        SensorManager.getOrientation(rThing, orientationValues);

        // Optionally convert the result from radians to degrees
        orientationValues[0] = (float) Math.toDegrees(orientationValues[0]);
        orientationValues[1] = (float) Math.toDegrees(orientationValues[1]);
        orientationValues[2] = (float) Math.toDegrees(orientationValues[2]);

        textView2.setText(" Yaw: " + orientationValues[0] + "\n Pitch: "
                + orientationValues[1] + "\n Roll (not used): "
                + orientationValues[2]);
//		SensorManager.getOrientation(rThing, orientationValues); // this is breaking the app//
//		textView2.setText("" + SensorManager. + ", " + SensorManager.AXIS_Y +", " + SensorManager.AXIS_Z);
//		textView2.setText("" + SensorManager.getOrientation(rThing, orientationValues));
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		// TODO Auto-generated method stub
		
	}
}
