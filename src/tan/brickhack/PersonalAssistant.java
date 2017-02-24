package tan.brickhack;

/**
 * Created by Ocean on 2/11/17.
 */
public class PersonalAssistant {

    // Variables
    private AudioRecorder audioRecorder = null;
    private SpeechToTextConverter speechToTextConverter = null;
    private CommandClassifier commandClassifier = null;
    private TextToSpeechConverter textToSpeechConverter = null;
    private AudioSpeaker audioSpeaker = null;
    private String text = null;


    public PersonalAssistant() {
        // Initialize required objects
        audioRecorder = new AudioRecorder();
        speechToTextConverter = new SpeechToTextConverter();
        commandClassifier = new CommandClassifier();
        textToSpeechConverter = new TextToSpeechConverter();
        audioSpeaker = new AudioSpeaker();
    }

    public void startInteraction() {

        System.out.println("[DEBUG] Interaction Started");

        try {

            //Introduction
            String greetings = "Hello. This is a simple program that determines whether you are a sneakerhead or just a regular person. Just tell me what you would tweet in twitter. ";
            textToSpeechConverter.convert(greetings,Constants.AUDIO_TYPE_GREETING);
            // Start conversation with a greeting
            audioSpeaker.speak(Constants.AUDIO_TYPE_GREETING);

            boolean b = true;
            String query = "";
            while (b){
                // Listen and record query
                audioRecorder.record();

                // Convert the recorded query speech into text
                query = speechToTextConverter.convert();
                this.text = query;
                if(!(query.equals(""))){
                    b = false;
                } else {
                    String nothing = "I'm sorry. I did not hear what you said. Could you repeat that?";
                    textToSpeechConverter.convert(nothing,Constants.AUDIO_TYPE_NOT_FOUND);
                    // Start conversation with a greeting
                    audioSpeaker.speak(Constants.AUDIO_TYPE_NOT_FOUND);
                }
            }

            // Classify the command
            String commandClassification = commandClassifier.classify(query);

            String[] split = commandClassification.split(" ");

            //System.out.println(split[0]);
            //System.out.println(split[1]);
            String result = "";
            if(split[0].equals("NO")){
                result = "You are a " + split[1] + " objectively just a regular person.";
            }else if(split[0].equals("YES")){
                result = "You are a " + split[1] + " objectively a sneakerhead.";
            }

            textToSpeechConverter.convert(result,Constants.AUDIO_TYPE_RESULT);
            audioSpeaker.speak(Constants.AUDIO_TYPE_RESULT);


        } catch (Exception ex){
            System.out.println("[DEBUG] " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String getText(){
        return this.text;
    }


    //The Start
    public static void main(String args[]) {
        new PersonalAssistant().startInteraction();
    }

}
