package company.sumapositiva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText primernum;
    EditText segundonum;
    Button operador;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        primernum = (EditText) findViewById(R.id.primernum);
        segundonum =(EditText)findViewById(R.id.segundonum);
        operador = (Button)findViewById(R.id.operador);
        total=(TextView)findViewById(R.id.total);

            operador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(primernum.getText().toString().startsWith("-")){

                        Toast.makeText(getApplication(),"ha introducido numeros negativos",Toast.LENGTH_SHORT).show();
                    }else{

                        int p = Integer.parseInt(primernum.getText().toString());
                        int s = Integer.parseInt(segundonum.getText().toString());
                        int suma = p + s;
                        String resultado = String.valueOf(suma);

                        total.setText(resultado);
                    }
                }


            });
        }


    }



