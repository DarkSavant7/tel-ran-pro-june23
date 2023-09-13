package de.telran.practice.lectures.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

  public static void main(String[] args) {
//    phoneCheck();

//    var messageForCensoring = "Этот сайт для неудачников LOL!";
//    System.out.println(removeVowels(messageForCensoring));

    var someCertField = "name=Alex; surname=Grigorev; id=b21865c3-4153-485e-9ef1-cf7c311bccee";

    System.out.println(isValidField(someCertField));

    System.out.println(vowel2Index("Codewars is the best site in the world"));
  }

  private static void phoneCheck() {
    String phone1 = "+(123)456789";
    String phone2 = "+(123) 456789";
    String phone3 = "+123-456789";
    String phone4 = "+1223-456789";

    String regex = "\\+\\(?\\d\\d\\d\\)?([\\s\\-])?\\d\\d\\d\\d\\d\\d";

    /**
     * symbols: \+, \(, \), d , s, \.
     * optional: ?
     * digit: \d, [0-9]
     * non digit: \D
     * every single symbol: .    ,  ....
     * range of appropriate values: [acd] [a-d]
     * range of number: {}  [f-q]{3,10}
     * space: \s, \t, \n
     * new line: \t, \n
     * beginning of str: ^, \A
     * end of the string: $, \Z, \z
     * continuation: + (ex: \d = 1 digit; \d+ = 1 or more digit)
     * or: |
     * word of symbols: \w
     * anti-w: \W
     */
    System.out.println(phone1.matches(regex));
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phone2);
    System.out.println(matcher.matches());
    System.out.println(phone3.matches(regex));
    System.out.println(phone4.matches(regex));
  }

  static void match() {
    String correctFormat = "+(371) 2924-2695";
    checkPhone(correctFormat);
    String incorrectFormat = "+(3Ы1) 2924-2695";
    checkPhone(incorrectFormat);
    String correctFormat2 = "+(371) 2609-9944";
    checkPhone(correctFormat2);
    String incorrectFormat2 = "+(371)2609-9944";
    checkPhone(incorrectFormat2);
  }

  public static void checkPhone(String phone) {

    String regex = "\\A[+]+[(][0-9]{3,3}[)]+[ ][0-9]{4,4}+[-][0-9]{4,4}\\Z";

    // \A - Начало всей строки
    // [+], [(], [)], [-] - конкретный требуемый символ
    // [0-9]{3,3}, [0-9]{4,4} спектр допустимых символов в фрагменте и допустимая длина фрагмента, от/до
    // \Z - Конец всей строки

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phone);
    System.out.println("Проверяемый номер телефона: " + phone + ": " + matcher.matches());
  }

  /**
   * Тролли атакуют ваш раздел комментариев! Распространенный способ справиться с этой ситуацией —
   * удалить все гласные из комментариев троллей, нейтрализуя угрозу. Ваша задача — написать
   * функцию, которая принимает строку и возвращает новую строку, из которой удалены все гласные.
   * Например, строка «Этот сайт для неудачников LOL!» станет «Ths wbst s fr lsrs LL!». Примечание:
   * для этой ката yне считается гласной.
   */
  private static final String VOWEL_REGEX = "[aeuioAEUIOяЯуУАаеЕиИОоэЭюЮёЁыЫ]";
  private static final String REPLACEMENT = "";

  static String removeVowels(String input) {
    return input.replaceAll(VOWEL_REGEX, REPLACEMENT);
  }

  private static final String FIELD_PATTERN = "name=\\w+; surname=\\w+; id=[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";

  static boolean isValidField(String field) {
    return field.matches(FIELD_PATTERN);
  }

  /**
   * Write a function
   * <p>
   * vowel2Index(String s) that takes in a string and replaces all the vowels [a,e,i,o,u] with their
   * respective positions within that string. E.g:
   * <p>
   * Kata.Vowel2Index("this is my string") == "th3s 6s my str15ng" Kata.Vowel2Index("Codewars is the
   * best site in the world") == "C2d4w6rs 10s th15 b18st s23t25 27n th32 w35rld" Your function
   * should be case insensitive to the vowels.
   */

  static String vowel2Index(String s) {
    String result = s;
    while (findVowelIndex(result) > -1) {
      var index = findVowelIndex(result);
      result = result.replaceFirst(VOWEL_REGEX, String.valueOf(index));
    }
    return result;
  }

  static int findVowelIndex(String s) {
    var arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      char ch = arr[i];
      if ("aeuioAEUIOяЯуУАаеЕиИОоэЭюЮёЁыЫ".indexOf(ch) != -1) {
        return s.indexOf(ch);
      }
    }
    return -1;
  }
}

