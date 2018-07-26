

package com.example.android.newsapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /** Tag for the log messages */
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    //URL for news data from the Guardian api
    private static final String NEWS_REQUEST_URL =
            "https://content.guardianapis.com/search?q=elon%20musk&api-key=bf3dcc23-6ca4-4239-a7b2-5d3839df748a";

    /**
     * Adapter for the list of articles
     */
    private NewsAdapter mAdapter;

    /**
     * TextView that is displayed when the list is empty
     */
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find a reference to the {@link ListView} in the layout
        ListView newsListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        newsListView.setEmptyView(mEmptyStateTextView);

        // Create a new adapter that takes an empty list of articles as input
        mAdapter = new NewsAdapter(this, new ArrayList<News>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        newsListView.setAdapter(mAdapter);

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

            // Perform the HTTP request for data and process the response.
            News news = Utils.fetchNewsData(NEWS_REQUEST_URL);
            return news;
        }

        /**
         * Update the screen with the news article (which was the result of the
         * {@link NewsAsyncTask}).
         */
        @Override
        protected void onPostExecute(News news) {
            if (news == null) {
                Log.d(LOG_TAG, "News: "+news);
                return;
            }

            // If there is a valid list of {@link News}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (news != null) {
                mAdapter.addAll(news);
            }
        }
    }
}
