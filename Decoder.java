import reference.Reference;

public class Decoder {
    public static void main (String[] args) {
        if (args.length != 1) {
            System.out.println("Please type in the format: java Decoder \"stringToDecodeInQuotation\"");
        }
        else {
            String encodedTextUppercase = args[0].toUpperCase();
            char encodeLetter = encodedTextUppercase.charAt(0);
            int offsetNum = Reference.getOffsetNum(encodeLetter);
            if (offsetNum == -1) {
                System.out.println("The offset is not in the table!");
            }
            else {
                String decodedText = "";
                for (int i = 1; i < encodedTextUppercase.length(); i ++) {
                    char currentLetter = encodedTextUppercase.charAt(i);
                    char newLetter = currentLetter;
                    // if character is a space, do not shift
                    if (Character.isWhitespace(currentLetter) != true){
                        newLetter = Reference.getNewLetter(currentLetter, offsetNum, false);
                    }
                    decodedText = decodedText + newLetter;
                }
                System.out.println(decodedText);
            }
        }
    }
}