package retrofit.mifeng.us.myfragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        FrameLayout fl = (FrameLayout) findViewById(R.id.fl);
        FragmentTabHost tab = (FragmentTabHost) findViewById(R.id.tabhost);
        //设置FragmentTabHost参数，第一个是上下文，第二个是碎片管理这，第三个是Fragment应该放的位置的id
        tab.setup(this,getSupportFragmentManager(),R.id.fl);
        //newTabSpec设置下方的指示器（里面参数只是个标记随便写），
        // setIndicator设置只是指示器的样式，第一个参数是指示器的名字。第二个是样式，可以制作selector
        TabHost.TabSpec a = tab.newTabSpec("首页").setIndicator("首页",null);
        Bundle bundle = new Bundle();
        bundle.putString("name","首页");
        //将指示器与Fragment绑定通过Bundle进行传值
        tab.addTab(a,Fragment1.class,bundle);
        TabHost.TabSpec b = tab.newTabSpec("我的").setIndicator("我的",null);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name","我的");
        tab.addTab(b,Fragment2.class,bundle2);
    }
}
