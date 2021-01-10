package com.liceoatarraya.app.layout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liceoatarraya.app.R;
import com.liceoatarraya.app.cerrarApp;

public class calendario_maestro extends AppCompatActivity implements CalendarView.OnDateChangeListener {
 BottomNavigationView calbottomNavigationView;
 private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario_maestro);
        setTitle("Calendario");
        //== Instanciando el calendario para la opción de agenda
        calendarView=(CalendarView)findViewById(R.id.cal_maestro);
        calendarView.setOnDateChangeListener((CalendarView.OnDateChangeListener) this);
        calbottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv_calendario);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumaestro,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_maestro:
                Intent intent = new Intent (getApplicationContext(), principal_maestro.class);
                startActivityForResult(intent, 0);
                return  true;
            case R.id.calendario_maestro:
                return  true;
            case R.id.aula_virtual_maestro:
                Intent intent3 = new Intent (getApplicationContext(), aulavirtual_maestro.class);
                startActivityForResult(intent3, 0);
                return  true;
            case R.id.menu_maestro:
                Intent intent2 = new Intent (getApplicationContext(), menu_maestro.class);
                startActivityForResult(intent2, 0);
                return  true;
            case R.id.exit_maestro:
                DialogFragment dialogo=new cerrarApp();
                dialogo.show(getSupportFragmentManager(),"salirapp");
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

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