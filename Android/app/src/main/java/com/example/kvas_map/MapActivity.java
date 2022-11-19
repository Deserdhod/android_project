package com.example.kvas_map;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.GeoObjectCollection;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.CameraUpdateReason;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.search.Response;
import com.yandex.mapkit.search.SearchFactory;
import com.yandex.mapkit.search.SearchManager;
import com.yandex.mapkit.search.SearchManagerType;
import com.yandex.runtime.Error;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.network.NetworkError;
import com.yandex.runtime.network.RemoteError;

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
        mapView.getMap().addCameraListener(this);
        mapView.getMap().move(
                new CameraPosition(new Point(56.0153, 92.8932), 11.0f, 0.0f, 0.0f),
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


}