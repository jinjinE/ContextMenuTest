package emirim0223.kr.hs.emirim.contextmenutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout Linear;
    ImageView image1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1 = (Button)findViewById(R.id.but1);
        Button but2 = (Button)findViewById(R.id.but2);
        Linear = (LinearLayout)findViewById(R.id.Linear);
        image1 = (ImageView)findViewById(R.id.image1);
        registerForContextMenu(but1);
        registerForContextMenu(but2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater =getMenuInflater();
        if(v.getId()==R.id.but1){
            menu.setHeaderTitle("배경색 변경");
            //menu.setHeaderIcon(R.drawble.icon1);
            menuInflater.inflate(R.menu.menu1, menu);
        }

        if(v.getId() == R.id.but2){
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch(item.getItemId()){
            case R.id.menu1_item_red:
                Linear.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu1_item_blue:
                Linear.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menu1_item_pink:
                Linear.setBackgroundColor(Color.rgb(255,178,217));
                return true;
            case R.id.menu2_item_rotation:
                image1.setRotation(image1.getRotation()+90);
                return true;
            case R.id.menu2_item_size:
                image1.setScaleX(image1.getScaleX()*1.5f);
                image1.setScaleY(image1.getScaleY()*1.5f);
                return true;
        }

        return false;
    }
}
