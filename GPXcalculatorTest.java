import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GPXcalculatorTest {

	@Before
	public void setup(){
		
	}
	
	@Test
	public void testOne() {
		int expectedResult = -1;
		GPXtrk trk = null;
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("null GPXtrk");
	}
	
	public void testTwo() {
		int expectedResult = 0;
		GPXtrkpt point = new GPXtrkpt(0, 0, null);
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(point);
		GPXtrkseg trkseg = new GPXtrkseg(points);
		ArrayList<GPXtrkseg> trksegs = new ArrayList<GPXtrkseg>();
		trksegs.add(null);
		trksegs.add(trkseg);
		GPXtrk trk = new GPXtrk("funtimes", trksegs);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("null GRPXtrk segments");
	}
	
	public void testThree() {
		int expectedResult = -1;
		GPXtrk trk = new GPXtrk("funtimes", null);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("no objects");
	}
	
	public void testFour() {
	    int expectedResult = 0;
		GPXtrkpt point = new GPXtrkpt(0, 0, null);
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(point);
		GPXtrkseg trkseg = new GPXtrkseg(points);
		ArrayList<GPXtrkseg> trksegs = new ArrayList<GPXtrkseg>();
		GPXtrk trk = new GPXtrk("funtimes", trksegs);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("GPXtrkseg contains no GPXtrkpt objects");
	}
	
	public void testFive() {
		int expectedResult = 0;
		GPXtrkpt point = new GPXtrkpt(0, 0, null);
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(point);
		GPXtrkseg trkseg = new GPXtrkseg(points);
		ArrayList<GPXtrkseg> trksegs = new ArrayList<GPXtrkseg>();
		trksegs.add(trkseg);
		GPXtrk trk = new GPXtrk("funtimes", trksegs);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("only one trkpt");
	}
	
	public void testSix() {
		int expectedResult = 0;
		GPXtrkpt point = null;
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(point);
		GPXtrkseg trkseg = new GPXtrkseg(points);
		ArrayList<GPXtrkseg> trksegs = new ArrayList<GPXtrkseg>();
		trksegs.add(trkseg);
		GPXtrk trk = new GPXtrk("funtimes", trksegs);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("null trkpt");
	}
	
	public void testSeven(){
		int expectedResult = 0;
		GPXtrkpt pointa = new GPXtrkpt(0, 0, null);
		GPXtrkpt pointb = new GPXtrkpt(5, 5, null);
		GPXtrkpt pointc = new GPXtrkpt(95, 0, null);
		GPXtrkpt pointd = new GPXtrkpt(-92, 0, null);
		GPXtrkpt pointe = new GPXtrkpt(0, 190, null);
		GPXtrkpt pointf = new GPXtrkpt(-5, -300, null);
		
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(pointa);
		GPXtrkseg trkseg = new GPXtrkseg(points);
		ArrayList<GPXtrkseg> trksegs = new ArrayList<GPXtrkseg>();
		trksegs.add(trkseg);
		GPXtrk trk = new GPXtrk("funtimes", trksegs);
		
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		
		points.add(pointb);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		
		points.add(pointc);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("invalid trkpt");
		
		points.remove(pointc);
		points.add(pointd);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("invalid trkpt");
		
		points.remove(pointd);
		points.add(pointe);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("invalid trkpt");
		
		points.remove(pointe);
		points.add(pointf);
		assertEquals(expectedResult, GPXcalculator.calculateDistanceTraveled(trk));
		fail("invalid trkpt");
	}
	
}
