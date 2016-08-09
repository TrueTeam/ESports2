package com.example.mypc.esports2.httputils.register;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mypc.esports2.bean.UserBean;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by peter on 2016/8/8.
 */
public class ORMliteUserHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASENAME = "user.db";
    private static final int VERSION = 1;

    public ORMliteUserHelper(Context context) {
        super(context, DATABASENAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            int table = TableUtils.createTable(connectionSource, UserBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, UserBean.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
