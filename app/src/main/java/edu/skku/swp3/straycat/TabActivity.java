package edu.skku.swp3.straycat;

import android.annotation.SuppressLint;
<<<<<<< HEAD
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.location.Location;
=======
import android.content.Intent;
>>>>>>> e25a72407534706df4580c0c75f36cb21b770a77
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
<<<<<<< HEAD
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;
=======
>>>>>>> e25a72407534706df4580c0c75f36cb21b770a77

import java.lang.reflect.Field;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class TabActivity extends AppCompatActivity {

    private View fragmentHolder;
    private TabActivity tabActivity;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.nav_feed:
                    Intent intent1 = new Intent(tabActivity, PostActivity.class);//ACTIVITY_NUM = 0
                    tabActivity.startActivity(intent1);
                    finish();
                    break;
                case R.id.nav_map:
//                    transaction.replace(R.id.nav_fragment, new MapsActivity(), "map");
                    return true;
                case R.id.nav_plus:

                    return true;
                case R.id.nav_donation:
                    transaction.replace(R.id.nav_fragment, new DonationMainFragment(), "donation_main");
                    return true;
                case R.id.nav_setting:
                    return true;
            }

            transaction.commit();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentHolder = findViewById(R.id.nav_fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.add(R.id.nav_fragment, new DonationMainFragment());
        transaction.commit();
        removeShiftMode(navigation);
<<<<<<< HEAD

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }

        supportMapFragment.getMapAsync(this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
    }


=======
    }

>>>>>>> e25a72407534706df4580c0c75f36cb21b770a77
    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    @SuppressLint("RestrictedApi")
    void removeShiftMode(BottomNavigationView  view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);

                item.setShiftingMode(false);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }

<<<<<<< HEAD
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//       ArrayList<Marker> markers = new ArrayList<Marker>();
        LatLng center = new LatLng(36.427397, 128.064719);
        LatLng testMarker = new LatLng(37.553042, 126.986792);




        Marker test = mMap.addMarker(new MarkerOptions()
                .position(testMarker)
                .title("5")
                .snippet("15")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.dot)));



//        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(37.275774, 127.010741))
//        .title("mark2")));
//        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(35.160694, 129.066059))
//        .title("mark3")));
//        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(35.155051, 126.829565))
//        .title("mark4")));
//        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(37.548287, 128.483212))
//        .title("mark5")));

//        for (Marker marker : markers) {
//            marker.setVisible(true);
//
//            //marker.remove(); <-- works too!
//        }

        CustomInfoWindowAdapter adapter = new CustomInfoWindowAdapter(TabActivity.this);
        mMap.setInfoWindowAdapter(adapter);

        test.showInfoWindow();
        test.setVisible(true);


        googleMap.moveCamera(CameraUpdateFactory.newLatLng(center));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 7));
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show();
    }
=======
>>>>>>> e25a72407534706df4580c0c75f36cb21b770a77
}