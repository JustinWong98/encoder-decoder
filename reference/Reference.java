package reference;

public class Reference {
final static String referenceArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
    public static int getOffsetNum (char offset) {
      return referenceArr.indexOf(offset);
    }
    public static char getNewLetter (char letter, int offsetNum, boolean toEncode) {
      int newLetterNum = toEncode ? referenceArr.indexOf(letter) - offsetNum : referenceArr.indexOf(letter) + offsetNum;
      char newLetter;
      if (toEncode) {
        if (newLetterNum < 0) {
          newLetter = referenceArr.charAt(44 + newLetterNum);
        }
        else {
          newLetter = referenceArr.charAt(newLetterNum);
        }
      }
      else {
        if (newLetterNum > 43) {
          newLetter = referenceArr.charAt(newLetterNum % 44);
        } else {
          newLetter = referenceArr.charAt(newLetterNum);
        }
      }
      return newLetter;
    }
}