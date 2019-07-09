package bwie.com.lib_core.base.mvp;

import bwie.com.lib_core.base.BaseActivity;

/**
 * date:2019/7/9
 * name:windy
 * function:
 */
public abstract class BaseMvpActivity <M extends IBaseModel,P extends BasePresenter>extends BaseActivity implements IBaseView{

    public M model;
    public P presenter;
    @Override
    protected void initData() {
        presenter=(P) initPresenter();
        if (presenter!=null){
           if (model!=null){
              presenter.attach(model,this);
           }
        }
        init();
    }

    protected abstract void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.pttach();
        }
    }
}
