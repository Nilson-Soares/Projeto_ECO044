package aplicativo.unifei.edu.br.aplicativo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PrincipalFragment extends Fragment {
    private ArrayList<Tarefa> todas = new ArrayList<Tarefa>();
    private ArrayList<Tarefa> urgentes = new ArrayList<Tarefa>();
    private ArrayList<Tarefa> normais = new ArrayList<Tarefa>();
    ListView itemsListView;
    MyArrayAdapter adapter;
    Tarefa tarefa;

    public static PrincipalFragment newInstance() {
        return new PrincipalFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_principal, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*Tarefa tarefa= new Tarefa("Nome1", "Descricao1");
        tarefas.add(tarefa);
        tarefa = new Tarefa("Nome2", "Descricao2");
        tarefas.add(tarefa);*/

        //criação da lista
        //cria um objeto adapter para o ArrayList
        //configura o adapter para a ListView
        tarefa= new Tarefa("Todas1", "Descricao1");
        todas.add(tarefa);
        tarefa = new Tarefa("Todas2", "Descricao2");
        todas.add(tarefa);
        tarefa= new Tarefa("Urgentes1", "Descricao1");
        urgentes.add(tarefa);
        tarefa = new Tarefa("Urgentes2", "Descricao2");
        urgentes.add(tarefa);
        tarefa= new Tarefa("Normais1", "Descricao1");
        normais.add(tarefa);
        tarefa = new Tarefa("Normais", "Descricao2");
        normais.add(tarefa);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_principal_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Todas));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Urgentes));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Normais));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO: criar e exibir o fragmento selecionado
                int numTab = tab.getPosition();
                switch (numTab){
                    case 0:
                        itemsListView = (ListView) view.findViewById(R.id.list_view_items);
                        adapter = new MyArrayAdapter(getContext(), todas);
                        itemsListView.setAdapter(adapter);
                        break;
                    case 1:
                        /*ArrayList<Tarefa> tarefas2 = new ArrayList<Tarefa>();
                        Tarefa tarefa2= new Tarefa("Nome1", "Descricao1");
                        tarefas2.add(tarefa2);
                        tarefa2 = new Tarefa("Nome3", "Descricao2");
                        tarefas2.add(tarefa2);

                        //criação da lista
                        ListView itemsListView2 = (ListView) view.findViewById(R.id.list_view_items);
                        //cria um objeto adapter para o ArrayList
                        MyArrayAdapter adapter2 = new MyArrayAdapter(getContext(), tarefas2);
                        //configura o adapter para a ListView
                        itemsListView2.setAdapter(adapter2);*/
                        itemsListView = (ListView) view.findViewById(R.id.list_view_items);
                        adapter = new MyArrayAdapter(getContext(), urgentes);
                        itemsListView.setAdapter(adapter);
                        break;
                    case 2:
                        itemsListView = (ListView) view.findViewById(R.id.list_view_items);
                        adapter = new MyArrayAdapter(getContext(), normais);
                        itemsListView.setAdapter(adapter);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }
}