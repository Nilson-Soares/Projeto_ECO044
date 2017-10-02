package aplicativo.unifei.edu.br.aplicativo;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_principal);
            exibirFragmentPrincipal();

        } if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_personalizado);
            exibirFragmentPrincipal();

        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Trate os eventos de navegação aqui

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);



        switch (item.getItemId()) {
            case R.id.nav_principal:
                exibirFragmentPrincipal();
                break;
            case R.id.nav_personalizado:
                exibirFragmentPersonalizado();
                break;
        }
        return true;
    }
    private void exibirFragmentPrincipal() {
        Fragment novoFragment = PrincipalFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteudo, novoFragment)
                .commit();
    }
    private void exibirFragmentPersonalizado() {
        Fragment novoFragment = PersonalizadoFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteudo, novoFragment)
                .commit();
    }

}