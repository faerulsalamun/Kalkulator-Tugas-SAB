package id.web.faerul.kalkulator.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.web.faerul.kalkulator.R;
import id.web.faerul.kalkulator.ui.base.BaseActivity;
import id.web.faerul.kalkulator.ui.base.BaseFragment;
import id.web.faerul.kalkulator.ui.bola.BolaFragment;
import id.web.faerul.kalkulator.ui.kerucut.KerucutFragment;
import id.web.faerul.kalkulator.ui.kubus.KubusFragment;
import id.web.faerul.kalkulator.ui.tabung.TabungFragment;
import util.customview.TitleBar;

/**
 * Created by faerulsalamun on 9/6/16.
 */
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) TitleBar mTitleBar;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view) NavigationView mNavVie;
    @BindView(R.id.frame_layout_container) FrameLayout mFrameLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mTitleBar.setImageButton(R.mipmap.ic_menu_black);

        mTitleBar.setOnActionButtonClick(v -> {
            mDrawerLayout.openDrawer(Gravity.LEFT);
        });

        setNavigationDrawer();
        setupDisplayFragment(0);
    }

    private void setupDisplayFragment(int position) {
        BaseFragment fragment = null;

        switch (position) {
            case 0:
                fragment = new KubusFragment();
                mTitleBar.setTitle(getString(R.string.drawer_kubus));
                break;
            case 1:
                fragment = new TabungFragment();
                mTitleBar.setTitle(getString(R.string.drawer_tabung));
                break;
            case 2:
                fragment = new BolaFragment();
                mTitleBar.setTitle(getString(R.string.drawer_bola));
                break;
            case 3:
                fragment = new KerucutFragment();
                mTitleBar.setTitle(getString(R.string.drawer_kerucut));
                break;

        }


        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_container, fragment).commit();
        }
    }

    private void setNavigationDrawer() {
        mNavVie.setNavigationItemSelectedListener(this);
        mNavVie.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float xPositionOpenDrawer = drawerView.getWidth();
                float xPositionWindowContent = (slideOffset * xPositionOpenDrawer);

                mFrameLayoutContainer.setX(xPositionWindowContent);
                mTitleBar.setAlpha(1 - slideOffset / 2);
                mTitleBar.setX(xPositionWindowContent);
            }
        };


        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_kubus) {
            setupDisplayFragment(0);
        } else if (id == R.id.nav_tabung) {
            setupDisplayFragment(1);
        } else if (id == R.id.nav_bola) {
            setupDisplayFragment(2);
        } else if (id == R.id.nav_kerucut) {
            setupDisplayFragment(3);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
