package br.geovani.agendamento;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaContatos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);
		
		List<String> contatos = 
				Arrays.asList("Contato1", "Contato2", "Contato3");
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos);
		
		final ListView listaContatos = (ListView) findViewById(R.id.listaContatos);
		listaContatos.setAdapter(adapter);
		/*
		 * Evento causado pelo clique do usu�rio nenhum item da lista
		 */
		listaContatos.setClickable(true);
		listaContatos.setOnItemClickListener(new OnItemClickListener() {
			/*
			 * Mostra uma mensagem r�pida quando um item da 
			 * lista de contatos � clicado (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,
					long id) {
				Toast.makeText(
						ListaContatos.this, 
						"Voc� selecionou o " + (posicao + 1) + "� contato", 
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
		/*
		 * LongClick: � adicionado a lista de alunos mais um listener via classe an�nima		
		 */
		listaContatos.setLongClickable(true);
		listaContatos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) { // � no onItemLongClick onde deve registrar
				registerForContextMenu(listaContatos); // Registra o menu de contexto
				return false; // Deve retornar false para que o longclick seja consumido
			}
		});
	}

	/*
	 * Cria um menu com o bot�o "Novo Cadastro" 
	 * para adicionar um novo contato na lista(non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem novoContato = menu.add(0, 0, 0, "Novo Contato");
		novoContato.setIcon(R.drawable.novo); // � posto no bot�o menu o �cone e o seu nome
		return true; // � necess�rio retornar true para que o menu seja vis�vel
	}

	/*
	 * Evento trata o clique no menu "Novo Contato" indo da tela 
	 * ListaContatos para Formulario (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 0) {
			startActivity(new Intent(this, Formulario.class));
		}
		return false; // devolve false para que o m�todo termine o processo da sele��o
	}

	
	/**
	 * Menu de Contexto
	 */
	@Override // M�todo de Tratamento
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}
	
	@Override // M�todo de Apresenta��o, que nos d� conforto ao tratar um �tem especifico
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
