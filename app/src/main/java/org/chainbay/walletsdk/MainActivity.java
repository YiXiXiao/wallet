package org.chainbay.walletsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.chainbay.wallet.ChainPay;
import org.chainbay.wallet.common.ChainPayConfig;
import org.chainbay.wallet.entity.PayEntity;
import org.chainbay.wallet.entity.ResultEntity;
import org.chainbay.wallet.lisenter.PayResultLisenter;

public class MainActivity extends AppCompatActivity {

    Button btStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btStart = (Button) findViewById(R.id.bt_start);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChainPayConfig.APP_KEY = "123";
                ChainPayConfig.APP_SECRET = "123";
                ChainPay.pay(MainActivity.this, new PayEntity("1", "0x02123", "123"), new PayResultLisenter() {
                    @Override
                    public void paySuccess(ResultEntity resultEntity) {
                        Toast.makeText(MainActivity.this,resultEntity.getMsg(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void payFail(ResultEntity resultEntity) {
                        Toast.makeText(MainActivity.this,resultEntity.getMsg(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
