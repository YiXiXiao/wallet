package org.chainbay.wallet.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xiaoyixi on 2018/11/5.
 */

public class PayEntity implements Parcelable {
    public String amount;
    public String toAddress;
    public String orderN;

    public PayEntity(String amount, String toAddress, String orderN) {
        this.amount = amount;
        this.toAddress = toAddress;
        this.orderN = orderN;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getOrderN() {
        return orderN;
    }

    public void setOrderN(String orderN) {
        this.orderN = orderN;
    }

    @Override
    public String toString() {
        return "PayEntity{" +
                "amount='" + amount + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", orderN='" + orderN + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.amount);
        dest.writeString(this.toAddress);
        dest.writeString(this.orderN);
    }

    protected PayEntity(Parcel in) {
        this.amount = in.readString();
        this.toAddress = in.readString();
        this.orderN = in.readString();
    }

    public static final Creator<PayEntity> CREATOR = new Creator<PayEntity>() {
        @Override
        public PayEntity createFromParcel(Parcel source) {
            return new PayEntity(source);
        }

        @Override
        public PayEntity[] newArray(int size) {
            return new PayEntity[size];
        }
    };
}
