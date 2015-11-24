package los.angeles.subway.map;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import los.angeles.subway.map.R;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;


public class Menu18 extends Activity implements OnTouchListener {
	// web cam as of now	
	   private static final String TAG = "Touch";
	   // These matrices will be used to move and zoom image
	   Matrix matrix = new Matrix(); 
	   Matrix savedMatrix = new Matrix(); 
	   // We can be in one of these 3 states
	   static final int NONE = 0;
	   static final int DRAG = 1;
	   static final int ZOOM = 2;
	   int mode = NONE;
	   // Remember some things for zooming
	   PointF start = new PointF();
	   PointF mid = new PointF();
	   float oldDist = 1f;
	//   ImageView view;
//	   float zoom = 0.5f;
	   float scale = 1.0f; 	
	
	ImageView iv; // = (ImageView)findViewById(R.id.remote_image);
	TextView tv;
	ImageButton bt;
	ImageView image; 
//	 ProgressDialog pd;
    @Override
    public void onCreate(Bundle extras){
        super.onCreate(extras);
    //    image = (ImageView) myView.findViewById(R.drawable.icon);
try {
        setContentView(R.layout.image_layout);
	      Display display = getWindowManager().getDefaultDisplay();
	      float disWidth = display.getWidth();
//	      Log.d("11111screeeenWirdthhhhhhh"," is " +disWidth);
	      float disHeight = display.getHeight();
        tv = (TextView)findViewById(R.id.TextView01);
        bt = (ImageButton)findViewById(R.id.ImageButton1);
        iv = (ImageView)findViewById(R.id.remote_image);
        iv.setOnTouchListener(this);
        scale = 0.5f;  
  //      Log.d("2222screeeenWirdthhhhhhh"," is " +disWidth);
        if(disWidth>=90){ // really titchy androids 
        	scale = 0.5f;
        }
        if(disWidth>=300){ // my htc desire c nexus etc
        	scale = 1.01f;
        }
        if(disWidth>=400){ // emulator normal (480)
        	scale = 1.21f;
        }
        if(disWidth>=590){ // large tab
        	scale = 1.41f;
        }
        if(disWidth>=795){ // big tab
        	scale = 1.5f;  
        }

        matrix.setScale(scale,scale);      
	      iv.setImageMatrix(matrix);
	      } catch(Exception e){
	    	e.printStackTrace();
	 //   	startActivity(new Intent(this, Phone_Numbers.class ));
	   // 	finish();
//	    		Toast.makeText(getApplicationContext()," Sorry, your phoine does not have enough VM memory  "+e,Toast.LENGTH_LONG).show();
	    		// TODO
	    	}       
       ImageDownloader id = new ImageDownloader(); 
   //    if(isOnline()) {
    	   id.execute("http://www.bbc.co.uk/travelnews/london/trafficcameras/transportforlondon/0000108600/1369727518054/image"); // } else {
    	   // cam1 http://195.137.110.245/record/current.jpg
    	   // cam2 http://camera.server1.net/cam_1.jpg
    // berlin http://www.opentopia.com/images/data/cams/14356/big.jpg
    	   // brighton orig http://195.137.110.245/record/current.jpg
  // brighton cam 2 umm does not display http://213.123.185.68/axis-cgi/mjpg/video.cgi?resolution=640x480
    	   // http://oceanscene-lahinch.remotemanager.co.uk/image/1000/-/tmp/?cam=896c2a5186c2079a6d2de88ada70cd89&b=no&f=yes&c=yes&q=70&m=yes&_nocache=d734043ad3bd24c18eebcfa258a97995/download.jpg
    	 // http://93.107.38.140/jpg/image.jpg
    	   //http://195.137.110.245/record/current.jpg
    	   // http://93.107.38.140/jpg/image.jpg
    	   // http://www.surf-forecast.com/webcam/Sumner-Bar.jpg
    //		   tv.setText("No internet?");
      //     Toast.makeText(this, "No Internet connection found.", Toast.LENGTH_LONG).show();
    	//   } 
 // http://lh5.ggpht.com/_Z6tbBnE-swM/TB0CryLkiLI/AAAAAAAAVSo/n6B78hsDUz4/s144-c/_DSC3454.jpg    
       // http://93.107.38.140/jpg/image.jpg
       bt.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
       	Intent intent = new Intent(Menu18.this,Menu18.class);
            startActivity(intent);
            finish();
        	   
           }
       });
    }
    // start title bar button calls
	   public void Menu4_Method(View v) {
		   	try {
	    		startActivity(new Intent(this, Menu4.class ));  
	    		finish();

		   	} catch(Exception e) {
		   		
		   	}}
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
	   public void Menu9_Method(View v) { 
		   	try {
	    		startActivity(new Intent(this, Menu9.class ));
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
		    		startActivity(new Intent(this, Menu2.class ));  
		    		finish();
			   	} catch(Exception e) {
			   		
			   	}}   
		   public void Menu7_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu7.class ));  
		    		finish();
	      		savedMatrix.set(matrix);

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
		// cam buttons start
		   public void Menu11_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu11.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu12_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu12.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu13_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu13.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu14_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu14.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu15_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu15.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu16_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu16.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu17_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu17.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu18_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu18.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu19_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu19.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   public void Menu20_Method(View v) {
			   	try {
		    		startActivity(new Intent(this, Menu20.class ));  
		    		finish();
	      	//	savedMatrix.set(matrix);

			   	} catch(Exception e) {
			   		
			   	}}
		   // cam buttons end
//end button calls


		    private class ImageDownloader extends AsyncTask<String, Integer, Bitmap>{
		    	Integer count=0;
		     //   ProgressDialog pd;
		    	protected void onPreExecute(){
		    		tv.setText(R.string.menu18);
		    		//        pd = new ProgressDialog(StartActivity.this);
		      //      pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		        //    pd.setMessage("Downloading Laching surf pic...");
		          //  pd.show();
		    	    }
		    	    @SuppressLint("ParserError")
					@Override
		    	    protected Bitmap doInBackground(String... params) {
		    	        //TODO Auto-generated method stub
		    	        try{
		    	            URL url = new URL(params[0]);
		    	            try {
		    	            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
		    	            httpCon.setConnectTimeout(15000); // make some nice messages here! do not be lazy
		    	            httpCon.setReadTimeout(15000);
		    	            //  if(httpCon.getResponseCode() != 200)
		    	            //   throw new Exception("Failed to connect");
		    	            InputStream is = httpCon.getInputStream();
		    	          return BitmapFactory.decodeStream(is); // try return a drawable

		    	            } catch(Exception e1){
		    	         Log.e("ERROR IS ::::","HERE: "+e1.getCause().toString().contains("ENETUNREACH"));
		    	         if(e1.getCause().toString().contains("ENETUNREACH")){
		    	        	 Log.e("containned IS ::::","contained : ENETUNREACH ");  	        	 
		    	         }
		    	            	count= 3; 
		    	            	return null;
		    	            }
		    	        }catch(Exception e){	
		                    count = 3;
		    	            Log.e("Image","Failed to load image",e);   	            
		    	        }
		    	        return null;  
		    	    } 
		    	    protected void onProgressUpdate(Integer... params){
		    	        //Update a progress bar here, or ignore it, it's up to you
		    	    }
		    	    @SuppressWarnings("static-access")
					protected void onPostExecute(Bitmap img){
		    	//        ImageView iv = (ImageView)findViewById(R.id.remote_image);
		    	  //  	onClicky();
		    	    	if(count==3){
		    	    	//	pd.dismiss();
		    	    	tv.setText(R.string.tryagainlater); // catch all error into text field
		    	    //		Log.e("Imagesyyyyyyyyyyyyyy","pppppppppppppppppppppppp");		
		    	    	} else {
		    	    		tv.setText(R.string.menu18);
		    	    	//	tv.setText("Live Shanghai Web Cam 上海网络摄像头");
		            //    pd.dismiss();
		    	        if(iv!=null && img!=null){

		    	        	
		    	            iv.setImageBitmap(img); 
		    	            
		    	        
		    	        
		    	        
		    	   
		    	        } }
		    	    }
    	        protected void onCancelled(){
    	        }
    	    }
    @Override 
    public void onPause(){ 
            super.onPause(); 
            tv.setText("...");
        //    pd.dismiss();
    }
	@Override
	public boolean onTouch(View v, MotionEvent event) {
	      ImageView iv = (ImageView) v;
	 try {
	      // Dump touch event to log  
	    //  dumpEvent(event);

	      // Handle touch events here...
	      switch (event.getAction() & MotionEvent.ACTION_MASK) {
	      case MotionEvent.ACTION_DOWN:
	         savedMatrix.set(matrix);
	         start.set(event.getX(), event.getY());
	         Log.d(TAG, "mode=DRAG");
	         mode = DRAG;
	         break;
	      case MotionEvent.ACTION_POINTER_DOWN:
	         oldDist = spacing(event);
	         // Log.d(TAG, "oldDist=" + oldDist);
	         if (oldDist > 10f) {
	            savedMatrix.set(matrix);
	            midPoint(mid, event);
	            mode = ZOOM;
	             Log.d(TAG, "mode=ZOOM");
	         }
	         break;
	      case MotionEvent.ACTION_UP:
	      case MotionEvent.ACTION_POINTER_UP:
	         mode = NONE;
	        Log.d(TAG, "mode=NONE");
	         break;
	      case MotionEvent.ACTION_MOVE:
	         if (mode == DRAG) {
	            // ...
	            matrix.set(savedMatrix);
	            matrix.postTranslate(event.getX() - start.x,
	                  event.getY() - start.y);
	         }
	         else if (mode == ZOOM) {
	            float newDist = spacing(event);
	         Log.d(TAG, "newDist=" + newDist);
	            if (newDist > 10f) {
	               matrix.set(savedMatrix);
	               float scale = newDist / oldDist;
	               matrix.postScale(scale, scale, mid.x, mid.y);
	            }
	         }
	         break;
	      }

	      iv.setImageMatrix(matrix);
	   } catch(Exception e){
			// trying to use a recycled bitmap?
		}
	      return true; // indicate event was handled
	   }
	   /** Determine the space between the first two fingers */
	   private float spacing(MotionEvent event) {
	      float x = event.getX(0) - event.getX(1);
	      float y = event.getY(0) - event.getY(1);
	      return FloatMath.sqrt(x * x + y * y);
	   }

	   /** Calculate the mid point of the first two fingers */
	   private void midPoint(PointF point, MotionEvent event) {
	      float x = event.getX(0) + event.getX(1);
	      float y = event.getY(0) + event.getY(1);
	      point.set(x / 2, y / 2);
	   }   
} // end od activity
