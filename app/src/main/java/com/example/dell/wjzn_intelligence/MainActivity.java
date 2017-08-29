package com.example.dell.wjzn_intelligence;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.wjzn_intelligence.Fragments.Fragments_Contacts;
import com.example.dell.wjzn_intelligence.Fragments.Fragments_HomePage;
import com.example.dell.wjzn_intelligence.Fragments.Fragments_Me;
import com.example.dell.wjzn_intelligence.Fragments.Fragments_Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //首页、联系人、消息、我的
    private LinearLayout line_homePage, line_contacts, line_message, line_my;
    private ImageView iv_homepage, iv_contacts, iv_message, iv_my;
    private TextView tv_homepage, tv_contacts, tv_message, tv_my;

    //管理者
    private FragmentManager fm;
    //处理者
    private FragmentTransaction ft;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        initListener();
        //获取碎片的管理者对象
        fm = getSupportFragmentManager();
        //获取事物对象
        ft = fm.beginTransaction();
        ft.replace(R.id.main, new Fragments_HomePage());
        ft.commit();

        list.add(new Fragments_HomePage());
        list.add(new Fragments_Contacts());
        list.add(new Fragments_Message());
        list.add(new Fragments_Me());

    }

    private void initListener() {
        line_homePage.setOnClickListener(this);
        line_contacts.setOnClickListener(this);
        line_message.setOnClickListener(this);
        line_my.setOnClickListener(this);
    }

    private void initview() {
        line_homePage = (LinearLayout) findViewById(R.id.line_homepage);
        line_contacts = (LinearLayout) findViewById(R.id.line_contacts);
        line_message = (LinearLayout) findViewById(R.id.line_message);
        line_my = (LinearLayout) findViewById(R.id.line_my);

        iv_homepage = (ImageView) findViewById(R.id.iv_homepage);
        iv_contacts = (ImageView) findViewById(R.id.iv_contacts);
        iv_message = (ImageView) findViewById(R.id.iv_message);
        iv_my = (ImageView) findViewById(R.id.iv_my);

        tv_homepage = (TextView) findViewById(R.id.tv_homepage);
        tv_contacts = (TextView) findViewById(R.id.tv_contacts);
        tv_message = (TextView) findViewById(R.id.tv_message);
        tv_my = (TextView) findViewById(R.id.tv_my);
    }

    @Override
    public void onClick(View view) {
        initTab();
        ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.line_homepage:
                ft.replace(R.id.main, new Fragments_HomePage());
                iv_homepage.setImageResource(R.mipmap.home_tag1_press);
                break;
            case R.id.line_contacts:
                ft.replace(R.id.main, new Fragments_Contacts());
                iv_contacts.setImageResource(R.mipmap.home_tag2_press);
                break;
            case R.id.line_message:
                ft.replace(R.id.main, new Fragments_Message());
                iv_message.setImageResource(R.mipmap.home_tag3_press);
                break;
            case R.id.line_my:
                ft.replace(R.id.main, new Fragments_Me());
                iv_my.setImageResource(R.mipmap.home_tag4_press);
                break;
            default:
                break;
        }
        ft.commit();
    }

    //初始化tab
    private void initTab(){
        iv_homepage.setImageResource(R.mipmap.home_tag1_release);
        iv_contacts.setImageResource(R.mipmap.home_tag2_release);
        iv_message.setImageResource(R.mipmap.home_tag3_release);
        iv_my.setImageResource(R.mipmap.home_tag4_release);
    }
}
