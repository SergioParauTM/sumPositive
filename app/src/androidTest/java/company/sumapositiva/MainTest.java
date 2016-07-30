package company.sumapositiva;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sergio on 02/02/2016.
 */
public class MainTest extends ActivityInstrumentationTestCase2<MainActivity> {

        MainActivity activity;
        EditText segundonum;
        EditText primernum;
        TextView total;

        public MainTest() {
        super(MainActivity.class);
        }

public void setUp() throws Exception{
        activity = getActivity();
        }

public void testPreconditions() {
        assertNotNull(activity);

        }


        public void testEditTextOne() {
                primernum = (EditText) activity.findViewById(R.id.primernum);
                getInstrumentation().runOnMainSync(new Runnable() { //lanzar primer thread de la aplicacion
                        @Override
                        public void run() {
                                primernum.requestFocus();


                        }
                });

                getInstrumentation().sendStringSync("10");//añadir texto al editText

        }



        public void testEditTextTwo() {
               segundonum = (EditText) activity.findViewById(R.id.segundonum);
                getInstrumentation().runOnMainSync(new Runnable() { //lanzar primer thread de la aplicacion
                        @Override
                        public void run() {
                                segundonum.requestFocus();


                        }
                });
                getInstrumentation().sendStringSync("10");//añadir texto al editText
        }



        public void testApp() {
                testEditTextOne();
                testEditTextTwo();

                Button operador = (Button) activity.findViewById(R.id.operador);

                TouchUtils.clickView(this, operador); //hacer clic al boton





                total = (TextView) activity.findViewById(R.id.total);

                String b= total.getText().toString();

                assertEquals("20", b);


        }





}



