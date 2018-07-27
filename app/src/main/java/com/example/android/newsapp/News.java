/* Sections of code functionality copied & modified from ud843 QuakeReport
 * to implement abnd_proj6 NewsApp
 */

package com.example.android.newsapp;

/**
 * {@News} represents an article.
 */
public class News {

    /** Title of the article */
    public final String mTitle;

    /** Section that the article is from */
    public final String mSection;

    /** Author's name */
    public final String mAuthor;

    /** Date of article */
    public final String mDate;

    /** Url of Article */
    public final String mArticleUrl;

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
        mTitle = newsTitle;
        mSection = newsSection;
        mAuthor = newsAuthor;
        mDate = newsDate;
        mArticleUrl = newsUrl;
    }

    /**
     * Returns the title of the news article.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the section that the news article is from.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the Author of the news article.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the date of the news article.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the url of the news article.
     */
    public String getUrl() {
        return mArticleUrl;
    }

}
