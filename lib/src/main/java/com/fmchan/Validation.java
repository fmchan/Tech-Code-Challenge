package com.fmchan;

public class Validation {
    public static boolean create(String cmd) {
        return cmd.matches(Constants.CMD_CREATE + " \\d+ \\d+");
    }
    public static boolean line(String cmd) {
        return cmd.matches(Constants.CMD_LINE + " \\d+ \\d+ \\d+ \\d+");
    }
    public static boolean rectangle(String cmd) {
        return cmd.matches(Constants.CMD_RECTANGLE + " \\d+ \\d+ \\d+ \\d+");
    }
    public static boolean bucketFill(String cmd) {
        return cmd.matches(Constants.CMD_BUCKET_FILL + " \\d+ \\d+ \\w");
    }

    public static boolean isPositive(int x, int y) {
        return (x >= 0 && y >= 0);
    }
    public static boolean isBoundary(int x, int y, int width, int height) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }
    public static boolean isLine(int x1, int y1, int x2, int y2) {
        return (x1 == x2 || y1 == y2);
    }
    public static boolean validOrder(int x1, int y1, int x2, int y2) {
        return (x1 <= x2 && y1 <= y2);
    }
}
