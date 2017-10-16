package com.keyman.android.tests.keyboardHarness;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.tavultesoft.kmea.KMManager;
import com.tavultesoft.kmea.KMTextView;
import com.tavultesoft.kmea.KeyboardEventHandler.OnKeyboardEventListener;
import com.tavultesoft.kmea.KeyboardEventHandler.OnKeyboardDownloadEventListener;
import com.tavultesoft.kmea.KMManager.KeyboardType;

import java.util.HashMap;

public class MainActivity extends Activity implements OnKeyboardEventListener, OnKeyboardDownloadEventListener {

  private KMTextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    KMManager.setDebugMode(true);
    KMManager.initialize(this, KeyboardType.KEYBOARD_TYPE_INAPP);

    setContentView(R.layout.activity_main);
    textView = (KMTextView) findViewById(R.id.kmTextView);

    // Add a custom keyboard
    final String KeyboardFont = "{\"family\":\"LatinWeb\",\"source\":[\"DejaVuSans.ttf\"]}";

    // Chirality test keyboard
    HashMap<String, String> ckbInfo = new HashMap<String, String>();
    ckbInfo.put(KMManager.KMKey_KeyboardID, "chirality");
    ckbInfo.put(KMManager.KMKey_LanguageID, "eng");
    ckbInfo.put(KMManager.KMKey_KeyboardName, "Chirality Keyboard");
    ckbInfo.put(KMManager.KMKey_LanguageName, "English");
    ckbInfo.put(KMManager.KMKey_KeyboardVersion, "1.0");
    ckbInfo.put(KMManager.KMKey_Font, KeyboardFont);
    KMManager.addKeyboard(this, ckbInfo);

    // Longpress test keyboard
    HashMap<String, String> lkbInfo = new HashMap<String, String>();
    lkbInfo.put(KMManager.KMKey_KeyboardID, "longpress");
    lkbInfo.put(KMManager.KMKey_LanguageID, "eng");
    lkbInfo.put(KMManager.KMKey_KeyboardName, "Longpress Keyboard");
    lkbInfo.put(KMManager.KMKey_LanguageName, "English");
    lkbInfo.put(KMManager.KMKey_KeyboardVersion, "1.0");
    lkbInfo.put(KMManager.KMKey_Font, KeyboardFont);
    KMManager.addKeyboard(this, lkbInfo);

    // Tchad test keyboard
    HashMap<String, String> tkbInfo = new HashMap<String, String>();
    tkbInfo.put(KMManager.KMKey_KeyboardID, "tchaduni");
    tkbInfo.put(KMManager.KMKey_LanguageID, "shu");
    tkbInfo.put(KMManager.KMKey_KeyboardName, "Tchad Unicode V3");
    tkbInfo.put(KMManager.KMKey_LanguageName, "Tchad");
    tkbInfo.put(KMManager.KMKey_KeyboardVersion, "3.0");
    tkbInfo.put(KMManager.KMKey_Font, KeyboardFont);
    KMManager.addKeyboard(this, tkbInfo);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onResume() {
    super.onResume();
    KMManager.onResume();
    KMManager.addKeyboardEventListener(this);
    KMManager.addKeyboardDownloadEventListener(this);
  }

  @Override
  protected void onPause() {
    super.onPause();
    KMManager.onPause();
    KMManager.removeKeyboardEventListener(this);
    KMManager.removeKeyboardDownloadEventListener(this);
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
  }

  @Override
  public void onKeyboardLoaded(KeyboardType keyboardType) {
    // Handle Keyman keyboard loaded event here if needed
  }

  @Override
  public void onKeyboardChanged(String newKeyboard) {
    // Handle Keyman keyboard changed event here if needed
  }

  @Override
  public void onKeyboardShown() {
    // Handle Keyman keyboard shown event here if needed
  }

  @Override
  public void onKeyboardDismissed() {
    // Handle Keyman keyboard dismissed event here if needed
  }

  @Override
  public void onKeyboardDownloadStarted(HashMap<String, String> keyboardInfo) {
    // Handle Keyman keyboard download started event here if needed
  }

  @Override
  public void onKeyboardDownloadFinished(HashMap<String, String> keyboardInfo, int result) {
    // Handle Keyman keyboard download finished event here if needed
  }
}