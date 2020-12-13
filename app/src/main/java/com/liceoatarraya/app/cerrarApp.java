package com.liceoatarraya.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class cerrarApp extends DialogFragment{

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder
                    .setMessage(R.string.mensajePregunta)
                    .setTitle(R.string.tituloMensajeSalida)
                    .setPositiveButton(R.string.opcionSi, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            CerrarApp();
                        }
                    })
                    .setNegativeButton(R.string.opcionNo, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dismiss();
                        }
                    });

            return builder.create();
        }

        public void CerrarApp() {
            getActivity().finishAffinity();
            getActivity().moveTaskToBack(true);
        }
    }

