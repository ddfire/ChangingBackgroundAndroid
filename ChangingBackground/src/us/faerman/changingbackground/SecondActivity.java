package us.faerman.changingbackground;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends Activity implements OnClickListener{
	RelativeLayout background;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		overridePendingTransition(R.anim.left_in, R.anim.left_out);
		background = (RelativeLayout)findViewById(R.id.background);
		Button goBack = (Button) findViewById(R.id.nextPage);
		goBack.setText("GoBack");
		TextView text = (TextView) findViewById(R.id.text);
		text.setText("Second activity");
		goBack.setOnClickListener( this);
	}

	@Override
	public void onClick(View arg0) {
		setResult(RESULT_OK);
		finish();
		overridePendingTransition(R.anim.right_in, R.anim.right_out);
	}

	@Override
	protected void onResume() {
		super.onResume();
		TransitionDrawable transition = (TransitionDrawable) background.getBackground();
		transition.startTransition(2500);
		
	}
	
	@Override
	public void onBackPressed() {//just in case the user go back with the back button
	    super.onBackPressed();
	    overridePendingTransition(R.anim.right_in, R.anim.right_out);
	}

}
