package practice.christmaslights;

import java.util.stream.IntStream;

public class ChristmasLights {

	private int[][] lights;
	private Operation operation;

	public void setLights(int[][] lights) {
		this.lights = lights;
	}

	public long totalBrightness() {
		long totalBrightness = 0;
		for (int[] col : lights) {
			totalBrightness += IntStream.of(col).filter(light -> light > 0).reduce(0, Integer::sum);
		}
		return totalBrightness;
	}

	public void turnOnSingleLight(int col, int row) {
		lights[col][row] += 1;
	}

	public void turnOffSingleLight(int col, int row) {
		if(lights[col][row] > 0) {
			lights[col][row] -= 1;	
		}
	}

	public void toggleSingleLight(int col, int row) {
		lights[col][row] += 2;
	}
	
	public void turnOnColumnRange(int colA, int rowA, int colB, int rowB) {
		operation = (col, row) -> turnOnSingleLight(col, row);
		apply(colA, rowA, colB, rowB);
	}

	public void turnOffColumnRange(int colA, int rowA, int colB, int rowB) {
		operation = (col, row) -> turnOffSingleLight(col, row);
		apply(colA, rowA, colB, rowB);
	}
	
	public void toggleColumnRange(int colA, int rowA, int colB, int rowB) {
		operation = (col, row) -> toggleSingleLight(col, row);
		apply(colA, rowA, colB, rowB);
	}

	private void apply(int colA, int rowA, int colB, int rowB) {
		for (int row = rowA; row <= rowB; row++) {
			for(int col = colA; col <= colB; col++) {
				operation.apply(col, row);
			}
		}
	}

}
