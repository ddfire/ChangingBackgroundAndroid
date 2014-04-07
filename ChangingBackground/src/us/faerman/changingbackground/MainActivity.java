package us.faerman.changingbackground;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	RelativeLayout background;
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//background.setBackgroundResource(R.drawable.green);
		background.setBackgroundResource(R.drawable.greentoblue);
		TransitionDrawable transition = (TransitionDrawable) background.getBackground();
		transition.startTransition(2500);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		background = (RelativeLayout) findViewById(R.id.background);
		Button goNext = (Button) findViewById(R.id.nextPage);
		goNext.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		Intent intent = new Intent(this,SecondActivity.class);
		startActivityForResult(intent,0);//Starting activity for result prevent the change of color 
										 //when the activity start from the launcher icon, with out complications.
		
		overridePendingTransition(0,R.anim.left_in);
	}
}
