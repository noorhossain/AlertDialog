package first.learn.alertdialog;

import static first.learn.alertdialog.Common.showGlobalAlert;
import static first.learn.alertdialog.Common.showStaticCustomDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnShow, btnShowGlobal, btnShowItems, btnShowCustomDialog, btnShowStaticCustomDialog;


    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        btnShow = (Button) findViewById(R.id.btnShow);
        btnShowGlobal= (Button) findViewById(R.id.btnShowGlobal);
        btnShowItems = (Button)findViewById(R.id.btnShowItems);
        btnShowCustomDialog = (Button)findViewById(R.id.btnShowCustomDialog);
        btnShowStaticCustomDialog = (Button)findViewById(R.id.btnShowStaticCustomDialog);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(mContext)
                        .setTitle("Confirmation")
                        .setMessage("Do you really want to  Delete the File Named My Book")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Cancel", null)
                        .create().show();


             /*
                AlertDialog.Builder ad = new AlertDialog.Builder(mContext);

                ad.setTitle("Confirmation");
                ad.setMessage("Do you really want to  Delete the File");

                ad.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        /// file Delete Method

                        Toast.makeText(mContext, "File Deleted Successfully", Toast.LENGTH_SHORT).show();



                    }
                });

                ad.setNeutralButton("NO", null);

                AlertDialog dialog = ad.create();

                dialog.show();

        */


            }
        });

        btnShowGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Success";
                String message= "Your File Download Successfully";

                title = "Failure";
                message = "Your File can't Download, Check Internet Connection";

                showGlobalAlert ( mContext, title, message);

            }
        });


        btnShowItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence [] options = { "Fruits", "Animals", "Books"  };

                AlertDialog.Builder ad = new AlertDialog.Builder(mContext);

                ad.setTitle("Select One : ");

                ad.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {

                        if(position==0){

                            CharSequence [] array1= { "Apple", "Banana", "Cherry"};

                            new AlertDialog.Builder(mContext)
                                    .setTitle("Choose One Fruit: ")
                                    .setItems(array1, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {



                                            String a = array1[which].toString();
                                            Toast.makeText(MainActivity.this, "You have Selected: " +a, Toast.LENGTH_SHORT).show();

                                        }
                                    }).setPositiveButton("Cancel", null)
                                    .create().show();


                        }

                        if(position==1){
                          new AlertDialog.Builder(mContext).setTitle("Not Available: ")
                                  .setMessage("This Information Upcoming")
                                  .setPositiveButton("Cancel", null)
                                  .create().show();

                        }
                        if(position==2){
                            Toast.makeText(mContext, "You Selected Books", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                ad.setPositiveButton("Cancel", null);

                ad.create().show();

            }
        });




        btnShowCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCustomDialog (mContext, "This is Title: ", "This is Message");


            }
        });


        btnShowStaticCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showStaticCustomDialog(mContext, "This is Static Title", "This is Static Message");

            }
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        System.out.println("Calling Method 3: Window Focus Changed");

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Calling Method 1: OnResume MainActivity");

    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("Calling Method 2: OnPause MainActivity");

    }

    void  showCustomDialog (Context mContext, String title, String message){

        AlertDialog.Builder ad = new AlertDialog.Builder(mContext);

        View  view = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);
        TextView tvMessage = (TextView)view.findViewById(R.id.tvMessage);
        TextView txtClose = (TextView)view.findViewById(R.id.txtClose);
        Button btnThree= (Button)view.findViewById(R.id.btnThree);
        Button btnTwo= (Button)view.findViewById(R.id.btnTwo);
        Button btnOne= (Button)view.findViewById(R.id.btnOne);


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "This is Button One", Toast.LENGTH_SHORT).show();

            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "This is Button Two", Toast.LENGTH_SHORT).show();

            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "This is Button Three", Toast.LENGTH_SHORT).show();

            }
        });
        tvTitle.setText(title);
        tvMessage.setText(message);

        ad.setView(view);

        AlertDialog dialog = ad.create();

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