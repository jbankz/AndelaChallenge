package jbankz.com.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import jbankz.com.fragment.BtcFragment;
import jbankz.com.fragment.EthFragment;

/**
 * Created by jaycee on 9/17/17.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                //btc Fragment
                return new BtcFragment();
            case 1:
                //eth Fragment
                return new EthFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                //btc Fragment
                return "BTC";
            case 1:
                //eth Fragment
                return "ETH";
        }
        return null;

    }

}
