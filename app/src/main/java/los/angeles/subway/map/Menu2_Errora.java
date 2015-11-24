package los.angeles.subway.map;


import los.angeles.subway.map.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint("ParserError")
public class Menu2_Errora extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().addFlags(WindowManager.LayoutParams.);
        try {
        setContentView(R.layout.menu2_errormain);
	      } catch(Exception e){
		    	startActivity(new Intent(this, WebCamShow.class )); // dummy error pic
		    	finish();
		    	}
    }
    
 // start title bar button calls
	   public void Menu4_Method(View v) {
		   	try {
	    		startActivity(new Intent(this, Menu4.class ));  
	    		finish();

		   	} catch(Exception e) {
		   		
		   	}}
	   public void Menu8_Method(View v) { // zoom +
//	Toast.makeText(getApplicationContext()," clicked btn222222222222222222 ",Toast.LENGTH_SHORT).show();
		   	try {
	    		startActivity(new Intent(this, Menu8.class ));
	    		finish();


		   	} catch(Exception e) {
		   	}
		   	    }
	   public void Menu1_Method(View v) { 
		   	try {
	    		startActivity(new Intent(this, Menu1.class ));  
	    		finish();
		   	} catch(Exception e) {
		   		
		   	}} 
	   public void Menu5_Method(View v) { 
		   	try {
	    		startActivity(new Intent(this, Menu5.class ));
	    		finish();
		   	} catch(Exception e) {
		   		
		   	}} 	
	   public void Menu6_Method(View v) { 
		   	try {
	    		startActivity(new Intent(this, Menu6.class ));
	    		finish();
		   	} catch(Exception e) {
		   		
		   	}} 
		   public void Menu2_Method(View v) { // zoom -
			   	try {
		    		startActivity(new Intent(this, Menu2.class ));  
		    		finish();
			   	} catch(Exception e) {
			   		
			   	}}   
		   public void Menu9_Method(View v) { 
			   	try {
		    		startActivity(new Intent(this, Menu9.class ));
		    		finish();
			   	} catch(Exception e) {
			   		
			   	}} 
		   public void Menu7_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu7.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu3_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu3.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu10_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu10.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
//end button calls
			@Override
			public void onStop() {
				super.onStop();
				System.gc();

			}
}