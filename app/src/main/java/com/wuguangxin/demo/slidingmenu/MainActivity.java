package com.wuguangxin.demo.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends Activity implements View.OnClickListener{
    private static SlidingMenu mSlidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSlidingMenu();
    }

    /**
     *  设置slidingment的属性
     */
    private void initSlidingMenu() {
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setMode(SlidingMenu.LEFT); //设置让Slidingmenu从屏幕左边滑进来
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN); //设置滑动什么区域可以滑出SlidingMenu
        mSlidingMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN); // 滑侧栏关闭menu
        mSlidingMenu.setShadowDrawable(R.drawable.slidingmenu_shadow); //设置Slidingmenu边缘的阴影图片
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width); //设置Slidingmenu边缘阴影的宽度
//		mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset); //设置SlidingMenu的宽度方式1
        mSlidingMenu.setBehindWidth(1000); //设置SlidingMenu的宽度方式2
        mSlidingMenu.setFadeEnabled(true); //是否允许淡入淡出
        mSlidingMenu.setFadeDegree(0.5f); //设置淡入淡出的渐变效果
//		mSlidingMenu.setMenu(R.layout.main_menu_layout); //设置Slidingmenu使用的布局文件
        mSlidingMenu.setMenu(getMenuView());
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW); //添加形式,使SlidingMenu附加在Activity右边
    }

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager)context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public View getMenuView() {
        View view = LayoutInflater.from(this).inflate(R.layout.main_menu_layout, null);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
//        switch (id) {
//        case R.id.main_menu_logout:
//            break;
//        }
    }

    /**
     * 开关侧边栏
     */
    public static void toggleSlidingMenu(){
        if(mSlidingMenu != null){
            mSlidingMenu.toggle();
        }
    }

    /**
     * 侧边栏是否显示中
     */
    public static boolean isMenuShowing(){
        if(mSlidingMenu != null){
            return mSlidingMenu.isMenuShowing();
        }
        return false;
    }
}
