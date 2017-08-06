package org.androidtown.colorvel2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ColoringActivity extends AppCompatActivity {

    LinearLayout toolLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloring);

        ImageView simple_image = (ImageView)findViewById(R.id.simple_image);
        setImage(simple_image);

        toolLayout = (LinearLayout)findViewById(R.id.toolLayout);
        toolLayout.setVisibility(View.GONE);
    }

    private void setImage(ImageView imageView){
        Intent receivedIntent = getIntent();

        int images = (int)receivedIntent.getExtras().get("images");
        imageView.setImageResource(images);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.moreButton:
                /* toolLayout 감췄다 나타내기 */
                if (toolLayout.getVisibility() == View.GONE)
                    toolLayout.setVisibility(View.VISIBLE);
                else if (toolLayout.getVisibility() == View.VISIBLE)
                    toolLayout.setVisibility(View.GONE);

            case R.id.saveButton:
                /* 저장 버튼 (저장 확인 대화상자) */
                AlertDialog.Builder alert = new AlertDialog.Builder(ColoringActivity.this);
                //alert.setTitle("저장");
                alert.setMessage("저장되었습니다.");
                alert.show();

            case R.id.eraseButton:
                /* 지우개 버튼 */

            case R.id.backButton:
                /* 이전 버튼 */

            case R.id.brushButton:
                /* 브러쉬 버튼 */

            case R.id.touchButton:
                /* 확대 버튼 */

                break;
        }
    }
}
