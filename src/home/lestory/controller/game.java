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
				else if(slideNumber == 5)
				{
					setTitle("Kill with Fork");
					story.setText("You dash for a fork lying on the ground, as the mighty Dragom swoops dowm to take a bite out of your flesh. You skillfully dodge his powerful jaw by twisting your body exactly 96 degrees, and you crouch dowm and grab the fork with your right hand. The terrifying creature recovers from his missed blow, and strikes agaim. He lunges at you, and you raise your left arm in defence. He sinks his teeth deep into your forearm, and you let out a cry of pain as blood drips from your free arm, and into a red puddle om the stony ground below. You clench your jaw, and swallow the paim. The determined Dragom has a firm grip om your arm, and will not relinquish it. He tugs your arm, and you feel excruciating agony as your arm is nearly pulled from it’s socket. You realize you only have seconds before he devours you. Im a panic, you grasp the fork and drive it deep into the villainous beast’s skull. He sways as he tumbles over, but his hold om your arm has slackened, so you wrench your arm free. The hideous Dragom falls to the ground with a satisfying slump, but as you clutch your injured arm, you feel like you might faint. What do you do? TL;DR:You defeated dragom, you’re bleeding out. wat will u doo?");
					choice3.setText("Inspect the Dragom");
					choice2.setText("Contemplate writing a book about Dragoms");
					choice1.setText("Seek medical attentiom");
					choice3.setVisibility(View.VISIBLE);
					choice2.setVisibility(View.VISIBLE);
					choice1.setVisibility(View.VISIBLE);
					slideNumber = 7;
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
					choice3.setText("Spoom");
					choice2.setText("Knife");
					choice1.setText("Fork");
					slideNumber = 5;
				}
				
			}
		});
		choice3.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				if(slideNumber == 4)
				{
					slideNumber = 2;
					Intent returnIntent = new Intent();
					setResult(RESULT_OK, returnIntent);
					finish();
				}
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