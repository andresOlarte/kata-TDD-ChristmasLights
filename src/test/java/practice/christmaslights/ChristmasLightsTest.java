package practice.christmaslights;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;



public class ChristmasLightsTest {

	@Test
	void cantTurnOnASingleLight(){
		ChristmasLights christmasLights = new ChristmasLights();
		assertThat(christmasLights.turnOn(0,0), is(1));
	}
	
}
