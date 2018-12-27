package com.bootdo.common.utils;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Set;

public class StringHelper {
    public StringHelper() {
    }

    public static StringBuilder formatMsg(CharSequence msgWithFormat, boolean autoQuote, Object[] args) {
        int argsLen = args.length;
        boolean markFound = false;
        StringBuilder sb = new StringBuilder(msgWithFormat);
        if (argsLen > 0) {
            for(int i = 0; i < argsLen; ++i) {
                String flag = "%" + (i + 1);

                for(int idx = sb.indexOf(flag); idx >= 0; idx = sb.indexOf(flag)) {
                    markFound = true;
                    sb.replace(idx, idx + 2, toString(args[i], autoQuote));
                }
            }

            if (args[argsLen - 1] instanceof Throwable) {
                StringWriter sw = new StringWriter();
                ((Throwable)args[argsLen - 1]).printStackTrace(new PrintWriter(sw));
                sb.append("\n").append(sw.toString());
            } else if (argsLen == 1 && !markFound) {
                sb.append(args[argsLen - 1].toString());
            }
        }

        return sb;
    }

    public static StringBuilder formatMsg(String msgWithFormat, Object[] args) {
        return formatMsg(new StringBuilder(msgWithFormat), true, args);
    }

    public static String toString(Object obj, boolean autoQuote) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            sb.append("NULL");
        } else if (obj instanceof Object[]) {
            for(int i = 0; i < ((Object[])obj).length; ++i) {
                sb.append(((Object[])obj)[i]).append(", ");
            }

            if (sb.length() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
        } else {
            sb.append(obj.toString());
        }

        if (autoQuote && sb.length() > 0 && (sb.charAt(0) != '[' || sb.charAt(sb.length() - 1) != ']') && (sb.charAt(0) != '{' || sb.charAt(sb.length() - 1) != '}')) {
            sb.insert(0, "[").append("]");
        }

        return sb.toString();
    }

    public static String getSetAsString(Set<Object> set) {
        return Joiner.on(",").skipNulls().join(set);
    }

    public static String trimPrefix(String toTrim, String trimStr) {
        while(toTrim.startsWith(trimStr)) {
            toTrim = toTrim.substring(trimStr.length());
        }

        return toTrim;
    }

    public static String trimSufffix(String toTrim, String trimStr) {
        while(toTrim.endsWith(trimStr)) {
            toTrim = toTrim.substring(0, toTrim.length() - trimStr.length());
        }

        return toTrim;
    }

    public static String trim(String toTrim, String trimStr) {
        return trimSufffix(trimPrefix(toTrim, trimStr), trimStr);
    }

    public static String escapeHtml(String content) {
        return StringEscapeUtils.escapeHtml4(content);
    }

    public static String unescapeHtml(String content) {
        return StringEscapeUtils.unescapeHtml4(content);
    }

    /** @deprecated */
    @Deprecated
    public static String makeFirstLetterUpperCase(String newStr) {
        if (newStr.length() == 0) {
            return newStr;
        } else {
            char[] oneChar = new char[]{newStr.charAt(0)};
            String firstChar = new String(oneChar);
            return firstChar.toUpperCase() + newStr.substring(1);
        }
    }

}
