package practice.christmaslights;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChristmasLightsTest {
	ChristmasLights christmasLights;

	@BeforeEach
	void setUp() {
		christmasLights = new ChristmasLights();
		christmasLights.setLights(createLightsOff());
	}
	@Test
	void AllLightsAreOff() throws Exception {
		assertThat(christmasLights.totalBrightness(), is(0l));
	}
	
	@Test
	void allLightsAreOn() throws Exception {
		christmasLights.setLights(createLightsOn());
		assertThat(christmasLights.totalBrightness(), is(1000000l));
	}
	
	@Test
	void canTurnOnSingleLightTwice() throws Exception {
		christmasLights.turnOnSingleLight(499,499);
		christmasLights.turnOnSingleLight(499,499);
		assertThat(christmasLights.totalBrightness(), is(2L));
	}
	
	@Test
	void canTurnOffSingleLightMoreThanOnce() throws Exception {
		christmasLights.setLights(createLightsOn());
		christmasLights.turnOffSingleLight(499,499);
		christmasLights.turnOffSingleLight(499,499);
		christmasLights.turnOffSingleLight(499,499);
		assertThat(christmasLights.totalBrightness(), is(999999L));
	}
	
	@Test
	void canToggleSingleLightTwice() {
		christmasLights.toggleSingleLight(499,499);
		christmasLights.toggleSingleLight(499,499);
		assertThat(christmasLights.totalBrightness(), is(4L));
	}
	@Test
	void canTurnOnRectangle() {
		christmasLights.turnOnColumnRange(100,100,  199,199);
		assertThat(christmasLights.totalBrightness(), is(10000L));
	}
	
	@Test
	void canTurnOffRectangle() {
		christmasLights.setLights(createLightsOn());
		christmasLights.turnOffColumnRange(100,100,  199,199);
		assertThat(christmasLights.totalBrightness(), is(990000L));
	}
	
	@Test
	void canToggleRectangle() {
		christmasLights.setLights(createRectangle100x100LightsOn());
		christmasLights.toggleColumnRange(0,0,  999,999);
		assertThat(christmasLights.totalBrightness(), is(2010000L));
	}
	
	@Test
	void followingInstructions() {
		christmasLights.turnOnColumnRange(887,9,  959,629);
		christmasLights.turnOnColumnRange(454,398, 844, 448);
		christmasLights.turnOffColumnRange(539, 243, 559, 965);
		christmasLights.turnOffColumnRange(370, 819, 676, 868);
		christmasLights.turnOffColumnRange(145, 40, 370, 997);
		christmasLights.turnOffColumnRange(301, 3, 808, 453);
		christmasLights.turnOnColumnRange(351, 678, 951, 908);
		christmasLights.toggleColumnRange(720, 196, 897, 994);
		christmasLights.toggleColumnRange(831, 394, 904, 860);
		assertThat(christmasLights.totalBrightness(), is(539560L));
		
	}
	
	private int[][] createLightsOn(){
		int[][] lights = new int[1000][1000];
		for (int col = 0; col < 1000; col++) {
			for (int row = 0; row < 1000; row++) {
				lights[col][row] = 1;
			}
		}
		return lights;
	}
	
	private int[][] createLightsOff(){
		return new int[1000][1000];
	}
	
	private int[][] createRectangle100x100LightsOn() {
		int[][] lights = new int[1000][1000];
		for (int col = 100; col <= 199; col++) {
			for (int row = 100; row <= 199; row++) {
				lights[col][row] = 1;
			}
		}
		return lights;
	}
}
