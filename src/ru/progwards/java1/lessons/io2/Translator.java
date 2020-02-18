package ru.progwards.java1.lessons.io2;

public class Translator {

    private String[] inLang, outLang;

    public Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            boolean isExists = false;
            for (int j = 0; j < inLang.length; j++) {
                if (words[i].toLowerCase().contains(inLang[j])) {
                    String out_word = "";
                    if (Character.isUpperCase(words[i].charAt(0))) {
                        out_word = Character.toString(Character.toUpperCase( outLang[j].charAt(0)));
                        out_word +=(outLang[j].substring(1));
                    } else  {
                        out_word = (outLang[j]);
                    }
                    sb.append(words[i].toLowerCase().replace(inLang[j],out_word));
                    if (i != words.length-1) {
                        sb.append(" ");
                    }
                    isExists = true;
                }
            }
            if (!isExists) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Translator translator = new Translator(new String[] {"make", "love", "not", "war"}
        , new String[] {"твори", "любовь", "не", "войну" });
        System.out.println(translator.translate("Not war - love make!"));

    }
}
