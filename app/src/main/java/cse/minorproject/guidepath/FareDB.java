package cse.minorproject.guidepath;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FareDB extends SQLiteOpenHelper {
    private static final int
            DATABASE_VERSION = 1;
    private static final String
            DATABASE_NAME = "fare.db";
    public static final String
            TABLE_BUSINFO = "Fare";
    public static final String NAME ="name";
    public static final String INDERLOK = "Inderlok";
    public static final String SHASTRI_NAGAR = "Shastri Nagar";
    public static final String PRATAP_NAGAR = "Pratap Nagar";
    public static final String PUL_BANGASH = "Pulbangash";
    public static final String TIS_HAZARI = "Tis Hazari";



    public FareDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUSINFO);
        onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BUS_TABLE = "CREATE TABLE " + TABLE_BUSINFO+" ("
                +NAME + " TEXT PRIMARY KEY,"
                +INDERLOK + " INTEGER,"
                + SHASTRI_NAGAR + " INTEGER,"
                + PRATAP_NAGAR + " INTEGER,"
                + PUL_BANGASH + " INTEGER,"
                + TIS_HAZARI + " INTEGER" + ")";
        db.beginTransaction();
        db.execSQL(CREATE_BUS_TABLE);
        String query="insert into "+TABLE_BUSINFO+" values( '"+INDERLOK+"',0,8,10,12,14)";
        db.execSQL(query);
        query="insert into "+TABLE_BUSINFO+" values( '"+SHASTRI_NAGAR+"',8,0,8,10,12)";
        db.execSQL(query);
        query="insert into "+TABLE_BUSINFO+" values( '"+PRATAP_NAGAR+"',10,8,0,8,10)";
        db.execSQL(query);
        query="insert into "+TABLE_BUSINFO+" values( '"+PUL_BANGASH+"',12,10,8,0,8)";
        db.execSQL(query);
        query="insert into "+TABLE_BUSINFO+" values( '"+TIS_HAZARI+"',14,12,10,8,0)";
        db.execSQL(query);
        db.setTransactionSuccessful();
        db.endTransaction();
    }
    public int getFare(String start,String end) throws Exception {
        SQLiteDatabase db= getReadableDatabase();
        String query="SELECT "+start+" FROM "+TABLE_BUSINFO+" WHERE "+NAME+"= '"+end+"'";
        Cursor c= db.rawQuery(query,null);
        if(c.moveToFirst()){
            return c.getInt(0);
        }
        else throw new Exception();
    }
}
