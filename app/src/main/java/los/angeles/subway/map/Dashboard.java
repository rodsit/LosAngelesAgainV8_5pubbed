package los.angeles.subway.map;


import los.angeles.subway.map.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends Activity {
    /** Called when the activity is first created. */   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_home);
    }
    /** Handle "refresh" title-bar action. */
    public void onRefreshClick(View v) {
// Toast.makeText(getApplicationContext()," clicked refresh ", Toast.LENGTH_SHORT).show();
// trigger off background sync
//      final Intent intent = new Intent(Intent.ACTION_SYNC, null, this, SyncService.class);
//      intent.putExtra(SyncService.EXTRA_STATUS_RECEIVER, mState.mReceiver);
//     startService(intent);
//     reloadNowPlaying(true); 
    }
    /** Handle "search" title-bar action. */
    public void onSearchClick(View v) {
  //  	Toast.makeText(getApplicationContext()," clicked search ", Toast.LENGTH_SHORT).show();
      //  UIUtils.goSearch(this);  
    }
    /** Handle "schedule" action. */
    public void Menu4_Method(View v) {
    	startActivity(new Intent(this, Menu7.class ));
//Toast.makeText(getApplicationContext()," clicked schedule ", //Toast.LENGTH_SHORT).show();
    }
    /** Handle "map" action. */
    public void onbtn1Click(View v) { 
    	startActivity(new Intent(this, Menu8.class ));
    }  
    public void onbtn3Click(View v) {
 //   	startActivity(new Intent(this, Touch3.class ));  
    }
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();  
        inflater.inflate(R.menu.menu, menu);
         return true;
     }
     /**
      * Called right before your activity's option menu is displayed.
      */
     @Override
     public boolean onPrepareOptionsMenu(Menu menu) {  
   
         return true;  
     } 
     /**
      * Called when a menu item is selected.
      */
     @Override
     public boolean onOptionsItemSelected(MenuItem item){  
         switch (item.getItemId()) {  
         case R.id.email:
       	Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:rodsit@gmail.com"));
       	intent.putExtra("subject", " ");
       	intent.putExtra("body", " " );
       	startActivity(intent); 
     		break;

     }  
         return true;  
     } 
}