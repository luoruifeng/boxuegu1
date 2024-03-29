package cn.edu.gamec.android.boxuegu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.edu.gamec.android.boxuegu.R;

/**
 * Created by student on 17/12/27.
 */

//广告轮播图的片段类
public class AdBannerFragment extends android.support.v4.app.Fragment {
    private String ab;//广告
    private ImageView iv;//图片

    public static AdBannerFragment newInstance(Bundle args){
        AdBannerFragment af = new AdBannerFragment ();
        af.setArguments ( args );
        return af;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate ( savedInstanceState );
        Bundle arg = getArguments ();
        //获取广告图片名称
        ab = arg.getString ( "ad" );
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated ( savedInstanceState );
    }
    @Override
    public void onResume(){
        super.onResume ();
        if (ab != null){
            if ("banner_1".equals ( ab )){
                iv.setImageResource ( R.drawable.banner_1 );
            }else if ("banner_2".equals ( ab )){
                iv.setImageResource ( R.drawable.banner_2 );
            }else if ("banner_3".equals ( ab )){
                iv.setImageResource ( R.drawable.banner_3 );
            }
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy ();
        if (iv != null){
            iv.setImageDrawable ( null );
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //创建广告图片控件
        iv = new ImageView ( getActivity () );
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams ( ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        iv.setLayoutParams ( lp );//设置图片宽度参数
        iv.setScaleType ( ImageView.ScaleType.FIT_XY );//把图片塞满整个控件
        return iv;
    }
}
