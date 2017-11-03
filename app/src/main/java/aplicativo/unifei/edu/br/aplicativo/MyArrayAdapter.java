package aplicativo.unifei.edu.br.aplicativo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom list adapter, implementing BaseAdapter
 */
public class MyArrayAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Tarefa> tarefas;

    public MyArrayAdapter(Context context, ArrayList<Tarefa> tarefas) {
        this.context = context;
        this.tarefas = tarefas;
    }

    @Override
    public int getCount() {
        return tarefas.size(); //returns total item in the list
    }

    @Override
    public Object getItem(int position) {
        return tarefas.get(position); //returns the item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Tarefa tarefaAtual = (Tarefa) getItem(position);
        viewHolder.tarefaNome.setText(tarefaAtual.getNome());
        viewHolder.tarefaDescricao.setText(tarefaAtual.getDescricao());

        return convertView;
    }

    //ViewHolder inner class
    private class ViewHolder {
        TextView tarefaNome;
        TextView tarefaDescricao;

        public ViewHolder(View view) {
            tarefaNome = (TextView)view.findViewById(R.id.nome_tarefa);
            tarefaDescricao = (TextView) view.findViewById(R.id.descricao_tarefa);
        }
    }
}