package com.example.saad.bookshelfapp;

/**
 * Created by saad on 12/17/2016.
 */
public class Book {
        private String mBook;
        private String mAuthor;
        private String mSelflink;
        public Book(String book, String author, String selflink){
            mBook = book;
            mAuthor = author;
            mSelflink = selflink;
        }
        public String getmBook(){
            return mBook;
        }
        public String getmAuthor(){
            return mAuthor;
        }
        public String getmSelflink() {
            return mSelflink;
        }
}
