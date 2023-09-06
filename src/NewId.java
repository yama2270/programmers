import java.util.Arrays;

public class NewId {

    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        MakeId.id = new_id;
        new MakeId()
                .toLower()
                .wordFilter()
                .oneEnd()
                .removePoint()
                .emptyString()
                .lengthLimit()
                .makeThree();
        System.out.println(MakeId.id);
    }

    private static class MakeId{

        private static String id;

        public MakeId(){

        }

        public MakeId toLower(){
            id = id.toLowerCase();
            return this;
        }

        public MakeId wordFilter(){
            id = id.replaceAll("[^a-z0-9\\-_.]","");
            return this;
        }

        public MakeId oneEnd(){
            id = id.replaceAll("\\.{2,}",".");
            return this;
        }

        public MakeId removePoint(){
            id = id.replaceAll("^\\.|\\.$","");
            return this;
        }

        public MakeId emptyString(){
            if(id.isEmpty()){
                id="a";
            }
            return this;
        }

        public MakeId lengthLimit(){
            if(id.length()>=16){
                id = id.substring(0,15);
                System.out.println(id);
                id = id.replaceAll("\\.$","");
            }
            return this;
        }

        public MakeId makeThree(){
            if(id.length()<3){
                char endWord = id.charAt(id.length()-1);
                while(id.length()<3){
                    id += endWord;
                }
            }
            return this;
        }

    }

}
