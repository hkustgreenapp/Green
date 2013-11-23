package com.ust.green;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;

/**
 * This demonstrates how you can implement switching between the tabs of a
 * TabHost through fragments.  It uses a trick (see the code below) to allow
 * the tabs to switch between fragments instead of simple views.
 */
public class MainActivity extends FragmentActivity {
    private TabHost mTabHost;
    private TabManager mTabManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.fragment_tabs);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        
        mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
        
        mTabHost.setCurrentTab(0);
       
        mTabManager.addTab(mTabHost.newTabSpec("GreenEvent").setIndicator("",this.getResources().getDrawable(R.drawable.event)),
        		GreenEvent.class, null);
        mTabManager.addTab(mTabHost.newTabSpec("GreenVideo").setIndicator("",this.getResources().getDrawable(R.drawable.video)),
        		GreenVideo.class, null);
        mTabManager.addTab(mTabHost.newTabSpec("GreenTip").setIndicator("",this.getResources().getDrawable(R.drawable.tip)),
        		GreenTip.class, null);
        mTabManager.addTab(mTabHost.newTabSpec("GreenMap").setIndicator("",this.getResources().getDrawable(R.drawable.map)),
        		GreenMap.class, null);
        mTabManager.addTab(mTabHost.newTabSpec("GreenUs").setIndicator("",this.getResources().getDrawable(R.drawable.us)),
        		GreenUs.class, null);

        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //先取得螢幕解析度  
        int screenWidth = dm.widthPixels;   //取得螢幕的寬
        int screenHeight = dm.heightPixels;   //取得螢幕的寬
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //取得tab的物件
        int count = tabWidget.getChildCount();   //取得tab的分頁有幾個
       /* if (count > 1) {   //如果超過三個就來處理滑動
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i).setMinimumWidth((screenWidth) / 8);//設定每一個分頁最小的寬度   
            }   
        }*/
        for (int i = 0; i < count; i++) {  
            View view = tabWidget.getChildTabViewAt(i);     
            view.getLayoutParams().height = screenHeight/9; //tabWidget.getChildAt(i)  
            view.getLayoutParams().width = (int) (screenWidth/(4.6));  
           }  
        

    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_BACK){
			getSupportFragmentManager().popBackStack();
		}
		return true;
	}
    
}