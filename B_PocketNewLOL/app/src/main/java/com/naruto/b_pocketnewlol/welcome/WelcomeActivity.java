import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;

//package com.naruto.b_pocketnewlol.welcome;
//
// /*
//                   _ooOoo_
//                  o8888888o
//                  88" . "88
//                  (| -_- |)
//                  O\  =  /O
//               ____/`---'\____
//             .'  \\|     |//  `.
//            /  \\|||  :  |||//  \
//           /  _||||| -:- |||||-  \
//           |   | \\\  -  /// |   |
//           | \_|  ''\---/''  |   |
//           \  .-\__  `-`  ___/-. /
//         ___`. .'  /--.--\  `. . __
//      ."" '<  `.___\_<|>_/___.'  >'"".
//     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//     \  \ `-.   \_ __\ /__ _/   .-` /  /
//======`-.____`-.___\_____/___.-`____.-'======
//                   `=---='
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//         佛祖保佑       永无BUG
//
//Created by Android_刘德强 on 16/12/28.
//*/
//
//
//import android.app.ProgressDialog;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnCancelListener;
//import android.content.Intent;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.naruto.b_pocketnewlol.R;
//import com.naruto.b_pocketnewlol.base.BaseActivity;
//import com.naruto.b_pocketnewlol.main.MainActivity;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
public class WelcomeActivity extends BaseActivity {
//
//    private static final String TAG = "LoginActivity";
//    public static final int REQUEST_CODE_SETNICK = 1;
//    private EditText usernameEditText;
//    private EditText passwordEditText;
//
//    private boolean progressShow;
//    private boolean autoLogin = false;
//
//    private String currentUsername;
//    private String currentPassword;
//
    @Override
    public int setLayout () {
        return R.layout.activity_welcome;
    }
//
    @Override
    public void initView () {
//        // 如果登录成功过，直接进入主页面
//        if (EMClient.getInstance ().isLoggedInBefore ()) {
//            autoLogin = true;
//            startActivity (new Intent (WelcomeActivity.this, MainActivity.class));
//
//            return;
        }
//
//        usernameEditText = (EditText) findViewById (R.id.username);
//        passwordEditText = (EditText) findViewById (R.id.password);
//
//    }
//
    @Override
    public void initData () {
//        // 如果用户名改变，清空密码
//        usernameEditText.addTextChangedListener (new TextWatcher () {
//            @Override
//            public void onTextChanged (CharSequence s, int start, int before, int count) {
//                passwordEditText.setText (null);
//            }
//
//            @Override
//            public void beforeTextChanged (CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void afterTextChanged (Editable s) {
//
//            }
//        });
//
//    }
//
//    /**
//     * 登录
//     */
//    public void login (View view) {
//        if (!EaseCommonUtils.isNetWorkConnected (this)) {
//            Toast.makeText (this, R.string.network_isnot_available, Toast.LENGTH_SHORT).show ();
//            return;
//        }
//        currentUsername = usernameEditText.getText ().toString ().trim ();
//        currentPassword = passwordEditText.getText ().toString ().trim ();
//
//        if (TextUtils.isEmpty (currentUsername)) {
//            Toast.makeText (this, R.string.User_name_cannot_be_empty, Toast.LENGTH_SHORT).show ();
//            return;
//        }
//        if (TextUtils.isEmpty (currentPassword)) {
//            Toast.makeText (this, R.string.Password_cannot_be_empty, Toast.LENGTH_SHORT).show ();
//            return;
//        }
//
//        progressShow = true;
//        final ProgressDialog pd = new ProgressDialog (LoginActivity.this);
//        pd.setCanceledOnTouchOutside (false);
//        pd.setOnCancelListener (new OnCancelListener () {
//
//            @Override
//            public void onCancel (DialogInterface dialog) {
//                Log.d (TAG, "EMClient.getInstance().onCancel");
//                progressShow = false;
//            }
//        });
//        pd.setMessage (getString (R.string.Is_landing));
//        pd.show ();
//        // close it before login to make sure DemoDB not overlap
//        DemoDBManager.getInstance ().closeDB ();
//        // reset current user name before login
//        DemoApplication.getInstance ().setCurrentUserName (currentUsername);
//        // 调用sdk登陆方法登陆聊天服务器
//        Log.d (TAG, "EMClient.getInstance().login");
//        EMClient.getInstance ().login (currentUsername, currentPassword, new EMCallBack () {
//
//            @Override
//            public void onSuccess () {
//                Log.d (TAG, "login: onSuccess");
//
//                if (!LoginActivity.this.isFinishing () && pd.isShowing ()) {
//                    pd.dismiss ();
//                }
//
//                // ** 第一次登录或者之前logout后再登录，加载所有本地群和回话
//                // ** manually load all local groups and
//                EMClient.getInstance ().groupManager ().loadAllGroups ();
//                EMClient.getInstance ().chatManager ().loadAllConversations ();
//                getFriends ();
//
//                // 进入主页面
//                Intent intent = new Intent (LoginActivity.this,
//                        MainActivity.class);
//                startActivity (intent);
//
//                finish ();
//            }
//
//            @Override
//            public void onProgress (int progress, String status) {
//                Log.d (TAG, "login: onProgress");
//            }
//
//            @Override
//            public void onError (final int code, final String message) {
//                Log.d (TAG, "login: onError: " + code);
//                if (!progressShow) {
//                    return;
//                }
//                runOnUiThread (new Runnable () {
//                    public void run () {
//                        pd.dismiss ();
//                        Toast.makeText (getApplicationContext (), getString (R.string.Login_failed) + message,
//                                Toast.LENGTH_SHORT).show ();
//                    }
//                });
//            }
//        });
//    }
//
//    private void getFriends () {
//        try {
//            List<String> usernames = EMClient.getInstance ().contactManager ().getAllContactsFromServer ();
//            Map<String, EaseUser> users = new HashMap<String, EaseUser> ();
//            for (String username : usernames) {
//                EaseUser user = new EaseUser (username);
//                users.put (username, user);
//
//
//            }
//
//            DemoApplication.getInstance ().setContactList (users);
//
//
//        } catch (HyphenateException e) {
//            e.printStackTrace ();
//        }
//
//    }
//
//
//    /**
//     * 注册
//     *
//     * @param view
//     */
//    public void register (View view) {
//        startActivityForResult (new Intent (this, RegisterActivity.class), 0);
//    }
//
//    @Override
//    protected void onResume () {
//        super.onResume ();
//        if (autoLogin) {
//            return;
        }
    }
//}
//
//
//
//
