package home.lestory.controller;

import home.lestory.model.UserInfo;
import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends Activity
{

	private Button startButton;
	public EditText userNameField;
	public UserInfo newUser;
	public String userName;
	private TextView textView2;
	private SensorManager orientation;
	private float[] orientationValues;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		newUser = new UserInfo();
		orientationValues = new float[3];
		userName = "JIMMY JOHN";
		startButton = (Button) findViewById(R.id.startButton);
		userNameField = (EditText) findViewById(R.id.nameField);

		textView2 = (TextView) findViewById(R.id.textView2);
		/**
		 * this will be the way to get your orientation so you can have the
		 * scroll thing work
		 */
		// orientation.getOrientation(R, orientationValues);
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
				// newUser.setUserName(userName);
				Intent otherScreenIntent = new Intent(currentView.getContext(), game.class);
				otherScreenIntent.putExtra("name", userName);
				startActivityForResult(otherScreenIntent, 0);
			}
		});
	}
}