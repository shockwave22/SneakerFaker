package tan.brickhack;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifiedClass;

/**
 * Created by Ocean on 2/11/17.
 */
public class CommandClassifier {
    public String classify(String command) {
        NaturalLanguageClassifier service = new NaturalLanguageClassifier();
        service.setUsernameAndPassword(Constants.NATURAL_LANG_CLASSIFIER_USERNAME,
                Constants.NATURAL_LANG_CLASSIFIER_PASSWORD);

        String classificationStr = null;
        Double  classificationConfidence = null;

        if (!(command == null || command.equals(""))) {
            try {
                // Classify command
                Classification classification = service.classify(Constants.NATURAL_LANG_CLASSIFIER, command).execute();
                List<ClassifiedClass> classifiedClasses = classification.getClasses();
                //classifiedClasses.remove(classifiedClasses.size() - 1);
                classificationConfidence = classifiedClasses.get(0).getConfidence();

                System.out.println("[DEBUG] Classification Confidence: " + classificationConfidence);





                classificationStr = classification.getTopClass();

                System.out.println("[DEBUG] Command Classification: " + classificationStr);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //decimal
        DecimalFormat df = new DecimalFormat("#.00");
        String numberFormat = df.format(classificationConfidence);

        //percent
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(1);
        String percent = percentFormat.format(Double.parseDouble(numberFormat));


        String result = classificationStr + " " + percent;
        return result;
    }

}
