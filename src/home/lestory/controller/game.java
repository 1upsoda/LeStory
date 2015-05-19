package home.lestory.controller;

import home.lestory.model.UserInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class game extends Activity
{
	private Button choice1, choice2, choice3, choice4, choice5, choice6, bigChoice1, bigChoice2;
	private TextView story;
	private String username;
	private int slideNumber;
	private boolean hasPickle;
	private int timesTriedToGetKnife;
	private UserInfo newUser;
	private ScrollView textScroll, buttonScroll;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		textScroll = (ScrollView) findViewById(R.id.textScroll);
		buttonScroll = (ScrollView) findViewById(R.id.buttonScroll);
		newUser = new UserInfo();
		/**
		 * gets the height of the entire screen
		 */

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
		// username = newUser.getUserName();
		story = (TextView) findViewById(R.id.Story);

		// updateDisplay();
		// slideInfo(4, "title here", "story here", "none", "none", "none",
		// "none", "none", "none", "none", "none");
		// ^ use this as a base for slides
		// if the text size needs to be changed then you just change it after
		// the method call so that you can
		// make sure the text is changed after it changes once
		setupListeners();

	}

	public void slideInfo(int slide, String title, String storyText, String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String bigAnswer1, String bigAnswer2)
	{
		story.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
		choice1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		choice2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		choice3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		choice4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		choice5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		choice6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		bigChoice1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		bigChoice2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		choice1.setVisibility(View.INVISIBLE);
		choice2.setVisibility(View.INVISIBLE);
		choice3.setVisibility(View.INVISIBLE);
		choice4.setVisibility(View.INVISIBLE);
		choice5.setVisibility(View.INVISIBLE);
		choice6.setVisibility(View.INVISIBLE);
		bigChoice1.setVisibility(View.INVISIBLE);
		bigChoice2.setVisibility(View.INVISIBLE);
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		choice6.setText("");
		bigChoice1.setText("");
		bigChoice2.setText("");
		slideNumber = slide;
		setTitle(title);
		story.setText(storyText);
		if (answer1 != "none")
		{
			choice1.setVisibility(View.VISIBLE);
		}
		if (answer2 != "none")
		{
			choice2.setVisibility(View.VISIBLE);
		}
		if (answer3 != "none")
		{
			choice3.setVisibility(View.VISIBLE);
		}
		if (answer4 != "none")
		{
			choice4.setVisibility(View.VISIBLE);
		}
		if (answer5 != "none")
		{
			choice5.setVisibility(View.VISIBLE);
		}
		if (answer6 != "none")
		{
			choice6.setVisibility(View.VISIBLE);
		}
		if (bigAnswer1 != "none")
		{
			bigChoice1.setVisibility(View.VISIBLE);
		}
		if (bigAnswer2 != "none")
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
		textScroll.scrollTo(0, 0);
		buttonScroll.scrollTo(0, 0);
	}

	/**
	 * a very complicated and broken way to attempt to make the scrolls be half
	 * size (app was originally a relative layout but I decided it would be
	 * easier to just convert to linear)
	 */
	// private void updateDisplay()
	// {
	// ScrollView textScroll = new ScrollView(this);
	// ScrollView buttonScroll = new ScrollView(this);
	// Display dis = getWindowManager().getDefaultDisplay();
	// DisplayMetrics dm = new DisplayMetrics();
	// getWindowManager().getDefaultDisplay().getMetrics(dm);
	// int height3 = dm.heightPixels;
	// int heightHalf = (height3/2);
	// //int height =
	// Point cow = new Point();
	// dis.getSize(cow);
	// int height = (int) Math.round(cow.y / 2);
	// // int height2 = dis.heightPixels;
	// //.getWidth() * 50 / 100;
	// RelativeLayout.LayoutParams lp = new
	// RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,heightHalf);
	// // RelativeLayout.LayoutParams below = new
	// RelativeLayout.LayoutParams(lp);
	// textScroll.setId(1);
	// textScroll.setLayoutParams(lp);
	// lp.addRule(RelativeLayout.BELOW, textScroll.getId());
	// buttonScroll.setLayoutParams(lp);
	// buttonScroll.layout(0, textScroll.getBottom(), 0, 0);
	// // buttonScroll.setTop(textScroll.getBottom());
	// }
	private void setupListeners()
	{
		slideNumber = 2;
		username = getIntent().getStringExtra("name");
		story.setText("Hello, " + username + "! You awake im room, wat do?");
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
		// choice 1: sleep retry
		// 2: kill dragom

		choice1.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{

				if (slideNumber == 2)
				{
					slideInfo(4, "You sleep", "you sleep and get kill by dragom, nice one " + username + ".", "retry", "none", "none", "none", "none", "none", "none", "none");
				}
				else if(slideNumber == 4)
				{
					slideNumber = 2;
					hasPickle = false;
					Intent returnIntent = new Intent();
					setResult(RESULT_OK, returnIntent);
					finish();	
				}
				else if (slideNumber == 5)
				{
					setTitle("Kill with Fork");
					// story.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
					choice1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
					choice2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
					choice4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
					story.setText("You dash for a fork lying on the ground, the mighty Dragom swoops dowm to" + " take a bite out of your flesh. You skillfully dodge his powerful jaw by twisting "
							+ "your body exactly 96 degrees, and you crouch dowm to grab the fork with your right hand. " + "The terrifying creature recovers from his missed blow, and strikes agaim. He lunges at you,"
							+ " but you raise your left arm in defence. He sinks his teeth deep into your forearm, and you " + "let out a cry of pain as blood drips from your free arm, into a red puddle om the stony"
							+ " ground below. You clench your jaw, to swallow the paim. The determined Dragom has a firm " + "grip om your arm, and will not relinquish it. He tugs your arm, and you feel excruciating"
							+ " agony as it is nearly pulled from it’s socket. You realize you only have seconds" + " before he devours you. Im a panic, you grasp the fork and drive it deep into the"
							+ " villainous beast’s skull. He sways as he tumbles over, releasing your arm from his " + "vice-like grip. The hideous Dragom falls to the ground with a" + " satisfying slump, but as you clutch your injured arm, you feel like you might faint."
							+ " What do you do?                                                                " + "                                                                                  "
							+ "                                                                                    " + "                                                                                     "
							+ "                                                                                     " + "                                                                                     "
							+ "                                                                                     " + "                                                                                     "
							+ "                                                                                     " + "TL;DR:You defeated dragom, you’re bleeding out, " + username + ". wat will u doo?");
					choice4.setText("Inspect the Dragom");
					choice2.setText("Contemplate writing a book about Dragoms");
					choice1.setText("Seek medical attentiom");
					choice4.setVisibility(View.VISIBLE);
					choice3.setVisibility(View.INVISIBLE);
					choice2.setVisibility(View.VISIBLE);
					choice1.setVisibility(View.VISIBLE);
					slideNumber = 7;
					// 1: seek medical attentiom
					// 2:write book
					// 4:inspect
					textScroll.scrollTo(0, 0);
					buttonScroll.scrollTo(0, 0);
				}
				else if (slideNumber == 7)
				{
					slideInfo(8, "Seek Medical Attentiom", "You press the “E” key in your mental keyboard to call out “Medic” in the hopes that someone om your team will come to your aid. You realize that you were never actually om a team, so this whole debacle is in vaim.",
							"Give up all hope...", "Contemplate writing book about dragoms", "none", "Inspect Dragom", "none", "none", "none", "none");
					// 1:give up hope
					// 2:contemplate book
					// 4:inspect dragom
				}
				else if (slideNumber == 8)
				{
					slideInfo(65, "Give up All Hope",
							"You decide this is probably not going to go anywhere good, and give up om life. Just as your last breath leaves your luscious, pink, plump lips you hear the footsteps of a medic rum inside- Oh too late, you crap out and die.", "none", "none",
							"retry", "none", "none", "none", "none", "none");
				}
				else if (slideNumber == 15)
				{
					hasPickle = true;
					slideInfo(73, "Get Pickle", "Good job " + username + "! You got a pickle now, huzzah. I am pretty sure you have won the game.", "Return to other options", "none", "none", "none", "Kill dragom with pickle", "none", "none", "none");
				}
				else if (slideNumber == 73)
				{
					slideInfo(5, "How Kill Dragom?", "Different ways are available. To kill it. Yes.", "Fork", "Knife", "Spoom", "none", "none", "none", "none", "none");
				}

			}
		});
		choice2.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				if (slideNumber == 2)
				{
					slideInfo(5, "How Kill Dragom?", "Different ways are available. To kill it. Yes.", "Fork", "Knife", "Spoom", "none", "none", "none", "none", "none");
					// 1:fork
					// 2:knife
					// 3:spoom
				}
				else if (slideNumber == 5 && timesTriedToGetKnife != 10)
				{
					setTitle("Knife");
					story.setText("There is no knife.");
					choice3.setVisibility(View.INVISIBLE);
					choice2.setVisibility(View.VISIBLE);
					choice1.setVisibility(View.VISIBLE);
					choice1.setText("Get Pickle");
					if (hasPickle == true)
					{
						choice1.setVisibility(View.INVISIBLE);
						choice1.setText("Get Pickle");
					}
					choice2.setText("Go Back to Options");
					timesTriedToGetKnife++;
					slideNumber = 15;
				}
				else if (slideNumber == 5 && timesTriedToGetKnife == 10)
				{

					slideInfo(4, "Really?", "THERE. IS. NO. KNIFE!", "none", "none", "retry", "none", "none", "none", "none", "none");
				}
				else if (slideNumber == 7)
				{

					slideInfo(9, "Contemplate a Book",
							"You consider how lucky you are, ya know, to be alive. You think, “I might be famous for living through a dragom attack.” You are so preoccupied, you forget you are bleeding out. As you pass out, your head hits a rock, and you die.", "none", "none",
							"retry", "none", "none", "Seriously though, write a book...", "none", "none");
					choice6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
				}
				else if (slideNumber == 8)
				{
					slideInfo(
							10,
							"Inspect Dragom",
							"You walk up to the dragom, and have am uh-oh. He is still breathing. He stands up, and pulls the fork from his head. He says, “I am rather impressed by you, Humam. I will now tell you a riddle, and if you guess right, I will not eat you.” What do you do now?",
							"Call his bluff", "Play his little game", "none", "none", "Ask if he went to Harvard or Yale", "none", "none", "none");
				}
				else if (slideNumber == 15)
				{

					slideInfo(5, "How Kill Dragom?", "Different ways are available. To kill it. Yes.", "Fork", "Knife", "Spoom", "none", "none", "none", "none", "none");
				}

			}
		});
		choice3.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				if (slideNumber == 5)
				{
					slideInfo(4, "Kill with spoom", "wat were u thinking? you are dead now.", "none", "none", "Retry", "none", "none", "none", "none", "none");
				}

				else if (slideNumber == 9 || slideNumber == 65 || slideNumber == 67 || slideNumber == 68 || slideNumber == 69 || slideNumber == 70)
				{
					slideNumber = 2;
					hasPickle = false;
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
				if (slideNumber == 7)
				{

					slideInfo(
							10,
							"Inspect Dragom",
							"You walk up to the dragom, and have am uh-oh. He is still breathing. He stands up, and pulls the fork from his head. He says, “I am rather impressed by you, Humam. I will now tell you a riddle, and if you guess right, I will not eat you.” What do you do now?",
							"Call his bluff", "Play his little game", "none", "none", "Ask if he went to Harvard or Yale", "none", "none", "none");
					choice3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
				}
				else if (slideNumber == 8)
				{
					slideInfo(9, "Contemplate a Book",
							"You consider how lucky you are, ya know, to be alive. You think, “I might be famous for living through a dragom attack.” You are so preoccupied, you forget you are bleeding out. As you pass out, your head hits a rock, and you die.", "none", "none",
							"retry", "none", "none", "Seriously though, write a book...", "none", "none");

				}

			}
		});
		choice5.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				if (slideNumber == 73)
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
				if (slideNumber == 9)
				{
					slideInfo(67, "Write a Book", "As your soul floats up to heavem, you realize you cannot write anything, because you are dead.", "none", "none", "Retry", "none", "none", "Continue to heavem", "none", "none");
					choice6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
				}
				else if (slideNumber == 67)
				{
					slideInfo(
							68,
							"Heavem",
							"As your soul arrives im heavem, you look around and see [classified]. You feel happy, and content with your life, except that you never wrote that book, and now will never be famous. Too bad, so sad. NOW STOP DELAYING YOUR NEXT ATTEMPT AT THE GAME, ALREADY!",
							"none", "none", "Retry", "none", "none", "You are going to write that book!", "none", "none");
				}
				else if (slideNumber == 68)
				{
					slideInfo(
							69,
							"Write the dang book",
							"You decide to sell your soul to the devil, in order to continue living long enough to finish writing the book. Im fact, your story has so much more to it, now that you can include the fact that Heavem, Satam, and God exist. Or perhaps this is all going through your head as your braim releases chemicals to make you feel better, because you never wrote that book...",
							"none", "none", "Retry", "none", "none", "I'm not giving up!", "none", "none");
				}
				else if (slideNumber == 69) /* heh heh */
				{
					slideInfo(
							70,
							"Continue Writing the book",
							"You don’t care what psychedelic drugs are going through your head (for some completely unrelated, unknowm reasom), you are writing the book. You force your braim to empty itself of the idea of death, and therefore become immortal. With this you resurrect right next to the dragom and kill him instantaneously with your pure awesomeness, I guess what they say is true, the mind IS stronger tham the body. But what will you write your book about?",
							"Living through the dragom attack.", "…or you could retry, already.", "Forcing yourself to live again.", "none", "none", "none", "none", "none");
					choice1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
					choice2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
					choice3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
				}

			}
		});
		bigChoice1.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
				textScroll.scrollTo(0, 0);
				buttonScroll.scrollTo(0, 0);
			}
		});
		bigChoice2.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				// TODO Auto-generated method stub
				textScroll.scrollTo(0, 0);
				buttonScroll.scrollTo(0, 0);
			}
		});
	}
}
