package lf2.jtp;
import java.applet.*;
import java.net.*;
public class Sound {
    public static void playSound() {
        try {
            AudioClip clip = Applet.newAudioClip(new URL("file:bij.wav"));
            clip.play();
        } 
        catch (MalformedURLException murle) {
            System.out.println(murle);
        }
    }
    
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
