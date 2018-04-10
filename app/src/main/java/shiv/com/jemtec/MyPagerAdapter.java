package shiv.com.jemtec;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MyPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment1 abt = new Fragment1();
                return abt;
            case 1:
                Fragment2 visn = new Fragment2();
                return visn;
            case 2:
                Fragment3 misn = new Fragment3();
                return misn;
            case 3:
                Fragment4 cmsg = new Fragment4();
                return cmsg;
            case 4:
                Fragment5 dmsg = new Fragment5();
                return dmsg;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
