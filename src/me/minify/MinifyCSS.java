package me.minify;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinifyCSS {
	
	public static String minifyCSS(String cssContent) {
        String minifiedCss = removeComments(cssContent);
        minifiedCss = removeExtraSpaces(minifiedCss);
        minifiedCss = removeUnnecessarySemicolons(minifiedCss);
        return minifiedCss;
    }

    private static String removeComments(String cssContent) {
        Pattern pattern = Pattern.compile("/\\*.*?\\*/", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(cssContent);
        return matcher.replaceAll("");
    }

    private static String removeExtraSpaces(String cssContent) {
        cssContent = cssContent.replaceAll("\\s+", " ");
        cssContent = cssContent.replaceAll("\\s*\\{\\s*", "{");
        cssContent = cssContent.replaceAll("\\s*\\}\\s*", "}");
        cssContent = cssContent.replaceAll("\\s*;\\s*", ";");
        cssContent = cssContent.replaceAll("\\s*:\\s*", ":");
        cssContent = cssContent.replaceAll("\\s*,\\s*", ",");
        return cssContent.trim();
    }

    private static String removeUnnecessarySemicolons(String cssContent) {
        return cssContent.replaceAll(";}", "}");
    }

}
