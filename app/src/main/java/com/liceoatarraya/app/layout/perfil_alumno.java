package com.liceoatarraya.app.layout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.liceoatarraya.app.R;

public class perfil_alumno extends AppCompatActivity {
    ImageView fotoperfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_alumno);
        fotoperfil = findViewById(R.id.imv_fotoperfil);
    }

    public void onClick(View view) {
        subirfotoperfil();
    }

    private void subirfotoperfil() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicación"),10);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri path = data.getData();
            fotoperfil.setImageURI(path);

        } else {
            Toast.makeText(this, "IMAGEN NO SELECCIONADA", Toast.LENGTH_SHORT).show();
        }
    }
}