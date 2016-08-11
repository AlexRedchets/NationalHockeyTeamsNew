package com.azvk.nationalhockeyteams.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.azvk.nationalhockeyteams.models.Team;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper{

    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME = "team.db";
    private static final String TABLE_TEAM = "team";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TEAMNAME = "teamname";
    private static final String COLUMN_TEAMFLAG = "teamflag";
    private static final String COLUMN_TEAMHEADCOACH = "teamheadcoach";
    private static final String COLUMN_TEAMCAPTAIN = "teamcaptain";
    private static final String COLUMN_TEAMPIC1 = "teampicture1";
    private static final String COLUMN_TEAMPIC2 = "teampicture2";
    private static final String COLUMN_TEAMPIC3 = "teampicture3";
    private static final String COLUMN_TEAMPIC4 = "teampicture4";
    private static final String COLUMN_TEAMPIC5 = "teampicture5";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_TEAM + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEAMNAME + " TEXT," +
                COLUMN_TEAMFLAG + " TEXT," +
                COLUMN_TEAMHEADCOACH + " TEXT," +
                COLUMN_TEAMCAPTAIN + " TEXT," +
                COLUMN_TEAMPIC1 + " TEXT," +
                COLUMN_TEAMPIC2 + " TEXT," +
                COLUMN_TEAMPIC3 + " TEXT," +
                COLUMN_TEAMPIC4 + " TEXT," +
                COLUMN_TEAMPIC5 + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + TABLE_TEAM);
        onCreate(sqLiteDatabase);
    }

    //add new row to the database
    public void addTeam(Team team){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEAMNAME, team.getName());
        values.put(COLUMN_TEAMFLAG, team.getFlag());
        values.put(COLUMN_TEAMHEADCOACH, team.getHead_coach());
        values.put(COLUMN_TEAMCAPTAIN, team.getCaptain());
        values.put(COLUMN_TEAMPIC1, team.getHeader_pic_1());
        values.put(COLUMN_TEAMPIC2, team.getHeader_pic_2());
        values.put(COLUMN_TEAMPIC3, team.getHeader_pic_3());
        values.put(COLUMN_TEAMPIC4, team.getHeader_pic_4());
        values.put(COLUMN_TEAMPIC5, team.getHeader_pic_5());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_TEAM, null, values);
        sqLiteDatabase.close();
    }

    //delete team
    public void deleteTeam(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_TEAM);
    }

    //print out the database
    public Team getTeam() {
        Team team = new Team();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_TEAM + " WHERE 1";

        //Cursor point to a location in results
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        //Move to the first row in results
        if (c != null) {
            while (c.moveToNext()) {
                if (c.getString(c.getColumnIndex(COLUMN_TEAMNAME)) != null) {
                    team.setName(c.getString(c.getColumnIndex(COLUMN_TEAMNAME)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMFLAG)) != null) {
                    team.setFlag(c.getString(c.getColumnIndex(COLUMN_TEAMFLAG)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMHEADCOACH)) != null) {
                    team.setHead_coach(c.getString(c.getColumnIndex(COLUMN_TEAMHEADCOACH)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMCAPTAIN)) != null) {
                    team.setCaptain(c.getString(c.getColumnIndex(COLUMN_TEAMCAPTAIN)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMPIC1)) != null) {
                    team.setHeader_pic_1(c.getString(c.getColumnIndex(COLUMN_TEAMPIC1)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMPIC2)) != null) {
                    team.setHeader_pic_2(c.getString(c.getColumnIndex(COLUMN_TEAMPIC2)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMPIC3)) != null) {
                    team.setHeader_pic_3(c.getString(c.getColumnIndex(COLUMN_TEAMPIC3)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMPIC4)) != null) {
                    team.setHeader_pic_4(c.getString(c.getColumnIndex(COLUMN_TEAMPIC4)));
                }
                if (c.getString(c.getColumnIndex(COLUMN_TEAMPIC5)) != null) {
                    team.setHeader_pic_5(c.getString(c.getColumnIndex(COLUMN_TEAMPIC5)));
                }
            }
            c.close();
            sqLiteDatabase.close();
        }
        return team;
    }
}
