package com.Moviecreedfull.moviecreedfull1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


import android.content.Context;
import android.content.SharedPreferences;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


import android.app.AlarmManager;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import androidx.core.splashscreen.SplashScreen;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {
    // ok

    private RecyclerView.LayoutManager mLayoutManager;

    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    ClipboardManager clipboardManager;


    private WebView webView;
    private ProgressBar progressBar;
    private Switch toggleButton;
    private FloatingActionButton button;

    private FloatingActionButton back;

    private FloatingActionButton foward;

    private FloatingActionButton home;

    private Dialog dialog;
    private ListView listView;

    EditText name;




    private Switch blockSwitch;

    private SharedPreferences sharedPreferences;

    private FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Handle the splash screen transition.
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Change the title of the ActionBar/Toolbar
        getSupportActionBar().setTitle("Moviecreed1.0");

        mAuth = FirebaseAuth.getInstance();


        // Retrieve the SharedPreferences instance from the Intent
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);







        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        checkDownloadPermission();


        final ArrayList array_list = new ArrayList<>();
        final ArrayList<String> originalList = new ArrayList<>(array_list);


        final ArrayAdapter[] arrayAdapter = {new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, array_list)};

        array_list.add("https://www.sabishare.com/");
        array_list.add("https://www.xproxxx.org/ ");
        array_list.add("https://xproxxx.org/");
        array_list.add(" https://anigogo.net/ ");
        array_list.add("https://ninjashare.to/  ");
        array_list.add(" https://anihdplay.com/ ");
        array_list.add("https://sbembed.com/");
        array_list.add("https://paystack.com/");


        array_list.add("https://pahe.win/");
        array_list.add("https://kwik.cx/");
        array_list.add("https://filemoon.sx/");

        array_list.add("https://safetxt.net/");


        array_list.add("https://eu-11.files.nextcdn.org/");

        array_list.add("https://eu-");
        array_list.add("about:blank");

        array_list.add("https://safetxt.net/");

        array_list.add("https://ratedwap.com/");


        array_list.add("https://dev-moviescreedagain.pantheonsite.io/");

        array_list.add("https://mp4upload.com/");
        array_list.add("https://gotaku1.com/");
        array_list.add("https://9jatechsibs.com/");

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);



        webView = (WebView) findViewById(R.id.web_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        FloatingActionButton fab1 = findViewById(R.id.fab_1);
        FloatingActionButton fab2 = findViewById(R.id.fab_2);
        FloatingActionButton fab3 = findViewById(R.id.fab_3);
        FloatingActionButton fab4 = findViewById(R.id.fab_4);


        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        webView.getSettings().setAllowFileAccess(true);


        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);


        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setOverScrollMode(WebView.OVER_SCROLL_ALWAYS);

//the Chromefooling part
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 10; Pixel 3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.193 Mobile Safari/537.36");





        String savedDate = sharedPreferences.getString("savedDate", "");

        if (hasPassedCurrentDate(savedDate)) {

            Toast.makeText(MainActivity.this, "Plan has expired pay to enable download " + savedDate, Toast.LENGTH_SHORT).show();

        }



        webView.setWebViewClient(new WebViewClient() {


            public boolean shouldOverrideUrlLoading(WebView view, String url) {




                // Check if the URL starts with "https://eu-"
                if (url.toLowerCase().startsWith("https://eu-")) {
                    return false;
                }

              //Domain matchcheck
                if (blockSwitch.isChecked()) {
                    String currentDomain = getCurrentDomain(view.getUrl());
                    String clickedDomain = getClickedDomain(url);
                    // Check if the URL matches the current domain
                    if (getCurrentDomain(url).equals(currentDomain)) {

                        // Allow the URL to load
                        return false;
                    }

                    // Check if the URL matches any of the allowed domains
                    for (Object domain : array_list) {
                        if (getCurrentDomain(url).equals(getCurrentDomain((String) domain))) {
                            // Allow the URL to load
                            return false;
                        }
                    }

                    // Check if the URL is a download link
                    if (isDownloadLink(url)) {
                        // Allow the URL to load
                        return false;
                    }

                    // Block the URL
                    Toast.makeText(MainActivity.this, "URL blocked", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    // Allow any URL to load
                    return false;
                }
            }





            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);

// Pages that should not be blocked




                if (url.contains("https://paystack.com/" )) {
                    blockSwitch.setChecked(false);

                    showPopupMenu(view);

                }





                if (url.contains("https://dev-moviescreedagain.pantheonsite.io/" )) {
                    blockSwitch.setChecked(false);




                }



            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);

                              // The payment part


                if (url.equals("https://dev-moviescreedagain.pantheonsite.io/youhavepaidmoviescreed/")) {
                    String savedDate = sharedPreferences.getString("savedDate", "");

                    // Delete the saved date
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("savedDate");
                    editor.apply();

                    // Calculate two days from the current date
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_YEAR, 30);
                    String newDate = formatDate(calendar.getTime());

                    // Save the new date in SharedPreferences
                    editor.putString("savedDate", newDate);
                    editor.apply();



                    Toast.makeText(MainActivity.this, "New date saved: " + newDate, Toast.LENGTH_SHORT).show();

                }






            }


        });

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setProgress(progress);
            }
        });


        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
                swipeRefreshLayout.setRefreshing(false);


                String savedDate = sharedPreferences.getString("savedDate", "");

                if (hasPassedCurrentDate(savedDate)) {

                    Toast.makeText(MainActivity.this, "Plan has expired pay to enable download " + savedDate, Toast.LENGTH_SHORT).show();

                }}
        });


        // enable download

        webView.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
                final String downloadUrl = url;

                // Check if the shared preference is empty
                if (!sharedPreferences.contains("savedDate")) {
                    // Get the current date
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_YEAR, -1); // Subtract 1 day
                    String initialDate = formatDate(calendar.getTime());

                    // Save the initial date in SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("savedDate", initialDate);
                    editor.apply();
                }

                String savedDate = sharedPreferences.getString("savedDate", "");

                if (hasPassedCurrentDate(savedDate)) {
                    webView.loadUrl("https://dev-moviescreedagain.pantheonsite.io/payment-page/");
                    Toast.makeText(MainActivity.this, "Date has passed: " + savedDate, Toast.LENGTH_SHORT).show();


                } else {
                    downloadFile(downloadUrl);
                    Toast.makeText(MainActivity.this, "Date has not passed: ", Toast.LENGTH_SHORT).show();

                }



            }






        });


        // Load a specific URL as soon as the activity is created
        webView.loadUrl(" https://dev-moviescreedagain.pantheonsite.io/");



        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.google.com/");
            }
        });







        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    Toast.makeText(MainActivity.this, "cant go back", Toast.LENGTH_LONG).show();

                }
            }
        });


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    webView.goForward();
                } else {
                    Toast.makeText(MainActivity.this, "cant go forward", Toast.LENGTH_LONG).show();

                }
            }
        });


        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webView.loadUrl("https://dev-moviescreedagain.pantheonsite.io/");


            }
        });






    }



    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle menu item clicks here
                switch (item.getItemId()) {
                    case R.id.menu_item_hi:
                        showToast("Hi");
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.block_switch);
        MenuItem menuItem = menu.findItem(R.id.textlink);
        blockSwitch = (Switch) item.getActionView();
        blockSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){




                    menuItem.setTitle("Ad blocker on");
                } else {
                    menuItem.setTitle("Ad blocker off");


                }
            }
        });
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MakePayment:
                // Handle the help menu item selection
                MakePayment();
                return true;
            case R.id.desktopsite:
                // Handle the settings menu item selection
                desktopsite();
                return true;
            case R.id.mobilesite:
                // Handle the about menu item selection
                mobilesite();
                return true;

            case R.id.logout:
                // Handle the about menu item selection
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void MakePayment() {
        // Implement your Settings activity here


        webView.loadUrl("https://paystack.com/buy/moviescreed-subscription-qcqhqq");



    }


    private void desktopsite() {
        // Implement your Settings activity here

        webView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");


        webView.reload();


    }


    private void mobilesite() {
        // Implement your Settings activity here

        webView.getSettings().setUserAgentString(null);


        webView.reload();



    }


    private void logout() {
        // Implement your Settings activity here

        mAuth.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();



    }

    private boolean hasPassedCurrentDate(String savedDate) {
        if (savedDate.isEmpty()) {
            return false;
        }

        Date currentDate = Calendar.getInstance().getTime();
        Date storedDate = parseDate(savedDate);

        return currentDate.after(storedDate);
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            return sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }




    private String getCurrentDomain(String url) {
        try {
            URL urlObj = new URL(url);
            String protocol = urlObj.getProtocol();
            String host = urlObj.getHost();
            return protocol + "://" + host;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getClickedDomain(String url) {
        try {
            URL urlObj = new URL(url);
            String protocol = urlObj.getProtocol();
            String host = urlObj.getHost();
            return protocol + "://" + host;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean isDownloadLink(String url) {
        // Define an array of file extensions to check for
        String[] fileExtensions = {"3gp", "7z", "aac", "ac3", "ai", "aif", "aiff", "apk", "app", "asf", "avi", "bak", "bin", "bmp", "bup", "cab", "cdr", "cer", "cfg", "cfgx", "class", "codec", "com", "config", "cpp", "crt", "css", "csv", "cue", "dat", "db", "dbf", "dcr", "deb", "dll", "dmg", "doc", "docx", "drv", "dsk", "dss", "dts", "dv", "dvf", "dwg", "dxf", "eml", "eps", "exe", "f4v", "flac", "flv", "gif", "gz", "h", "h264", "htm", "html", "iif", "img", "ini", "iso", "jar", "java", "jfif", "jpg", "jpeg", "js", "json", "key", "ksd", "lnk", "log", "m", "m2v", "m4a", "m4v", "max", "mdb", "mid", "midi", "mkv", "mod", "mov", "mp3", "mp4", "mpa", "mpeg", "mpg", "mpp", "msg", "msi", "ncd", "odb", "odf", "odg", "odp", "ods", "odt", "ogg", "ogv", "ora", "ost", "otg", "oth", "otp", "ots", "ott", "p12", "p7b", "p7c", "pdd", "pdf", "php", "pkg", "pl", "png", "pps", "ppt", "pptx", "prf", "ps", "psd", "pst", "pub", "py", "qcp", "qpw", "qt", "ra", "ram", "rar", "raw", "rm", "rmvb", "rtf", "rw2", "s3m", "sav", "sdc", "sdd", "sdp", "sdw", "sh", "sitx", "skp", "sln", "sol", "spc", "spl", "sql", "srt", "svg", "swf", "tar", "tga", "thm", "tif", "tiff", "tmp", "torrent", "tpl", "trp", "ts", "txt", "udw", "vb", "vcf", "vob", "wav", "webm", "wma", "wmv", "wpd", "wps", "x3f", "xcf", "xlam", "xls", "xlsx", "xml", "xpi", "xz", "yuv", "zip"};





        // Get the URL's file extension
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);

        // Check if the extension matches any of the extensions in the array
        for (String ext : fileExtensions) {
            if (ext.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        Toast.makeText(MainActivity.this, "NOT DOWNLOAD LINK", Toast.LENGTH_SHORT).show();
        return false;

    }








    private void downloadFile(String url) {
        // Create a DownloadManager.Request and set the download URL
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

        // Set the download destination directory and file name
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, null, null));

        // Set the MIME type
        String mimeType = URLConnection.guessContentTypeFromName(url);
        request.setMimeType(mimeType);

        // Add cookies to the request
        String cookies = CookieManager.getInstance().getCookie(url);
        request.addRequestHeader("cookie", cookies);

        // Enqueue the download and display a Toast message
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
        Toast.makeText(MainActivity.this, "DOWNLOADING", Toast.LENGTH_SHORT).show();
    }








    @Override
    public void onBackPressed() {
        if ( webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }






    private void checkDownloadPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(MainActivity.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }


}














