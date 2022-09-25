import { referenceArr, referenceTable } from "./reference";

export const decode = (encodedString: string) => {
  const textUpperCased: string = encodedString.toUpperCase();
  let result: string = "";
  if (referenceTable[textUpperCased[0].toUpperCase()] === undefined) {
    return "The first character is not in the Reference!";
  }
  const offsetNum: number = referenceTable[textUpperCased[0].toUpperCase()];
  let newLetter: string;
  for (let i = 1; i < textUpperCased.length; i += 1) {
    const currentLetter: string = textUpperCased[i];
    // if character is a space, do not shift
    if (currentLetter !== " ") {
      let newLetterNum: number = referenceTable[currentLetter] + offsetNum;
      if (newLetterNum > 43) {
        newLetter = referenceArr[newLetterNum % 44];
      } else {
        newLetter = referenceArr[newLetterNum];
      }
    } else {
      newLetter = " ";
    }
    result += newLetter;
  }
  return result;
};

if (process.argv.length === 3) {
  console.log(decode(process.argv[2]));
} else {
  console.log(
    `Please type in the format: npm run decode "stringToDecodeInQuotation"`
  );
}
