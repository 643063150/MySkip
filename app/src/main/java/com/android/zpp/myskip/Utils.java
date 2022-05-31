package com.android.zpp.myskip;

import android.widget.Toast;

import java.util.Collection;

/**
 * @ProjectName: MySkip
 * @Package: com.android.zpp.myskip
 * @ClassName: Utils
 * @Description:
 * @Author: zpp
 * @CreateDate: 2022/5/31 10:55
 * @UpdateUser:
 * @UpdateDate: 2022/5/31 10:55
 * @UpdateRemark:
 */
public class Utils {


    //集合是否是空的
    public static boolean isEmptyArray(Collection list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean isEmptyArray(T[] list) {
        return list == null || list.length == 0;
    }
}
