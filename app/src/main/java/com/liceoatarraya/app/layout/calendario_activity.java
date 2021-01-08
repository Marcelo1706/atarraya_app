package com.liceoatarraya.app.layout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liceoatarraya.app.R;

public class calendario_activity extends AppCompatActivity implements CalendarView.OnDateChangeListener {
 BottomNavigationView calbottomNavigationView;
 private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario_activity);
        setTitle("Calendario");
        //== Instanciando el calendario para la opción de agenda
        calendarView= findViewById(R.id.cal_alumno);
        calendarView.setOnDateChangeListener(this);
        calbottomNavigationView= findViewById(R.id.bnv_calendario);
        calbottomNavigationView.setSelectedItemId(R.id.menu_calendario);
        calbottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            //IF PARA CONTROLAR HACIA QUE ACTIVITY ME DEBE ENVIAR AL UTILIZAR EL MENU INFERIOR
            if (item.getItemId()==R.id.menu_aulavirtual){
                startActivity(new Intent(getApplicationContext(), aulavirtual_activity.class));
                overridePendingTransition(0,0);
                return  true;

            }
            if (item.getItemId()==R.id.menu_home){
                startActivity(new Intent(getApplicationContext(), menuNavegacion.class));
                overridePendingTransition(0,0);
                return  true;
            }
            if (item.getItemId()==R.id.menu_calificaciones){
                startActivity(new Intent(getApplicationContext(), calificaciones_activity.class));
                overridePendingTransition(0,0);
                return  true;
            }
            return true;
        });
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