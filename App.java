package com.imooc.扎金花;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Hello world!
 *
 */
public class App {
    private AudioFormat audioFormat = null;
    private SourceDataLine sourceDataLine = null;
    private DataLine.Info dataLine_info = null;
    //private String file = "";
    private String file="http://test.kuanrf.com:81/gs/audio/2016/09/23/3f9eef64b9284e25b32bc2df80a0049e.wav";
    private AudioInputStream audioInputStream = null;

    public App() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //audioInputStream = AudioSystem.getAudioInputStream(new File(file));
        audioInputStream=AudioSystem.getAudioInputStream(new URL(file));
        audioFormat = audioInputStream.getFormat();
        System.out.println("每秒播放帧数："+audioFormat.getSampleRate());
        System.out.println("总帧数："+audioInputStream.getFrameLength());
        System.out.println("音频时长（秒）："+audioInputStream.getFrameLength()/audioFormat.getSampleRate());
        dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);
    }

    public void play() throws IOException, LineUnavailableException {
        byte[] b = new byte[1024];
        int len = 0;
        sourceDataLine.open(audioFormat, 1024);
        sourceDataLine.start();
        while ((len = audioInputStream.read(b)) > 0) {
            sourceDataLine.write(b, 0, len);
        }
        audioInputStream.close();
        sourceDataLine.drain();
        sourceDataLine.close();
    }

    public static void main(String[] args) {
        try {
            new App().play();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}