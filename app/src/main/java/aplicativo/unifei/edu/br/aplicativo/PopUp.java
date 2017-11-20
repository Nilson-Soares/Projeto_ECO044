package aplicativo.unifei.edu.br.aplicativo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class PopUp extends DialogFragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private EditText editTextNome;
    private EditText editTextDescricao;
    //private EditText data;
    //private EditText hora;
    private DatePickerDialog calendario;
    private TimePickerDialog horario;
    private Button data;
    private Button hora;
    private String Nome, Descricao;

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

        calendario = new DatePickerDialog(getContext(), PopUp.this, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        horario = new TimePickerDialog(getContext(), PopUp.this, Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), true);

        Button cancel;
        cancel = (Button)view.findViewById(R.id.button_cancelar);

        Button salvar;
        salvar = (Button) view.findViewById(R.id.button_salvar);

        data = (Button) view.findViewById(R.id.buttonData);

        hora = (Button) view.findViewById(R.id.buttonHora);

        // Get field from view
        editTextNome = (EditText) view.findViewById(R.id.edit_text_popup_nome);
        // Get field from view
        editTextDescricao = (EditText) view.findViewById(R.id.edit_ext_popup_descricao);

        //editTextDescricao = (EditText) view.findViewById(R.id.editTextData);

        //editTextDescricao = (EditText) view.findViewById(R.id.editTextHora);

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

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendario.show();
            }
        });
        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                horario.show();
            }
        });

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

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        String dataTarefa;
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        dataTarefa = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR);
        data.setText(dataTarefa);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int h, int min) {
        String horaTarefa;
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, h);
        c.set(Calendar.MINUTE, min);
        horaTarefa = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE);
        hora.setText(horaTarefa);
    }
}