package com.naruto.b_pocketnewlol.me;

import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;


import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;
/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/26.
 */

public class MapActivity extends BaseActivity {

    // 创建 LocationClient 的实例
    public LocationClient locationClient;
    private TextView positionText;

    private MapView mapView;

    private BaiduMap baiduMap;
    private boolean isFirstLocate = true;
    @Override
    public int setLayout() {
        //在这里调用 getApplicationContext() 方法来获取一个全局的Context 参数并传入
        locationClient = new LocationClient(getApplicationContext());
        //然后再调用 registerLocationListener() 方法来注册一个定位监听器,
        //当我们获取到位置信息的时候,就会回调这个定位监视器
        locationClient.registerLocationListener(new MyLocationListener());
        //调用此方法进行初始化操作,initialize()方法接收一个Context参数
        SDKInitializer.initialize(getApplicationContext());
        return R.layout.activity_map;
    }

    @Override
    public void initView() {


        mapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        //根据百度地图的限制,如果我们想要使用这一功能,
        //一定要事先调用BaiduMap的 setMyLocationEnabled方法 将此功能开启,
        //否则设备的位置将无法在地图上显示
        baiduMap.setMyLocationEnabled(true);


        positionText = (TextView) findViewById(R.id.position_text_view);
    }

    @Override
    public void initData() {
        // 我们要一次性申请三个权限,首先创建一个空的List集合,
        // 再调用ActivityCompat.requestPermissions方法一次性申请
        List<String> permisslionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MapActivity.this, Manifest.
                permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permisslionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MapActivity.this, Manifest.
                permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permisslionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MapActivity.this, Manifest.
                permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permisslionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permisslionList.isEmpty()) {
            String[] permissions = permisslionList.toArray(new String[permisslionList.size()]);
            ActivityCompat.requestPermissions(MapActivity.this, permissions, 1);
        } else {
            requestLocation();
        }
    }

    //调用一下locationClient.start()方法就可以开始定位了,
    // 定位的结果会回调到我们前面注册的监听器之中
    private void requestLocation() {
        initLocation();
        locationClient.start();
    }
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        //option.setScanSpan(5000);
        //option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        option.setIsNeedAddress(true);
        locationClient.setLocOption(option);
    }

    // 先将BDLocation 对象中的地理位置信息取出并封装到LatLng对象中,
    // 然后调用MapStatusUpdateFactory 的 newLatLng()方法将LatLng对象传入,
    // 接着将返回的MapStatusUpdate 对象作为参数传入BaiduMap 的animateMapStatus()方法中
    // isFirstLocate 这个变量的作用是 为了防止多次调用animateMapStatus()方法,因为将地图移动到我们当前的位置
    // 只需要在程序第一次定位的时候用一次就可以了
    private void navigateTo(BDLocation bdLocation) {
        if (isFirstLocate) {
            LatLng ll = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;
        }


        //在navigateTo()方法中,我们添加了 MyLocationData的构建逻辑
        //将包含的经纬度分别封装到 MyLocationData.Builder 之中,
        //最后把MyLocationData设置到BaiduMap的setMyLocationData()方法之中
        MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
        locationBuilder.latitude(bdLocation.getLatitude());
        locationBuilder.longitude(bdLocation.getLongitude());
        MyLocationData locationData = locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }

    //另外还需要重写onResume(),onPause(),onDestroy()三个方法,
    // 在这里对我们的MapView进行管理,以保证资源能够及时的得到释放
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationClient.stop();
        mapView.onDestroy();
        //在程序退出的时候,也要将此功能关闭了
        baiduMap.setMyLocationEnabled(false);
    }


    //这个方法我们通过一个循环将申请的每一个权限都进行了判断,
    //如果有任何一个权限被拒绝了,那么就直接调用finish()方法关闭当前程序,
    //只有当所有权限都被用户同意了,才会调用requestPermissions()方法开始地理位置定位
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }


    //监听器
    private class MyLocationListener implements BDLocationListener {
        //在这个方法中直接把 BDLocation 对象传给 navigateTo()方法,
        // 这样就能够让地图移动到设备所在的位置了
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {

            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation
                    || bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                navigateTo(bdLocation);
            }
            //在这里我们调用 getLatitude()方法获取当前纬度
            //            getLongitude()方法获取当前经度
            //            getLocType()方法获取定位方式
            StringBuilder currentPosition = new StringBuilder();
            currentPosition.append("纬度: ").append(bdLocation.getLatitude()).append("\n");
            currentPosition.append("经线: ").append(bdLocation.getLongitude()).append("\n");
            currentPosition.append("国家: ").append(bdLocation.getCountry()).append("\n");
            currentPosition.append("省: ").append(bdLocation.getProvince()).append("\n");
            currentPosition.append("市: ").append(bdLocation.getCity()).append("\n");
            currentPosition.append("区: ").append(bdLocation.getDistrict()).append("\n");
            currentPosition.append("街道: ").append(bdLocation.getStreet()).append("\n");
            currentPosition.append("定位方式: ");
            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
                currentPosition.append("GPS");
            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                currentPosition.append("网络");
            }
            positionText.setText(currentPosition);
        }
    }

}
