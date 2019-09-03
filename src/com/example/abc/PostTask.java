package com.example.abc;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

class PostTask extends AsyncTask<Void, Integer, String> { 
TextView title;ProgressBar progressbar;
Context c;
	PostTask(Context co,TextView txt, ProgressBar progressBar)
	{
		c=co;
		title = txt;
		progressbar = progressBar;
	}
   @Override
   protected void onPreExecute() {
      super.onPreExecute();
      updateStatus("Downloading...");
   }
   @Override
   protected String doInBackground(Void... params) {
     for (int i = 0; i <= 100; i += 5) {
       try {
         Thread.sleep(250);
                } catch (InterruptedException e) {
          e.printStackTrace();
        }
   publishProgress(i);}
      return "All Done!";}
   @Override
  protected void onProgressUpdate(Integer... values) {
   super.onProgressUpdate(values);
      updateProgressBar(values);
   }
@Override
   protected void onPostExecute(String result) {
      super.onPostExecute(result);
      dismissProgressBar();
      Intent i=new Intent(c,Main_interface.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		c.startActivity(i);
      }
 private void updateStatus(String string) { title.setText(string); }   
private void updateProgressBar(Integer[] values) {
progressbar.setProgress(values[0]);
}
private void dismissProgressBar() {
updateStatus("Downloaded");
progressbar.setProgress(100);


}
}
