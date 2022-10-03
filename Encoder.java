import reference.Reference;

public class Encoder {
    public static void main (String[] args) {
        if (args.length != 2) {
            System.out.println("Please type in the format: java Encoder offsetLetter \"stringToEncodeInQuotation\"");
        }
        else {
            if(args[0].length() > 1) {
                System.out.println("Please only use a single character for the offset!");
            }
            else {
                String plainTextUppercase = args[1].toUpperCase();
                char offsetChar = args[0].toUpperCase().charAt(0);
                int offsetNum = Reference.getOffsetNum(offsetChar);
                if (offsetNum == -1) {
                    System.out.println("The offset is not in the table!");
                }
                else {
                    String encodedText = "";
                    for (int i = 0; i < plainTextUppercase.length(); i ++) {
                        char currentLetter = plainTextUppercase.charAt(i);
                        char newLetter = currentLetter;
                        // if character is a space, do not shift
                        if (Character.isWhitespace(currentLetter) != true){
                            newLetter = Reference.getNewLetter(currentLetter, offsetNum, true);
                        }
                        encodedText = encodedText + newLetter;
                    }
                    System.out.println(offsetChar + encodedText);
                }
            }
        }
    }
}