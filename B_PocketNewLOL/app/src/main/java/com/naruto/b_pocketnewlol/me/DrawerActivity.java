package com.naruto.b_pocketnewlol.me;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.me.card.CardActivity;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/23.
 */

public class DrawerActivity extends BaseActivity implements View.OnClickListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Button btn,inOut,cardBtn;


    @Override
    public int setLayout() {
        return R.layout.activity_drawer;
    }

    @Override
    public void initView() {
        navigationView = bindView(R.id.drawer_nv);
        drawerLayout = bindView(R.id.dl);
        btn = bindView(R.id.btn);
        inOut = bindView(R.id.btn_map);
        cardBtn = bindView(R.id.btn_tantan);
        btn.setOnClickListener(this);
        inOut.setOnClickListener(this);
        cardBtn.setOnClickListener(this);

    }



    @Override
    public void initData() {
      navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item5:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        Snackbar.make(btn,"你真的,真的,退出登录啦!",1000).show();

                }
                return false;
            }
        });
        // 改变menu 的字颜色
        Resources resources =(Resources)getBaseContext().getResources();
        ColorStateList csl = resources.getColorStateList(R.color.navigation_menu_item_color);
        navigationView.setItemTextColor(csl);
        navigationView.getMenu().getItem(0).setChecked(true);


        View view = LayoutInflater.from(this).inflate(R.layout.item_drawer_head,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.card);
        imageView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card:
                Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn:
                drawerLayout.openDrawer(Gravity.LEFT);
                Snackbar.make(btn,"恭喜你,登录成功",1000).show();
                break;
            case R.id.btn_map:
//                Intent intent = new Intent(DrawerActivity.this,MapActivity.class);
//                startActivity(intent);
                break;
            case R.id.btn_tantan:
                Intent intent = new Intent(DrawerActivity.this,CardActivity.class);
                startActivity(intent);
                break;
        }
    }
}
