package com.example.kvas_map;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.search.SearchFactory;
import com.yandex.mapkit.search.SearchManager;
import com.yandex.mapkit.search.SearchManagerType;

public class MapActivity extends AppCompatActivity {

    private MapView mapView;
    private EditText eLocation;
    private SearchManager searchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MapKitFactory.setApiKey("61348beb-3bbf-4259-988c-039babcaeb1e");
        MapKitFactory.initialize(this);
        SearchFactory.initialize(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        searchManager = SearchFactory.getInstance().createSearchManager(SearchManagerType.COMBINED);

        mapView = (MapView) findViewById(R.id.map_view);
        mapView.getMap().move(
                new CameraPosition(new Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
/*        eLocation = findViewById(R.id.edit_location);
        eLocation.setImeOptions(EditorInfo.IME_ACTION_DONE);

        eLocation.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    dbh.updateNoteLocationById(getIntent().getIntExtra("note_id", -1),
                            eLocation.getText().toString().trim());
                    dbh.updateNoteWeatherById(getIntent().getIntExtra("note_id", -1),
                            "");
                    submitQuery(eLocation.getText().toString());
                }

                return false;
            }
        });
        submitQuery(eLocation.getText().toString());*/
    }
    @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }


}