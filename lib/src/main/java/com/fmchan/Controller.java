package com.fmchan;

public class Controller {
    private static Canvas canvas;

    public String assign(String cmd) {
        char op = cmd.toUpperCase().charAt(0);
		try {
			switch (op) {
				case Constants.CMD_CREATE -> { return create(cmd); }
				case Constants.CMD_LINE -> { return line(cmd); }
				case Constants.CMD_RECTANGLE -> { return rectangle(cmd); }
				case Constants.CMD_BUCKET_FILL -> { return bucketFill(cmd); }
                default -> throw new IllegalArgumentException(Constants.ERR_INVALID_CMD);
			}
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
        return "";
    }

    public static String[] cmdToArgs(String cmd) {
        return cmd.split(" ");
    }

    public static String create(String cmd) {
        if (!Validation.create(cmd)) throw new IllegalArgumentException(Constants.ERR_CMD_CREATE);
        String[] args =  cmdToArgs(cmd);
        int w = Integer.parseInt(args[1]);
        int h = Integer.parseInt(args[2]);
        if (!Validation.isPositive(w, h)) throw new IllegalArgumentException(Constants.ERR_NOT_BOUND);
        canvas = new Canvas(w, h);
        return canvas.render();
    }
    public static String line(String cmd) {
        if (!Validation.line(cmd)) throw new IllegalArgumentException(Constants.ERR_CMD_LINE);
        if (!hasCanvas()) throw new IllegalStateException(Constants.ERR_CREATE_CANVAS);
        String[] args =  cmdToArgs(cmd);
        int x1 = Integer.parseInt(args[1]) - 1;
        int y1 = Integer.parseInt(args[2]) - 1;
        int x2 = Integer.parseInt(args[3]) - 1;
        int y2 = Integer.parseInt(args[4]) - 1;
        if (!Validation.isBoundary(x1, y1, canvas.getWidth(), canvas.getHeight()) 
            || !Validation.isBoundary(x2, y2, canvas.getWidth(), canvas.getHeight()))
                throw new IllegalArgumentException(Constants.ERR_NOT_BOUND);
        if (!Validation.isLine(x1, y1, x2, y2)) throw new IllegalArgumentException(Constants.ERR_NOT_LINE);
        if (!Validation.validOrder(x1, y1, x2, y2)) throw new IllegalArgumentException(Constants.ERR_INVALID_ORDER);
        canvas.drawLine(x1, y1, x2, y2);
        return canvas.render();
    }
    public static String rectangle(String cmd) {
        if (!Validation.rectangle(cmd)) throw new IllegalArgumentException(Constants.ERR_CMD_RECTANGLE);
        if (!hasCanvas()) throw new IllegalStateException(Constants.ERR_CREATE_CANVAS);
        String[] args =  cmdToArgs(cmd);
        int x1 = Integer.parseInt(args[1]) - 1;
        int y1 = Integer.parseInt(args[2]) - 1;
        int x2 = Integer.parseInt(args[3]) - 1;
        int y2 = Integer.parseInt(args[4]) - 1;
        if (!Validation.isBoundary(x1, y1, canvas.getWidth(), canvas.getHeight()) 
            || !Validation.isBoundary(x2, y2, canvas.getWidth(), canvas.getHeight()))
                throw new IllegalArgumentException(Constants.ERR_NOT_BOUND);
        if (!Validation.validOrder(x1, y1, x2, y2)) throw new IllegalArgumentException(Constants.ERR_INVALID_ORDER);
        canvas.drawRectangle(x1, y1, x2, y2);
        return canvas.render();
    }
    public static String bucketFill(String cmd) {
        if (!Validation.bucketFill(cmd)) throw new IllegalArgumentException(Constants.ERR_CMD_BUCKET_FILL);
        if (!hasCanvas()) throw new IllegalStateException(Constants.ERR_CREATE_CANVAS);
        String[] args =  cmdToArgs(cmd);
        int x = Integer.parseInt(args[1]) - 1;
        int y = Integer.parseInt(args[2]) - 1;
        char color = args[3].charAt(0);
        if (!Validation.isBoundary(x, y, canvas.getWidth(), canvas.getHeight()))
            throw new IllegalArgumentException(Constants.ERR_NOT_BOUND);
        canvas.doBucketFill(x, y, color);
        return canvas.render();
    }
    public static boolean hasCanvas() {
		return canvas != null;
	}
}
