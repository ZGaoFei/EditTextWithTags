package mabbas007.myapplication;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;

import mabbas007.tagsedittext.TagsEditText;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TagsEditText mTagsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTagsEditText = (TagsEditText) findViewById(R.id.tagsEditText);
        mTagsEditText.setHint("Enter names of fruits");
        mTagsEditText.setTagsListener(new TagsEditText.TagsEditListener() {
            @Override
            public void onTagsChanged(Collection<String> tags) {
                String s = Arrays.toString(tags.toArray());
                String[] split = s.split(" ");
                if (split.length == 5) {
                    Log.e("======", "======" + s + "===" + s.length());
                }
            }

            @Override

            public void onEditingFinished() {
            }
        });
        mTagsEditText.setTagsWithSpacesEnabled(false);
//        mTagsEditText.setAdapter(new ArrayAdapter<>(this,
//                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.fruits)));
        mTagsEditText.setThreshold(1);
//        mTagsEditText.setOnEditorActionListener(actionListener);
//        mTagsEditText.setOnKeyListener(keyListener);

        setButtonClickListener(R.id.btnChangeTags);
        setButtonClickListener(R.id.btnChangeBackground);
        setButtonClickListener(R.id.btnChangeColor);
        setButtonClickListener(R.id.btnChangeSize);
        setButtonClickListener(R.id.btnChangeDrawableLeft);
        setButtonClickListener(R.id.btnChangeDrawableRight);
        setButtonClickListener(R.id.btnChangeClosePadding);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mTagsEditText.showDropDown();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChangeTags: {
                //mTagsEditText.setTags("1", "2", "3");
                mTagsEditText.setTags(new String[]{"1","2","3","4"});
                break;
            }
            case R.id.btnChangeBackground: {
                mTagsEditText.setTagsBackground(R.drawable.square);
                break;
            }
            case R.id.btnChangeColor: {
                mTagsEditText.setTagsTextColor(R.color.blackOlive);
                break;
            }
            case R.id.btnChangeSize: {
                mTagsEditText.setTagsTextSize(R.dimen.larger_text_size);
                break;
            }
            case R.id.btnChangeDrawableLeft: {
                mTagsEditText.setCloseDrawableLeft(R.drawable.dot);
                break;
            }
            case R.id.btnChangeDrawableRight: {
//                mTagsEditText.setCloseDrawableRight(R.drawable.tag_close);
                mTagsEditText.setText("haha 你好 buuo");
                mTagsEditText.setText("hello");
                mTagsEditText.setText("hello");
                mTagsEditText.setText("hello");
                break;
            }
            case R.id.btnChangeClosePadding: {
//                mTagsEditText.setCloseDrawablePadding(R.dimen.larger_padding);
                String s = mTagsEditText.getText().toString();
                Log.e("=======", "======" + s);
                break;
            }
        }
    }

    /*@Override
    public void onTagsChanged(Collection<String> tags) {
        Log.d("====c=====", "Tags changed: ");
        Log.d("====c=====", Arrays.toString(tags.toArray()));
    }

    @Override
    public void onEditingFinished() {
        Log.d("===f======","OnEditing finished");
//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(mTagsEditText.getWindowToken(), 0);
//        //mTagsEditText.clearFocus();
    }*/

    private void setButtonClickListener(@IdRes int id) {
        findViewById(id).setOnClickListener(this);
    }

    TextView.OnEditorActionListener actionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            Log.e("======", "=====" + event.getKeyCode());
            if (event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                Log.e("==111====", "======");
            }
            return false;
        }
    };

    View.OnKeyListener keyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                Log.e("=====", "===111==");
                return false;
            } else {
                return true;
            }
        }
    };

}
