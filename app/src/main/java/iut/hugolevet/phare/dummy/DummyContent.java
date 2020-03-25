package iut.hugolevet.phare.dummy;

import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iut.hugolevet.phare.MainActivity;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //    private static final int COUNT = 25;
    final static String TAG = "MainActivity";

    static {
        // Add some sample items.

        //récupérer les phares
        try {
//            Log.d(TAG, "récup phares");
//            BufferedReader br = new BufferedReader(new InputStreamReader(MainActivity.getContext().getAssets().open("phares.json")));
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            String str = new String(sb.toString()) ;
            String str = MainActivity.loadJson("phares.json");

            Log.d(TAG, str);

            JSONObject jObjConnection = new JSONObject(str);
            JSONObject jsonBix = jObjConnection.getJSONObject("phares");
            JSONArray jsonA = jsonBix.getJSONArray("liste");
            for(int i =0 ; i < jsonA.length() ; i++) {
                JSONObject obj = (JSONObject)jsonA.get(i) ;
                String nom = obj.getString("name");
                String id = obj.getString("id");
                Log.d(TAG, "nom d'un phare: "+nom);
                addItem(createDummyItem(id, nom));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

//    private static DummyItem createDummyItem(int position) {
        private static DummyItem createDummyItem(String id, String name) {

        return new DummyItem(id, name, "prout");
//        return new DummyItem(String.valueOf(position), "nom : " + nom, makeDetails(position));
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
