package examples;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class ActionBase {
	//create the pointer
	private static final PointerInput pointer = new PointerInput(Kind.TOUCH, "finger");
	
	//create the action
	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
		//create the sequence of action
		Sequence swipe = new Sequence(pointer, 1).
			addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY())).
			addAction(pointer.createPointerDown(LEFT.asArg())).
			addAction(pointer.createPointerMove(ofMillis(0), viewport(), end.getX(), end.getY())).
			addAction(pointer.createPointerUp(LEFT.asArg()));
				
		//perform the Action
		driver.perform(Arrays.asList(swipe));
	}
}
