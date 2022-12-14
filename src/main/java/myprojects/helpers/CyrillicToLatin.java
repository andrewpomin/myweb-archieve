package myprojects.helpers;

import java.io.File;
import java.util.List;

public class CyrillicToLatin {

    public void translate(String directory) {

        List<String> pathnames = FileWorker.makeList(directory);
        if (pathnames == null) {
            return;
        }

        int counter = 0;
        for (String path : pathnames) {
            ++counter;
            File file = new File(directory + "\\" + path);
            StringBuilder path2 = new StringBuilder();

            if (CyrillicToLatin.isNeededTranslate(path)) {
                boolean isAllUpperCase = CyrillicToLatin.isNameUpperCase(path);
                char previousLetter = ' ';
                char[] charArray = path.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (Character.UnicodeBlock.of(charArray[i]) == Character.UnicodeBlock.CYRILLIC) {
                        char nextLetter = ' ';
                        if (i + 1 < charArray.length) {
                            nextLetter = charArray[i + 1];
                        }
                        path2.append(CyrillicToLatin.changeLetter(charArray[i], previousLetter, nextLetter, isAllUpperCase));
                    } else {
                        path2.append(charArray[i]);
                    }
                    previousLetter = charArray[i];
                }

                File file2 = new File(directory + "\\" + path2);
                if (file.renameTo(file2)) {
                    System.out.println("Renamed " + path + " to " + path2);
                } else if (file2.exists()) {
                    path2 = new StringBuilder(path2.substring(0, path2.indexOf(".")) + " (2).mp3");
                    file2 = new File(directory + "\\" + path2);
                    if (file.renameTo(file2)) {
                        System.out.println("Renamed " + path + " to " + path2);
                    } else {
                        System.out.println("Can't rename");
                    }
                } else {
                    System.out.println("Can't rename");
                }
            }
        }
        System.out.println("Processed files: " + counter);
    }

    public static boolean isNeededTranslate(String path) {
        for (char c : path.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNameUpperCase(String path) {
        for (char c : path.toCharArray()) {
            if (String.valueOf(c).equals(String.valueOf(c).toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static String changeLetter(char c, char previous, char next, boolean isWordUpperCase) {
        boolean isNextUpper = String.valueOf(next).equals(String.valueOf(next).toUpperCase());
        switch (c) {
            case '??':
                return "A";
            case '??':
                return "a";
            case '??':
                return "B";
            case '??':
                return "b";
            case '??':
                return "V";
            case '??':
                return "v";
            case '??':
                if (previous == '??' || previous == '??') {
                    return "GH";
                } else {
                    return "H";
                }
            case '??':
                if (previous == '??' || previous == '??') {
                    return "gh";
                } else {
                    return "h";
                }
            case '??':
                return "G";
            case '??':
                return "g";
            case '??':
                return "D";
            case '??':
                return "d";
            case '??':
                return "E";
            case '??':
                return "e";
            case '??':
                if (isWordUpperCase) {
                    return "YE";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YE";
                    } else {
                        return "Ye";
                    }
                } else {
                    return "IE";
                }
            case '??':
                if (previous == ' ') {
                    return "ye";
                } else {
                    return "ie";
                }
            case '??':
                if (previous == ' ' && !isNextUpper) {
                    return "Zh";
                } else {
                    return "ZH";
                }
            case '??':
                return "zh";
            case '??':
                return "z";
            case '??':
                return "z";
            case '??':
                return "Y";
            case '??':
                return "y";
            case '??':
                return "I";
            case '??':
                return "i";
            case '??':
                if (isWordUpperCase) {
                    return "YI";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YI";
                    } else {
                        return "Yi";
                    }
                } else {
                    return "I";
                }
            case '??':
                if (previous == ' ') {
                    return "yi";
                } else {
                    return "i";
                }
            case '??':
                if (previous == ' ') {
                    return "Y";
                } else {
                    return "I";
                }
            case '??':
                if (previous == ' ') {
                    return "y";
                } else {
                    return "i";
                }
            case '??':
                return "K";
            case '??':
                return "k";
            case '??':
                return "L";
            case '??':
                return "l";
            case '??':
                return "M";
            case '??':
                return "m";
            case '??':
                return "N";
            case '??':
                return "n";
            case '??':
                return "O";
            case '??':
                return "o";
            case '??':
                return "P";
            case '??':
                return "p";
            case '??':
                return "R";
            case '??':
                return "r";
            case '??':
                return "S";
            case '??':
                return "s";
            case '??':
                return "T";
            case '??':
                return "t";
            case '??':
                return "U";
            case '??':
                return "u";
            case '??':
                return "F";
            case '??':
                return "f";
            case '??':
                if (previous == ' ' && !isNextUpper) {
                    return "Kh";
                } else {
                    return "KH";
                }
            case '??':
                return "kh";
            case '??':
                if (previous == ' ' && !isNextUpper) {
                    return "Ts";
                } else {
                    return "TS";
                }
            case '??':
                return "ts";
            case '??':
                if (previous == ' ' && !isNextUpper) {
                    return "Ch";
                } else {
                    return "CH";
                }
            case '??':
                return "ch";
            case '??':
                if (previous == ' ' && !isNextUpper) {
                    return "Sh";
                } else {
                    return "SH";
                }
            case '??':
                return "sh";
            case '??':
                if (previous == ' ' && !isNextUpper) {
                    return "Shch";
                } else {
                    return "SHCH";
                }
            case '??':
                return "shch";
            case '??':
                if (isWordUpperCase) {
                    return "YU";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YU";
                    } else {
                        return "Yu";
                    }
                } else {
                    return "IU";
                }
            case '??':
                if (previous == ' ') {
                    return "yu";
                } else {
                    return "iu";
                }
            case '??':
                if (isWordUpperCase) {
                    return "YA";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YA";
                    } else {
                        return "Ya";
                    }
                } else {
                    return "IA";
                }
            case '??':
                if (previous == ' ') {
                    return "ya";
                } else {
                    return "ia";
                }
            case '??':
            case '??':
            case '`':
            case '\'':
            case '??':
            case '??':
                return "";
            case '??':
                return "E";
            case '??':
                return "e";
            case '??':
                return "Y";
            case '??':
                return "y";
            case '??':
                return "E";
            case '??':
                return "e";
            case ',':
            case '.':
            case '(':
            case ')':
            case '-':
            case '_':
            case '&':
                return String.valueOf(c);
        }

        return "?";
    }
}
