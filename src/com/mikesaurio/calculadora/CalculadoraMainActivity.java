package com.mikesaurio.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraMainActivity extends Activity {

	private TextView pantalla;
	private Button calculadora_btn_0,calculadora_btn_1,calculadora_btn_2,calculadora_btn_3,calculadora_btn_4,calculadora_btn_5,calculadora_btn_6,
	calculadora_btn_7,calculadora_btn_8,calculadora_btn_9,calculadora_btn_mas,calculadora_btn_menos,calculadora_btn_por,calculadora_btn_entre,calculadora_btn_igual,calculadora_btn_borrar;
	private String memoria = null;
	private String tipoOperacion=null;
	private final String SUMA = "1";
	private final String RESTA = "2";
	private final String POR = "3";
	private final String ENTRE = "4";
	private final String IGUAL = "5";
	private String operador= null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculadora_main);
		
		//instancias y escuchas
		
		pantalla =(TextView)findViewById(R.id.calculadora_tv_pantalla);
		
		calculadora_btn_borrar=(Button)findViewById(R.id.calculadora_btn_borrar);
		calculadora_btn_borrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pantalla.setText(getResources().getString(R.string.calculadora_btn_0)); //regresamos a cero la pantalla
				memoria = null;//limpiamos la memoria
				tipoOperacion=null;//indicamos que no hay operaciones pendientes
				operador = null;
				
			}
		});
		
		
		
		calculadora_btn_0=(Button)findViewById(R.id.calculadora_btn_0);
		calculadora_btn_0.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!pantalla.getText().toString().equals("0")){
					if(tipoOperacion!=null){
						pantalla.setText("0");
						if(tipoOperacion.equals(IGUAL)){
							operador=null;
							tipoOperacion=null;
						}else{
							operador=tipoOperacion;
							tipoOperacion=null;
						}
						
					}else{
						pantalla.append("0");
					}
				}
				
			}
		});
		
		calculadora_btn_1=(Button)findViewById(R.id.calculadora_btn_1);
		calculadora_btn_1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ponerNumero("1");
				
			}

			
		});
		
		calculadora_btn_2=(Button)findViewById(R.id.calculadora_btn_2);
		calculadora_btn_2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ponerNumero("2");
				
			}
		});
		
		calculadora_btn_3=(Button)findViewById(R.id.calculadora_btn_3);
		calculadora_btn_3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				ponerNumero("3");
			}
		});
		
		calculadora_btn_4=(Button)findViewById(R.id.calculadora_btn_4);
		calculadora_btn_4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ponerNumero("4");
				
			}
		});
		
		calculadora_btn_5=(Button)findViewById(R.id.calculadora_btn_5);
		calculadora_btn_5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ponerNumero("5");
			}
		});
		
		calculadora_btn_6=(Button)findViewById(R.id.calculadora_btn_6);
		calculadora_btn_6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				ponerNumero("6");
			}
		});
		
		calculadora_btn_7=(Button)findViewById(R.id.calculadora_btn_7);
		calculadora_btn_7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ponerNumero("7");
				
			}
		});
		
		calculadora_btn_8=(Button)findViewById(R.id.calculadora_btn_8);
		calculadora_btn_8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				ponerNumero("8");
			}
		});
		
		calculadora_btn_9=(Button)findViewById(R.id.calculadora_btn_9);
		calculadora_btn_9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ponerNumero("9");
		
			}
		});
		
		calculadora_btn_mas=(Button)findViewById(R.id.calculadora_btn_mas);
		calculadora_btn_mas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				memoria = pantalla.getText().toString();
				tipoOperacion= SUMA;
				
			}
		});
		
		calculadora_btn_menos=(Button)findViewById(R.id.calculadora_btn_menos);
		calculadora_btn_menos.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				memoria = pantalla.getText().toString();
				tipoOperacion=RESTA;
				
			}
		});
		
		calculadora_btn_por=(Button)findViewById(R.id.calculadora_btn_por);
		calculadora_btn_por.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				memoria = pantalla.getText().toString();
				tipoOperacion=POR;
			}
		});
		
		calculadora_btn_entre=(Button)findViewById(R.id.calculadora_btn_entre);
		calculadora_btn_entre.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				memoria = pantalla.getText().toString();
				tipoOperacion=ENTRE;
				
			}
		});
		
		calculadora_btn_igual=(Button)findViewById(R.id.calculadora_btn_igual);
		calculadora_btn_igual.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			if(memoria!=null&&operador!=null)	{
				if(operador.equals(SUMA)){
					pantalla.setText((Integer.parseInt(memoria)+Integer.parseInt(pantalla.getText().toString()))+"");
				}if(operador.equals(RESTA)){
					pantalla.setText((Integer.parseInt(memoria)-Integer.parseInt(pantalla.getText().toString()))+"");
				}if(operador.equals(POR)){
					pantalla.setText((Integer.parseInt(memoria)*Integer.parseInt(pantalla.getText().toString()))+"");
				}if(operador.equals(ENTRE)){
					if(!pantalla.getText().toString().equals("0")){
						pantalla.setText((Integer.parseInt(memoria)/Integer.parseInt(pantalla.getText().toString()))+"");
					}
				}
			}
				tipoOperacion=IGUAL;
				
			}
		});
	}
	
	
	public void ponerNumero(String numero){
		if(pantalla.getText().toString().equals("0")){
			pantalla.setText(numero);
		}else{
			if(tipoOperacion!=null){
				pantalla.setText(numero);
				if(tipoOperacion.equals(IGUAL)){
					operador=null;
					tipoOperacion=null;
				}else{
					operador=tipoOperacion;
					tipoOperacion=null;
				}
			}else{
			pantalla.append(numero);
			}
		}
	}
		
	
}
