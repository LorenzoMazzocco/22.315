// Simcenter STAR-CCM+ macro: switch_mesh_to_CASE_1.java
// Written by Simcenter STAR-CCM+ 16.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.sweptmesher.ui.*;
import star.vis.*;
import star.meshing.*;
import star.sweptmesher.*;

public class switch_mesh_to_CASE_1 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_9 = 
      simulation_0.getSceneManager().createScene("Directed Mesh");

    scene_9.initializeAndWait();

    DirectedMeshOperation directedMeshOperation_2 = 
      ((DirectedMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("Directed Mesh"));

    directedMeshOperation_2.editDirectedMeshOperation(scene_9);

    PolygonMeshDisplayer polygonMeshDisplayer_4 = 
      ((PolygonMeshDisplayer) scene_9.getDisplayerManager().getObject("PolygonMesh displayer 1"));

    polygonMeshDisplayer_4.initialize();

    PartDisplayer partDisplayer_25 = 
      ((PartDisplayer) scene_9.getDisplayerManager().getObject("Dummy 1"));

    partDisplayer_25.initialize();

    PartDisplayer partDisplayer_26 = 
      ((PartDisplayer) scene_9.getDisplayerManager().getObject("SourceSurfaces 1"));

    partDisplayer_26.initialize();

    PartDisplayer partDisplayer_27 = 
      ((PartDisplayer) scene_9.getDisplayerManager().getObject("TargetSurfaces 1"));

    partDisplayer_27.initialize();

    PartDisplayer partDisplayer_28 = 
      ((PartDisplayer) scene_9.getDisplayerManager().getObject("InternalSurfaces 1"));

    partDisplayer_28.initialize();

    PartDisplayer partDisplayer_29 = 
      ((PartDisplayer) scene_9.getDisplayerManager().getObject("DirectedVolumeMesh 1"));

    partDisplayer_29.initialize();

    scene_9.open();

    scene_9.setAdvancedRenderingEnabled(false);

    SceneUpdate sceneUpdate_9 = 
      scene_9.getSceneUpdate();

    HardcopyProperties hardcopyProperties_9 = 
      sceneUpdate_9.getHardcopyProperties();

    hardcopyProperties_9.setCurrentResolutionWidth(25);

    hardcopyProperties_9.setCurrentResolutionHeight(25);

    hardcopyProperties_9.setCurrentResolutionWidth(1334);

    hardcopyProperties_9.setCurrentResolutionHeight(689);

    scene_9.resetCamera();

    DirectedMeshDisplayController directedMeshDisplayController_2 = 
      directedMeshOperation_2.getDisplayController();

    directedMeshDisplayController_2.getHighlightedSurfaces().setQuery(null);

    directedMeshDisplayController_2.getHighlightedSurfaces().setObjects();

    directedMeshDisplayController_2.getHiddenSurfaces().setQuery(null);

    directedMeshDisplayController_2.getHiddenSurfaces().setObjects();

    DirectedPatchSourceMesh directedPatchSourceMesh_0 = 
      ((DirectedPatchSourceMesh) directedMeshOperation_2.getGuidedSurfaceMeshBaseManager().getObject("Patch Mesh"));

    directedPatchSourceMesh_0.editDirectedPatchSourceMesh();

    CurrentView currentView_5 = 
      scene_9.getCurrentView();

    currentView_5.setInput(new DoubleVector(new double[] {2.5, 0.0, 1.0}), new DoubleVector(new double[] {2.5, 0.0, 16.297058540778355}), new DoubleVector(new double[] {1.0, 0.0, -0.0}), 7.648529270389178, 1, 30.0);

    currentView_5.setInput(new DoubleVector(new double[] {2.5, 0.0, 1.0}), new DoubleVector(new double[] {2.5, 0.0, 30.48843566830137}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 7.632168761236874, 1, 30.0);

    scene_9.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    scene_9.setAdvancedRenderingEnabled(false);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(1).build());

    directedPatchSourceMesh_0.enablePatchMeshMode();

    currentView_5.setInput(new DoubleVector(new double[] {2.5, 0.0, 1.0}), new DoubleVector(new double[] {2.5, 0.0, 30.48843566830137}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 7.632168761236874, 1, 30.0);

    currentView_5.setInput(new DoubleVector(new double[] {2.5, 0.0, 1.0}), new DoubleVector(new double[] {2.5, 0.0, 30.48843566830137}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 7.632168761236874, 1, 30.0);

    PatchCurve patchCurve_0 = 
      ((PatchCurve) directedPatchSourceMesh_0.getPatchCurveManager().getObject("PatchCurve 2"));

    patchCurve_0.getStretchingFunction().setSelected(StretchingFunctionBase.Type.CONSTANT);

    directedPatchSourceMesh_0.defineMeshPatchCurve(patchCurve_0, patchCurve_0.getStretchingFunction(), 0.1, 0.1, 26, false, false);

    currentView_5.setInput(new DoubleVector(new double[] {2.5, 0.0, 1.0}), new DoubleVector(new double[] {2.5, 0.0, 30.48843566830137}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 7.632168761236874, 1, 30.0);

    PatchCurve patchCurve_1 = 
      ((PatchCurve) directedPatchSourceMesh_0.getPatchCurveManager().getObject("PatchCurve 0"));

    patchCurve_1.getStretchingFunction().setSelected(StretchingFunctionBase.Type.CONSTANT);

    directedPatchSourceMesh_0.defineMeshPatchCurve(patchCurve_1, patchCurve_1.getStretchingFunction(), 0.1, 0.1, 16, false, false);

    directedPatchSourceMesh_0.stopEditPatchOperation();

    scene_9.setAdvancedRenderingEnabled(false);

    scene_9.setAdvancedRenderingEnabled(false);

    directedMeshOperation_2.stopEditingDirectedMeshOperation();

    simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[] {scene_9}));

    directedMeshOperation_2.execute();
  }
}
