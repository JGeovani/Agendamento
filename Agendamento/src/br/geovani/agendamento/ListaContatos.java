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
		 * Evento causado pelo clique do usuário nenhum item da lista
		 */
		listaContatos.setClickable(true);
		listaContatos.setOnItemClickListener(new OnItemClickListener() {
			/*
			 * Mostra uma mensagem rápida quando um item da 
			 * lista de contatos é clicado (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,
					long id) {
				Toast.makeText(
						ListaContatos.this, 
						"Você selecionou o " + (posicao + 1) + "ª contato", 
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
		/*
		 * LongClick: é adicionado a lista de alunos mais um listener via classe anônima		
		 */
		listaContatos.setLongClickable(true);
		listaContatos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) { // É no onItemLongClick onde deve registrar
				registerForContextMenu(listaContatos); // Registra o menu de contexto
				return false; // Deve retornar false para que o longclick seja consumido
			}
		});
	}

	/*
	 * Cria um menu com o botão "Novo Cadastro" 
	 * para adicionar um novo contato na lista(non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem novoContato = menu.add(0, 0, 0, "Novo Contato");
		novoContato.setIcon(R.drawable.novo); // É posto no botão menu o ícone e o seu nome
		return true; // É necessário retornar true para que o menu seja visível
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
		return false; // devolve false para que o método termine o processo da seleção
	}

	
	/**
	 * Menu de Contexto
	 */
	@Override // Método de Tratamento
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}
	
	@Override // Método de Apresentação, que nos dá conforto ao tratar um ítem especifico
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
