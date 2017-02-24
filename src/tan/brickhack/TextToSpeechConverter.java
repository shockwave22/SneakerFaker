package tan.brickhack;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Ocean on 2/11/17.
 */
public class TextToSpeechConverter {
    public void convert(String text, String audioType) throws Exception {

        TextToSpeech synthesizer = new TextToSpeech();
        synthesizer.setUsernameAndPassword(Constants.TEXT_TO_SPEECH_USERNAME, Constants.TEXT_TO_SPEECH_PASSWORD);

        // Synthesize
        InputStream in = synthesizer.synthesize(text, Voice.EN_MICHAEL, AudioFormat.WAV).execute();
        writeToFile(WaveUtils.reWriteWaveHeader(in),
                new File(Constants.AUDIO_FOLDER + audioType + Constants.AUDIO_FORMAT));
    }

    /**
     * Write the input stream to a file
     */
    private void writeToFile(InputStream in, File file) throws Exception {
        OutputStream out = new FileOutputStream(file);
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.close();
        in.close();
    }
}
