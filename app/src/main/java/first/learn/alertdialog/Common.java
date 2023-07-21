package first.learn.alertdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class Common {

    public static AlertDialog globalAlert = null;



    public static void  showGlobalAlert (Context mContext, String title, String message){


        if(globalAlert!=null && globalAlert.isShowing()){
            globalAlert.dismiss();
        }


        AlertDialog.Builder ad = new AlertDialog.Builder(mContext);
        ad.setTitle(title);
        ad.setMessage(message);

        ad.setPositiveButton("Ok", null);

        globalAlert = ad.create();
        globalAlert.show();

    }



   public static void  showStaticCustomDialog (Context mContext, String title, String message){

        android.app.AlertDialog.Builder ad = new android.app.AlertDialog.Builder(mContext);

       LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(R.layout.custom_dialog, null);

        TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);
        TextView tvMessage = (TextView)view.findViewById(R.id.tvMessage);
       TextView txtClose = (TextView)view.findViewById(R.id.txtClose);
        Button btnThree= (Button)view.findViewById(R.id.btnThree);
        Button btnTwo= (Button)view.findViewById(R.id.btnTwo);
        Button btnOne= (Button)view.findViewById(R.id.btnOne);


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "This is Static Button One", Toast.LENGTH_SHORT).show();

            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "This is Static Button Two", Toast.LENGTH_SHORT).show();

            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "This is Static Button Three", Toast.LENGTH_SHORT).show();

            }
        });
        tvTitle.setText(title);
        tvMessage.setText(message);

        ad.setView(view);

        android.app.AlertDialog dialog = ad.create();

       txtClose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Toast.makeText(mContext, "Dialog is Closed", Toast.LENGTH_SHORT).show();

               dialog.dismiss();
           }
       });

        dialog.show();


    }



}
