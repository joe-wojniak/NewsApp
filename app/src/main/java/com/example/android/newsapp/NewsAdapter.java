/* Sections of code functionality copied & modified from ud843 QuakeReport
 * to implement abnd_proj6 NewsApp Stage 1
 */

package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context  of the app
     * @param newsList is the list of articles, which is the data source of the adapter
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

        // Display Author if not empty
        if (currentNews.getAuthor() != null && !currentNews.getAuthor().isEmpty()) {
            // Find the TextView with view ID author
            TextView authorView = (TextView) listItemView.findViewById(R.id.author);
            // make the TextView visible
            authorView.setVisibility(View.VISIBLE);
            // Display the author in that TextView
            String author = currentNews.getAuthor();
            authorView.setText("Author: " + author);
        } else {
            // Find the TextView with view ID author
            TextView authorView = (TextView) listItemView.findViewById(R.id.author);
            // if Author is null or empty, make the TextView gone (doesn't show or take up space)
            authorView.setVisibility(View.GONE);
        }

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String dateToFormat = currentNews.getDate().substring(0, 10);
        String formattedDate = formatDate(dateToFormat);
        // Set the TextView with current date
        dateView.setText(formattedDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a String.
     */
    private String formatDate(String dateFormatting) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateFormatting);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String strDate = dateFormat.format(convertedDate);
        return strDate;
    }

}
