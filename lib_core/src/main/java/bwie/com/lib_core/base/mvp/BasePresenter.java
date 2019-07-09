package bwie.com.lib_core.base.mvp;

import java.lang.ref.WeakReference;

/**
 * date:2019/7/9
 * name:windy
 * function:
 */
public abstract class BasePresenter <M,V>{

    public M model;
    public V view;
    private WeakReference<V> weakReference;

   public abstract M getModel();
   //绑定
   public void attach(M model,V view){
        this.model=model;
        weakReference=new WeakReference<>(view);
        this.view=weakReference.get();//德到view
   }
   //解绑
    public  void pttach(){
        if (weakReference!=null){
            weakReference.clear();//清空对象
            weakReference=null;
            this.view=null;
        }
    }
}
