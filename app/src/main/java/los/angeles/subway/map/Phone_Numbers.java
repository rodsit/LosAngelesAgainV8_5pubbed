package los.angeles.subway.map;



import los.angeles.subway.map.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Phone_Numbers extends Activity {
	ImageButton btn1, btn2, btn3,btn4,btn5,btn6;
	
	OnClickListener btn1listener;
    @SuppressLint("ParserError")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_numbers);
        btn1 = (ImageButton)findViewById(R.id.imageButton1);
        btn2 = (ImageButton)findViewById(R.id.imageButton2);
        btn3 = (ImageButton)findViewById(R.id.imageButton3);
        btn4 = (ImageButton)findViewById(R.id.imageButton4);
        btn5 = (ImageButton)findViewById(R.id.imageButton5);
        btn6 = (ImageButton)findViewById(R.id.imageButton6);
        btn1.setOnClickListener(new View.OnClickListener() {// this button gets next word
            public void onClick(View view) {
                String 	Latitudes = "31.248774";
                String 	Longitudes = "121.45521";
           String label = "Station 站";
           String uriBegin = "geo:"+Latitudes+","+Longitudes+"";
           String query = ""+Latitudes+","+Longitudes+"(" + label + ")";
           String encodedQuery = Uri.encode( query  );
           String uriString = uriBegin + "?q=" + encodedQuery;
           Uri uri = Uri.parse( uriString );
           Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri );
           startActivity( intent );
  // Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse("geo:0,0?q="+Latitudes+","+Longitudes+"")); 
   // startActivity(intent);
             //   finish();       
         	   }
        });  // end button01 listener
        btn2.setOnClickListener(new View.OnClickListener() {// this button gets next word
            public void onClick(View view) {
                String 	Latitudes = "31.022282";
                String 	Longitudes = "120.844995";
                String label = "London";
                String uriBegin = "geo:"+Latitudes+","+Longitudes+"";
                String query = ""+Latitudes+","+Longitudes+"(" + label + ")";
                String encodedQuery = Uri.encode( query  );
                String uriString = uriBegin + "?q=" + encodedQuery;
                Uri uri = Uri.parse( uriString );
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri );
                startActivity( intent );    
         	   }
        }); 
        btn3.setOnClickListener(new View.OnClickListener() {// this button gets next word
            public void onClick(View view) {
                String 	Latitudes = "31.322282";
                String 	Longitudes = "121.544995";
                String label = "Gongqing Forest Resort";
                String uriBegin = "geo:"+Latitudes+","+Longitudes+"";
                String query = ""+Latitudes+","+Longitudes+"(" + label + ")";
                String encodedQuery = Uri.encode( query  );
                String uriString = uriBegin + "?q=" + encodedQuery;
                Uri uri = Uri.parse( uriString );
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri );
                startActivity( intent );      
         	   }
        }); 
        btn4.setOnClickListener(new View.OnClickListener() {// this button gets next word
            public void onClick(View view) {
                String 	Latitudes = "31.2402";
                String 	Longitudes = "121.5000";
                String label = "Pearl Tower 珍珠塔";
                String uriBegin = "geo:"+Latitudes+","+Longitudes+"";
                String query = ""+Latitudes+","+Longitudes+"(" + label + ")";
                String encodedQuery = Uri.encode( query  );
                String uriString = uriBegin + "?q=" + encodedQuery;
                Uri uri = Uri.parse( uriString );
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri );
                startActivity( intent );       
         	   }
        }); 
        btn5.setOnClickListener(new View.OnClickListener() {// this button gets next word
            public void onClick(View view) {
                String 	Latitudes = "31.235252";
                String 	Longitudes = "121.757591";
                String label = "Golf 高尔夫球";
                String uriBegin = "geo:"+Latitudes+","+Longitudes+"";
                String query = ""+Latitudes+","+Longitudes+"(" + label + ")";
                String encodedQuery = Uri.encode( query  );
                String uriString = uriBegin + "?q=" + encodedQuery;
                Uri uri = Uri.parse( uriString );
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri );
                startActivity( intent );       
         	   }
        }); 
        btn6.setOnClickListener(new View.OnClickListener() {// this button gets next word
            public void onClick(View view) {
                String 	Latitudes = "31.782282";
                String 	Longitudes = "121.254995";
                String label = "Xinguangcun";
                String uriBegin = "geo:"+Latitudes+","+Longitudes+"";
                String query = ""+Latitudes+","+Longitudes+"(" + label + ")";
                String encodedQuery = Uri.encode( query  );
                String uriString = uriBegin + "?q=" + encodedQuery;
                Uri uri = Uri.parse( uriString );
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri );
                startActivity( intent );      
         	   }
        }); 
     //   TextView textview = new TextView(this);
      //  textview.setText("This is Android tab");
       // setContentView(textview);
    }
    // start title bar button calls
	   public void Menu4_Method(View v) {
		   	try {
	    		startActivity(new Intent(this, WebCamShow.class ));  
	    		finish();

		   	} catch(Exception e) {
		   		
		   	}}
	   public void Menu1_Method(View v) { 
		   	try {
		   		startActivity(new Intent(this, Menu1.class ));
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

		   public void Menu2_Method(View v) { // zoom -
			   	try {
		    		startActivity(new Intent(this, Menu1_Errora.class ));  
		    		finish();
			   	} catch(Exception e) {
			   		
			   	}}   
		   public void Menu7_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu7.class ));  
		    		finish();
	  //    		savedMatrix.set(matrix);

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
}