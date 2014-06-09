package lf2.jtp;
import java.applet.*;
import java.net.*;

/**
 * Klasa odpowiedzialna za generowanie dzwięków
 * 
 */
public class Sound {

    /**
     * Odtworzenie dzwięku
     */
    public static synchronized void play() {
        new Thread(new Runnable() {
  
            public void run() {
              try {
                AudioClip clip = Applet.newAudioClip(new URL("file:bij.wav"));
                clip.play(); 
              } catch (Exception e) {
                System.err.println(e.getMessage());
              }
            }
        }).start();
    }
}
