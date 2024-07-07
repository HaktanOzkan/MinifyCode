package me.minify;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinifyJS {
	
	public static String minifyJavaScript(String jsContent) {
        String minifiedJs = removeComments(jsContent);
        minifiedJs = removeExtraSpaces(minifiedJs);
        return minifiedJs;
    }

    private static String removeComments(String jsContent) {
        Pattern pattern = Pattern.compile("(//.*?$)|(/\\*.*?\\*/)", Pattern.DOTALL | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(jsContent);
        return matcher.replaceAll("");
    }

    private static String removeExtraSpaces(String jsContent) {
        jsContent = jsContent.replaceAll("\\s+", " ");
        jsContent = jsContent.replaceAll("\\s*\\{\\s*", "{");
        jsContent = jsContent.replaceAll("\\s*\\}\\s*", "}");
        jsContent = jsContent.replaceAll("\\s*\\(\\s*", "(");
        jsContent = jsContent.replaceAll("\\s*\\)\\s*", ")");
        jsContent = jsContent.replaceAll("\\s*;\\s*", ";");
        jsContent = jsContent.replaceAll("\\s*,\\s*", ",");
        jsContent = jsContent.replaceAll("\\s*:\\s*", ":");
        return jsContent.trim();
    }

}
