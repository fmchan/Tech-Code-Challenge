package com.fmchan;

public class Canvas {
    private final int width;
    private final int height;
    private final char matrix[][];

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

		matrix = new char[height][width];
		
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				matrix[i][j] = ' ';
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String render() {
        return renderHorizantalLine() + renderVerticalLine() + renderHorizantalLine();
    }
    public String renderHorizantalLine() {
        return String.valueOf(Constants.H).repeat(this.width + 2) + "\n";
    }
    public String renderVerticalLine() {
        String output = "";
        for (int i = 0; i < this.getHeight(); i++) {
            output += Constants.V;
            for (int j = 0; j < this.getWidth(); j++)
                output += matrix[i][j];
            output += Constants.V + "\n";
        }
        return output;
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
		for (int i = y1; i <= y2; i++)
			for (int j = x1; j <= x2; j++)
				matrix[i][j] = Constants.X;
    }
    public void drawRectangle(int x1, int y1, int x2, int y2) {
		for (int i = y1; i <= y2; i++)
			for (int j = x1; j <= x2; j++)
				matrix[i][j] = (i != y1 && i != y2 && j != x1 && j != x2)? ' ': Constants.X;
    }
    public void doBucketFill(int x, int y, char color) {
        if (x < 0 || x >= this.width || y < 0 || y >= this.height || matrix[y][x] != ' ') return;
        matrix[y][x] = color;
        doBucketFill(x + 1, y, color);
        doBucketFill(x - 1, y, color);
        doBucketFill(x, y - 1, color);
        doBucketFill(x, y + 1, color);
    }
}
