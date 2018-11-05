package org.chainbay.wallet.lisenter;

import org.chainbay.wallet.entity.ResultEntity;

/**
 * Created by xiaoyixi on 2018/11/5.
 */

public interface PayResultLisenter {
    public void paySuccess(ResultEntity resultEntity);
    public void payFail(ResultEntity resultEntity);
}
