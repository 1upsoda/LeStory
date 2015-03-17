package home.lestory.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
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
	private boolean hasPickle;
	private int timesTriedToGetKnife;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		slideNumber = 2;
		timesTriedToGetKnife = 0;
		hasPickle = false;
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
		
//		slideInfo(4, "title here", "story here", "none", "none", "none", "none", "none", "none", "none", "none");
//		^ use this as a base for slides
		setupListeners();
	}
	public void slideInfo(int slide, String title, String storyText, String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String bigAnswer1, String bigAnswer2)
	{
		choice1.setVisibility(View.INVISIBLE);
		choice2.setVisibility(View.INVISIBLE);
		choice3.setVisibility(View.INVISIBLE);
		choice4.setVisibility(View.INVISIBLE);
		choice5.setVisibility(View.INVISIBLE);
		choice6.setVisibility(View.INVISIBLE);
		bigChoice1.setVisibility(View.INVISIBLE);
		bigChoice2.setVisibility(View.INVISIBLE);
		slideNumber = slide;
		setTitle(title);
		story.setText(storyText);
		if(answer1 != "none")
		{
			choice1.setVisibility(View.VISIBLE);
		}
		if(answer2 != "none")
		{
			choice2.setVisibility(View.VISIBLE);
		}
		if(answer3 != "none")
		{
			choice3.setVisibility(View.VISIBLE);
		}
		if(answer4 != "none")
		{
			choice4.setVisibility(View.VISIBLE);
		}
		if(answer5 != "none")
		{
			choice5.setVisibility(View.VISIBLE);
		}
		if(answer6 != "none")
		{
			choice6.setVisibility(View.VISIBLE);
		}
		if(bigAnswer1 != "none")
		{
			bigChoice1.setVisibility(View.VISIBLE);
		}
		if(bigAnswer2 != "none")
		{
			bigChoice2.setVisibility(View.VISIBLE);
		}
		choice1.setText(answer1);
		choice2.setText(answer2);
		choice3.setText(answer3);
		choice4.setText(answer4);
		choice5.setText(answer5);
		choice6.setText(answer6);
		bigChoice1.setText(bigAnswer1);
		bigChoice2.setText(bigAnswer2);
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
		//choice 1: sleep retry
		//2: kill dragom
		
		choice1.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				switch(slideNumber)
				{
					case 2:slideInfo(4, "You sleep", "you sleep and get kill by dragom, nice one " +username+ ".", "none", "none", "retry", "none", "none", "none", "none", "none");break;
					case 5:
					{
						setTitle("Kill with Fork");
						story.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						choice1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
						choice2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
						choice4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
						story.setText("You dash for a fork lying on the ground, as the mighty Dragom swoops dowm to take a bite out of your flesh. You skillfully dodge his powerful jaw by twisting your body exactly 96 degrees, and you crouch dowm and grab the fork with your right hand. The terrifying creature recovers from his missed blow, and strikes agaim. He lunges at you, and you raise your left arm in defence. He sinks his teeth deep into your forearm, and you let out a cry of pain as blood drips from your free arm, and into a red puddle om the stony ground below. You clench your jaw, and swallow the paim. The determined Dragom has a firm grip om your arm, and will not relinquish it. He tugs your arm, and you feel excruciating agony as your arm is nearly pulled from it’s socket. You realize you only have seconds before he devours you. Im a panic, you grasp the fork and drive it deep into the villainous beast’s skull. He sways as he tumbles over, but his hold om your arm has slackened, so you wrench your arm free. The hideous Dragom falls to the ground with a satisfying slump, but as you clutch your injured arm, you feel like you might faint. What do you do? TL;DR:You defeated dragom, you’re bleeding out, " +username+ ". wat will u doo?");
						choice4.setText("Inspect the Dragom");
						choice2.setText("Contemplate writing a book about Dragoms");
						choice1.setText("Seek medical attentiom");
						choice4.setVisibility(View.VISIBLE);
						choice3.setVisibility(View.INVISIBLE);
						choice2.setVisibility(View.VISIBLE);
						choice1.setVisibility(View.VISIBLE);
						slideNumber = 7;
						//1: seek medical attentiom
						//2:write book
						//4:inspect
					} break;
					case 7:
					{
						slideInfo(8, "Seek Medical Attentiom", "You press the “E” key in your mental keyboard to call out “Medic” in the hopes that someone om your team will come to your aid. You realize that you were never actually om a team, so this whole debacle is in vaim.", "Give up all hope...", "Contemplate writing book about dragoms", "none", "Inspect Dragom", "none", "none", "none", "none");
						//1:give up hope
						//2:contemplate book
						//4:inspect dragom
					} break;
					case 15:
					{
						hasPickle = true;
						slideInfo(73, "Get Pickle", "Good job " +username+ "! You got a pickle now, huzzah. I am pretty sure you have won the game.", "Return to other options", "none", "none", "none", "Kill dragom with pickle", "none", "none", "none");
					} break;
					case 73:slideInfo(5, "How Kill Dragom?", "Different ways are available. To kill it. Yes.", "Fork", "Knife", "Spoom", "none", "none", "none", "none", "none"); break;
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
					slideInfo(5, "How Kill Dragom?", "Different ways are available. To kill it. Yes.", "Fork", "Knife", "Spoom", "none", "none", "none", "none", "none");
					//1:fork
					//2:knife
					//3:spoom
				}
				else if(slideNumber == 5 && timesTriedToGetKnife != 10)
				{
					setTitle("Knife");
					story.setText("There is no knife.");
					choice3.setVisibility(View.INVISIBLE);
					choice2.setVisibility(View.VISIBLE);
					choice1.setVisibility(View.VISIBLE);
					choice1.setText("Get Pickle");
					if(hasPickle == true)
					{
						choice1.setVisibility(View.INVISIBLE);
						choice1.setText("Get Pickle");
					}
					choice2.setText("Go Back to Options");
					timesTriedToGetKnife++;
					slideNumber = 15;
				}
				else if(slideNumber == 5 && timesTriedToGetKnife == 10)
				{
					
					slideInfo(4, "Really?", "THERE. IS. NO. KNIFE!", "none", "none", "retry", "none", "none", "none", "none", "none");
				}
				else if(slideNumber == 15)
				{
					
					slideInfo(5, "How Kill Dragom?", "Different ways are available. To kill it. Yes.", "Fork", "Knife", "Spoom", "none", "none", "none", "none", "none");
				}
				else if(slideNumber == 7)
				{
					choice6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
					slideInfo(9, "Contemplate a Book", "You consider how lucky you are, ya know, to be alive. You think, “I might be famous for living through a dragom attack.” You are so preoccupied, you forget you are bleeding out. As you pass out, your head hits a rock, and you die.", "none", "none", "retry", "none", "none", "Seriously though, write a book...", "none", "none");
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
					hasPickle = false;
					Intent returnIntent = new Intent();
					setResult(RESULT_OK, returnIntent);
					finish();
				}
				else if(slideNumber == 5)
				{
					slideInfo(4, "Kill with spoom", "wat were u thinking? you are dead now.", "none", "none", "Retry", "none", "none", "none", "none", "none");
				}
				
				
			}
		});
		choice4.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				if(slideNumber == 7)
				{
					choice3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
					slideInfo(10, "Inspect Dragom", "You walk up to the dragom, and have am uh-oh. He is still breathing. He stands up, and pulls the fork from his head. He says, “I am rather impressed by you, Humam. I will now tell you a riddle, and if you guess right, I will not eat you.” What do you do now?", "Call his bluff", "Play his little game", "none", "none", "Ask if he went to Harvard or Yale", "none", "none", "none");

				}
			}
		});
		choice5.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				if(slideNumber == 73)
				{
					slideInfo(4, "No.", "Well, while a pickle may be the most amazing thing ever, you can not kill a dragom with it.", "none", "none", "Retry", "none", "none", "none", "none", "none");
					
				}
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