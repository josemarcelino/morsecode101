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
		
		final Alphabet Acreated = new Alphabet();	
		
		tobutton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	String before = rectext.getText().toString();
		    	String after = convertToMorse(before,Acreated);
		    	settext.setText(after);
		    	
		    }
		});
		
		frombutton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	String before = rectext.getText().toString();
		    	String after = convertFromMorse(before, Acreated);
		    	settext.setText(after);
		    	
		    }
		});
		
	}

	private String convertToMorse(String before, Alphabet Acreated) {
		
		String [] after  = new String [before.length()];
		
		for(int i = 0; i <before.length(); i++){
				
			after[i] = Acreated.getEquivToMorse(before.charAt(i));
			
		}
			
		String afterConcat = after[0];
		
		for(int i = 1; i < before.length(); i++){
			
			afterConcat = afterConcat + after[i];
			
		}
		
		return afterConcat;
	}
	
	private String convertFromMorse(String before, Alphabet Acreated) {
		
		String [] after  = new String [before.length()];
		
		
		
		String afterConcat = after[0];
		
		for(int i = 1; i < before.length(); i++){
			
			afterConcat = afterConcat + after[i];
			
		}
		
		return afterConcat;
	}
	
}
