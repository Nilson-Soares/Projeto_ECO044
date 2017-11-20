package aplicativo.unifei.edu.br.aplicativo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PopUp extends DialogFragment {

    private EditText editTextNome;
    private EditText editTextDescricao;
    private String Nome, Descricao;
    private Button cancel, salvar;

    public PopUp() { }

    public static PopUp newInstance() {
        PopUp popUp = new PopUp();
        return popUp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.popup, container);
    }
    @Override
    public void onResume() {
        // Get existing layout params for the window
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        // Assign window properties to fill the parent
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        // Call super onResume after sizing
        super.onResume();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Botão cancelar;
        cancel = (Button)view.findViewById(R.id.button_cancelar);
        //Botão salvar
        salvar = (Button) view.findViewById(R.id.button_salvar);

        // Nome da tarefa
        editTextNome = (EditText) view.findViewById(R.id.edit_text_popup_nome);
        // Descrição da tarefa
        editTextDescricao = (EditText) view.findViewById(R.id.edit_ext_popup_descricao);

        // Show soft keyboard automatically and request focus to field
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        editTextNome.requestFocus();

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.Prioridades, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nome = editTextNome.getText().toString();
                Descricao = editTextDescricao.getText().toString();
                dismiss();
            }
        });
    }


}