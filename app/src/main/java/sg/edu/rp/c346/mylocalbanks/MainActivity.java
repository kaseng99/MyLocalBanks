package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btndbs , btnocbc , btnuob;
int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndbs.findViewById(R.id.buttondbs);
        btnocbc.findViewById(R.id.buttonocbc);
        btnuob.findViewById(R.id.buttonuob);



        btndbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        btnocbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnuob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.buttondbs){
            mode=1;
        }else if(v.getId()==R.id.buttonocbc){
            mode=2;
        }else if(v.getId()==R.id.buttonuob){
            mode=3;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle().toString()=="Website") {
            if (mode == 1) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);


            } else if (mode == 2) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

            } else {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);


            }
            return true;
        }
        else if(item.getTitle().toString()=="Contact the bank") {

            if (mode == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);

            } else if (mode == 2) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);

            } else {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);

            }
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.ChineseSelection) {


            btndbs.setText("星展银行");
            btnocbc.setText("华侨银行");
            btnuob.setText("大华银行");

            return true;
        }else if (id == R.id.EnglishSelection) {
            btndbs.setText("DBS");
            btnocbc.setText("OCBC");
            btnuob.setText("UOB");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
