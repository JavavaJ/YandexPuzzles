package some_playground;

public class NullStringPlayground {

    public static void main(String[] args) {
        String str = null;

        str = str + "web";
        System.out.println(str);

        StringBuilder sb = new StringBuilder();
        boolean someBoolean = false;

        if (someBoolean) {
            sb.append("firstWord_");
        }
        sb.append("secondWord");

        String output = sb.toString();
        System.out.println(output);

    }

}



