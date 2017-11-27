package aplicativo.unifei.edu.br.aplicativo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ListView itemsListView;
    private MyArrayAdapter adapter;
    private NavigationView navigationView;
    private  Toolbar toolbar;
    private  FloatingActionButton fab;
    private  DrawerLayout drawer;
    private  ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //verifica se o apricativo possui configurações salvas
        if (savedInstanceState == null) {
            //navigationView.setCheckedItem(R.id.nav_principal);
            exibirFragmentPrincipal();
        }
        //cria o NavigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        //configura o Listener para os itens da NavigationView
        navigationView.setNavigationItemSelectedListener(this);

        //cria a Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //adiciona support
        setSupportActionBar(toolbar);

        //instancia o botão flutuante
        fab = (FloatingActionButton) findViewById(R.id.fab);
        //adiciona o Listener ao botão flutuante
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();
            }
        });

        //instancia o DrawerLayout
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //instancia a ActionBar
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //Listener para ActionBar
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }
    //implementa a interface do Listener para a NavigationView
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //configura a posição do drawer
        drawer.closeDrawer(GravityCompat.START);
        //verifica qual item selecionado no drawer
        switch (item.getItemId()) {
            case R.id.nav_principal:
                exibirFragmentPrincipal();//exibe o fragment Principal
                break;
            case R.id.nav_personalizado:
                exibirFragmentPersonalizado();//exibe o fragment Personalizado
                break;
            case R.id.nav_feitas:
                exibirFragmentFeitas();//exibe o fragment Feitas
                break;
        }
        return true;
    }
    //método responsável por exibir o fragment principal
    private void exibirFragmentPrincipal() {
        Fragment novoFragment = PrincipalFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_conteudo, novoFragment).commit();
    }
    //metodo responsável por exibir o fragment personalizado
    private void exibirFragmentPersonalizado() {
        Fragment novoFragment = PersonalizadoFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteudo, novoFragment)
                .commit();
    }
    //método responsável por exibir o fragment feita
    private void exibirFragmentFeitas() {
        Fragment novoFragment = FeitasFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteudo, novoFragment)
                .commit();
    }
    //método responsável por exibir o popup
    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        PopUp popUp = PopUp.newInstance();
        popUp.show(fm, "fragment_edit_name");
    }
}