import { referenceArr, referenceTable } from "./reference";

export const encode = (offset: string, textToEncode: string) => {
  const textUpperCased: string = textToEncode.toUpperCase();
  let result: string = "";
  if (referenceTable[offset.toUpperCase()] === undefined) {
    return `${offset} is not part of the reference!`;
  }
  const offsetNum: number = referenceTable[offset.toUpperCase()];
  let newLetter: string;
  // Iterate through text
  for (let i = 0; i < textUpperCased.length; i += 1) {
    const currentLetter: string = textUpperCased[i];
    // if character is a space, do not shift
    if (currentLetter !== " ") {
      let newLetterNum: number = referenceTable[currentLetter] - offsetNum;
      if (newLetterNum < 0) {
        newLetter = referenceArr[44 + newLetterNum];
      } else {
        newLetter = referenceArr[newLetterNum];
      }
    } else {
      newLetter = " ";
    }
    result += newLetter;
  }
  return offset.toUpperCase() + result;
};

if (process.argv.length >= 4) {
  if (process.argv[2].length > 1) {
    console.log("Please only use a single character for the offset!");
  } else {
    console.log(encode(process.argv[2], process.argv[3]));
  }
} else {
  console.log(
    `Please type in the format: npm run encode offsetLetter "stringToEncodeInQuotation"`
  );
}
