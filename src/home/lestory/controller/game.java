package home.lestory.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import home.lestory.model.*;


public class game extends Activity 
{
	private Button choice1, choice2, choice3, choice4, choice5, choice6, bigChoice1, bigChoice2;
	private TextView story;
	private String username;
//	private StartActivity myActivity;
	
//	private UserName baseName;
//	public game()
//	{
//		
//	}
//	public game(UserName baseName)
//	{
//		this.baseName = baseName;
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
//		baseName = new UserName(userNameField.getText().toString());
		choice1 = (Button) findViewById(R.id.choice1);
		choice2 = (Button) findViewById(R.id.choice2);
		choice3 = (Button) findViewById(R.id.choice3);
		choice4 = (Button) findViewById(R.id.choice4);
		choice5 = (Button) findViewById(R.id.choice5);
		choice6 = (Button) findViewById(R.id.choice6);
		bigChoice1 = (Button) findViewById(R.id.bigChoice1);
		bigChoice2 = (Button) findViewById(R.id.bigChoice2);
		String username = getIntent().getStringExtra("name"); 
//		myActivity = new StartActivity();
		story = (TextView) findViewById(R.id.Story);
		
		
		
		setupListeners();
	}
	
	private void setupListeners()
	{
		/*" +myActivity.getName()+ "!  v    */
		username = getIntent().getStringExtra("name"); 
		story.setText("Hello, " +username+ "! You awake im room, wat do?");
		choice1.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
		choice2.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
		choice3.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
		choice4.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
		choice5.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
		choice6.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
		bigChoice1.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
		bigChoice2.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
			}
		});
	}
}