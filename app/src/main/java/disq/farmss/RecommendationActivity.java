package disq.farmss;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RecommendationActivity extends Activity {

    EditText RN,RP,RK;
    SharedPreferences sharedPref;
    int result_n, result_p, result_k;
    DatabaseHelper dbhelper = new DatabaseHelper(this);
    String TAG = "disq.farmss:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        sharedPref = this.getSharedPreferences("MyPref", 0);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        result_n = (int) b.getDouble("FNC");
        Log.i("disq.farmss:",Double.toString(result_n));
        RN = (EditText) findViewById(R.id.result_nvalue);
        RN.setText(String.valueOf(result_n));

        result_p = (int) b.getDouble("FPC");
        Log.i("disq.farmss:",Double.toString(result_p));
        RP = (EditText) findViewById(R.id.result_pvalue);
        RP.setText(String.valueOf(result_p));

        result_k =(int)  b.getDouble("FKC");
        Log.i("disq.farmss:",Double.toString(result_k));
        RK = (EditText) findViewById(R.id.result_kvalue);
        RK.setText(String.valueOf(result_k));

    }
    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(this).create();
        alertDialog.setIcon(R.mipmap.alert);
        alertDialog.setTitle(getString(R.string.leave_application));
        alertDialog.setMessage(getString(R.string.Leave_application_msg));
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.Yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                        System.exit(0);
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.No), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.cancel();
                    }
                }
        );
        alertDialog.show();
    }

    public void Open_Login_Register(View view){
        Intent intent = new Intent(RecommendationActivity.this,AddPlotSizeActivity.class);
        InsertSoilTestResult();
        startActivity(intent);
        finish();
    }

    private void InsertSoilTestResult() {
        String Str_mobile = sharedPref.getString("Login_Mobile",null);
        String Str_area_type = sharedPref.getString("land_type",null);
        String Str_area_value = String.valueOf(sharedPref.getFloat("plot_size",0.0f));
        String Str_ph = String.valueOf(sharedPref.getInt("pH",0));
        String Str_n = String.valueOf(sharedPref.getInt("N",0));
        String Str_p = String.valueOf(sharedPref.getInt("P",0));
        String Str_k = String.valueOf(sharedPref.getInt("K",0));
        String Str_fn = String.valueOf(result_n);
        String Str_fp = String.valueOf(result_p);
        String Str_fk = String.valueOf(result_k);

        SoilTestResultDBMethod str = new SoilTestResultDBMethod();
        str.setMobile(Str_mobile);
        str.setAreaType(Str_area_type);
        str.setAreaValue(Str_area_value);
        str.setpH(Str_ph);
        str.setN(Str_n);
        str.setP(Str_p);
        str.setK(Str_k);
        str.setFN(Str_fn);
        str.setFP(Str_fp);
        str.setFK(Str_fk);

        long res = dbhelper.insertSoilTestData(str);
        if (res==-1){
            Log.i(TAG," SoilTest Data is not Inserted ");
        }else {
            Log.i(TAG," SoilTest Result is Inserted ");
        }
    }
}
