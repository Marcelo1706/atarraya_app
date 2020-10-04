package com.liceoatarraya.app.layout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.liceoatarraya.app.R;
import com.liceoatarraya.app.cerrarApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;

public class menuNavegacion extends AppCompatActivity {
   /* EditText date_in;
    ImageView ivFotoperfil;
    Button Btnseleccionarfoto;
    Button Btntomarfoto;
    Uri imagenUri;
    int TOMAR_FOTO=100;
    int SELECT_IMAGEN=200;
    String CARPETA_RAIZ="MisFotosAtaraya";
    String CARPETA_IMAGENES="imagenes";
    String RUTA_IMAGEN= CARPETA_RAIZ + CARPETA_IMAGENES;
    String path;*/


    BottomNavigationView mbottomNavigationView;
    private AppBarConfiguration mAppBarConfiguration;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_navegacion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.mensajes, R.id.notificaciones, R.id.perfil, R.id.menu, R.id.salir)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        /*
        CÓDIGOS PARA MENU INFERIOR
         */
        mbottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //IF PARA CONTROLAR HACIA QUE ACTIVITY ME DEBE ENVIAR AL UTILIZAR EL MENU INFERIOR
                if (item.getItemId() == R.id.menu_aulavirtual) {
                    startActivity(new Intent(getApplicationContext(), aulavirtual_activity.class));
                    overridePendingTransition(0, 0);
                    return true;

                }
                if (item.getItemId() == R.id.menu_calendario) {
                    startActivity(new Intent(getApplicationContext(), calendario_activity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                if (item.getItemId() == R.id.menu_calificaciones) {
                    startActivity(new Intent(getApplicationContext(), calificaciones_activity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return true;
            }
        });
        /*COD PARA CAMBIAR FOTO PERFIL
        ivFotoperfil=findViewById(R.id.iv_fotoperfil);
        Btnseleccionarfoto=findViewById(R.id.btn_seleccionarfoto);
        Btntomarfoto=findViewById(R.id.btn_tomarfoto);
        if (ContextCompat.checkSelfPermission(menuNavegacion.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(menuNavegacion.this,
                    new String[]{Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }
        Btntomarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarfoto();
            }
        });
        Btnseleccionarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarImagen();
            }
        });*/

        /*DESCOMENTAR ESTA PARTE PARA REVISAR EL ERROR DEL DATEPICKER
        //Cod para el datepicker del menu
        date_in=findViewById(R.id.date_input);
        date_in.setInputType(InputType.TYPE_NULL);

        date_in.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });
        //Fin del Cod para el datepicker
         */

    }


    /*METODO DEL DATEPICKER
        private void showDateDialog(final EditText date_in) {
            final Calendar calendar= Calendar.getInstance();
            DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(Calendar.YEAR,year);
                    calendar.set(Calendar.MONTH,month);
                    calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yy");
                    date_in.setText(simpleDateFormat.format(calendar.getTime()));
                }
            };
            new DatePickerDialog(menuNavegacion.this,dateSetListener,calendar.get(calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

        }
        */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navegacion, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //metodo onclick de opcion salir en navigation drawer
    public void onclick(MenuItem item) {
        mostrarDialogoSalir();
    }

    private void mostrarDialogoSalir() {
        DialogFragment dialogo=new cerrarApp();
        dialogo.show(getSupportFragmentManager(),"salirapp");
    }
    /*public void tomarfoto() {
        String nombreImagen="";
        File fileImagen = new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);
        boolean isCreada = fileImagen.exists();
        if (isCreada==false){
            isCreada=fileImagen.mkdirs();
        }
        if (isCreada==true){
            nombreImagen=(System.currentTimeMillis()/1000)+".jpg";
        }
        path=Environment.getExternalStorageDirectory()+File.separator+RUTA_IMAGEN+File.separator+nombreImagen;
        File imagen = new File (path);
        Intent intent = null;
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            String authorities=this.getPackageName()+".provider";
            Uri imagenUri = FileProvider.getUriForFile(this,authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imagenUri);
        }else{
            intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(imagen));
        }
        startActivityForResult (intent, TOMAR_FOTO);
    }

    public void seleccionarImagen(){
        Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galeria,SELECT_IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK && requestCode==SELECT_IMAGEN){
            imagenUri=data.getData();
            ivFotoperfil.setImageURI(imagenUri);
        }else if (resultCode == RESULT_OK && requestCode ==TOMAR_FOTO){
            MediaScannerConnection.scanFile(menuNavegacion.this, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                @Override
                public void onScanCompleted(String path, Uri uri) {

                }
            });
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            ivFotoperfil.setImageBitmap(bitmap);
        }

    }*/
}
