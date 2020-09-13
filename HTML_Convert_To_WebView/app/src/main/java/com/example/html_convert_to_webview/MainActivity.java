package com.example.html_convert_to_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import static com.example.html_convert_to_webview.R.id.webviewid;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    String Mywebview="<h1> This Is Heading 1 </h1>\n" +
                     "<h2> This Is Heading 2 </h2>\n" +
                     "<h3> This Is Heading 3 </h3>\n" +
                     "<p> This Is Paragraph </p>\n" +
                     "<p> <u> This Is Paragraph </u> </p>\n" +
                     "<p> <u> This Is using underline </u> </p>\n" +
                     "<p> <b> This Is using bold text </b> </p>\n" +
                     "<p> <i> This Is using italic text </i> </p>\n" +
                     "Programing language Order list ...\n" +
                     "<ol>\n" +
                     "<li> C </li>\n"+
                     "<li> C++ </li>\n"+
                     "<li> Java </li>\n"+
                     "</ol>\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview= (WebView)findViewById(R.id.webviewid);
        webview.loadDataWithBaseURL(null,Mywebview,"text/html","utf-8",null);
    }
}