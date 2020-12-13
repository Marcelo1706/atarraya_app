package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.liceoatarraya.app.R;

public class ReportViewerActivity extends AppCompatActivity {

    TextView tvReportViewerTitle;
    WebView wvReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_viewer);

        tvReportViewerTitle = findViewById(R.id.tvReportViewerTitle);
        wvReport = findViewById(R.id.wvReport);

        Intent intent = getIntent();
        tvReportViewerTitle.setText(intent.getStringExtra("TITLE"));
        wvReport.loadUrl(intent.getStringExtra("URL"));
    }
}