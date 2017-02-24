package tan.brickhack;

import javax.sound.sampled.AudioFileFormat;

/**
 * Created by Ocean on 2/11/17.
 */
public interface Constants {

    // Audio Location & Types
    public static String AUDIO_FOLDER = "./audio/";
    public static String AUDIO_TYPE_GREETING = "greeting";
    public static String AUDIO_TYPE_RESULT = "result";
    public static String AUDIO_TYPE_CHECKING = "checking";
    public static String AUDIO_TYPE_NOT_UNDERSTOOD = "not-understood";
    public static String AUDIO_TYPE_NOT_FOUND = "not-found";
    public static String AUDIO_TYPE_COMMAND = "command";
    public static String AUDIO_TYPE_ANSWER = "answer";
    public static long AUDIO_RECORD_TIME = 3000; // 3 seconds

    // Audio Format
    public static String AUDIO_FORMAT = "." + AudioFileFormat.Type.WAVE.getExtension();
    public static float AUDIO_FORMAT_SAMPLE_RATE = 16000; // 8000, 11025, 16000, 22050, 44100
    public static int AUDIO_FORMAT_SAMPLE_SIZE_IN_BITS = 16; // 8, 16
    public static int AUDIO_FORMAT_CHANNELS = 1; // 1,2
    public static boolean AUDIO_FORMAT_SIGNED = true; // true, false
    public static boolean AUDIO_FORMAT_BIG_ENDIAN = false; // true, false

    // Watson API Credentials
    public static String SPEECH_TO_TEXT_USERNAME = "";
    public static String SPEECH_TO_TEXT_PASSWORD = "";
    public static String TEXT_TO_SPEECH_USERNAME = "";
    public static String TEXT_TO_SPEECH_PASSWORD = "";
    public static String NATURAL_LANG_CLASSIFIER_USERNAME = "";
    public static String NATURAL_LANG_CLASSIFIER_PASSWORD = "";
    public static String NATURAL_LANG_CLASSIFIER = "";




}
