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
			
			if(after[i] != null){
				afterConcat = afterConcat + after[i];
			}
			
		}
		
		return afterConcat;
	}
	
	private String convertFromMorse(String before, Alphabet Acreated) {

		String [] after  = new String [before.length()];
		
		int start = 0;
		int finish = 0;
		
		while(finish  != before.length()){
			
			if(before.charAt(finish) == '/'){
				
				after[start]= before.substring(start, finish);
				start = finish+1;
			}
		
			finish++;
		}
		
		after[start]= before.substring(start, before.length());
		
		for(int i = 0; i < before.length(); i++){
		
			if(after[i] != null){
				after[i] = Acreated.getEquivFromMorse(after[i]);
			}
		}
		
		
		String afterConcat = after[0];
		
		for(int i = 1; i < before.length(); i++){
			
			if(after[i] != null){
				afterConcat = afterConcat + ' ' +after[i];
			}
		}
		
		return afterConcat;
	}	
}
