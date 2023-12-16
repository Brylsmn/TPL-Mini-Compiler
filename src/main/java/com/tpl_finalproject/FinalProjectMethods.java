package com.tpl_finalproject;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalProjectMethods {
    private static final Pattern JAVA_STATEMENT = Pattern.compile(
            "^(int|double|char|String|boolean)\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*(=\\s*.+)?;$"
    );
    public static boolean areLinesLexicallyCorrect(List<String> lines) {
        for (String line : lines) {
            String modifiedInput = line.replaceAll(";", " ; ");
            String[] tokens = modifiedInput.split("\\s+");
            for (String token : tokens) {
                if (!(token.matches("int|double|char|String") ||
                        token.equals("=") ||
                        token.equals(";") ||
                        token.matches("[0-9]+|\"[^\"]*\"|'[^']*'|[0-9]*\\.[0-9]+") ||
                        token.matches("[a-zA-Z_][a-zA-Z0-9_]*"))) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSyntaxCorrect(List<String> lines) {
        for (String line : lines) {
            if (!JAVA_STATEMENT.matcher(line.trim()).matches()) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSemanticallyCorrect(List<String> lines) {
        Pattern pattern = Pattern.compile("(int|double|String|boolean|char)\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*(=\\s*(.*))?;");
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line.trim());  // trim to handle leading/trailing whitespaces
            if (!matcher.matches()) {
                return false;
            }
            String type = matcher.group(1);
            String value = matcher.group(3);
            if (value != null) {
                switch (type) {
                    case "int":
                        if (!value.matches("-?\\d+")) {
                            return false;
                        }
                        break;
                    case "double":
                        if (!value.matches("-?\\d+(\\.\\d+)?")) {
                            return false;
                        }
                        break;
                    case "String":
                        if (!value.startsWith("\"") || !value.endsWith("\"")) {
                            return false;
                        }
                        break;
                    case "boolean":
                        if (!value.matches(String.valueOf(true | false))) {
                            return false;
                        }
                        break;
                    case "char":
                        if (!value.startsWith("\'") || !value.endsWith("\'")) {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }
}
