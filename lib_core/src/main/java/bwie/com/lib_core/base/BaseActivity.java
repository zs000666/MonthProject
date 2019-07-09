package bwie.com.lib_core.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.Unbinder;
import bwie.com.lib_core.R;
import bwie.com.lib_core.utils.LogUtils;

public abstract class BaseActivity extends AppCompatActivity {
    private boolean isStatus;//沉浸式
    private boolean isFullScreen;//全屏
    private Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();
    /*
    * 绑定根布局id
    * */
        public abstract int bindLayoutId();
    /*
    * 显示toast
    * */
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    /*
    * 无参构造
    * */
    public void startActivity(Class<?> clz){
        startActivity(new Intent(this,clz));
    }

    public void startActivity(Bundle bundle,Class<?>clz){
        Intent intent=new Intent(this,clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void isStatus(boolean status){
      if (status){
          //沉浸式代码
      }
    }
    public void isFillscreen(boolean fillscreen){
        if (isFinishing()){
           //全屏代码
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e("onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e("onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();//解绑
        }
    }
}
