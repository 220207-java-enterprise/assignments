public class LengthOfString {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("Expected a single string argument to be provided!");
        }
        System.out.println("Provided string: " + args[0]);
        System.out.println("Abbreviated string: " + abbreviateLongStrings(args[0]));
    }

    public static String abbreviateLongStrings(String s) {
        if (s.length() > 10) {
            return s.charAt(0) + Integer.toString(s.substring(1, s.length() - 1).length()) + s.charAt(s.length() - 1);
        } else {
            return s;
        }
    }

}
