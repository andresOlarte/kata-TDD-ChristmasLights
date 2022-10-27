package practice.christmaslights;

public class ChristmasLights {

	private int[][] lights = new int[1000][1000];

	public int turnOn(int column, int row) {
		lights[column][row] = 1;
		return lights[column][row];
	}
	

}
