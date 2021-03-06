package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.helpers.Variables;

import java.io.File;
import java.util.Objects;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.os.Environment.getExternalStorageDirectory;

public class Login extends AppCompatActivity {
    EditText usuario;
    EditText contra;
    Spinner rol;

    private static final int MIS_PERMISOS = 100;
    private SharedPreferences myPreferences;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ocultar barra de título
        Objects.requireNonNull(getSupportActionBar()).hide();
        checkIfNomediaExist();

        //Solicitud de Permisos
        myPreferences = PreferenceManager.getDefaultSharedPreferences(com.liceoatarraya.app.layout.Login.this);

        solicitaPermisosVersionesSuperiores();

        usuario=(EditText)findViewById(R.id.numUsuario);
        contra = (EditText) findViewById(R.id.etPassLogin);
        rol = (Spinner) findViewById(R.id.spRol);
        String []opciones={"maestro","alumno","administrativo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        rol.setAdapter(adapter);
        Button btn = (Button) findViewById(R.id.loginButton);
        btn.setOnClickListener(v -> lanzarsegunrol());
    }
    private void lanzarsegunrol() {
        usuario=(EditText)findViewById(R.id.numUsuario);
        contra = (EditText) findViewById(R.id.etPassLogin);
        rol = (Spinner) findViewById(R.id.spRol);
        int position = (Integer) rol.getSelectedItemPosition();
        if (position==0){
            //0== maestro
            Intent intent = new Intent (getApplicationContext(), principal_maestro.class);
            startActivityForResult(intent, 0);
        }else
        if (position==1){
            //1== alumno
            Intent intent = new Intent (getApplicationContext(), menuNavegacion.class);
            startActivityForResult(intent, 0);
        }else
        if (position==2){
            //2 == admin
            Intent intent = new Intent (getApplicationContext(), dasboard_modAdmin.class);
            startActivityForResult(intent, 0);
        }
    }

    /**
     * Proceso de peticion de permisos del telefono
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void solicitaPermisosVersionesSuperiores() {
        boolean permisosPedidos;

        permisosPedidos = myPreferences.getBoolean("permisosPedidos", false);

        //validamos si los permisos ya fueron aceptados
        if((getApplicationContext().checkSelfPermission(WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)&&
                (getApplicationContext().checkSelfPermission(CAMERA)==PackageManager.PERMISSION_GRANTED) &&
                (getApplicationContext().checkSelfPermission(ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED) &&
                (getApplicationContext().checkSelfPermission(ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)){
            return;
        }

        if (!(shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)&&shouldShowRequestPermissionRationale(CAMERA)&&
                shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)&&shouldShowRequestPermissionRationale(ACCESS_COARSE_LOCATION)) && permisosPedidos){
            getPermissionsManually();
        }else{
            showRecomendationPermissionsDialog();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ShowToast")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(!(myPreferences.getBoolean("permisosPedidos", false)))
        {
            SharedPreferences.Editor myEditor = myPreferences.edit();
            myEditor.putBoolean("permisosPedidos", true);
            myEditor.apply();
        }
        if (requestCode == MIS_PERMISOS){
            if(grantResults.length==4 && grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED &&
                    grantResults[2]==PackageManager.PERMISSION_GRANTED && grantResults[3]==PackageManager.PERMISSION_GRANTED){//el dos representa los 2 permisos
                Toast.makeText(getApplicationContext(),"Permisos aceptados",Toast.LENGTH_SHORT);
            }
            else
                solicitaPermisosVersionesSuperiores();
        }else{
            getPermissionsManually();
        }
    }

    /**
     * Obtenemos los permisos de forma manual
     */
    private void getPermissionsManually() {
        final CharSequence[] opciones={"si","no"};
        AlertDialog.Builder alertOpciones=new AlertDialog.Builder(this);//estamos en fragment
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual? ");
        //alertOpciones.setMessage("Recuerde que estos permisos son NECESARIOS para el correcto funcionamiento de Quickly");
        alertOpciones.setItems(opciones, (dialogInterface, i) -> {
            if (opciones[i].equals("si")){
                Intent intent=new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri=Uri.fromParts("package",getApplicationContext().getPackageName(),null);
                intent.setData(uri);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
            finish();
        });
        alertOpciones.setCancelable(false);

        alertOpciones.show();

    }

    /**
     * Mostramos dialogo de recomendacion al usuario para que active los permisos
     */
    private void showRecomendationPermissionsDialog() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", (dialogInterface, i) -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION,WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        });
        dialogo.setCancelable(false);
        dialogo.show();
    }

    public static String  checkIfNomediaExist(){

        File route = new File(Variables.tempsPictures);
        if (route.exists()){
            return route.getPath();
        }else{
            File nomedia = new File(getExternalStorageDirectory()+"/Android/Atarraya/", ".nomedia");
            nomedia.mkdirs();
            File tempsPics = new File(getExternalStorageDirectory()+"/Android/Atarraya/.nomedia", "tempPicture");
            tempsPics.mkdirs();
            return Variables.tempsPictures;
        }
    }
}