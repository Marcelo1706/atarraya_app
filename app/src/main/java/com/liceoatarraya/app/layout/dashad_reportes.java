package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liceoatarraya.app.R;

public class dashad_reportes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashad_reportes);
    }
    public void onReportClick(View v){
        switch (v.getId()){
            case R.id.lyAttendanceReport:
                launchViewer("https://www.google.com", "Reporte de Asistencias por Grado");
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