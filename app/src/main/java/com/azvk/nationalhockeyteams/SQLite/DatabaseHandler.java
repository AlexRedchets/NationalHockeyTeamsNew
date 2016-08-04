package com.azvk.nationalhockeyteams.SQLite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "rostersManager";

    // Players table name
    private static final String TABLE_ROSTERS = "rosters";

    // Rosters Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TEAM = "team";
    private static final String KEY_POSITION = "position";
    private static final String KEY_BIRTHDATE = "birthdate";
    private static final String KEY_BIRTHPLACE = "birthplace";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_IMAGEURL = "imageUrl";
    private static final String KEY_NATIONALTEAM = "nationalTeam";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ROSTERS_TABLE = "CREATE TABLE " + TABLE_ROSTERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_TEAM + " TEXT," + KEY_TEAM + " TEXT," + KEY_POSITION + " TEXT,"
                + KEY_BIRTHDATE + " TEXT," + KEY_BIRTHPLACE + " TEXT," + KEY_NUMBER + " INTEGER,"
                + KEY_WEIGHT + " INTEGER," + KEY_HEIGHT + " INTEGER," + KEY_IMAGEURL + " TEXT,"
                + KEY_NATIONALTEAM + " TEXT" + ")";
        db.execSQL(CREATE_ROSTERS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROSTERS);

        // Create tables again
        onCreate(db);
    }
}
