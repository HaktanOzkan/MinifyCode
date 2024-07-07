package me.minify;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinifyHTML {
	
	public static String minifyHTML(String htmlContent) {
        String minifiedHtml = removeComments(htmlContent);
        minifiedHtml = removeExtraSpaces(minifiedHtml);
        return minifiedHtml;
    }

    private static String removeComments(String htmlContent) {
        Pattern pattern = Pattern.compile("<!--.*?-->", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(htmlContent);
        return matcher.replaceAll("");
    }

    private static String removeExtraSpaces(String htmlContent) {
        htmlContent = htmlContent.replaceAll("\\s+", " ");
        htmlContent = htmlContent.replaceAll(">\\s+<", "><");
        return htmlContent.trim();
    }

}
