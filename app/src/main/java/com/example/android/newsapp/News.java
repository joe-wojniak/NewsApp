package com.example.android.newsapp;

/**
 * {@News} represents an article.
 */
public class News {

    /** Title of the article */
    public final String title;

    /** Section that the article is from */
    public final String section;

    /** Author's name */
    public final String author;

    /** Date of article */
    public final String date;

    /** Url of Article */
    public final String articleUrl;

    /**
     * Constructs a new {@link News}.
     *
     * @param newsTitle is the title of the article
     * @param newsSection is the section that the article is from
     * @param newsAuthor is the name of the author
     * @param newsDate is the date of the article
     * @param newsUrl is the url of the article
     */
    public News(String newsTitle, String newsSection, String newsAuthor, String newsDate, String newsUrl) {
        title = newsTitle;
        section = newsSection;
        author = newsAuthor;
        date = newsDate;
        articleUrl = newsUrl;
    }
}
