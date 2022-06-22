package com.fmchan;

public class Constants {
    public static final char CMD_CREATE = 'C';
    public static final char CMD_LINE = 'L';
    public static final char CMD_RECTANGLE = 'R';
    public static final char CMD_BUCKET_FILL = 'B';
    public static final char CMD_QUIT = 'Q';

    public static final char X = 'X';
    public static final char V = '|';
    public static final char H = '-';

    public static String ERR_CMD_CREATE = "Create: Please input C w h";
    public static String ERR_CMD_LINE = "Line: Please input L x1 y1 x2 y2";
    public static String ERR_CMD_RECTANGLE = "Rectangle: Please input R x1 y1 x2 y2";
    public static String ERR_CMD_BUCKET_FILL = "Bucket Fill: Please input B x y c";

    public static String ERR_INVALID_CMD = "Please input valid command";
    public static String ERR_INVALID_ORDER = "Please input valid order of point";
    public static String ERR_NOT_LINE = "Please input a valid line";
    public static String ERR_NOT_BOUND = "Please input inbound values";
    public static String ERR_CREATE_CANVAS = "Please create canvas first";
}