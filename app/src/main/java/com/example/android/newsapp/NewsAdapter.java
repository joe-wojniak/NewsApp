package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context  of the app
     * @param newsList is the list of earthquakes, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    /**
     * Returns a list item view that displays information at the given position in the list.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the article at the given position in the list
        News currentNews = getItem(position);

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);

        // Display the title in that TextView
        String title = currentNews.getTitle();
        titleView.setText(title);

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);

        // Display the section in that TextView
        String section = currentNews.getSection();
        sectionView.setText(section);

        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);

        // Display the author in that TextView
        String author = currentNews.getAuthor();
        authorView.setText(author);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        // Display the date in that TextView
        String date = currentNews.getDate();
        dateView.setText(date);

        // Find the TextView with view ID newsUrl
        TextView newsUrlView = (TextView) listItemView.findViewById(R.id.newsUrl);

        // Display the newsUrl in that TextView
        String newsUrl = currentNews.getUrl();
        newsUrlView.setText(newsUrl);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
