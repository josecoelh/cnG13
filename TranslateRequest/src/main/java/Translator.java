import com.google.cloud.translate.*;
import com.google.protobuf.ByteString;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class Translator {
    static Translate translate = TranslateOptions.getDefaultInstance().getService();

    static void translate(String imageName, String text, String currentLang) throws ExecutionException, InterruptedException {
        List<Language> languages = translate.listSupportedLanguages();

        for (Language language : languages) {
            String translated = translateText(text, currentLang, language.getCode());
            ResultDB.putText(imageName, language.getName(), translated);
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
