package Processing.Visualization;

import Dictionary.Hangul_jamo;
import java.io.IOException;


public class Romanization {

    public static String yale_romanization(String hangul) throws IOException {

        //https://scriptsource.org/cms/scripts/page.php?item_id=entry_detail&uid=wrhffp2ffm

        String typo = hangul;

        String trans_word = "";

        // typo스트링의 글자수 만큼 list에 담기
        for (int i = 0; i < typo.length(); i++) {
            String one_word = "";
            char comVal = (char) (typo.charAt(i)-0xAC00);

            if (comVal >= 0 && comVal <= 11172){
                // 한글일경우

                // 초성만 입력 했을 시엔 초성은 무시해서 List에 추가합니다.
                char uniVal = (char)comVal;

                // 유니코드 표에 맞추어 초성 중성 종성을 분리
                char cho = (char) ((((uniVal - (uniVal % 28)) / 28) / 21) + 0x1100);
                char jung = (char) ((((uniVal - (uniVal % 28)) / 28) % 21) + 0x1161);
                char jong = (char) ((uniVal % 28) + 0x11a7);

                if(cho!=4519){
                    if(String.valueOf(cho).equals("ᄋ")){
                        one_word = one_word+"";
                    } else {
                        for(int j = 0; j < Hangul_jamo.jamo.length; j++){
                            if(String.valueOf(cho).equals(Hangul_jamo.jamo[j])){
                                one_word = one_word+Hangul_jamo.jamo_yale[j];
                            }
                        }
                    }
//                    System.out.print(String.valueOf(cho));
                }
                if(jung!=4519){
                    for(int j = 0; j < Hangul_jamo.jamo.length; j++){
                        if(String.valueOf(jung).equals(Hangul_jamo.jamo[j])){
                            //System.out.print("gg");
                            one_word = one_word+Hangul_jamo.jamo_yale[j];
                        }
                    }
//                    System.out.print(String.valueOf(jung));
                }
                if(jong!=4519){
                    if(String.valueOf(jong).equals("ᆼ")){
                        one_word = one_word+"ng";
                    } else {
                        for(int j = 0; j < Hangul_jamo.jamo_jong.length; j++){
                            if(String.valueOf(jong).equals(Hangul_jamo.jamo_jong[j])){
                                one_word = one_word+Hangul_jamo.jamo_jong_yale[j];
                            }
                        }
                    }
//                    System.out.print(String.valueOf(jong));
                }

            } else {
                // 한글이 아닐경우
                comVal = (char) (comVal+0xAC00);
                one_word = one_word+comVal;
            }

            trans_word = trans_word+one_word;

            //System.out.println(typo.charAt(i)+" : "+one_word);

        }
        return trans_word;
    }
}
