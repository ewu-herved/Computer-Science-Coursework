package s15cscd580task1;

import java.util.ArrayList;

import cs480viewer.task1.Viewer;

//=============================================================================================================================================================
public class CS480Task1Driver
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
	public static void main(final String[] args)
    {
		new CS480Task1Driver();
    }

    private final Viewer _viewer;

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------
    public CS480Task1Driver() //do the test method calls here
    {
       _viewer = new Viewer("track1_.trk");
       
       herveTest5(10, 100);
       
       System.out.println("End Test");
    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------
    private void tappanTest()
    {
    	for (double i = 0; i < 150; i += 1)
        {
            // call this once per movement; the arguments are id (use "bird"), x, y, z, yaw, pitch, and roll
    		_viewer.doAddEvent("bird", i, (i * i * 0.01), (i * i * 0.025), (i * 10), i, (i * 3));

            // call this after each movement; the argument is the delay in milliseconds
            _viewer.doAdvanceEventClock(50);
        }
    }
   
    private void herveTest1(int lineNum, int interval)
    {
	   
    	Line3D lineCurr = new Line3D(new Triple(500), new Triple(500));
	  
	    for (int i = 0; i < lineNum; i++)
        {
	    	if(i != 0) {    	 
	    		Line3D temp = new Line3D(lineCurr.getEndPnt(), new Triple(500));
	    		lineCurr = temp;
	    	}
	    		
	    		// call this once per movement; the arguments are id (use "bird"), x, y, z, yaw, pitch, and roll
	    		_viewer.doAddEvent("bird", lineCurr.getStrtPnt().getX(), lineCurr.getStrtPnt().getY(), lineCurr.getStrtPnt().getZ(), 0, 0, 0);

	    		// call this after each movement; the argument is the delay in milliseconds
	    		_viewer.doAdvanceEventClock(50);
        }
    }
    
    private void herveTest2(int lineNum, int interval)
    {
	   
    	Line3D lineCurr = new Line3D(new Triple(500), new Triple(500));
	  
	    for (int i = 0; i < lineNum; i++)
        {
	    	if(i != 0) {    	 
	    		Line3D temp = new Line3D(lineCurr.getEndPnt(), new Triple(500));
	    		lineCurr = temp;
	    	}
	    	
	    	Triple[] linePlot = lineCurr.plotLine(interval); //this plots the line
    	 
	    	for (int j = 0; j < linePlot.length; j++) {
	    		
	    		// call this once per movement; the arguments are id (use "bird"), x, y, z, yaw, pitch, and roll
	    		_viewer.doAddEvent("bird", linePlot[j].getX(), linePlot[j].getY(), linePlot[j].getZ(), 0, 0, 0);

	    		// call this after each movement; the argument is the delay in milliseconds
	    		_viewer.doAdvanceEventClock(100);
	    	}
        }
    }
    
    private void herveTest3(int lineNum, int interval)
    {
    	Line3D lineCurr = new Line3D(new Triple(0, 0, 0), new Triple(400, 300, 300));
	  
	    for (int i = 0; i < lineNum; i++)
        {
	    	if(i != 0) {
	    		Line3D temp = new Line3D(lineCurr.getEndPnt(), new Triple(500));
	    		lineCurr = temp;
	    	}
	    	
	    	Triple orientation = Pathing.orient(lineCurr.getStrtPnt(), lineCurr.getEndPnt()); //this sets the orientation
	    	
	    	Triple[] linePlot = lineCurr.plotLine(interval);
    	 
	    	for (int j = 0; j < linePlot.length; j++) {
	    		
	    		// call this once per movement; the arguments are id (use "bird"), x, y, z, yaw, pitch, and roll
	    		_viewer.doAddEvent("bird", linePlot[j].getX(), linePlot[j].getY(), linePlot[j].getZ(), orientation.getX(), orientation.getY(), 0);//orientation.getX(), orientation.getY(), 0);

	    		// call this after each movement; the argument is the delay in milliseconds
	    		_viewer.doAdvanceEventClock(150);
	    	}
        }
    }
    
    private void herveTest4(int lineNum, int interval)
    {
    	Line3D lineCurr = new Line3D(new Triple(0, 0, 0), new Triple(400, 300, 300));//new Line3D(new Triple(500), new Triple(500));
	  
	    for (int i = 0; i < lineNum; i++)
        {
	    	if(i != 0) {
	    		Line3D temp = new Line3D(lineCurr.getEndPnt(), new Triple(500));
	    		lineCurr = temp;
	    	}
	    	
	    	Triple orientation = Pathing.orient(lineCurr.getStrtPnt(), lineCurr.getEndPnt());
	    	
	    	Triple[] linePlot = lineCurr.plotLineRandom(interval); //this gives some randomness to plot points
    	 
	    	for (int j = 0; j < linePlot.length; j++) {
	    		
	    		// call this once per movement; the arguments are id (use "bird"), x, y, z, yaw, pitch, and roll
	    		_viewer.doAddEvent("bird", linePlot[j].getX(), linePlot[j].getY(), linePlot[j].getZ(), orientation.getX(), orientation.getY(), 0);

	    		// call this after each movement; the argument is the delay in milliseconds
	    		_viewer.doAdvanceEventClock(100);
	    	}
        }
    }
    
    private void herveTest5(int lineNum, int interval)
    {
    	
    	int runs = lineNum / 10;
    	if(runs == 0 && lineNum > 0)
    		runs = 1;
    	
    	ArrayList<Triple[]> runSegs = new ArrayList<>();
    	ArrayList<Triple> renderingPoints = new ArrayList<>(); //points for drawing
    	double t = 1.0 / (double) interval; //this is used in bezier calculations (is percentage of traversal of line)
    	
    	for(int n = 0; n < runs; n++) { //create Triple array for each run
    		
    		int controlSize; // size of the array
    		
    		if((n + 1) == runs && lineNum % 10 != 0)
    			controlSize = lineNum % 10;
    		else
    			controlSize = 10;
    		
    		Triple[] controls = new Triple[controlSize + 1]; //add 1 b/c # of lines = # of points + 1    	
    	
    		for(int i = 0; i < controls.length; i++) {
    			
    			if(n != 0 && i == 0) {
    				
    				Triple temp = runSegs.get(n - 1)[10]; //grab the last point from the previous triple[]
    				controls[i] = new Triple(temp.getX(), temp.getY(), temp.getZ());    				
    			}
    			else if(n != 0 && i == 1) {
    				
    				Triple temp = runSegs.get(n - 1)[10].sub(runSegs.get(n - 1)[9]); //grab the difference between the last 2 points
    				
    				controls[i] = yAbove0(controls[i -1].add(temp));  
    			}
//    			else if(n != 0 && i == 2) {
//    				
//    				Triple temp = runSegs.get(n - 1)[10].sub(runSegs.get(n - 1)[9]); //grab the difference between the last 2 points
//    				
//    				controls[i] = yAbove0(controls[i -1].add(temp));
//    			}
    			else	
    				controls[i] = new Triple(500);
    		}
    		runSegs.add(controls);
    	}
    	for(int i = 0; i < runSegs.size(); i++) {
    		
    		
	    	for(double j = 0; j < 1; j += t) {
	    		renderingPoints.add(BezierCurveTools.bezier(runSegs.get(i), j)); //this is the fancy math. See in Pathing
	    	}	    	
    	}
    	
    	BezierCurveTools.plotLineRandom(renderingPoints);
	    	
	    for (int i = 0; i < renderingPoints.size() - 1; i++) {
	    		
	    		// call this once per movement; the arguments are id (use "bird"), x, y, z, yaw, pitch, and roll
	    		_viewer.doAddEvent("bird", renderingPoints.get(i).getX(), renderingPoints.get(i).getY(), renderingPoints.get(i).getZ(), Pathing.orient(renderingPoints.get(i), renderingPoints.get(i +1)).getX(), Pathing.orient(renderingPoints.get(i), renderingPoints.get(i +1)).getY(), 0);

	    		// call this after each movement; the argument is the delay in milliseconds
	    		_viewer.doAdvanceEventClock(100);
	    }
        
    }
    
    private Triple yAbove0(Triple point) {
    	
    	if(point.getY() >= 0)
    		return point;
    	
    	else
    		return yAbove0(point.div(2));
    		
    }
}
