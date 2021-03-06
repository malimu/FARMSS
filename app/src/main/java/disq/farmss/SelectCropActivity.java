package disq.farmss;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SelectCropActivity extends Activity {
    int SN,SP,SK;
    double FN,FP,FK;
    String TAG = "disq.farmss:";
    SharedPreferences sharedPref;
    String AreaTpye;
    double PerAcre = 0.4;
    double PerGuntha = 0.01;
    Float AreaValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectcrop);
        sharedPref = this.getSharedPreferences("MyPref", 0);
        AreaTpye= sharedPref.getString("land_type",null);
        Log.i(TAG,"AreaType"+AreaTpye);
        AreaValue = sharedPref.getFloat("plot_size",0.0f);
        Log.i(TAG,"AreaValue"+AreaValue);
        SN=sharedPref.getInt("N",0);
        Log.i(TAG,"SN"+String.valueOf(SN));
        SP=sharedPref.getInt("P",0);
        Log.i(TAG,"SP"+String.valueOf(SP));
        SK=sharedPref.getInt("K",0);
        Log.i(TAG,"SK"+String.valueOf(SK));
    }
    //Logic for calculating RecommendationActivity for cabbage
    public void rec_cabbage(View view){
        try{

            int T=35;
            //N
            Double N1=8.28;
            Double N2=0.21;

            double C1=2.17;
            FN=(((N1*T)-(N2*SN))*C1);
            Log.i(TAG,"FN1"+Double.toString(FN));
            //P
            Double N3=4.72;
            Double N4=2.34;

            double C2=6.25;
            FP=(((N3*T)-(N4*SP))*C2);
            if(FP<25)FP=25;
            Log.i(TAG,"FP1"+Double.toString(FP));

            //K
            Double N5=6.68;
            Double N6=0.19;

            double C3=1.72;
            FK=(((N5*T)-(N6*SK))*C3);
            Log.i(TAG,"FK1"+Double.toString(FK));

            //For Final Result
            if (AreaTpye.equals("Guntha")){
                FN = FN*PerGuntha*AreaValue;
                Log.i(TAG,"FN2"+Double.toString(FN));
                FP = FP*PerGuntha*AreaValue;
                Log.i(TAG,"FP2"+Double.toString(FP));
                FK = FK*PerGuntha*AreaValue;
                Log.i(TAG,"FK2"+Double.toString(FK));
            }else if (AreaTpye.equals("Acre")){
                FN = FN*PerAcre*AreaValue;
                FP = FP*PerAcre*AreaValue;
                if(FP<25)FP=25;
                FK = FK*PerAcre*AreaValue;
            }
        }catch (Exception e){
            System.out.print(e);
        }
        Intent intent = new Intent(SelectCropActivity.this,RecommendationActivity.class);
        Bundle b = new Bundle();
        b.putDouble("FNC", FN);
        intent.putExtras(b);
        b.putDouble("FPC", FP);
        intent.putExtras(b);
        b.putDouble("FKC", FK);
        intent.putExtras(b);

        startActivity(intent);
        finish();
    }

    //Logic for calculating RecommendationActivity for onion
    public void rec_onion(View view){
        try{
            int T=25;
            //N
            Double N1=5.40;
            Double N2=0.54;

            double C1=2.17;
            FN=(((N1*T)-(N2*SN))*C1);
            Log.i(TAG,Double.toString(FN));

            //P
            Double N3=4.00;
            Double N4=4.32;

            double C2=6.25;
            FP=(((N3*T)-(N4*SP))*C2);
            if(FP<25)FP=25;
            Log.i(TAG,Double.toString(FP));

            //K
            Double N5=3.10;
            Double N6=0.13;

            double C3=1.72;
            FK=(((N5*T)-(N6*SK))*C3);
            Log.i(TAG,Double.toString(FK));

            //For Final Result
            if (AreaTpye.equals("Guntha")){
                FN = FN*PerGuntha*AreaValue;
                FP = FP*PerGuntha*AreaValue;
                FK = FK*PerGuntha*AreaValue;
            }else if (AreaTpye.equals("Acre")){
                FN = FN*PerAcre*AreaValue;
                FP = FP*PerAcre*AreaValue;
                FK = FK*PerAcre*AreaValue;
            }

        }catch (Exception e){
            System.out.print(e);
        }
        Intent intent = new Intent(SelectCropActivity.this,RecommendationActivity.class);
        Bundle b = new Bundle();
        b.putDouble("FNC", FN);
        intent.putExtras(b);
        b.putDouble("FPC", FP);
        intent.putExtras(b);
        b.putDouble("FKC", FK);
        intent.putExtras(b);

        startActivity(intent);
        finish();
    }

    //Logic for calculating RecommendationActivity for tomato
    public void rec_tomato(View view){
        try{
            int T=30;
            //N
            Double N1=5.33;
            Double N2=0.46;

            double C1=2.17;
            FN=(((N1*T)-(N2*SN))*C1);
            Log.i(TAG,Double.toString(FN));

            //P
            Double N3=3.88;
            Double N4=4.16;

            double C2=6.25;
            FP=(((N3*T)-(N4*SP))*C2);
            if(FP<25)FP=25;
            Log.i(TAG,Double.toString(FP));

            //K
            Double N5=5.16;
            Double N6=0.25;

            double C3=1.72;
            FK=(((N5*T)-(N6*SK))*C3);
            Log.i(TAG,Double.toString(FK));

            //For Final Result
            if (AreaTpye.equals("Guntha")){
                FN = FN*PerGuntha*AreaValue;
                FP = FP*PerGuntha*AreaValue;
                FK = FK*PerGuntha*AreaValue;
            }else if (AreaTpye.equals("Acre")){
                FN = FN*PerAcre*AreaValue;
                FP = FP*PerAcre*AreaValue;
                FK = FK*PerAcre*AreaValue;
            }

        }catch (Exception e){
            System.out.print(e);
        }
        Intent intent = new Intent(SelectCropActivity.this,RecommendationActivity.class);
        Bundle b = new Bundle();
        b.putDouble("FNC", FN);
        intent.putExtras(b);
        b.putDouble("FPC", FP);
        intent.putExtras(b);
        b.putDouble("FKC", FK);
        intent.putExtras(b);

        startActivity(intent);
        finish();
    }

    //Logic for calculating RecommendationActivity for chilli
    public void rec_chilli(View view){
        try{
            int T=7;
            //N
            Double N1=50.23;
            Double N2=0.54;

            double C1=2.17;
            FN=(((N1*T)-(N2*SN))*C1);
            Log.i(TAG,Double.toString(FN));

            //P
            Double N3=27.09;
            Double N4=3.17;

            double C2=6.25;
            FP=(((N3*T)-(N4*SP))*C2);
            if(FP<25)FP=25;
            Log.i(TAG,Double.toString(FP));

            //K
            Double N5=36.48;
            Double N6=0.30;

            double C3=1.72;
            FK=(((N5*T)-(N6*SK))*C3);
            Log.i(TAG,Double.toString(FK));

            //For Final Result
            if (AreaTpye.equals("Guntha")){
                FN = FN*PerGuntha*AreaValue;
                FP = FP*PerGuntha*AreaValue;
                FK = FK*PerGuntha*AreaValue;
            }else if (AreaTpye.equals("Acre")){
                FN = FN*PerAcre*AreaValue;
                FP = FP*PerAcre*AreaValue;
                FK = FK*PerAcre*AreaValue;
            }

        }catch (Exception e){
            System.out.print(e);
        }
        Intent intent = new Intent(SelectCropActivity.this,RecommendationActivity.class);
        Bundle b = new Bundle();
        b.putDouble("FNC", FN);
        intent.putExtras(b);
        b.putDouble("FPC", FP);
        intent.putExtras(b);
        b.putDouble("FKC", FK);
        intent.putExtras(b);

        startActivity(intent);
        finish();
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

}
