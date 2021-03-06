package com.example.mypc.esports2.main.persondetails;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.UserBean;
import com.example.mypc.esports2.httputils.register.UserDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EditingInterfaceActivity extends BaseActivity {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.btn_save_data)
    Button btnSaveData;
    @BindView(R.id.head_image_one)
    ImageView headImageOne;
    @BindView(R.id.head_image_two)
    ImageView headImageTwo;
    @BindView(R.id.head_image_three)
    ImageView headImageThree;
    @BindView(R.id.tv_date_time_picker)
    TextView tvDateTime;
    @BindView(R.id.et_nickname)
    EditText etNickname;
    @BindView(R.id.rg_choice_sex)
    RadioGroup rgChoiceSex;
    @BindView(R.id.et_describe)
    EditText etDescribe;
    @BindView(R.id.et_qq_number)
    EditText etQqNumber;
    private ImageView add_head;
    private Bitmap photo;
    private TimePickerView pvTime;
    private UserBean userBean;

    @Override
    public int getLayoutID() {
        return R.layout.activity_editing_interface;
    }

    //// TODO: 2016/8/7 具体功能实现
    private static final String IMAGE_FILE_NAME = "temp_head_image.jpg";

    /* 请求识别码 */
    private static final int CODE_GALLERY_REQUEST = 0xa0;//本地
    private static final int CODE_CAMERA_REQUEST = 0xa1;//拍照
    private static final int CODE_RESULT_REQUEST = 0xa2;//最终裁剪后的结果

    // 裁剪后图片的宽(X)和高(Y),480 X 480的正方形。
    private static int output_X = 600;
    private static int output_Y = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
        //控制时间范围
        Calendar calendar = Calendar.getInstance();
        pvTime.setRange(calendar.get(Calendar.YEAR) - 116, calendar.get(Calendar.YEAR) + 100);//要在setTime 之前才有效果哦
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                long l = System.currentTimeMillis();
                String nowtime = getTime(new Date(l));
                String picktime = getTime(date);

                tvDateTime.setText(String.valueOf(Integer.parseInt(nowtime)-Integer.parseInt(picktime))+"岁");
            }
        });
        //弹出时间选择器
        tvDateTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pvTime.show();
            }
        });
        add_head = (ImageView) findViewById(R.id.add_head_image);
        add_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditingInterfaceActivity.this);
                String title = "选择获取图片方式";
                final String[] items = new String[]{"从本地获取", "从相机获取"};
                builder.setTitle(title).setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choseHeadImageFromGallery();
                                break;
                            case 1:
                                choseHeadImageFromCameraCapture();
                                break;

                        }
                    }
                }).show();


            }
        });

        //从本地获取当前登录用户的UID，通过数据库将头像的路径保存在数据库中
        SharedPreferences preferences = getSharedPreferences("info.txt", MODE_PRIVATE);
        String username = preferences.getString("username", "");
        List<UserBean> beanList = UserDao.QueryOne(EditingInterfaceActivity.this, "username", username);
        userBean = beanList.get(0);
    }


    // 从本地相册选取图片作为头像
    //ACTION_GET_CONTENT--打开媒体库
    private void choseHeadImageFromGallery() {
        Intent intentFromGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media
                .EXTERNAL_CONTENT_URI);
        // 设置文件类型
        intentFromGallery.setType("image/*");//选择图片
        //如果你想在Activity中得到新打开Activity关闭后返回的数据，
        //你需要使用系统提供的startActivityForResult(Intent intent,int requestCode)方法打开新的Activity
        startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 判断存储卡是否可用，存储照片文件
        if (hasSdcard()) {
            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment
                    .getExternalStorageDirectory(), IMAGE_FILE_NAME)));
        }

        startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {//取消
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }

        switch (requestCode) {
            case CODE_GALLERY_REQUEST://如果是来自本地的
                cropRawPhoto(intent.getData());//直接裁剪图片
                break;

            case CODE_CAMERA_REQUEST:
                if (hasSdcard()) {
                    File tempFile = new File(Environment.getExternalStorageDirectory(),
                            IMAGE_FILE_NAME);
                    cropRawPhoto(Uri.fromFile(tempFile));
                } else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG).show();
                }
                break;

            case CODE_RESULT_REQUEST:
                if (intent != null) {
                    setImageToHeadView(intent);//设置图片框
                }

                break;
        }

        super.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * 裁剪原始的图片
     */
    public void cropRawPhoto(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");

        //把裁剪的数据填入里面

        // 设置裁剪
        intent.putExtra("crop", "true");

        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);

        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    /**
     * 提取保存裁剪之后的图片数据，并设置头像部分的View
     */
    private void setImageToHeadView(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            photo = extras.getParcelable("data");
            if (headImageOne.getVisibility() == View.VISIBLE) {
                headImageTwo.setVisibility(View.VISIBLE);
                headImageTwo.setImageBitmap(photo);
            } else if (headImageOne.getVisibility() == View.VISIBLE && headImageTwo.getVisibility() == View.VISIBLE) {
                headImageThree.setVisibility(View.VISIBLE);
                headImageThree.setImageBitmap(photo);
            } else {
                headImageOne.setVisibility(View.VISIBLE);
                headImageOne.setImageBitmap(photo);
            }
            //从本地获取当前登录用户的UID，通过数据库将头像的路径保存在数据库中
            SharedPreferences preferences = getSharedPreferences("info.txt", MODE_PRIVATE);
            String username = preferences.getString("username", "");
            List<UserBean> beanList = UserDao.QueryOne(EditingInterfaceActivity.this, "username", username);
            UserBean userBean = beanList.get(0);
            String uid = userBean.getUid();

            //新建文件夹 先选好路径 再调用mkdir函数 现在是根目录下面的Ask文件夹
            File nf = new File(Environment.getExternalStorageDirectory() + "/Ask");
            nf.mkdir();
            //在根目录下面的ASk文件夹下 创建用户UID + .jpg文件
            File f = new File(Environment.getExternalStorageDirectory() + "/Ask", uid + "head.jpg");
            UserDao.update(EditingInterfaceActivity.this, userBean, "headimg", f.getAbsolutePath());

            FileOutputStream out = null;
            try {//打开输出流 将图片数据填入文件中
                out = new FileOutputStream(f);
                assert photo != null;
                photo.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }

    @OnClick({R.id.on_back_image, R.id.btn_save_data, R.id.tv_date_time_picker})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_save_data:
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("photo", photo);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                onSaveInstanceState(bundle);
                //判断个人信息是否已经更改，更改则保存在数据库中
                String nickname = etNickname.getText().toString().trim();
                assert nickname != null;
                UserDao.update(this, userBean, "nickname", nickname);
                String sign = etDescribe.getText().toString().trim();
                assert sign != null;
                UserDao.update(this, userBean, "sign", sign);
                String qq = etQqNumber.getText().toString().trim();
                assert qq != null;
                UserDao.update(this, userBean, "qq", qq);
                for (int i = 0; i < rgChoiceSex.getChildCount(); i++) {
                    if (rgChoiceSex.getChildAt(i).isSelected()) {
                        String sex = String.valueOf(i);
                        UserDao.update(this, userBean, "sex", sex);
                    }
                }
                finish();
                break;
            case R.id.tv_date_time_picker:

                break;
        }
    }
    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(date);
    }

}
