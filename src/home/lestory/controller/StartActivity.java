package home.lestory.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends Activity 
{

	private Button startButton;
	private EditText userNameField;
	public String userName;
	
	public String getName()
	{
		return userName;
	}
	public StartActivity()
	{
		this.userName = "";
	}
	public void StartActivity(String userName)
	{
		this.userName = userName;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		startButton = (Button) findViewById(R.id.startButton);
		userNameField = (EditText) findViewById(R.id.nameField);
		
		setupListeners();
		StartActivity(userNameField.getText().toString());
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
				Intent otherScreenIntent = new Intent(currentView.getContext(), game.class);
				startActivityForResult(otherScreenIntent, 0);
			}
		});
	}
}
