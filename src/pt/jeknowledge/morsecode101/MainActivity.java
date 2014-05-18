package pt.jeknowledge.morsecode101;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button tobutton= (Button) findViewById(R.id.tomorseButton);
		final Button frombutton = (Button) findViewById(R.id.frommorseButton);
		
		final TextView settext = (TextView) findViewById(R.id.textView);
		final EditText rectext = (EditText) findViewById(R.id.editText1);
		
		tobutton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	String before = rectext.getText().toString();
		    	String after = convertToMorse(before);
		    	settext.setText(after);
		    	
		    }
		});
	}

	private String convertToMorse(String before) {
	
		Alphabet Acreated = new Alphabet();	
		String [] after  = new String [before.length()];
		
		for(int i = 0; i <before.length(); i++){
				
			after[i] = Acreated.getEquiv(before.charAt(i));
			
		}
			
		String afterConcat = after[0];
		
		for(int i = 1; i < before.length(); i++){
			
			afterConcat = afterConcat + after[i];
			
		}
		
		return afterConcat;
	}
	
}
