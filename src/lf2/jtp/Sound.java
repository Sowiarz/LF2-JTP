package lf2.jtp;
import java.applet.*;
import java.net.*;
public class Sound {
public static void playSound() {
try {
AudioClip clip = Applet.newAudioClip(new URL("file:bij.wav"));
clip.play();
} catch (MalformedURLException murle) {
System.out.println(murle);
}
}
}
