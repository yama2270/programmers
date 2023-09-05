import java.util.Arrays;

public class NewId {

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        // 조건 1 - 모든 문자는 소문자
        // toLowerCase()
        new_id = new_id.toLowerCase();

        // 조건 2 - 알파벳 소문자,숫자,빼기,밑줄,마침표를 제외한 모든 문자를 제거
        // replaceAll()
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]","");

        // 조건 3 - 2회 이상 .이가 있으면 .으로 변환
        // replaceAll()
        new_id = new_id.replaceAll("\\.{2,}",".");

        // 조건 4 - .가 처음이나 끝에 위치한다면 제거합니다.
//        if(new_id.startsWith(".")){
//            new_id = new_id.replaceFirst("[\\.]","");
//        }
//
//        if(new_id.endsWith(".")){
//            new_id = new_id.substring(0,new_id.length()-1);
//        }

        new_id = new_id.replaceAll("^\\.|\\.$","");

        // 조건 5 - 빈 문자열이라면, new_id에 "a"를 대입한다.

        if(new_id == null || new_id.equals("")){
            new_id="a";
        }

        // 조건 6 - new_id 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 만약 .이 위치한다면 .도 제거
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            if(new_id.endsWith(".")){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }

        // 조건 7 - 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될때가지 붙힌다.
        if(new_id.length() <= 2){
            char lastWord = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3){
                new_id += lastWord;
            }
        }

    }

}
