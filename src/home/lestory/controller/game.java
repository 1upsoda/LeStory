package home.lestory.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class game extends Activity 
{
	private Button choice1, choice2, choice3, choice4, choice5, choice6, bigChoice1, bigChoice2;
	private TextView story;
	private String username;
	private int slideNumber;

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		slideNumber = 2;
		choice1 = (Button) findViewById(R.id.choice1);
		choice2 = (Button) findViewById(R.id.choice2);
		choice3 = (Button) findViewById(R.id.choice3);
		choice4 = (Button) findViewById(R.id.choice4);
		choice5 = (Button) findViewById(R.id.choice5);
		choice6 = (Button) findViewById(R.id.choice6);
		bigChoice1 = (Button) findViewById(R.id.bigChoice1);
		bigChoice2 = (Button) findViewById(R.id.bigChoice2);
		String username = getIntent().getStringExtra("name"); 

		story = (TextView) findViewById(R.id.Story);
		
		
		
		setupListeners();
	}
	
	private void setupListeners()
	{
		slideNumber =2;
		username = getIntent().getStringExtra("name"); 
		story.setText("Hello, " +username+ "! You awake im room, wat do?");
		choice1.setText("Go back asleep");
		choice2.setText("kill dragom");
		setTitle("The Room");
		choice2.setVisibility(View.VISIBLE);
		choice1.setVisibility(View.VISIBLE);
		choice3.setVisibility(View.INVISIBLE);
		choice4.setVisibility(View.INVISIBLE);
		choice5.setVisibility(View.INVISIBLE);
		choice6.setVisibility(View.INVISIBLE);
		bigChoice2.setVisibility(View.INVISIBLE);
		bigChoice1.setVisibility(View.INVISIBLE);
		choice1.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				if(slideNumber == 2)
				{
					setTitle("You sleep");
					story.setText("you sleep and get kill by dragom");
					choice3.setText("retry");
					choice3.setVisibility(View.VISIBLE);
					choice2.setVisibility(View.INVISIBLE);
					choice1.setVisibility(View.INVISIBLE);
					slideNumber = 4;
				}
				
			}
		});
		choice2.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				if(slideNumber == 2)
				{
					setTitle("How Kill Dragom?");
					story.setText("Different ways are available. To kill it. Yes.");
					choice3.setVisibility(View.VISIBLE);
					choice2.setVisibility(View.VISIBLE);
					choice1.setVisibility(View.VISIBLE);
					choice3.setText("Spoon");
					choice2.setText("Knife");
					choice1.setText("Fork");
					slideNumber = 3;
				}
				
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