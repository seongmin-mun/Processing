package Main;

import Processing.Romanization;

public class MainRun {
    public static void main (String [] args) throws Exception {
        
        String out = Romanization.yale_romanization("초성만 입력 했을 시엔 초성은 무시해서 List에 추가합니다.");
        System.out.println(out);

    }
}
