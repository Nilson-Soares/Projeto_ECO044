package aplicativo.unifei.edu.br.aplicativo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PrincipalFragment extends Fragment {
    ListView itemsListView, lista;

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

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_principal_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Todas));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Urgentes));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Normais));

        final BancoController crud = new BancoController(getContext());
        final Cursor[] cursor = {crud.carregaDados()};

        final String[] nomeCampos = new String[] {CriaBanco.NOME, CriaBanco.DESCRICAO};
        final int[] idViews = new int[] {R.id.nome_tarefa, R.id.descricao_tarefa};

        final SimpleCursorAdapter[] adaptador = {new SimpleCursorAdapter(getContext(),
                R.layout.item_lista, cursor[0], nomeCampos, idViews, 0)};

        lista = (ListView) view.findViewById(R.id.list_view_items);
        lista.setAdapter(adaptador[0]);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO: criar e exibir o fragmento selecionado
                int numTab = tab.getPosition();
                switch (numTab){
                    case 0:
                        cursor[0] = crud.carregaDados();
                        adaptador[0] = new SimpleCursorAdapter(getContext(),
                                R.layout.item_lista, cursor[0],nomeCampos,idViews, 0);
                        lista.setAdapter(adaptador[0]);
                        break;
                    case 1:
                        cursor[0] = crud.carregaDados();
                        adaptador[0] = new SimpleCursorAdapter(getContext(),
                                R.layout.item_lista, cursor[0],nomeCampos,idViews, 0);
                        lista.setAdapter(adaptador[0]);
                        break;
                    case 2:
                        cursor[0] = crud.carregaDados();
                        adaptador[0] = new SimpleCursorAdapter(getContext(),
                                R.layout.item_lista, cursor[0],nomeCampos,idViews, 0);
                        lista.setAdapter(adaptador[0]);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int numTab = tab.getPosition();
                switch (numTab){
                    case 0:
                        cursor[0] = crud.carregaDados();
                        adaptador[0] = new SimpleCursorAdapter(getContext(),
                                R.layout.item_lista, cursor[0],nomeCampos,idViews, 0);
                        lista.setAdapter(adaptador[0]);
                        break;
                    case 1:
                        cursor[0] = crud.carregaDados();
                        adaptador[0] = new SimpleCursorAdapter(getContext(),
                                R.layout.item_lista, cursor[0],nomeCampos,idViews, 0);
                        lista.setAdapter(adaptador[0]);
                        break;
                    case 2:
                        cursor[0] = crud.carregaDados();
                        adaptador[0] = new SimpleCursorAdapter(getContext(),
                                R.layout.item_lista, cursor[0],nomeCampos,idViews, 0);
                        lista.setAdapter(adaptador[0]);
                        break;
                }
            }
        });
    }
}