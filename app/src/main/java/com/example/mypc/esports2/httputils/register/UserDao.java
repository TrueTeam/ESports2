package com.example.mypc.esports2.httputils.register;

import android.content.Context;

import com.example.mypc.esports2.bean.UserBean;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2016/8/8.
 */
public class UserDao {

    private ORMliteUserHelper orMliteUserHelper;
    private static Dao<UserBean, Integer> dao;
    private static UserDao userDao;

    private UserDao(Context context) {
        this.orMliteUserHelper = new ORMliteUserHelper(context);
        try {
            dao = orMliteUserHelper.getDao(UserBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static UserDao userDaoInstance(Context context) {
        if (userDao == null) {
            userDao = new UserDao(context);
        }
        return userDao;
    }

    public static int add(UserBean userBean, Context context) {
        userDaoInstance(context);
        try {
            int i = dao.create(userBean);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int del(Context context, String columnName, String value) {
        userDaoInstance(context);
        DeleteBuilder<UserBean, Integer> deleteBuilder = dao.deleteBuilder();
        try {
            deleteBuilder.where().eq(columnName, value);
            int delete = deleteBuilder.delete();
            return delete;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int update(Context context, UserBean user, String dickey, String dicvalue) {
        userDaoInstance(context);
        UpdateBuilder<UserBean, Integer> updateBuilder = dao.updateBuilder();
        try {
            updateBuilder.where().eq("username", user.getUsername());
            updateBuilder.updateColumnValue(dickey, dicvalue);
            int update = updateBuilder.update();
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<UserBean> QueryAll(Context context) {
        List<UserBean> userBeenlist = new ArrayList<>();
        userDaoInstance(context);
        try {
            userBeenlist = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBeenlist;
    }

    public static List<UserBean> QueryOne(Context context, String key, String value) {
        List<UserBean> userBeenlist = new ArrayList<>();
        userDaoInstance(context);
        QueryBuilder<UserBean, Integer> queryBuilder = dao.queryBuilder();
        try {
            queryBuilder.where().eq(key, value);
            userBeenlist = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBeenlist;
    }
}
