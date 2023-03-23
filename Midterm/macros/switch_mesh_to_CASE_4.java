// Simcenter STAR-CCM+ macro: switch_mesh_to_CASE_4.java
// Written by Simcenter STAR-CCM+ 16.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.meshing.*;
import star.sweptmesher.*;

public class switch_mesh_to_CASE_4 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    DirectedMeshOperation directedMeshOperation_2 = 
      ((DirectedMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("Directed Mesh"));

    directedMeshOperation_2.editDirectedMeshOperation();

    DirectedPatchSourceMesh directedPatchSourceMesh_0 = 
      ((DirectedPatchSourceMesh) directedMeshOperation_2.getGuidedSurfaceMeshBaseManager().getObject("Patch Mesh"));

    directedPatchSourceMesh_0.editDirectedPatchSourceMesh();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(1).build());

    directedPatchSourceMesh_0.enablePatchMeshMode();

    PatchCurve patchCurve_1 = 
      ((PatchCurve) directedPatchSourceMesh_0.getPatchCurveManager().getObject("PatchCurve 0"));

    patchCurve_1.getStretchingFunction().setSelected(StretchingFunctionBase.Type.CONSTANT);

    directedPatchSourceMesh_0.defineMeshPatchCurve(patchCurve_1, patchCurve_1.getStretchingFunction(), 0.1, 0.1, 128, false, false);

    PatchCurve patchCurve_0 = 
      ((PatchCurve) directedPatchSourceMesh_0.getPatchCurveManager().getObject("PatchCurve 2"));

    patchCurve_0.getStretchingFunction().setSelected(StretchingFunctionBase.Type.CONSTANT);

    directedPatchSourceMesh_0.defineMeshPatchCurve(patchCurve_0, patchCurve_0.getStretchingFunction(), 0.1, 0.1, 208, false, false);

    directedPatchSourceMesh_0.stopEditPatchOperation();

    directedMeshOperation_2.stopEditingDirectedMeshOperation();

    directedMeshOperation_2.execute();
  }
}
