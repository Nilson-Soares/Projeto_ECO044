package aplicativo.unifei.edu.br.aplicativo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PersonalizadoFragment extends Fragment {
    public static PersonalizadoFragment newInstance() {
        return new PersonalizadoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personalizado, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_personalizado_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Personalizado1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Personalizado2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Personalizado3));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO: criar e exibir o fragmento selecionado
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }
}