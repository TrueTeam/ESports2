package com.example.mypc.esports2.httputils.matchdetails;

import com.example.mypc.esports2.bean.MatchDetailsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by zhonghang on 16/8/1.
 */

public class DetailsConvertFactory extends Converter.Factory {
    /**
     * id : 218
     * cover : a27387a66d5d880648d6dbaeaa2c6d86ea067d60
     * apply_start_time : 1470034800
     * apply_end_time : 1470454200
     * title : #悟空水友-卡拉赞之夜#切磋赛
     * status : 1
     * city : 0
     * type : 2
     * start_time : 1470456000
     * city_name :
     * province_name :
     * address :
     * prize : <p style=white-space: normal; text-align: justify;><strong>冠军128元</strong>。<strong>亚军60元</strong>。<strong>第3-第4名30元</strong>。<strong>随机奖6名15元</strong>。</p><p><br/></p>
     * content : http://www.gvgcn.com/Home/ItemWap/info/id/218/model/v_match
     * end_time : 1470585600
     * issign : 1
     * match_nature : 1
     * game_id : 110
     * play_id : 549
     * netbar_id :
     * limit : 128
     * sign_lists : [{"id":"10177","name":"空白画卷","head":"abcc94a3ec96f05600e2a9832821fc7488f73326","head_link":"http://139.196.106.200/Uploads/Picture/2016-05-11/5732e7657faff.jpg"},{"id":"10255","name":"MirJQ#5530","head":"51678333f429da90a2dc60783c4581f3576d828a","head_link":"http://139.196.106.200/Uploads/Picture/2016-05-23/574284535a229.jpg"},{"id":"10289","name":"老司机丨浮生墨白","head":"1d2e7cb632989a2071130dd11ab54e3112589f98","head_link":"http://139.196.106.200/Uploads/Picture/2016-05-26/57467d60de418.jpg"},{"id":"10320","name":"迟伤","head":"aa46713c7b89857973c73bd73b657984bd3e74f1","head_link":"http://139.196.106.200/Uploads/Picture/2016-05-27/574804f547b72.jpg"},{"id":"10328","name":"哈哈","head":"4f9f4e7673365200f4cb6d3b080087ffab8315a7","head_link":"http://139.196.106.200/Uploads/Picture/2016-06-15/576129c39383e.jpg"},{"id":"10599","name":"阡陌丶云","head":"a33bc561b9631532375cbb79b29ae056709c5fa3","head_link":"http://139.196.106.200/Uploads/Picture/2016-06-20/57674d435720b.jpg"},{"id":"10670","name":"爱殇","head":"8551a446430a31ffc4ee20b7c292636364a4edb6","head_link":"http://139.196.106.200/Uploads/Picture/2016-06-28/57721e36770f5.jpg"},{"id":"10781","name":"SunDust","head":"2b3b3460c2599f5c6aed012fa444985975c72e67","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-07/577e3bad7ab52.jpg"},{"id":"10788","name":"霸道总裁","head":"80f6aa551bb3dbc2b89310717dbc6b069eff99c5","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-07/577e4f1e06c22.jpg"},{"id":"10799","name":"风水大师阿木木#5381","head":"e047ffa47eab158c811d277a43d1321ff9e47da7","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-08/577f501e67513.jpg"},{"id":"10858","name":"邱琴#5887","head":"705be3cf45f09c9e9049dfea196afb9833bdde44","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-30/579c0e57f4119.jpg"},{"id":"68489","name":"小红","head":"0045fee4e7c0eb95241af159d54895d5720a3059","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-19/578ddfc16a2ac.jpg"},{"id":"70170","name":"愚鹏","head":"7202b398a389c3eb115c39ed27efcd6f76d23cb6","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-19/578ded12dfa33.png"},{"id":"74271","name":"没有杀气","head":"de6b65e5038acdbfd15d0cd53b2a6e629e923256","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-19/578e32ed56b9c.png"},{"id":"101047","name":"哇啦啦啦","head":"5c0e4852bfb69db6758d7d327930c8a7e8382582","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-24/5794474eb0e81.jpg"},{"id":"101106","name":"一包辣条","head":"2a279b6506953d34bd1a0cf6f4a2fd2546973e93","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-24/5794c2d8db777.png"},{"id":"101173","name":"时光旅途","head":"302166b857a6ff775e434975a650f6c3bdd1a3ca","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-25/57957cf310dbb.png"},{"id":"101182","name":"美丽与哀伤","head":"d3dc5a87378e227983f830c6be96257b5bfda710","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-25/579590c449ccc.jpg"},{"id":"101194","name":"Rorschach","head":"6002b452e7b479b4e122c0b0ac8c92710bcdde38","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-25/579592bc7420c.jpg"},{"id":"101535","name":"Deleted memo","head":"77b923e9f563c5d52d60498a1519e0859972f96a","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-25/57961cda31acf.png"},{"id":"101881","name":"Wes＆Joker","head":"f3392707512fbe6565897a2c6792d9c875a8bceb","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-27/57984d2c12215.png"},{"id":"101965","name":"温柔善良你四爷","head":"a272532667e66d30e4f28ec7bb5b09d4cc3b18d6","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-27/5798d90d9de5e.jpg"},{"id":"102131","name":"Krystal","head":"33ea93cf82176fa2fb5af1b46e2c6326b1448f53","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-28/5799ad3ca2544.jpg"},{"id":"102261","name":"阡陌丶云","head":"981481dfa643f45a380bb6ff684a018eb35fb9e7","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-28/5799d3a80f7c8.png"},{"id":"102320","name":"天之娇纸","head":"ddd62bbd2b5a4d6afbf80d5c0e21e221ca3d7fff","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-28/5799e1a0140d5.jpg"},{"id":"102379","name":"移动的ATM","head":"2b5df2c742077d231312fed1b48f7628b6abacc2","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-28/5799fc7be6e9d.png"},{"id":"102566","name":"549ugud","head":"9d18c85cf3f613aecf80eab6c8ef98b1b7279590","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-29/579b3c7b6e7fa.png"},{"id":"102583","name":"星空下的约定","head":"e92e4448e2160f5dbdcf1b3687ff47d4dc852c31","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-29/579b5ba10a3fe.jpg"},{"id":"102611","name":"索克.萨尔","head":"c5e7a292ccafddbdd4c7d780ce58d468ffd618e0","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-29/579b67a9c7947.jpg"},{"id":"102912","name":"猴星人","head":"1f8dfea819695dd32b1490cc222ea899522a085a","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-31/579d7403ab163.jpg"},{"id":"103101","name":"恩佐斯","head":"cfde61f97408582b197d44468b0c47036c659128","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579ef960d5f1e.png"},{"id":"103110","name":"巴尔地摩","head":"dffb1b79794057ef1e544e4a1b78a7ab181e1160","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579efd3c2c169.png"},{"id":"103122","name":"Zero Kelvin ","head":"e7d7a8357e010f8f614da4ca9cc075b1fd541ff6","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579efe1d6eec5.png"},{"id":"103134","name":"☁","head":"559c0418243b74307826d59a45286e3b497b0c7a","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579eff6a19e78.png"},{"id":"103145","name":"我们仍未","head":"d410ce98a702b5f53f8739447f961205a7a44c26","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f002f94f28.png"},{"id":"103155","name":"随风的弧","head":"1b096fdc11070362b0dd5aa538307678c71e5c4f","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f028e53fed.png"},{"id":"103210","name":"少年闰土","head":"493ab912f5e3a5a00466df94cc9d3551a4153fdd","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f0c480aab3.png"},{"id":"103219","name":"冷たい風","head":"a4e0156e2a00de1288d1e3537a514aafde4291c2","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f10bc3e1a9.png"},{"id":"103225","name":"影丶祭","head":"c1b2f61a99631b34e86d91d60a50b35bf3c6d672","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f145c9a910.jpg"},{"id":"103235","name":"脑抽233","head":"3222b60f6230afca1589ae45111c28e327c7ed44","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f17e24c7c0.png"},{"id":"103242","name":"simple","head":"0be51127d31c5f55e331e0dee9e0776a566e0ae8","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f1d4a6348b.jpg"},{"id":"103256","name":"优秀的男子","head":"ae5df8fe9c2712a735c38356dcb4a5462589a0f5","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-01/579f5622d0d65.jpg"},{"id":"103323","name":"是吗。。","head":"ecb5a0acfefc9e09662d64837e6aa746e1465d4b","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-02/57a0046085f8a.png"},{"id":"103356","name":"_劉ycy👈🏽","head":"75a14a01481dc80cd89107f9ebd7f21a5f0ed2d1","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-02/57a03807b5298.png"},{"id":"103372","name":"⊙_⊙","head":"0f33d2689fa8e17e33223266554414379dcb632c","head_link":"http://139.196.106.200/Uploads/Picture/2016-07-20/578edcaae675f.jpg"},{"id":"103424","name":"斯基","head":"92ae9a4feebbac1e5adfe733a468deccc8363262","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-02/57a08751804ac.jpg"},{"id":"103557","name":"齊雲","head":"cb43f67de0156768a59166b58b965558f441f368","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-03/57a1a1aaf118d.png"},{"id":"103609","name":"Mr.No","head":"b6e08dd60faf129b77529179d3793c67d90ea927","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-03/57a1cd1ddd0cf.png"},{"id":"103783","name":"命运","head":"79d8c10ca84fca104efd0d9f33ff3d31cfade57a","head_link":"http://139.196.106.200/Uploads/Picture/2016-08-04/57a31cd648a5b.jpg"}]
     * sign_count : 49
     * intro : 活动发起：阡陌丶云#5343报名时间：8月1日15:00-8月6日11:30比赛时间：8月6日12:00（周六中午）比赛规则：（重点）1）第一次报名需绑定炉石角色，填写完整的炉石角色名称包含了后面的#
     * _model : v_match
     * haspassword : 0
     * is_reg : 0
     * is_uppic : 0
     * userissign : 1
     * match_status : 2
     * match_address :
     * cover_link : http://139.196.106.200/Uploads/Picture/2016-08-01/579f224698f4b.jpg
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new DetailsConvert();
    }


    static class DetailsConvert implements Converter<ResponseBody, MatchDetailsBean> {

        @Override
        public MatchDetailsBean convert(ResponseBody value) throws IOException {
            String result = value.string();
            MatchDetailsBean matchDetailsBean=null;
            try {
                List<MatchDetailsBean.SignListsBean> msList = new ArrayList<>();
               JSONObject jsonObject = new JSONObject(result);
                String id = jsonObject.getString("id");
                String title = jsonObject.getString("title");
                String prize = jsonObject.getString("prize");
                JSONArray sign_lists = jsonObject.getJSONArray("sign_lists");
                for (int i = 0; i < sign_lists.length(); i++) {
                    JSONObject jsonObject1 = sign_lists.getJSONObject(i);
                    String id1 = jsonObject1.getString("id");
                    String name = jsonObject1.getString("name");
                    String head_link = jsonObject1.getString("head_link");
                    MatchDetailsBean.SignListsBean signListsBean =
                            new MatchDetailsBean.SignListsBean(id1,name,head_link);
                    msList.add(signListsBean);
                }
                String content = jsonObject.getString("content");
                String game_id = jsonObject.getString("game_id");
                String play_id = jsonObject.getString("play_id");
                String limit = jsonObject.getString("limit");
                String sign_count = jsonObject.getString("sign_count");
                String intro = jsonObject.getString("intro");
                String model = jsonObject.getString("_model");
                String cover_link = jsonObject.getString("cover_link");
                matchDetailsBean =
                        new MatchDetailsBean(id,title,prize,content,game_id,play_id,limit,msList,sign_count,intro,model,cover_link);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return matchDetailsBean;
        }
    }
}
