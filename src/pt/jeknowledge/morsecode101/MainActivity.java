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
		
		
		final Button button= (Button) findViewById(R.id.refreshButton);
		final TextView settext = (TextView) findViewById(R.id.textView);
		final EditText rectext = (EditText) findViewById(R.id.editText);
		
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        
		    	settext.setText((CharSequence) rectext.getText());
		    	
		    	
		    }
		});
	}

	
	
}
