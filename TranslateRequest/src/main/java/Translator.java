import com.google.cloud.translate.*;
import com.google.protobuf.ByteString;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class Translator {
    private static Translate translate = TranslateOptions.getDefaultInstance().getService();

    static void translate(String user, String imageName, String text, String currentLang) throws ExecutionException, InterruptedException {
        List<Language> languages = translate.listSupportedLanguages();
        ResultDB resultDB = new ResultDB(user);
        for (Language language : languages) {
            String translated = translateText(text, currentLang, language.getCode());
            resultDB.putText(imageName, language.getCode(), translated);
        }
    }

    private static String translateText(String text, String currentLang, String desiredLang) {
        Translation translation = translate.translate(
                text,
                Translate.TranslateOption.sourceLanguage(currentLang),
                Translate.TranslateOption.targetLanguage(desiredLang));
        return translation.getTranslatedText();
    }
}
