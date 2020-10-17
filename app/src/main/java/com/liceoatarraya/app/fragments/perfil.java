package com.liceoatarraya.app.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.layout.menuNavegacion;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class perfil extends Fragment {
    ImageView ivFotoperfil;
    Button Btnseleccionarfoto;
    Button Btntomarfoto;
    Uri imagenUri;
    int TOMAR_FOTO=100;
    int SELECT_IMAGEN=200;
    String CARPETA_RAIZ="MisFotosAtaraya";
    String CARPETA_IMAGENES="imagenes";
    String RUTA_IMAGEN= CARPETA_RAIZ + CARPETA_IMAGENES;
    String path;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static perfil newInstance(String param1, String param2) {
        perfil fragment = new perfil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //COD PARA CAMBIAR FOTO PERFIL
        ivFotoperfil= ivFotoperfil.findViewById(R.id.iv_fotoperfil);
        Btnseleccionarfoto=Btnseleccionarfoto.findViewById(R.id.btn_seleccionarfoto);
        Btntomarfoto=Btntomarfoto.findViewById(R.id.btn_tomarfoto);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
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
        });
    }

    private void seleccionarImagen() {
        Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galeria,SELECT_IMAGEN);
    }

    private void tomarfoto() {
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
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.N){
            String authorities=getActivity().getPackageName()+".provider";
            Uri imagenUri = FileProvider.getUriForFile(getActivity(),authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imagenUri);
        }else{
            intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(imagen));
        }
        startActivityForResult (intent, TOMAR_FOTO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==SELECT_IMAGEN){
            imagenUri=data.getData();
            ivFotoperfil.setImageURI(imagenUri);
        }else if (resultCode == RESULT_OK && requestCode ==TOMAR_FOTO){
            MediaScannerConnection.scanFile(getActivity(), new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                @Override
                public void onScanCompleted(String path, Uri uri) {

                }
            });
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            ivFotoperfil.setImageBitmap(bitmap);
        }
    }
}