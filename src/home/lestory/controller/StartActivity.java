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
	public EditText userNameField;
	
	public String userName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		userName = "Johnny";
		startButton = (Button) findViewById(R.id.startButton);
		userNameField = (EditText) findViewById(R.id.nameField);
		
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
				
				Intent otherScreenIntent = new Intent(currentView.getContext(), game.class);
				otherScreenIntent.putExtra("name", userName);
				startActivityForResult(otherScreenIntent, 0);
			}
		});
	}
}
