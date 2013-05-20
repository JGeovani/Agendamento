package br.geovani.agendamento;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Formulario extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		/*
		 * Nesta versão não será gravado em banco de dados SQLite
		 * os dados de cadastro, mas será apresentado apenas uma 
		 * mensagem descrita a seguir.
		 */
		Button cadastrarButton = (Button) findViewById(R.id.btCadastrar);
		cadastrarButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(Formulario.this, 
							   "Cadastro realizado com sucesso!", 
							   Toast.LENGTH_SHORT).show();
			}
		});
	}
}
