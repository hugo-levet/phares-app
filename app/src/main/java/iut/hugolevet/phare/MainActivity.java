package iut.hugolevet.phare;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.DoubleBuffer;

import iut.hugolevet.phare.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private AppBarConfiguration mAppBarConfiguration;
    final static String TAG = "MainActivity";

    //context
    public static Context context;

    public static JSONArray jsonA = new JSONArray();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MainActivity.context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_list)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

//
//        //récupérer les phares
//        try {
//            Log.d(TAG, "récup phares");
//            BufferedReader br = new BufferedReader(new InputStreamReader(MainActivity.this.getAssets().open("phares.json")));
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            String str = new String(sb.toString()) ;
//
//            Log.d(TAG, str);
//
//            JSONObject jObjConnection = new JSONObject(str);
//            JSONObject jsonBix = jObjConnection.getJSONObject("phares");
//            /*JSONArray */jsonA = jsonBix.getJSONArray("liste");
//            for(int i =0 ; i < jsonA.length() ; i++) {
//                JSONObject obj = (JSONObject)jsonA.get(i) ;
//                String nom = obj.getString("name");
//                String id = obj.getString("id");
//                Log.d(TAG, "nom d'un phare: "+nom);
//            }
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }

    }

//    public void Read() /*throws JSONException*/ {
//        try {
////            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open( "phares.json")));
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(getContext().getAssets().open("phares.json")));
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            String str = new String(sb.toString()) ;
//
//            JSONObject jObjConnection = new JSONObject(str);
//            JSONObject jsonBix = jObjConnection.getJSONObject("phare");
//            JSONArray jsonA = jsonBix.getJSONArray("liste");
//            for (int i=0; i>jsonA.length(); ++i) {
//                JSONObject obj = (JSONObject) jsonA.get(i);
//                String nom = obj.getString("name");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            Log.d(TAG, "on est là");
////            BufferedReader br = new BufferedReader(new InputStreamReader(MainActivity.getContext().getAssets().open("phares.json")));
//            BufferedReader br = new BufferedReader(new InputStreamReader(getContext().getAssets().open("phares.json")));
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            String str = new String(sb.toString());
//            Log.d(TAG, str);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    private Context getContext() {
//        return null;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyContent.DummyItem item);
    }

    public static String loadJson(String filename) throws IOException {
        Log.d(TAG, "récup phares");
        BufferedReader br = new BufferedReader(new InputStreamReader(MainActivity.context.getAssets().open(filename)));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        String str = new String(sb.toString()) ;

        return str;
    }
}
