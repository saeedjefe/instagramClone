package saeed.example.com.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.List;

public class signup extends AppCompatActivity implements View.OnClickListener{

    EditText edtName, edtPunchSpeed, edtKickSpeed, edtKickPower;
    Button btnSave, btnGetAllData, btnTransition;
    TextView textView;

    String together = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup );


        edtName = findViewById( R.id.edtName );
        edtPunchSpeed = findViewById( R.id.edtPunchSpeed );
        edtKickSpeed = findViewById( R.id.edtKickSpeed );
        edtKickPower = findViewById( R.id.edtKickPower );
        btnSave = findViewById( R.id.btnSave);

        textView = findViewById( R.id.textView );

        btnGetAllData = findViewById( R.id.btnGetAllData );

        btnTransition = findViewById( R.id.btnTransition );

        btnTransition.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


        btnGetAllData.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery( "kickBoxer" );
                parseQuery.whereGreaterThanOrEqualTo( "puchSpeed", 987 );

                parseQuery.findInBackground( new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if(objects.size()>0)
                        {
                            for(ParseObject parseObject: objects)
                            {
                                 together += parseObject.get( "name" )+"\t";
                            }
                            textView.setText( together );
                            FancyToast.makeText( signup.this,  "narridi", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();



                        }
                        else {

                            FancyToast.makeText( signup.this,  "ridi", FancyToast.LENGTH_LONG, FancyToast.ERROR, true ).show();


                        }

                    }
                } );
            }
        } );


        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParseQuery<ParseObject>  parseQuery = ParseQuery.getQuery( "kickBoxer" );

                parseQuery.whereGreaterThanOrEqualTo( "punchSpeed", 987 );
                parseQuery.getInBackground( "iXpTODfCCd", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if(object!= null&& e==null)
                        {
                            textView.setText(object.get("name") + "\t" +object.get( "kickPower" )+"\t" + object.get("kickSpeed")+"\t"+object.get( "kickPower" ));
                            FancyToast.makeText( signup.this,  "narridi", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();


                            FancyToast.makeText( signup.this,  "narridi", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();


                        }

                        else
                        {
                            FancyToast.makeText( signup.this,  "ridi", FancyToast.LENGTH_LONG, FancyToast.ERROR, true ).show();

                        }

                    }
                } );
            }
        } );

//        edtName.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FancyToast.makeText( signup.this, "sdf",FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();
//
//            }
//        } );


        btnSave.setOnClickListener(this);
    }



//
//    public void helloWorldTapped(View view){
//
////        ParseObject boxer = new ParseObject( "Boxer" );
////        boxer.put("punchSpeed", 90);
//////        boxer.saveInBackground();//save in new fred
////        boxer.saveInBackground( new SaveCallback() {
////            @Override
////            public void done(ParseException e) {
////                if(e ==null)
////                {
////                    Toast.makeText( signup.this, "boxer object is saved successfully", Toast.LENGTH_SHORT ).show();
////                }
////            }
////        } );
//
////        ParseObject kickBoxer = new ParseObject( "kickBoxer" );
////        kickBoxer.put("name","John");
////        kickBoxer.put("puchSpeed", 330);
////        kickBoxer.put("kickPower", 343);
////
////        kickBoxer.saveInBackground( new SaveCallback() {
////            @Override
////            public void done(ParseException e) {
////                if(e== null)
////                {
////                    Toast.makeText( signup.this, "John is saved to the server", Toast.LENGTH_SHORT ).show();
////                }
////            }
////        } );
//
//    }

    @Override
    public void onClick(View v) {

        try {
            final ParseObject kickBoxer = new ParseObject( "kickBoxer" );
            kickBoxer.put( "name", edtName.getText().toString() );
            kickBoxer.put( "puchSpeed", Integer.parseInt( edtPunchSpeed.getText().toString() ) );
            kickBoxer.put( "kickPower", Integer.parseInt( edtKickPower.getText().toString() ) );
            kickBoxer.put( "kickSpeed", edtKickSpeed.getText().toString() );

            kickBoxer.saveInBackground( new SaveCallback() {
                @Override
                public void done(ParseException e) {

                    if (e == null) {
                        FancyToast.makeText( signup.this, kickBoxer.get( "name" ) + "is saved", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();
                    } else {
                        FancyToast.makeText( signup.this, kickBoxer.get( "name" ) + "is not saved", FancyToast.LENGTH_LONG, FancyToast.ERROR, true ).show();

                    }
                }
            } );
        }
            catch(Exception e)
            {
                FancyToast.makeText( signup.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true ).show();

            }


    }
}
