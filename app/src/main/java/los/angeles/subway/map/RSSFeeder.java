package los.angeles.subway.map;


import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import los.angeles.subway.map.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
// import android.os.StrictMode;
// import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


@SuppressLint("NewApi")
public class RSSFeeder extends Activity {
	/** Called when the activity is first created. */
	ListView lv1;
	ProgressDialog ShowProgress;
	public ArrayList<Post> PostList = new ArrayList<Post>();

	@TargetApi(9)
	@SuppressLint({ "NewApi", "NewApi", "NewApi" })
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        ThreadPolicy tp = ThreadPolicy.LAX;
        StrictMode.setThreadPolicy(tp);
		setContentView(R.layout.twitter_main);
		lv1 = (ListView) findViewById(R.id.listView1);
ShowProgress = ProgressDialog.show(RSSFeeder.this, "","", true);
		new loadingTask().execute("http://search.twitter.com/search.rss?q=shanghai&rpp=4");
	//	https://twitter.com/statuses/user_timeline/303177860.rss // but no images
		// screen_name=lahinchsurfshop
		// http://search.twitter.com/search.rss?q=android
// http://feeds.feedburner.com/theappleblog
/*		lv1.setOnItemClickListener(new OnItemClickListener() { // onclick cells
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri
						.parse(PostList.get(position).getUrl()));
				startActivity(intent);

			}
		});
*/
	}
    public void twitRefresh(View view) {
       	Intent intent = new Intent(RSSFeeder.this,RSSFeeder.class);
        startActivity(intent);
        finish();
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
	    		startActivity(new Intent(this, RSSFeeder.class ));
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
int count = 0;
	class loadingTask extends AsyncTask<String, Void, String> {
		protected String doInBackground(String... urls) {
			try {
			SAXHelper sh = null;
			try {
				sh = new SAXHelper(urls[0]);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			sh.parseContent("");
			} catch (Exception e) {
				count = 3;
				e.printStackTrace();

			}
			return "";
		}
		protected void onPostExecute(String s) {
			if(count==3){
	// Log.e("ERROR IS ::::","HERE: "); 
	ShowProgress.dismiss();
			} else {
			lv1.setAdapter(new EfficientAdapter(RSSFeeder.this, PostList));
			ShowProgress.dismiss();
			}
		}
	}

	class SAXHelper {
		public HashMap<String, String> userList = new HashMap<String, String>();
		private URL url2;
		public SAXHelper(String url1) throws MalformedURLException {
			this.url2 = new URL(url1);
		}
		public RSSHandler parseContent(String parseContent) {
			RSSHandler df = new RSSHandler();
			try {
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				XMLReader xr = sp.getXMLReader();
				xr.setContentHandler(df);
				xr.parse(new InputSource(url2.openStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return df;
		}
	}

	class RSSHandler extends DefaultHandler {
		private Post currentPost = new Post();
		StringBuffer chars = new StringBuffer();
		boolean inItem = false;
		@Override
		public void startElement(String uri, String localName, String qName,Attributes atts) {
			chars = new StringBuffer();
	        if(localName.equalsIgnoreCase("channel")) {
	        	inItem = false;
	        	// Log.d("rssrssrsschannelchannel"," channel is false"); 
	        } else if(localName.equalsIgnoreCase("item")) {
	        	// Log.d("rssrssrssitemitemitem"," item is true "); 
	            inItem = true;
	       }			
		}
		@Override
		public void endElement(String uri, String localName, String qName)
		
				throws SAXException { 
// Log.d("rssrssrss000000"," uri is "+uri+" localName is "+localName+" qName is "+qName);  
			if (localName.equalsIgnoreCase("title") && currentPost.getTitle() == null) {
				 if(inItem) {
					 // Log.d("rssrssrss11111",""+currentPost.getTitle());
					 currentPost.setTitle(chars.toString());
		            } else {
		           // dunno
		            }	}
			if (localName.equalsIgnoreCase("pubDate") && currentPost.getPubDate() == null) {
				 if(inItem) {
					 // Log.d("rssrssrss11111",""+currentPost.getPubDate());
					 currentPost.setPubDate(chars.toString());
		            } else {
		           // dunno
		            }	}			
			if (localName.equalsIgnoreCase("image_link") && currentPost.getThumbnail() == null) {
				 if(inItem) {
					 // Log.d("rssrssrss11111",""+currentPost.getThumbnail());
					 currentPost.setThumbnail(chars.toString());
		            } else {
		           // dunno
		            }	}	
			if (localName.equalsIgnoreCase("guid") && currentPost.getUrl() == null) {
				 if(inItem) {
					 // Log.d("rssrssrss11111",""+currentPost.getUrl());
					 currentPost.setUrl(chars.toString());
		            } else {
		           // dunno
		            }	}				
			
			if (localName.equalsIgnoreCase("item")) {
// Log.d("rssrssrss555555555","localname is item add to list");
				PostList.add(currentPost);
				currentPost = new Post();
			}
		}
		@Override
		public void characters(char ch[], int start, int length) {
			chars.append(new String(ch, start, length));
		}
	}
	// class post starts here
	private class Post {

		private String title;
		private String thumbnail;
		private String url;
		private String description;
		private String pubDate;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public void setPubDate(String pubDate) {
			this.pubDate = pubDate;
		}

		public String getPubDate() {
			return pubDate;
		}

	} // end of Post class
	// EfficientAdapter starts here
	public class EfficientAdapter extends BaseAdapter {
		private Activity activity;
		private ArrayList<Post> data;
		private LayoutInflater inflater = null;
		//public ImageLoader imageLoader;
		ViewHolder holder;

		EfficientAdapter(Activity a, ArrayList<Post> d) {

			activity = a;
			data = d;
			inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//	imageLoader = new ImageLoader(activity.getApplicationContext());
		}
		@Override
		public int getCount() {
			return data.toArray().length;
		}
		@Override
		public Object getItem(int position) {
			return position;
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
		public class ViewHolder {
			public TextView titley;
			public TextView pubDatey;
			public ImageView thumby;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View vi = convertView;
			if (convertView == null) {
				vi = inflater.inflate(R.layout.twitter_row, null);
				holder = new ViewHolder();
				holder.titley = (TextView) vi.findViewById(R.id.title_textview);
				holder.pubDatey = (TextView) vi.findViewById(R.id.pubdatey_textview);
				holder.thumby = (ImageView) vi.findViewById(R.id.thumb_imageview);
				vi.setTag(holder);
			//	// Log.d("my tag","1111111111111111111111111 "+position + " "+data.get(position).getTitle()); 
			} else
				holder = (ViewHolder) vi.getTag();
		//	int count = data.get(index);
		//	if(position<2){
			holder.titley.setText(data.get(position).getTitle());
			holder.pubDatey.setText(data.get(position).getPubDate());
			// Log.d("my tag","222222222222222222222222222 "+position + " "+data.get(position).getTitle() + " length "+ data.toArray().length ); 
		//	}
//			imageLoader.DisplayImage((data.get(position).getThumbnail()), activity,
//					holder.image, 72, 72);
			URL url = null;
			try {
				url = new URL((data.get(position).getThumbnail())); 
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InputStream content = null;
			try {
				content = (InputStream)url.getContent();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Drawable d = Drawable.createFromStream(content , "src"); 
			Bitmap mIcon1 = null;
			 try {
				 mIcon1 =
				        BitmapFactory.decodeStream(url.openConnection().getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			holder.thumby.setImageBitmap(Bitmap.createScaledBitmap(mIcon1, 48, 48, false));

			
			return vi;
		}

	}


}
