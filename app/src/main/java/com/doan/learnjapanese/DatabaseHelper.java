package com.doan.learnjapanese;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;



public class DatabaseHelper extends SQLiteOpenHelper {
    private final Context context;
    private SQLiteDatabase db;
    private static final String DB_NAME="tn1.sqlite";
    private static final String DB_PATH="/data/data/com.doan.learnjapanese/databases/"+DB_NAME;
    private static final int  VERSION =1;

    // phương thức khởi tạo 1 tham số
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context=context;
    }

    // phương thức mở CSDL
    public SQLiteDatabase openDB(){
        db=SQLiteDatabase.openDatabase(DB_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    //phương thức đóng CSDL
    public void closeDB(){
        db.close();
    }

    //thực hiện câu lệnh SQL
    public void excuteSQL(String q){
        openDB();
        db.execSQL(q);
        closeDB();
    }

    // thực hiện truy vấn trả về đối số
    public Cursor getCursor(String q){
        openDB();
        return  db.rawQuery(q,null);
    }

    //sao chép CSDL
    public void copyDB(){
        boolean check=false;
        try{
            File file=new File(DB_PATH);
            check=file.exists();
            if (check){
                this.close();
            }
            else if (!check){
                this.getReadableDatabase();

                InputStream input=context.getAssets().open(DB_NAME);
                String outFile=DB_PATH;
                OutputStream output=new FileOutputStream(outFile);
                byte[]buffer=new byte[1024];
                int length;
                while((length=input.read(buffer))>0){
                    output.write(buffer,0,length);
                }
                output.flush();
                output.close();
                input.close();
            }
        }catch (Exception e){e.printStackTrace();}
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
