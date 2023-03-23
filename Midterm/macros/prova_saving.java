// Simcenter STAR-CCM+ macro: prova_saving.java
// Written by Simcenter STAR-CCM+ 16.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class prova_saving extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
      
    String dir = simulation_0.getSessionDir(); //getting the name of the sims directory


    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("L2 Error"));
      
    
    String path_L2 = (dir + "/results/L2_error.csv");
    monitorPlot_0.export(resolvePath(path_L2), ",");

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Probes"));

    String path_probes = (dir + "/results/probes.csv");
    monitorPlot_1.export(resolvePath(path_probes), ",");

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));
      
    String path_res = (dir + "/results/residuals.csv");
    residualPlot_0.export(resolvePath(path_res), ",");
  }
}
