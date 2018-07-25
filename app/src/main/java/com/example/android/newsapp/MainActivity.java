package com.example.android.newsapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    /**
     * URL for news data from the Guardian api
     */
    private static final String NEWS_REQUEST_URL =
            "https://content.guardianapis.com/search?q=elon%20musk&api-key=bf3dcc23-6ca4-4239-a7b2-5d3839df748a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kick off an {@link AsyncTask} to perform the network request
        NewsAsyncTask task = new NewsAsyncTask();
        task.execute();
    }

    /**
     * {@link AsyncTask} to perform the network request on a background thread, and then
     * update the UI with the first article in the response.
     */
    private class NewsAsyncTask extends AsyncTask<URL, Void, News> {

        @Override
        protected News doInBackground(URL... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            // Perform the HTTP request for earthquake data and process the response.
            News news = Utils.fetchNewsData(NEWS_REQUEST_URL);
            return news;
        }

        /**
         * Update the screen with the given earthquake (which was the result of the
         * {@link NewsAsyncTask}).
         */
        @Override
        protected void onPostExecute(News news) {
            if (news == null) {
                return;
            }

            // Update the information displayed to the user.
            updateUi(news);
        }

        /**
         * Update the UI with the given article information.
         */
        private void updateUi(News news) {
            TextView titleTextView = (TextView) findViewById(R.id.title);
            titleTextView.setText(news.title);

            TextView sectionTextView = (TextView) findViewById(R.id.section);
            sectionTextView.setText(news.section);

            TextView authorTextView = (TextView) findViewById(R.id.author);
            authorTextView.setText(news.author);

            TextView dateTextView = (TextView) findViewById(R.id.date);
            dateTextView.setText(news.date);

            TextView newsUrlTextView = (TextView) findViewById(R.id.newsURL);
            newsUrlTextView.setText(news.articleUrl);
        }
    }
}
