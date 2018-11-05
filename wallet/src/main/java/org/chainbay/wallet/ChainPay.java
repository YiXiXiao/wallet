package org.chainbay.wallet;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import org.chainbay.wallet.common.Constant;
import org.chainbay.wallet.entity.PayEntity;
import org.chainbay.wallet.entity.ResultEntity;
import org.chainbay.wallet.lisenter.PayResultLisenter;
import org.chainbay.wallet.utils.AppUtils;

/**
 * Created by xiaoyixi on 2018/11/5.
 */

public class ChainPay {
    /**
     * 支付接口
     * @param lisenter
     */
    public static void pay(Context context, PayEntity params, PayResultLisenter lisenter){
        //如果参数错误，直接回调失败
        if(TextUtils.isEmpty(params.getAmount()) || TextUtils.isEmpty(params.getOrderN()) || TextUtils.isEmpty(params.getToAddress())){
            ResultEntity<String> resultEntity = new ResultEntity<String>("00001", "parameters missing", "");
            lisenter.payFail(resultEntity);
            return;
        }
        if(Long.parseLong(params.getAmount()) < 0){
            ResultEntity<String> resultEntity = new ResultEntity<String>("00002","parameters error","amount");
            lisenter.payFail(resultEntity);
        }

        //打开链贝支付
        if(AppUtils.checkPackInfo(context, Constant.PACKAGE_NAME)){
            boolean b = openPackage(context, params, Constant.PACKAGE_NAME, Constant.WALLET_PAY_ACTIVITY);
            if(!b){
                lisenter.payFail(new ResultEntity<String>("00003","Context is error",""));
            } else {
                lisenter.paySuccess(new ResultEntity<String>("00000","Success",""));
            }
        } else {
            //没有安装链贝
            lisenter.payFail(new ResultEntity<String>("00010","Not installed Chain Bay",""));
        }
    }

    /**
     * 打开链贝
     * @param context
     * @param params
     * @param packageName
     * @return
     */
    private static boolean openPackage(Context context, PayEntity params, String packageName, String activityName) {
        Context pkgContext = AppUtils.getPackageContext(context, packageName);
        Intent intent = AppUtils.getAppOpenIntentByPackageName(context, packageName,activityName);
        intent.putExtra("amount",params.getAmount());
        intent.putExtra("toAddress",params.getToAddress());
        intent.putExtra("orderN",params.getOrderN());
        if (pkgContext != null && intent != null) {
            pkgContext.startActivity(intent);
//            try {
//                ((Activity)pkgContext).startActivityForResult(intent, Constant.PAY_REQUEST_CODE);
                return true;
//            }catch (Exception e){
//                return false;
//            }
        }
        return false;
    }

}
