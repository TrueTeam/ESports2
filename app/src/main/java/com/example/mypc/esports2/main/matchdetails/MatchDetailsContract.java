package com.example.mypc.esports2.main.matchdetails;

import com.example.mypc.esports2.bean.MatchDetailsBean;
import java.util.HashMap;
import retrofit2.Callback;

/**
 * Created by MyPC on 2016/8/4.
 */
public class MatchDetailsContract {
    public interface View{
        void onSuccess(MatchDetailsBean mdb);
        void onFild(String msg);
    }
    public interface Persenter{
        void getDate(String s);
    }
    public interface Model{
        void getData(String path, HashMap<String, String> params, Callback<MatchDetailsBean> callback);
    }
}
