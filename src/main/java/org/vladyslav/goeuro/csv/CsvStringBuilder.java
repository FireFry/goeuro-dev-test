package org.vladyslav.goeuro.csv;

public class CsvStringBuilder {

    public static final String DEFAULT_SEPARATOR = ",";
    
    private final StringBuilder stringBuilder = new StringBuilder();
    private String separator = DEFAULT_SEPARATOR;
    private boolean isStarted;

    public static String toString(CsvCompatible csvCompatible) {
        return new CsvStringBuilder().csvAppend(csvCompatible).toString();
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        if (separator == null) {
            throw new NullPointerException("separator");
        }
        this.separator = separator;
    }

    public void reset() {
        isStarted = false;
        stringBuilder.setLength(0);
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public CsvStringBuilder csvAppend(CsvCompatible csvCompatible) {
        csvCompatible.appendTo(this);
        return this;
    }

    private void beforeAppend() {
        if (isStarted) {
            stringBuilder.append(separator);
        } else {
            isStarted = true;
        }
    }

    //region Delegated from StringBuilder methods

    public CsvStringBuilder append(Object obj) {
        beforeAppend();
        stringBuilder.append(obj);
        return this;
    }

    public CsvStringBuilder append(String str) {
        beforeAppend();
        stringBuilder.append(str);
        return this;
    }

    public CsvStringBuilder append(StringBuffer sb) {
        beforeAppend();
        stringBuilder.append(sb);
        return this;
    }

    public CsvStringBuilder append(CharSequence s) {
        beforeAppend();
        stringBuilder.append(s);
        return this;
    }

    public CsvStringBuilder append(CharSequence s, int start, int end) {
        beforeAppend();
        stringBuilder.append(s, start, end);
        return this;
    }

    public CsvStringBuilder append(char[] str) {
        beforeAppend();
        stringBuilder.append(str);
        return this;
    }

    public CsvStringBuilder append(char[] str, int offset, int len) {
        beforeAppend();
        stringBuilder.append(str, offset, len);
        return this;
    }

    public CsvStringBuilder append(boolean b) {
        beforeAppend();
        stringBuilder.append(b);
        return this;
    }

    public CsvStringBuilder append(char c) {
        beforeAppend();
        stringBuilder.append(c);
        return this;
    }

    public CsvStringBuilder append(int i) {
        beforeAppend();
        stringBuilder.append(i);
        return this;
    }

    public CsvStringBuilder append(long lng) {
        beforeAppend();
        stringBuilder.append(lng);
        return this;
    }

    public CsvStringBuilder append(float f) {
        beforeAppend();
        stringBuilder.append(f);
        return this;
    }

    //endregion

}
