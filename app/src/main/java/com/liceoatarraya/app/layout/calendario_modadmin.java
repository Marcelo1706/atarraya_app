package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import com.liceoatarraya.app.R;

public class calendario_modadmin extends AppCompatActivity implements CalendarView.OnDateChangeListener {
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_modadmin);
        setTitle("Calendario / Agenda");

        //== Instanciando el calendario para la opción de agenda

        calendarView=(CalendarView)findViewById(R.id.calendar_admin);
        calendarView.setOnDateChangeListener((CalendarView.OnDateChangeListener) this);
    }
    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        CharSequence []items=new CharSequence[3];
        items[0]="Agregar evento";
        items[1]="Ver Eventos";
        items[2]="Cancelar";
        final int dia, mes, anio;
        dia=dayOfMonth;
        mes=month;
        anio=year;
        builder.setTitle("Seleccione una tarea")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (i==0){
                            //actividad agregar eventos
                            Intent intent=new Intent(getApplication(),agregarEventos.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("dia",dia);
                            bundle.putInt("mes",mes);
                            bundle.putInt("anio",anio);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }else if(i==1){
                            //ver eventos
                            Intent intent=new Intent(getApplication(),ver_eventos_calendario.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("dia",dia);
                            bundle.putInt("mes",mes);
                            bundle.putInt("anio",anio);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }else{
                            return;
                        }
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}