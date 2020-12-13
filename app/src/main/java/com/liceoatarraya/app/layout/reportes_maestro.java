package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liceoatarraya.app.R;

public class reportes_maestro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes_maestro);
    }

    public void onReportClick(View v){
        switch (v.getId()){
            case R.id.lyAttendanceReport:
                launchViewer("http://www.google.com", "Reporte de Asistencias por Grado");
                break;
            case R.id.lySScoreReport:
                launchViewer("https://stackoverflow.com", "Reporte de Calificaciones por Materia");
                break;
            case R.id.lyCScoreReport:
                launchViewer("https://www.geeksforgeeks.org/", "Reporte de Calificaciones por Grado");
                break;
            case R.id.lySTScoreReport:
                launchViewer("https://developer.android.com", "Reporte de Calificaciones por Estudiantes");
                break;
            case R.id.lyBehaviorReport:
                launchViewer("https://github.com", "Reporte de Conducta por Alumno");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void launchViewer(String url, String title) {
        Intent intent = new Intent(this, ReportViewerActivity.class);
        intent.putExtra("URL", url);
        intent.putExtra("TITLE", title);
        startActivity(intent);
    }


}